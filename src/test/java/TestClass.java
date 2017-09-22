import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {
    AppiumDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus 5");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("platformName", "Android");
        File file = new File("/home/yogesh/Downloads", "DelphiAnaliticsApp-com.ooyala.android.analytics-1-v1.0.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.ooyala.android.analytics");
        capabilities.setCapability("appActivity", "com.ooyala.android.analytics.LoginActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testMethod() {
        MobileElement userName = (MobileElement) driver.findElement(By.id("com.ooyala.android.analytics:id/testerName"));
        userName.sendKeys("Yogesh Adsare");

        MobileElement emaiId = (MobileElement) driver.findElement(By.id("com.ooyala.android.analytics:id/emailID"));
        emaiId.sendKeys("yogesh.adsare@forgeahead.io");

        MobileElement hlsRadioButton = (MobileElement) driver.findElement(By.id("com.ooyala.android.analytics:id/radioHLSAssets"));
        hlsRadioButton.click();

        MobileElement selectCountry = (MobileElement) driver.findElement(By.id("com.ooyala.android.analytics:id/menu_settings"));
        selectCountry.click();

    }
}
