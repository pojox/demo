# demo
demo

# summary

- [x] FW using Selenium - TestNG - Extent - RestAssured - Maven 

- [x] Included modular implementation and reusable steps 
    - [x] **page-constants**: provides the page attributes labels, ,constants etc
    - [x] **page-objects**: provides the locaters - xpath,, css etc
    - [x] **page-helpers**: provides the steps to interact with the application 
    - [x] **various-common-helpers**: provides common utilities to help in interacting with page elements, validating expectations, generating validation messages waiters, logging, listeners etc
    - [x] **config.poperties**: provide basic parameters for test - like url, user credentials, standard wait-times
    
- [x] Included a logging mechanism for each actuon using log4j and extent reports

- [x] Included parallel test run capability using TestNG

- [x] Included a retry mechanism to retry failing tests 3 times using TestNG retry analyzer

- [x] Included waiting mechanisms that may be called by any step on demand 
    - [ ] _Home page load-wait need to revisited for speed. Currently waits for cookie. _
    
- [x] Test can be initiated via Jenkins pipeline using mvn commands with option for parameterizing target tests

- [x] Test included
    - [x] **Test01_logo_targets** - verify page transition based on guest/authneticated user
    - [x] **Test02_visit_blogs** - verify menu access to various learn pages
    - [x] **Test03_search** - verify search for posts & autocomplete suggestion checks 
    - [x] **Test04_carousel** - verify image carousel naggivation and target posts
    - [x] **Test05_api_schema** - verify jsaon schema

