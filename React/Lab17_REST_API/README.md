# Lab 17: Consuming REST APIs

## Overview
This lab fetches data from an external REST API (JSONPlaceholder) asynchronously using the `fetch` API within a `useEffect` hook.

## Java Developer Perspective
**React fetch() vs. Java RestTemplate / WebClient**
In Java Spring Boot, you use `RestTemplate` or `WebClient` to make HTTP calls to external microservices.
In a React SPA, the `fetch` API (or libraries like `axios`) performs this role. By placing the `fetch` call inside a `useEffect` hook with an empty dependency array `[]`, we ensure the network call happens exactly once when the component mounts. This asynchronously retrieved data is then stored in state, triggering a UI re-render (just like asynchronously loading data into a Java desktop UI table).
