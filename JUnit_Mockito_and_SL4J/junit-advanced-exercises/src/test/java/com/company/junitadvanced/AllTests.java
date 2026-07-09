package com.company.junitadvanced;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    EvenCheckerTest.class,
    DummyTest.class
})
public class AllTests {
    // This class remains empty. It only serves as an entry point for the test suite.
}
