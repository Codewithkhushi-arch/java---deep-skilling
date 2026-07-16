# Lab 2: Class Components

## Overview
This lab demonstrates how to create a React component using ES6 Classes. Class components were the traditional way to manage state and lifecycle hooks before React Hooks were introduced.

## Java Developer Perspective
**React Class Components vs. Java Classes**
A React Class Component is structurally very similar to a Java class extending a base class (e.g., `public class App extends Component`).
- `render()` method: Just like a Java object might override `toString()` to return a string representation of its state, a React class component must implement `render()` to return its UI representation (JSX).
- `this`: In Java, `this` refers to the current instance of the class. In React class components, `this` is used similarly to access instance properties, state (`this.state`), and props (`this.props`).
