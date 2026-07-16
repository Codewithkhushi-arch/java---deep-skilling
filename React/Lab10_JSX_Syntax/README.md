# Lab 10: JSX Syntax

## Overview
This lab focuses on JSX (JavaScript XML), illustrating how we can seamlessly embed JavaScript expressions (variables and logic) inside what looks like HTML markup.

## Java Developer Perspective
**JSX vs. JavaServer Pages (JSP) / Thymeleaf**
If you have used JSP or Thymeleaf in Java web development, JSX serves a similar purpose: it is a templating syntax. 
However, JSP and Thymeleaf are server-side templating engines (they generate HTML strings on the server). JSX is a syntax extension for JavaScript that gets compiled into `React.createElement()` calls (it generates a virtual DOM on the client). 
In JSP you use `<%= variable %>` to output data; in JSX you simply use `{variable}`.
