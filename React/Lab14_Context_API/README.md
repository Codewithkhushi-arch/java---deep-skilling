# Lab 14: Context API

## Overview
This lab demonstrates the Context API, which provides a way to pass data deeply through the component tree without having to pass props manually down at every level ("prop drilling").

## Java Developer Perspective
**Context API vs. Spring Dependency Injection (IoC)**
In Java, passing dependencies down through 5 layers of object constructors is tedious. Instead, Spring Boot's IoC container allows you to declare a `@Bean` globally and `@Inject` or `@Autowired` it exactly where it's needed.
The React Context API solves the exact same problem for the frontend. A Context `<Provider>` acts like a Spring ApplicationContext, exposing a value globally to its children. A nested component uses `useContext()` (acting like `@Autowired`) to grab that value directly, bypassing intermediate components.
