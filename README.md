# hostmanager
Java Spring Boot application and a Single-Page application (SPA) in Angular 5 and Clarity [1] as following:
* The application connects with a PostgresSQL database to read/write data on a
table with two columns, one containing an IP address and the other a hostname
* The application has a REST web interface so that users interact with these
data (CRUD model implementation)
* The SPA consumes the REST interface, so that users interact with the data

#### common 
- entity interfaces
- exception handling
- CRUD operation implementation with spring data
- Paging and Sorting functionality over entity collections (N/A in the UI)
  - /hosts?sortBy=id&sortOrder=ASC
  - /hosts?page=1&size=5
- event listeners for enriching response headers on resource retrieving and creation

#### auth
- AUTH Server implementation with spring security and OAuth

#### restapi
- Resource server exposing the real restapi

#### ui
- the frontend angular project

### Build and Run
- clone the project (git clone https://github.com/isilona/hostmanager.git)
- build the whole project
  - /hostmanager mvn clean install
- run the **auth** project 
  - find the jar in /hostmanager/auth/target/restapi.jar
  - run the jar: java -jar restapi.jar
- build/run the **restapi** project 
  - find the jar in /hostmanager/restapi/target/restapi.jar
  - run the jar: java -jar restapi.jar
- build/run the **ui** project 
  - /hostmanager/ui npm install
  - /hostmanager/ui ng serve
