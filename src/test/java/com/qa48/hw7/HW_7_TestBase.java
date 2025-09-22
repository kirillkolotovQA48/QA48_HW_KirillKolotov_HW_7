package com.qa48.hw7;

import com.qa48.hw7.fw.HW_7_AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;

public class HW_7_TestBase {

    Logger logger = LoggerFactory.getLogger(HW_7_TestBase.class);

    protected static HW_7_AppManager app;
    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        if (app == null) {
            // Берем browser из системы, по умолчанию "chrome"
            String browser = System.getProperty("browser", "chrome");
            app = new HW_7_AppManager(browser); // передаем параметр в AppManager
            app.init();
            driver = app.getDriver();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (app != null) {
            app.stop();
        }
    }

    @BeforeMethod
    public void starTest(Method method){
        logger.info("Start test" + method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: "+result.getMethod().getMethodName());
        }
        else {
            logger.error("FAILED: "+ result.getMethod().getMethodName()+ "Screenshot path: "
                    +app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("*************************************");
    }

}

