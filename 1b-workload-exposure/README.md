# 1B Workload Exposure

Workload Exposure task is written in Java using Maven for build and with Eclipse IDE, performs searching if array is in waveform or not.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What you need to have:

* Installed at least JDK 1.8 and Maven
* Eclipe IDE if you want to import project and change the code

### Running the project

This project is structured to be able to accept the parameters through main method arguments. 
Because of the easier manipulation you can pass the numbers in a String form and it will be converted into array of numbers.
The example of how you can run the project is described below.

This project can be run with the command:
* mvn exec:java -Dexec.mainClass=com.codingchallenge.workload.WorkloadApp -Dexec.args="0 8 15 7 13 4 1"
* -Dexec.args="0 8 15 7 13 4 1" represents the array that can be passed to main method as parameter and which is used to find if array is in waveform.

## Running the tests

* To run the unit tests, call 'mvn test'
* To run the integration tests as well, call 'mvn verify'

## Built With

* A Java 8 application with tests
* Unit tests written with [JUnit 5](https://junit.org/junit5/)
* Integration tests written with [JUnit 5](https://junit.org/junit5/)
* A Maven build that puts it all together

## Conventions

This example follows the following basic conventions:

| | unit test | integration test |
| --- | --- | --- |
| **resides in:** | `src/test/java/*Test.java` | `src/test/java/*IT.java` |
| **executes in Maven phase:** | test | verify |
| **handled by Maven plugin:** | [surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) | [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/) |