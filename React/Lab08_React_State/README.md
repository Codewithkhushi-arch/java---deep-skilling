# Lab 8: React State

## Overview
This lab introduces the concept of `State` in React class components. We build a simple counter that increments its value when a button is clicked.

## Java Developer Perspective
**React State vs. Java Instance Variables**
In Java, an object maintains its internal state using private instance variables. In React, a component maintains its state using the `state` object.
However, there is a critical difference: in Java, you directly assign values (`this.count = 5;`). In React, state is immutable and you **must** use `this.setState()`. 
Using `setState()` is analogous to calling a setter method in Java (`setCount(5)`) that also triggers a `notifyListeners()` or `revalidate()` method, informing React that the state has changed and it needs to re-render the UI.
