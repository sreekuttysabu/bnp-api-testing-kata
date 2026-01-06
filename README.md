# Kata API Testing in Java

API Testing and Java Exercise: Setting up a Basic API Test Automation Framework.

## Objective
The objective of this exercise is to evaluate your knowledge on API testing and Java by setting up a basic API Test Automation framework using Rest-Assured and Cucumber. You will need to create a test suite that executes a few tests against one endpoint of a hotel booking website and evaluates their responses.

## Background
The application under test is a simple hotel booking website where you can book a room and also send a form with a request.

The website can be accessed at https://automationintesting.online/.

The Swagger documentation for the two endpoints you will be testing can be found at:

Booking endpoint: https://automationintesting.online/booking/swagger-ui/index.html  
Optionally, you also have the Authentican endpoint: https://automationintesting.online/auth/swagger-ui/index.html

### Swagger
This website is an external application which is not in our control.  
We noticed that the Swagger documentation is sometimes not available on the mentioned URL above.  
As a backup, you can find the Swagger documentation in this repository at [src/test/resources/spec/booking.yaml](src/test/resources/spec/booking.yaml)

The Open API Spec file is only supported in the Ultimate version of IntelliJ IDEA. But you can copy the content of the file and paste it in an online Swagger editor like https://editor.swagger.io/ to visualize the API documentation.

### Authentication
In order to authenticate yourself, the required credentials are:
* Username: `admin`
* Password: `password`

## Task
You are provided with an extremely basic API test project.

Please clone the project and create a new branch with your name. At the end, please push your branch to this project.

The project to start from, can be found here: https://github.com/freddyschoeters/API_Testing_kata

Your task is to set up an API Test Automation framework from this project using Java, Rest-Assured, and Cucumber (feel free to add more dependencies if required).

It is up to you to define the test cases. You don’t need to have a full coverage, but you need to show enough variation on the types of tests that you would need to write and execute, and what to check in the response.

This kata has the purpose to evaluate both your technical skills as well as your testing skills.

`For this task, you will use the booking endpoint.`


## Requirements
* Use Java as the programming language
* Use Rest-Assured as the API testing library
* Use Cucumber as the BDD framework
* Design your codebase using a proper Java design pattern
* Write good tests with correct checks
* Use Git for version control and push your codebase to an open GitHub repository
* Make regular commits to demonstrate your progress


## Deliverables
* Your branch pushed in the provided project.
* A comprehensive test suite covering the scenarios mentioned above
* A well-structured codebase with proper design patterns and comments
* Regular commits demonstrating your progress

## Evaluation Criteria
* Being able to successfully run the tests
* Correctness and completeness of the test suite
* Quality of the codebase (design patterns, structure, code quality, …)
* Use of Rest-Assured and Cucumber features
* Commit history and progress demonstration
#Initial setup verified in Eclipse.

## Overview of Automation Project
This project demonstrates a basic API Test Automation framework built using Java, Rest-Assured, and Cucumber (BDD).
It validates key functionalities of a public hotel booking API, focusing on test design, maintainability, and real-world stability rather than exhaustive coverage.
The solution is designed to reflect how API automation is approached in real projects, including handling of shared test environments.
________________________________________
## Tech Stack
- 	Java
- 	Rest-Assured – API testing library
- 	Cucumber – BDD framework
- 	JUnit Platform
- 	Maven
- 	Git / GitHub

## Application Under Test
- 	Base URL: https://automationintesting.online
- 	Booking API: /api/booking
- 	Authentication API: /api/auth
*  This is a shared public environment, so dynamic test data is used to reduce conflicts.

## Test Coverage
Booking – Create
* 	Create booking with valid data
* 	Create booking without deposit
* 	Validation error for invalid phone number
* 	Validation error when last name is omitted
* Booking – Update (Authenticated)
* 	Update booking firstname successfully
* Booking – Delete (Authenticated)
* 	Delete an existing booking successfully

## Design Approach
	
*  BDD-first design using readable feature files
*  Reusable utility classes for:
  - Payload creation
  - API endpoints
  - Configuration handling
* 	Dynamic test data (room IDs and dates) to avoid collisions
* 	No hard-coded credentials (read from configuration)
* 	Clear separation of concerns for maintainability
