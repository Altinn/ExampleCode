# External Attachment Receiver
This SOAP web service is built using the Spring framework (https://spring.io/guides/gs/producing-web-service/).
The web service consumes SOAP requests, performs XML-validation based on XSD-files, and saves the payload + attachments to disk. The payload and attachments will be written to a "data" folder in the server root folder.

What you will need to run this project:
- JDK 1.8 or later
- Maven 3.0+

Both Java and Maven environment variables have to be set to run the application. (https://www.tutorialspoint.com/maven/maven_environment_setup.htm)

The application utilizes Spring Boot which embeds a Tomcat server within an executable .jar file. This means there is no need to install a specific server to run the application locally.

How to run:

1. Navigate to the project root folder
2. Execute the command: **mvn clean package** (This will create an executable jar in the "target" folder) / Can also execute the command: **mvn clean package spring-boot:run** (this will automatically create the executable jar, and run in it on the defualt port 8080)
3. Run the .jar file in the "target" folder with the following command: **java -jar external-attachment-receiver-1.0-SNAPSHOT --server.port=8080** (the port argument is optionable)

The servier should now be running on port 8080. 

The soap-ui-tests folder contains a package of tests that can be imported into SOAP UI to test the endpoint.

Errors are written to a logging file in the server root folder.

The javadoc folder contains documentation of the five non-auto-generated java-classes. The remaining classes are automatically generated from wsdl-, and xsd-files. This happens during the maven build.
