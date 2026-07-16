# Lab 6: React Router

## Overview
This lab demonstrates client-side routing using `react-router-dom`. We create a simple navigation menu with `Home` and `About` pages, enabling seamless transitions without full page reloads.

## Java Developer Perspective
**React Router vs. Java Servlet / Spring MVC Mapping**
In a Java backend using Spring Boot, routing is typically handled by controllers (e.g., `@GetMapping("/about")`), which map URL paths to specific methods that return views or data.
React Router does the equivalent on the client-side. The `<Route path="/about" element={<About />} />` declaration is analogous to a `@GetMapping` mapping in Spring. Instead of the server sending a new HTML page, React Router intercepts the URL change and instructs React to render the `About` component in place of the `Home` component.
