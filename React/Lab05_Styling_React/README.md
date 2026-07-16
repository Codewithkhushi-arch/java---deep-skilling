# Lab 5: Styling React Components

## Overview
This lab demonstrates how to style React components using CSS Modules, which scope CSS locally to the component by generating unique class names.

## Java Developer Perspective
**CSS Modules vs. Java Package Visibility**
In Java, we use access modifiers (like `private` or package-private) to encapsulate classes and prevent them from conflicting with identically named classes in other packages.
CSS Modules provide this exact encapsulation for stylesheets. Instead of creating global CSS styles that can cause naming collisions across the application, a CSS module scopes the styles specifically to the component importing it, much like package-private scoping in Java.
