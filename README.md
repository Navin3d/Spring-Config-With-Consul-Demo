# Spring-Config-With-Consul-Demo
This is just an Demo project on HashiCorp Consul with Spring Boot.


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Installation:
•	Install consul.exe from ` https://www.consul.io/downloads`.
•	Unzip it and you will find consul.exe you can and it to the path if you want else you can access it directly from the exe location through CMD.
Project Setup:
•	The setup consists of a consul agent running in command prompt.
•	The command to activate it is: 
•	` consul agent -server -bootstrap-expect=1 -data-dir=consul.data -ui -bind=<<YOURIPADDRESS>>`.
•	The consul agent will be running in localhost:8500 by default.
•	Once it is started mention these in the application.yml.
` spring:
  application:
    name: // your app-name
  profiles:
    active: // your profile
  cloud:
    consul:
      config:
        fail-fast: true
  config:
    import: consul:localhost:8500`
•	Simple web consists of a simple controller and a configuration class that fetch values from config server and delivers it to the controller.
Options for specifying the properties:
•	The properties are usually specified inside application.properties file inside resources of the respective application.
•	We can have properties that belongs to different profiles of that spring application so a single application may contain many property file in it but only one profile will be picked by the application that is specified by the property 
o	`spring.profiles.active=dev`
•	The third and most preferred way is to store the properties from a config server which picks up the data from 
o	Remote Github Repo,
o	Local File System,
o	Or From Database.
In this a dedicated server usually called with common name called config server is used.
o	This config server will pick up all the files from the location mentioned in its application.properties 
Example:
	`spring.cloud.config.server.git.uri=file:///D:/Programming/Java/Spring_Projects/configs-simple-web/`

o	We can have multiple property files inside config server similar like we have in our own spring boot application we can also have profile specific property file
Example: 
	`application-{profile}.properties`
	`{application-name}-{profile}.properties`

o	We can also specify the properties in run configurations as VM arguments.



Hierarchy Order:
		Hierarchy order in which the config server picks the property file is.
1.	VM arguments get the top priority.
2.	Application Specific Property files with respect to their active profile (simple-web-{profile}.properties).
3.	Common application profile property file (application-{profile}.properties).
4.	At last application.properties file will be getting the priority
5.	If two active profile set at the same time the second profile will be getting the higher priority.

References:
o	https://cloud.spring.io/spring-cloud-consul/reference/html/
o	https://www.baeldung.com/spring-cloud-consul

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Project Setup:
•	The setup consists of a config server and a Microservice.
•	Config Server with only the dependency of Spring Cloud Config Server.
•	The Microservice will have its own dependencies + Spring Cloud Config Client.
•	The Config Server’s Main class is annotated with @EnableConfigServer.
•	Config server application.properties file contains the location from which the configurations will be picked up.
•	Microservice acts as config client and the endpoints of config server is specified in that application.properties.
•	Simple web consists of a simple controller and a configuration class that fetch values from config server and delivers it to the controller.
Options for specifying the properties:
•	The properties are usually specified inside application.properties file inside resources of the respective application.
•	We can have properties that belongs to different profiles of that spring application so a single application may contain many property file in it but only one profile will be picked by the application that is specified by the property 
o	`spring.profiles.active=dev`
•	The third and most preferred way is to store the properties from a config server which picks up the data from 
o	Remote Github Repo,
o	Local File System,
o	Or From Database.
In this a dedicated server usually called with common name called config server is used.
o	This config server will pick up all the files from the location mentioned in its application.properties 
Example:
	`spring.cloud.config.server.git.uri=file:///D:/Programming/Java/Spring_Projects/configs-simple-web/`

o	We can have multiple property files inside config server similar like we have in our own spring boot application we can also have profile specific property file
Example: 
	`application-{profile}.properties`
	`{application-name}-{profile}.properties`

o	We can also specify the properties in run configurations as VM arguments.



Hierarchy Order:
		Hierarchy order in which the config server picks the property file is.
1.	VM arguments get the top priority.
2.	Application Specific Property files with respect to their active profile (simple-web-{profile}.properties).
3.	Common application profile property file (application-{profile}.properties).
4.	At last application.properties file will be getting the priority
5.	If two active profile set at the same time the second profile will be getting the higher priority.

References:

o	https://cloud.spring.io/spring-cloud-config/reference/html/
o	https://www.baeldung.com/spring-cloud-configuration
