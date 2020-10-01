<h1 align="center">Nutrients Tracker</h1>

<p align="center">
  <img src="https://img.shields.io/github/license/karolku/nutrients_tracker">
  <img src="https://img.shields.io/github/languages/count/karolku/nutrients_tracker">
  <img src="https://img.shields.io/badge/madeby-karolku-green">
</p>

<img src="./readme_assets/logo-1.jpg">

  ## Description
  
  <p>
  Web application that allows to track daily nutrients needs. This app aims to help people 
  with autoimmune disease that try to improve their
  health conditions with the use of diet.
  Users can register/login, search for detailed products, check their nutrients as well as 
  make food entires to be able to display the added products presented in a form of a dashboard 
  with some key statistics. The system would check how much of each nutrients
  they consumed and find their macro or micro nutrient deficits.
  </br>
  </br>
  The appliction is build with a mobile first approach to make the mobile browsing as pleasant as the desktop experience. For the system the three-tier architecture was used with clear separation between the presentation, business and database layers allowing modular code development, were the presentation and business layers were communicating through the HTTP protocol and following REST architectural style.
  </p>
</br>
<p align="center">
<img src="https://media.giphy.com/media/mkwCXfGWQDO5Uhn0O8/giphy.gif"></p>
<br>
<p>Users can display food entries for given days and check basic statistics about all the nutrients consumed.</p>
<br>
<p align="center">
<img src="https://media.giphy.com/media/lnqf9bp0LwPpQz8fjQ/giphy.gif"></p>

## Installing

Project is build with Maven, so it is required to download Maven first. In order to run the app the database has to be created and application.properties file requires infomration about the database. The Java JPA with Hibernate implementation will take care of creating the tables.

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
  <li> <a href="https://angular.io">Angular</a> - Development platform for creating single-page applications.</li>
  <li> <a href="https://spring.io/projects/spring-boot">Spring Boot</a> - Java-based framework to build spring based applications with minimum configuration.</li>
  <li> <a href="https://hibernate.org">Hibernate</a> - Object Relational Mapping, implementation of the Java JPA.</li>
  <li> <a href="https://www.mysql.com">MySQL</a> - Relational Database Management System.</li>
  <li> <a href="https://maven.apache.org">Maven</a> - Management tool.</li>
</ul>

## License
The project is licensed under the MIT licence, check the LICENSE file for details.
