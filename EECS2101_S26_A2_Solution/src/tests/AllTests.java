package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   StarterTests.class,
   StarterTestsMod.class,
   ExtraTests.class,
   ExtraTests2.class,
})

public class AllTests {
}  	