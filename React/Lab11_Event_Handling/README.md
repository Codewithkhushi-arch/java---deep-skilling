# Lab 11: Event Handling

## Overview
This lab covers handling user events, such as button clicks, using React's SyntheticEvents.

## Java Developer Perspective
**React SyntheticEvents vs. Java AWT/Swing ActionListeners**
In Java Swing GUI development, you attach an `ActionListener` to a `JButton` to listen for click events. The listener receives an `ActionEvent` object containing details about the click.
React does something very similar: you attach a function to the `onClick` property. React wraps the native browser event into a cross-browser `SyntheticEvent` object, ensuring consistent behavior across all browsers, much like how Java abstracts underlying OS UI events into consistent `java.awt.AWTEvent` classes.
