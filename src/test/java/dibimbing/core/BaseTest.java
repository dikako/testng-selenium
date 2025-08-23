package dibimbing.core;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        DriverManager.initDriver("chrome");
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
