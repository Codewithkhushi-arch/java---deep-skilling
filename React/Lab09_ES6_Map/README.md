# Lab 9: ES6 Map

## Overview
This lab explores rendering lists using the ES6 `map()` array method. 

## Java Developer Perspective
**JavaScript map() vs. Java Streams map()**
The `Array.prototype.map()` method in JavaScript is almost exactly the same as the `map()` operation in Java 8 Streams (`java.util.stream.Stream.map()`).
In Java, you might do: `List<String> items = technologies.stream().map(tech -> "<li>" + tech + "</li>").collect(Collectors.toList());`
In React JSX, we use JavaScript's native array `.map()` to transform an array of data (like strings) into an array of React elements (like `<li>` tags).
