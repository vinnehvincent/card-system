#Card System

This system supports the business functionality and requirements of card card holders and their cards.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To be able to able to run the system successfully, the following are required:

```
Java 8 compiler
```
```
Apache Maven 3.6.0
```
```
Postgres 10.10
```
```
Wildfly Application Server 8.0.0.Final 
```
For installation of the above-mentioned, please consult their respective sites.
### Installing

Having installed the prerequisites, do the following:

*Prepare Database*

Create a database called "postgres", connect to the the database and run the following command: 
```
postgres=# \i /home/vinneh/Dev/Java/card-system/src/test/resources/META-INF/create.sql
```
this should create the necessary tables required for the system to run. 

To confirm that the tables a created successfully,
```  
postgres=#\dt
```
You should see the new tables
```
postgres=# \dt
            List of relations
 Schema |    Name     | Type  |  Owner   
--------+-------------+-------+----------
 public | cardholders | table | postgres
 public | cards       | table | postgres
(2 rows)

```
## Running the tests

Having created the tables, run the following command in the project folder
```
mvn clean install

```
This should run all the tests and confirm that the environment is correctly setup.
Furthermore, card-system.war should be created on /target folder in the project.


## Deployment

Deploy card-system on Wildfly.

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Vincent Tshabalala** - [Github](https://github.com/vinnehvincent)


