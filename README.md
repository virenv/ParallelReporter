# ParallelReports
 
Using TestNG with ExtentReports
Purpose: Demonstrate parallel runs by-method and by-class.

## Quick Setup

Just import into your IDE as a Gradle project and run with the command:
gradle cleanTest test

The build.gradle can be setup to scan for .java files or explicity run a testng.xml file.

NOTE: If you run with Gradle, IntelliJ-IDEA will hide test results from you in the IDE window, and it will not if you run with a TestNG run configuration.

## Manual Setup Without Gradle

To run this project, add these 3 .jar files to your classpath:

1. extentreports-2.41.2.jar
2. freemarker-2.3.23.jar
3. testng-6.10.jar

## Manual Execution

This project is not implemented with Maven or Gradle but support could easily be added.

### Manual Execution Using Intellij-IDEA

1. Import the project as a generic project.
2. Create a new Run Configuration for TestNG
3. Choose "Run As Suite"
4. Execute

### Manual Execution Using Eclipse

1. TODO


