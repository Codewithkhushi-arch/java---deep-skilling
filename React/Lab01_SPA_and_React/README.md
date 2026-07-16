# Lab 1: SPA and React

## Overview
This project demonstrates the creation of a simple Single Page Application (SPA) using React. The application renders a basic heading on the page, initializing our journey into React development.

## Java Developer Perspective
**React Application vs. Java `public static void main(String[] args)`**
In Java, execution begins at the `main` method. In a React application, execution begins at `index.jsx` or `main.jsx`, where `ReactDOM.createRoot().render()` is called to attach our root React component (`App`) to the DOM. Just as a Java program needs an entry point to bootstrap the JVM execution, a React app needs a mounting point (usually an `<div id="root">`) in the HTML file.
