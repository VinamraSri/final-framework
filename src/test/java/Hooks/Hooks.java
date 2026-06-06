package Hooks;

import Utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void openBrowser()
    {
        DriverManager.init();
    }

    @After
    public void tearDown()
    {
        DriverManager.quitDriver();
    }
}
