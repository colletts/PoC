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
Two services
SOAP
http://localhost:8185/cxf/policy?wsdl

REST
http://localhost:8185/rest/policy
Send any message to the SOAP service it calls the REST service basic CRUD implemented
Uses simple Camel HTTP to call REST - we could use Restlet, CFXRS or POJO using whatever e.g. Spring RestTemplate

DE18 Demonstrate how business rules are configured, deployed, executed, monitored and changed. Demonstrate how they are used in integrations.
Schedule creates two messages, one with an 'adult' object and one with a 'minor' object.  Based on the
type of object the drools spreadsheet will calculate a different premium.
Modify the 'drools.file' property in camel-context.xml to point to the absolute location of the xls file in the root directory

DE19 Demonstrate a scenario involving and event driven messaging to execute in real-time and via a scheduled batch.
Schedule creates a message every 15 secs, batch job processes messages in groups of three.

DE20 Send a message to an offline queue and handle gracefully? Resend per interval. Demonstrate guaranteed delivery of message data once receiving queue becomes active.
Pushes an asynchronous message onto the connectToOfflineEndpoint queue every 15 secs.
From the queue an attempt is made to post to http://localhost:8184/cxf/offlineRequest.
If it fails the message will remain on the queue and retry every 30secs until successful
The http://localhost:8184/cxf/offlineRequest endpoint can be started/stopped by installing/uninstalling de19


DE13
Expose a REST endpoint, which will consume a JSON request as below. 
The "to" element is a phone number, which will be used to lookup a customer in AD, and if customer exists in AD, will make a call to http://api.whispir.com/workspaces/874B8A072EF1DE68/messages?apikey=ubgxc58t6bb5zt2acshp7wgb endpoint with few additional HTTP headers as per below.
{
"to" : "61435003411",
"subject":" ",
"body":"Test from ESB to Whispir"
}


Post JSON 

http://localhost:8188/rest/DE13

Might pay to check it is working first by direct post to the whispr service - its a bit slow sometimes. (maybe there is some throttle on it)

Before the AD call you can use your own number to get a text message.

@TODO - go to AD and only send message if number is in AD



AV29
Third use case AV29
Scenario, expose a webservice that will look up a database for a sample string, and will store that string into JDG (data grid). Demonstrate that subsequent calls will get the value from a data grid and not from the underlying database.
Deploy across two nodes. Run the case on Node1, get it from database put it in cache. Kill Node1. Run the case on Node2, it should read it from JDG without hitting the database. Basically here we're demoing Fuse/JDG integration.

************ FIRST install datagrid ********************

1) Download Jboss Data grid from
https://www.jboss.org/products/jdg.html

2) unzip to install into $JDG_HOME

3) Add application user restful user to access rest interface

$JDG_HOME\bin\add-user

Create with these settings  
b) Application User (application-users.properties)
Realm: ApplicationRealm
UID:restuser
PWD:Passw0rd#
Role:REST
Is this new user going to be used for one AS process to connect to another AS process? NO

4) Add a cache
Edit $JDG_HOME\standalone\configuration\standalone.xml

Add another cache to

        <subsystem xmlns="urn:infinispan:server:core:6.0" default-cache-container="local">
            <cache-container name="local" default-cache="default" statistics="true">
...
                <local-cache name="cuacache" start="EAGER">
                    <locking isolation="NONE" acquire-timeout="30000" concurrency-level="1000" striping="false"/>
                    <transaction mode="NONE"/>
                </local-cache>

5) Bind to 0.0.0.0
Edit $JDG_HOME\standalone\configuration\standalone.xml
				
Change this address to 0.0.0.0				

        <interface name="public">
            <inet-address value="${jboss.bind.address:127.0.0.1}"/>
        </interface>				
				
				
6) start JBOSS data grid
$JDG_HOME\bin\standalone.bat

7)Check REST is running 

Setup basic auth with UID:restuser PWD:Passw0rd#

GET this 
http://localhost:8080/rest/cuacache
Should be empty
POST anything to this
http://localhost:8080/rest/cuacache



************ Then use service ********************

Get from 

http://localhost:8187/rest/av29/{key}

key will lookup the value in whatever database

Route will try and get the value for key from datagrid.

@TODO If it is null it should get it from database at the moment returns constant DATABASE_VALUE

Route will save the value to datagrid so next time it gets it from datagrid not database

You can see what is in the cache via this GET

http://localhost:8080/rest/cuacache/{key}

You can clear the cache via this DELETE

http://localhost:8080/rest/cuacache/{key}

You will need Basic Auth for each connection to cache manually.


DE23 
Telebanker via MQ

Scenario
CUA has 4 Telebanker servers each talking to their own MQ queues and can only talk to other systems via MQ. However due to legacy requirements the ESB will be required to manipulate a section of this message only when message type is 1(bold below) with a java class provided by a vendor so the message can be accepted by core banking. The ESB will also need to do matching on Correlation ID so the response message is returned to the correct Telebanker system.
Note: the ESB is only responsible for executing this code on the message it is not required to validate the execution .

Secnarios has changed to using activeMQ and showing some level of correlation between messages

2 Tests

1) add message to queue that is enriched based on Body of message and goes through different queues using reply to header (and correlation id behind scenes) to send to different processing quues

Put a message on queue DE23_SharedProcessingQueue - if message contains Queue1 it will be transformed and processed by the 1 queues if not no transform and the 2 queues wil process

2) add message to queue that will aggregate based on customid header in groups of 3 
Put message on DE23_AggregateRequestQueue - needs a header customid - will aggregate these messages to DE23_AggregateResponseQueue in bactheds of 3 based on same customid header.





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
