# Lab 18: Unit Testing (Enzyme / React Testing Library)

## Overview
This lab introduces the concepts of component testing. *Note: Enzyme is deprecated for React 18, so modern React uses React Testing Library, but the architectural concepts remain the same.*

## Java Developer Perspective
**Component Testing vs. JUnit + Spring MockMvc**
In Java Spring, `MockMvc` allows you to test controller endpoints without starting a full HTTP server, simulating requests and asserting on the JSON responses.
In React, Enzyme or React Testing Library allows you to mount a component in an isolated, simulated DOM (using `jsdom`) without starting a real browser. You can simulate clicks and assert on the rendered HTML output, making it extremely fast and predictable, exactly like a `MockMvc` test.
