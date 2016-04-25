package test


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DataSourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test multiple data sources"() {
        when:
        new Customer(name: "Something",value: "Bored").save(flush: true)        //This line cause problem. This is due to static mapping{ datasource "datasource"}. Same problem occurs if I used Any other database with static mapping block
    //    new Customer1(name: "Something",value: "Bored").save(flush: true)
        new Customer1(name: "Something1",value: "Really Bored").save(flush: true)
        def c = Customer.findByName("Something")
        def c1 = Customer1.findByName("Something1")
        def url = Customer1.withSession { session ->
            session.connection()
                    .metaData
                    .URL
        }
        then:
        Customer.count() == 1
        Customer1.count() == 1
        c != null
        c1 != null
        url == "jdbc:h2:mem:devDb"
    }

    void "test something"() {
        expect:"fix me"
        true == true
    }
}
