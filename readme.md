mvn clean install

in Fuse 6.0 console 
features:addUrl mvn:org.poc/SE00/4.0-SNAPSHOT/xml/features

features:install fuse

cxf:list-endpoints


DE11 Implement simple canonical data model (CDM).

Simple classes

Class diagram at src\main\resources\CDM_Model.png is genetrated via eclipse plugin ObjectAid class diagram

Fixtures generate these objects for test data

Attempted to annotate and use as JAXB



DE15 Perform a complex transformation and enrichment using previously developed services.

ActiveMQ user/password needs to be set in camel-context.xml

features:addUrl mvn:org.poc/DE15/4.0-SNAPSHOT/xml/features

features:install DE15

Service at http://localhost:8183/cxf/portfolio?wsdl

push anything in as the name of the Portfolio - it will enriched and go to activeMQ queue DE15_Queue


DE16 Mediate between a SOAP/XML and a RESTFul/JSON service interface. 
- Dummy project todo


DE18 Demonstrate how business rules are configured, deployed, executed, monitored and changed. Demonstrate how they are used in integrations.
- Dummy project todo


DE19 Demonstrate a scenario involving and event driven messaging to execute in real-time and via a scheduled batch.
- Dummy project todo


DE20 Send a message to an offline queue and handle gracefully? Resend per interval. Demonstrate guaranteed delivery of message data once receiving queue becomes active.
- Dummy project todo


features
generates all projects into KAR that is saved to features\target
Drop this into deploy directory to deploy all projects



To develop

1) Get version of fuse and unzip - tested using jboss-fuse-6.1.0.redhat-328


2) start fuse (bin/fuse.bat)

3) build your project mvn clean install

4) in console add the project from maven e.g. features:addUrl mvn:org.poc/DE15/4.0-SNAPSHOT/xml/features

5) features:install DE15

To refresh after code changes

1) mvn clean install

2) features:uninstall DE15

3) features:install DE15

4) if dependencies have been added and features.xml changed in the individual projects use features:refreshUrl mvn:org.poc/DE15/4.0-SNAPSHOT/xml/features then steps 2/3
