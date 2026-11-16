# SauceDemo Playwright Frontend Testing

## Overview

SauceDemo Playwright Frontend Testing is an automated UI testing framework built with Java, Playwright, JUnit 5, and Maven. The project validates the functionality of the SauceDemo e-commerce web application through end-to-end automated test scenarios using the Page Object Model (POM) design pattern.

## Technologies

- Java
- Playwright
- JUnit 5
- Maven
- Page Object Model (POM)
- Git

## Project Structure

- **base** – Foundational base classes (`BasePage` providing shared page utilities and `BaseTest` handling browser lifecycle setup)
- **pages** – Page Object classes containing page-specific locators for application elements
- **actions** – Action classes containing UI interaction methods representing user actions
- **components** – Reusable UI components (Header and Footer bars) shared across multiple pages
- **tests** – Automated UI test classes organized by application features and checkout funnel scenarios

## Test Coverage

The framework covers 89 validation checkpoints, including:

- Authentication (Positive credentials, missing fields, and unauthenticated access restrictions)
- E-Commerce Funnel (Cart interactions, information forms, and order placement paths)
- Dynamic Financial Calculations (Dynamic product price calculations, 8% tax calculations, and custom precision rounding)
- Visual Style Validation (Typography layouts, CSS font sizing, background hex color codes, and hover state transitions)
- Positive scenarios
- Negative scenarios
- Parameterized tests (ValueSource and CsvSource data matrices)

## Design Principles

- Page Object Model (POM)
- Complete decoupling of page locators (pages) from interaction methods (actions)
- Reusable UI components
- Separation of test logic from dynamic mathematical calculations and style interactions
- Clean and maintainable project structure

## Documentation

The repository also includes:

- Automation Test Evidence (PDF report with execution metadata and run screenshots)

---

Developed as a comprehensive QA Automation portfolio project covering automated UI testing.
