<h1 align="center">Nutrients Tracker</h1>

<p align="center">
  <img src="https://img.shields.io/github/license/karolku/nutrients_tracker">
  <img src="https://img.shields.io/github/languages/count/karolku/nutrients_tracker">
  <img src="https://img.shields.io/badge/madeby-karolku-green">
</p>

<img src="./readme_assets/logo-1.jpg">

  Web application that allows to track daily nutrients needs.This app aim to help people 
  with autoimmune disease that try to improve their
  health conditions with the use of diet. Users can register/login and write down what
  they have have eaten during a given day, the system would check how much of each nutrients
  they consumed which would help identify their macro or micro nutrient deficits, help them
  choose adequate food products and give recommendations of which products they can consume
  depending on their diet.

<p align="center">
<img src="https://media.giphy.com/media/mkwCXfGWQDO5Uhn0O8/giphy.gif"></p>
<br>
<p>Users can display food entries for given days and check basic statistics about all the nutrients consumed.</p>
<br>
<p align="center">
<img src="https://media.giphy.com/media/lnqf9bp0LwPpQz8fjQ/giphy.gif"></p>

## Installing

Project is build with Maven. In order to run the app the database has to be created and application.properties file requires infomration about the database. Java JPA with Hibernate implementation will take care of creating the tables.
```
spring.datasource.url= 
spring.datasource.username= 
spring.datasource.password=
```
In order to run the server application run

```
mvn clean install
mvn spring-boot: run
```

In order to run the Angular client
```
ng serve
```

If there are problems with dependencies for the Angualr application try

```
npm install
ng update
npm update
```
## Built with
<ul>
  <li> <a href="https://angular.io">Angular</a> - Development platform for creating single-page applications.
  <li> <a href="https://spring.io/projects/spring-boot">Srping Boot</a> - Java-based framework to build spring based applications with minimum configuration.
  <li> <a href="https://spring.io/projects/spring-boot">Maven</a> - Management tool.
</ul>

## License
The project is licensed under the MIT licence, check the LICENSE file for details.
