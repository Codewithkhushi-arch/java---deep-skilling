# Lab 16: Form Validation

## Overview
This lab demonstrates real-time form validation by evaluating state changes as the user types.

## Java Developer Perspective
**Form Validation vs. Java Bean Validation (JSR 380)**
In Java, we often use annotations like `@Email` or `@NotNull` on our DTOs to validate data at the controller boundary. 
On the frontend, React validates state incrementally. Instead of waiting for a submit event (like a Spring Boot `@Valid` payload), a Controlled Component allows us to execute validation logic inside the `onChange` handler directly, giving immediate feedback to the user before the payload is ever constructed for the backend.
