# Lab 19: Unit Testing (Jest & Mocking)

## Overview
This lab focuses on mocking dependencies in unit tests using Jest, isolating the code under test.

## Java Developer Perspective
**Jest Mocking vs. Mockito**
In Java unit testing, when a Service class depends on a Database Repository, you use Mockito (`@Mock` and `when().thenReturn()`) to mock the database responses and test the Service in isolation.
Jest provides the exact same mocking capabilities for JavaScript. You can use `jest.mock()` to mock external modules (like `axios` for HTTP requests), bypassing actual network calls and returning mock JSON objects. This allows you to verify that your React component correctly processes the data, strictly testing frontend logic in total isolation.
