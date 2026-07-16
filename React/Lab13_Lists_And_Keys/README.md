# Lab 13: Lists and Keys

## Overview
This lab expands on `map()` by demonstrating the critical requirement of `key` props when rendering lists of components.

## Java Developer Perspective
**React Keys vs. Java Object HashCodes**
In React, when iterating over an array to render elements, React requires a unique `key` prop for each element. This key helps React's Virtual DOM reconciliation engine identify which items have changed, been added, or been removed.
This is similar to the concept of `hashCode()` in Java Collections. A `HashMap` uses the hash code to quickly identify and locate an object. React uses the `key` to quickly locate the specific DOM node that needs updating, avoiding unnecessary re-renders of the entire list.
