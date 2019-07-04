
[![Build Status](https://travis-ci.org/ta4anka/projectSpringMvc.svg?branch=master)](https://travis-ci.org/ta4anka/projectSpringMvc)

**`Employee manager`**

****Task:****

Implement an application that allows you to store employee data.

It is necessary to implement access control:
- Administrator (ROLE_ADMIN): full access to the application (management of employees, departments and users);
- Moderator (ROLE_MODERATOR): full management of staff and departments;
- User (ROLE_USER): only reading data about employees and departments;

****Requirements:****

 * The application must be deployed on **heroku**.
 * The github repository should display the build status (**travis CI**).
 * It is necessary to implement the registration and authentication of users.
 * Upon registration -  _ROLE_USER_
 * It is necessary to implement registration confirmation by phone number (**twilio**).
 * You need to implement two launch environments - dev and prod.

****Technologies:****

**Java, MySQL, Spring** (_MVC, Data, Security_), **Lombok, Maven**, **Thymeleaf**, **Liquibase.**

The result of the execution of the application should be an application deployed on **heroku.**

 * [Link to realization - springmvcemployeemanager](http://springmvcemployeemanager.herokuapp.com)

--------------------------------------

Useful links:
 * [Thymeleaf + Spring Security integration basics](https://www.thymeleaf.org/doc/articles/springsecurity.html)
 * [Getting started with Spring MVC and Twilio](https://www.twilio.com/blog/2015/11/getting-started-with-spring-mvc-and-twilio.html)
 * [Deploying Tomcat-based Java Web Applications with Webapp Runner](https://devcenter.heroku.com/articles/java-webapp-runner)
 * [Connecting to Relational Databases on Heroku with Java configuration](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-spring-with-java-configuration)