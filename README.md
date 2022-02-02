**Selenium-Cucumber-TestNG-Maven ToDoProject**

Code built using Selenium-Cucumber-TestNG

**Folder Structure**

src/main/java
The Base package contains DriverManager class and TestNGCucumberTests class
DriverManager class has the methods to setup chrome driver, launch application and quite driver.
TestNGCucumberTests class is used to run the cucumber Runner class

The Hooks package has the Hooks class to run code before or after ascenario.

The Pages package has the ToDoPage class which contains the page elements and methods of business actions. 

The Utility package has the Util class to handle the elements identifed in the pages.


src/test/java
The Runner package has the Runner class with cucumber options to run cucumber scenarios
The StepDefenitions package has the StepDefs class with respective annotation to link the Step Definition that  Cucumber will execute when it on each Gherkin Step

src/test/resources
The Features folder has the TestToDo feature file with Gherkin steps of each scenario

cucumber.properties file has the cucumber.publish properties to display results accordingly


**Requirements**
Java
Maven
TestNG
WebDriver, using ChromeDriver


**Running Tests**
Clone the repository
Open the project using any Java IDE
Run the tests with testng.xml. Run as TestNG suite.

**Test Results**
Test result with number of tests run, passed and failed are displayed in console.
Link for the cucumber report with screenshot is shown in the console
For example: 
????????????????????????????????????????????????????????????????????????????
? View your Cucumber Report at:                                            ?
? https://reports.cucumber.io/reports/0ca07b12-4711-448b-b7eb-9a55b25fd0dc ?

TestNg report is also generated in the test-output folder
