# Bookspace

This project is a Book Management application. It is developed using Java, SQL, and Maven.

## Prerequisites

- Java 21
- Maven 3.6.3
- MySQL 8.0+
- Nacos

## Getting Started

First, clone the repository to your local machine:

```bash
git clone https://github.com/JunCheung/book-space-cloud.git
```

## Initial

Initial database with the files in the folder "sql" in the project.

## Building the Project

To build the project, run the following command:

```bash
mvn clean package
```

## Running the Project

To run the project, use the following command:

```bash
mvn install
```

Run gateway

```bash
cd bookspace-gateway
mvn spring-boot:run
```

Run book module

```bash
cd bookspace-module-book/bookspace-module-book-biz
mvn spring-boot:run
```

## Deploying the Project With Docker

The profile "dev" is default, you can change it to "prod" but make sure you have update url and username/password for
the database.

And before deploying, you should Build the project first, then run the following command:

```bash
cd deploy
docker-compose up --build -d
```
