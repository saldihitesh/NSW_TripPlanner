# NSW_TripPlanner
Trip Planner’ is a web application for planning trips within New South Wales using the public transport network.
*******************************************************************************************************************
          Trip Planner Framework
*******************************************************************************************************************
1.	Introduction: 
                  ‘Trip Planner’ is a web application for planning trips within New South Wales using the public transport network. As a test automation consultant you are required to create a quick Proof of Concept (POC) for implementing a test automation solution. For the purpose of this exercise we suggest limiting the time spent to around 2 hours.

2.	Task Create an automated test for the scenario below using open-source tooling (e.g. Selenium) in the language (C#, Java etc) and framework (xUnit, BDD etc) of your choice. Note that although the scenario is defined in Gherkin, a BDD implementation is not mandatory. 
 
 Scenario: A trip request can be executed and results returned
      Given Phileas is planning a trip
      When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
      Then a list of trips should be provided
      
  AUT URL: https://transportnsw.info/trip

3.	Solution Proposed: 
                      Trip Planner is a web application for planning trips, consists of numerous pages and functionalities. Hence, the best approach to automate the testing process of this application will be to develop the Page Object Model (POM) framework. In POM framework every page of the application has a corresponding page repository class and test class. Page repository includes details of the web elements and methods on that particular page to encapsulate the page methods from test methods. Whereas, test class will be consist of test cases corresponding to the pages of the application. By implementing this framework, we get the advantages, such as, easy to maintain, reusable, readable and easily understandable. For instance, if in future there are any changes in the web elements than only one page needs to be updated instead of all the page which are using that web element. POM also supports various type of file format, such as, Excel, CSV, txt and Database, which can be used as external file for providing the Test data to the test cases.
This framework is compatible with most of the continuous development and integration tools, such as Jenkins, Maven, Git, etc.  

4.  Key points: 
        1. Trip Planner – It’s Selenium java based Page Object Model (POM) Framework 
        2. It is a maven project, which make the build management easier. 
        3. Driver Type and Application under Test URL has been provided as the parameter from the testng.xml. 
        4. Page factory class has been implemented to use the annotation approach of the selenium. It makes the usage of Page Objects              simpler and easier. 
        5.  From and To stations name are passed in the test case using properties file. It makes the maintenance of the test input                 easy.  
5. Technology stacks:
        Automation Framework		: Selenium – Page Object Model

        Programming Language		: Java

        IDE				            : Eclipse

        Testing framework		    : TestNG

        Build Management 		    : Maven

        Subversion Tool			    : Git/GitHub

        CD/CI Tool			        : Jenkins

        Browser			            : Google Chrome and Firefox
        
6.	Pre-condition for the execution:
    i.	Maven has to be configured on the system, on which this project will be executed.

7.	Instruction for Installation and Execution:
    i.	Extract the project folder at any location, from where test has to be executed.
    ii.	Open command prompt and access the project location.
    iii.	Execute the command “mvn test”
    iv.	Verify the results.

8.	Project Structure:
    	src/test/java/ - has three folders: 
      •	com.qa.ahq.nswtripplanner.common – It Contains all common test utilites functions. 
      •	com.qa.ahq.nswtripplanner.pages – it contains all web Page of the Web Application. 
      •	com.qa.ahq.nswtripplanner.tests – it contains the all test classes of the web Application.

   src/test/resources/ - has two folders: 
      •	Drivers – to store the collection of browser driver exe files 
      •	TestData – to store the test case related file, e.g; properties file. 
      
9.	TestNG Result:
      [RemoteTestNG] detected TestNG version 6.14.3
      Launching google chrome...
      ===============================================
      NSW Trip Planner Automation Suite
      Total tests run: 1, Failures: 0, Skips: 0
      ===============================================

 
10.	Github Location:https://github.com/saldihitesh/NSW_TripPlanner/

