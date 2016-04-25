# grails3_DatasrouceMapping


##Grails env
Grails Version: 3.1.4
Groovy Version: 2.4.6
JVM Version: 1.7.0_80

##Java env
java version "1.7.0_80"
Java(TM) SE Runtime Environment (build 1.7.0_80-b15)
Java HotSpot(TM) 64-Bit Server VM (build 24.80-b11, mixed mode)

Upon adding: 

```
static mapping = {
	datasource 'datasource'	//Or any other datasource here
}
```

I get :

```
java.lang.IllegalStateException: Either class [test.Customer] is not a domain class or GORM has not been initialized correctly or has already been shutdown. If you are unit testing your entities using the mocking APIs

	at org.grails.datastore.gorm.GormEnhancer.stateException(GormEnhancer.groovy:159)
	at org.grails.datastore.gorm.GormEnhancer.findInstanceApi(GormEnhancer.groovy:165)
	at org.grails.datastore.gorm.GormEntity$Trait$Helper.currentGormInstanceApi(GormEntity.groovy:1311)
	at org.grails.datastore.gorm.GormEntity$Trait$Helper.save(GormEntity.groovy:140)
	at test.DataSourceSpec.$tt__$spock_feature_0_0(DataSourceSpec.groovy:20)
	at test.DataSourceSpec.Test multiple data sources_closure3(DataSourceSpec.groovy)
	at groovy.lang.Closure.call(Closure.java:426)
	at groovy.lang.Closure.call(Closure.java:442)
	at grails.transaction.GrailsTransactionTemplate$1.doInTransaction(GrailsTransactionTemplate.groovy:70)
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:133)
	at grails.transaction.GrailsTransactionTemplate.executeAndRollback(GrailsTransactionTemplate.groovy:67)
	at test.DataSourceSpec.Test multiple data sources(DataSourceSpec.groovy)
```

I have gone through the functional tests given on grails repo and it does work just fine. However when I create project via create-app script (as done with this project) I start getting this error.