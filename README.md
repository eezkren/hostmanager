# hostmanager
simple spring boot / angular / clarity giving ability for CRUD operation over Host entity
it consists 3 projects

#### common 
- entity interfaces
- exception handling
- CRUD operation implementation with spring data
- Paging and Sorting functionality over entity collections (N/A in the UI)
  - /hosts?sortBy=id&sortOrder=ASC
  - /hosts?page=1&size=5
- event listeners for enriching response headers on resource retrieving and creation

#### restapi
- AUTH Server implementation with spring security and OAuth
- Resource server exposing the real restapi

#### ui
- the frontend angular project

### Build and Run
- clone the project (git clone https://github.com/isilona/hostmanager.git)
- build/run the **restapi** project 
  - /hostmanager mvn clean install 
  - find the jar in /hostmanager/restapi/target/restapi.jar
  - run the jar: java -jar restapi.jar
- build/run the **ui** project 
  - /hostmanager/ui npm install
  - /hostmanager/ui ng serve
