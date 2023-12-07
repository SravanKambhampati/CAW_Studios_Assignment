#READ ME

# Maven Automation Project

This Maven Automation Project has been developed as an assignment provided by CAW Studios. It is designed to automate various tasks related to opening an application, filling in details by reading from JSON files, and asserting the values obtained from these files.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
- [Acknowledgments](#acknowledgments)

## Introduction

This Maven Automation Project was created as part of an assignment provided by CAW Studios. It aims to automate specific tasks related to a targeted application. The automation project streamlines the process of opening the application, populating details from JSON files, and performing assertions on the retrieved values.

## Features

- **Automated Application Opening:** The project includes automation to open the target application seamlessly.
- **JSON File Data Population:** JSON files are utilized to populate necessary details within the application.
- **Value Assertion:** The project performs assertions on the values obtained from the JSON files to ensure accuracy and reliability.


## Prerequisites

Before using this automation project, ensure the following prerequisites are met:

- Java JDK 8 or later
- Maven installed on your system

## Getting Started

Follow these steps to get started with the Maven Automation Project.

### Installation

Clone the repository and build the project using Maven:

```bash
$ git clone https://github.com/SravanKambhampati/CAW_Studios_Assignment.git
$ cd CAW_Studios_Assignment
$ mvn install
```

### Configuration

No additional configuration is required for basic usage. However, you can customize certain settings in the `config.properties` file if needed.

## Usage

To execute specific test cases, follow these steps:

1. Open the feature runner class (`FeatureRunner.java`) in your preferred Java editor.
   import org.junit.runner.RunWith;
   import io.cucumber.junit.Cucumber;
   import io.cucumber.junit.CucumberOptions;

   @RunWith(Cucumber.class)
   @CucumberOptions(
       features = "src/test/resources/features",
       glue = "stepdefinitions",
       tags = "@testCase"
   )
   public class FeatureRunner {
   }
   ```

2. Tag the scenarios you want to run with the `@testCase` annotation in your feature files.

   ```gherkin
   @testCase
   Scenario: Your tagged scenario
     Given ...
     When ...
     Then ...
   ```

3. Run the featureRunner.java to execute the tagged test cases:

   This will execute only the test cases with the specified tag as configured in your JUnit runner class.


## Acknowledgments

Special thanks to CAW Studios for providing the assignment that inspired the development of this automation project.

---
