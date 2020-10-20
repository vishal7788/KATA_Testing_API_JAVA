# KATA Testing JAVA

## Framework structure

The below framework can be used for API automation, using Java, Maven and  RestAssured (a Java DSL for easy testing of REST services)

### com/kss
In this folder you will find the pets.feature file, that you can use as an example for further scenarios.
It is also the place you will store yoru BDD scenarios.

### dto

This folder contains all the Getters/Setters for all the objects from the services (visit, pets, pet, owner ...) 

### step_definitions

In this folder you will store all the step definitions for the BDD scenarios created

### support

In the support folderm you have all general methods used within different test cases (e.g. call get request, call post request) - in the `SupportFunctions.java` or helpers for interacting with JSON objects (in `JSONFileParser.java`)

## Instructions

Clone locally the repository from here:
`https://github.com/spring-petclinic/spring-petclinic-rest`
In order to run it locally do the following:

* open GitBash
* cd spring-petclinic-rest
* ./mvnw spring-boot:run

In a browser navigate to http://localhost:9966/petclinic/swagger-ui.html#/ after the build is complete

You should be able to access all the APIs for this project. (e.g. in the `pet-rest-controller` you can access all the APIs for the pets category)

Create BDD scenarios and execute them successfully for the following situations:

* Add a new pet (Attention points: in order to have the correct information in the request body you need to first GET the owners details + GET a pet's category(id + name). Visits information are not mandatory, but the visits:[] Array needs to be in the request body)
* Using scenario outline, create a vet for each of the specialities (the id of the speciality is required)

## Useful resources

* https://itsadeliverything.com/declarative-vs-imperative-gherkin-scenarios-for-cucumber

