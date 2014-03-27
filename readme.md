mvn clean install

in Fuse 6.0 console 
features:addUrl mvn:org.poc/SE00/4.0-SNAPSHOT/xml/features

features:install fuse

cxf:list-endpoints

DE15 Perform a complex transformation and enrichment using previously developed services.

ActiveMQ user/password needs to be set in camel-context.xml

features:addUrl mvn:org.poc/DE15/4.0-SNAPSHOT/xml/features
features:install DE15

Service at 
http://localhost:8183/cxf/portfolio?wsdl
push anything in as the name of the Portfolio - it will enriched and go to activeMQ queue DE15_Queue

DE16 Mediate between a SOAP/XML and a RESTFul/JSON service interface. 
DE19 Demonstrate a scenario involving and event driven messaging to execute in real-time and via a scheduled batch.
DE20 Send a message to an offline queue and handle gracefully? Resend per interval. Demonstrate guaranteed delivery of message data once receiving queue becomes active.