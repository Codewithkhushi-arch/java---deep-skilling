# Lab 12: Conditional Rendering

## Overview
This lab demonstrates how to conditionally render React elements based on the component's state using the ternary operator.

## Java Developer Perspective
**Conditional Rendering vs. Java if-else / Ternary Operator**
Just as Java allows you to conditionally assign a value using `condition ? trueValue : falseValue`, React JSX uses this exact same JavaScript ternary operator to conditionally return UI blocks. Because JSX compiles to method calls (`React.createElement`), standard Java/JavaScript `if/else` statements cannot be embedded directly in the middle of a JSX expression, making the ternary operator the preferred tool for conditional UI rendering.
