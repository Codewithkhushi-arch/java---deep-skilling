# Lab 15: React Forms

## Overview
This lab demonstrates Controlled Components in React. A controlled input's value is driven strictly by React state, rather than the DOM.

## Java Developer Perspective
**Controlled Components vs. Data Binding in JavaFX/JSF**
In traditional HTML, input fields maintain their own internal state. In a React Controlled Component, React state becomes the "single source of truth."
If you have used JavaFX properties and bidirectional data binding (`textProperty().bindBidirectional(...)`), the concept is identical. We bind the HTML input's `value` strictly to a state variable, and intercept `onChange` events to update that state variable. The UI always mirrors the state exactly.
