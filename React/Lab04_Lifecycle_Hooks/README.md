# Lab 4: Lifecycle Hooks

## Overview
This lab demonstrates the `componentDidMount` lifecycle hook in a React class component. This hook is used for executing side-effects, such as fetching data from an API, immediately after the component is rendered in the DOM.

## Java Developer Perspective
**Lifecycle Hooks vs. Java Constructors & @PostConstruct**
In Java Spring, you often use the `@PostConstruct` annotation to execute logic immediately after a bean is initialized and its dependencies injected, rather than putting that logic in the constructor.
Similarly, `componentDidMount` acts like `@PostConstruct`. The `constructor()` is used for initial setup (like variable initialization), while `componentDidMount()` is reserved for side-effects like network requests.
