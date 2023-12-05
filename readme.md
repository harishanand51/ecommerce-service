
# Project Title - E-Commerce Application

## Overview
Welcome to our E-Commerce Application! This platform is designed to provide a seamless and enjoyable shopping experience for users seeking a diverse range of products. Whether you're a customer looking for the latest trends, a seller eager to showcase your products, or a developer interested in contributing to our open-source project, you've come to the right place.

## Features
Product Discovery: Explore a vast catalog of products conveniently categorized for easy navigation.

User Authentication: Securely create and manage your account to enhance your shopping experience.

Shopping Cart: Easily add and remove items from your cart before making a purchase.


## Getting Started
To get started with the E-Commerce Application, follow the installation steps outlined in the Installation Section of this README.

## Installation
To set up the application locally, follow the steps detailed in the Installation Guide. This will guide you through the necessary configurations for both the backend (server-side) and frontend (client-side) components of the application.

## Technologies Used
Backend: The server-side is built using the Spring Boot framework, offering a robust and scalable foundation.

Frontend: The user interface is crafted with Angular, providing a dynamic and responsive experience for users.

Database: We utilize a relational database to store and manage product information, user data, and order details.


## Installation Steps

### Spring Boot

#### 1. Install Java Development Kit (JDK)

Ensure that you have Java Development Kit (JDK) installed. You can download it from the official website: [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://adoptopenjdk.net/).

#### 2. Install an Integrated Development Environment (IDE)

Download and install an IDE of your choice. Popular choices for Spring Boot development include:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Eclipse](https://www.eclipse.org/)

#### 3. Set up Spring Boot Project

Create a new Spring Boot project or clone your existing project. You can use [Spring Initializr](https://start.spring.io/) to generate a project with the required dependencies.

#### 4. Build and Run

Build and run your Spring Boot application using the following commands:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Your Spring Boot application should be accessible at `http://localhost:8080`.

### Angular

#### 1. Install Node.js and npm

Ensure that you have Node.js and npm installed. You can download them from the official website: [Node.js](https://nodejs.org/).

#### 2. Install Angular CLI

Install the Angular CLI globally using the following command:

```bash
npm install -g @angular/cli
```

#### 3. Set up Angular Project

Create a new Angular project or clone your existing project using the Angular CLI:

```bash
ng new my-angular-app
cd my-angular-app
```

#### 4. Build and Run

Build and run your Angular application using the following commands:

```bash
ng serve
```

Your Angular application should be accessible at `http://localhost:4200`.

## Additional Configuration

Include any additional configuration steps or details that are specific to your project. This may include database setup, environment configurations, or any other relevant information.

# Contribution
Mani Deepika
Harish
Supriya
Tanvi
Charanvardhan

# SAMPLE TABLE is

# Review Table
## Overview
The Product Reviews API allows users to manage and retrieve reviews for a specific product. The API supports the following operations:

GET: Retrieve all reviews for a given product.
POST: Add a new review for a product.
POST: Edit an existing review for a product.

## Table Structure
The product reviews are stored in a relational database, and the main table representing reviews has the following structure:

### Fields:
id: Unique identifier for the review.
product_id: Identifier of the product the review is associated with.
rating: Numeric value representing the rating given by the user (e.g., on a scale of 1 to 5).
comment: Textual comment provided by the user.
review_date: Timestamp indicating when the review was created.



