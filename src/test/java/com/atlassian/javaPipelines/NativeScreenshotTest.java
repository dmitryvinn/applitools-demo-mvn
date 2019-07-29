package com.atlassian.javaPipelines;


import com.applitools.eyes.selenium.Eyes;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class NativeScreenshotTest {

    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new RemoteWebDriver(new URL("http://172.18.0.2:4444/wd/hub"), capabilities);
        // Create the Eyes instance
        eyes = new Eyes();
        eyes.setApiKey("Fr6tqbEAnI5LnbvGdxUPeHbanTvzf1vorPDz1pErILQ110");

        driver = eyes.open(driver, "Bitbucket Pipe App Name",
                "Bitbucket Test Name");
    }

    @After
    public void tearDown() {
        // If "close" was not called, this will mark the test as aborted.
        eyes.abortIfNotClosed();
        driver.quit();
    }

    @Test
    public void testHelloAmerica() {
        driver.get("http://example.com/");
        eyes.checkWindow("Main Window");
        eyes.close();
    }
}
