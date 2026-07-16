# Lab 7: Props

## Overview
This lab showcases the concept of 'Props' (short for properties) in React. We pass data from a parent component (`App`) to a child component (`Greeting`).

## Java Developer Perspective
**React Props vs. Java Constructor Arguments**
Props in React are conceptually identical to constructor arguments in a Java class. 
When you instantiate an object in Java (`new Greeting("Java Developer", "React")`), you pass arguments to configure the object's initial, immutable state. In React, `<Greeting name="Java Developer" />` passes props to the child component.
Just like you should not modify constructor arguments or `final` fields within a Java method, React props are strictly **read-only** inside the child component.
