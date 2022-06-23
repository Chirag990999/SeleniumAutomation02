package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {
    LoadProperty loadProperty = new LoadProperty();
    DesiredCapabilities caps = new DesiredCapabilities();


    public final String AUTOMATE_USERNAME = loadProperty.getProperty("bsUsername");
    public final String AUTOMATE_ACCESS_KEY = loadProperty.getProperty("bsAccessKey");
    public final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));

//    String browserName = "chrome";

    String browserName = System.getProperty("browser");
    //String browserName = loadProp.getProperty("browser");
    public void openBrowser() {
        if (cloud) {
            System.out.println("running cloud");
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.out.println("Chrome");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browse_version", "Latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            }else if (browserName.equalsIgnoreCase("Edge")) {
                System.out.println( "Edge" );
                caps.setCapability( "os", "Windows" );
                caps.setCapability( "os_version", "11" );
                caps.setCapability( "browser", "Edge" );
                caps.setCapability( "browse_version", "Latest" );
                caps.setCapability( "browserstack.local", "false" );
                caps.setCapability( "browserstack.selenium_version", "4.1.0" );
            }else if (browserName.equalsIgnoreCase("Firefox")) {
                System.out.println("Firefox");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browse_version", "Latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            }else{
                System.out.println("browser is wrong");
            }
            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("running locally");
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.out.println("Chrome");
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                //Open Firefox
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("The wrong browser");
            }
        }

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }


    public void quit () {

        driver.quit();
    }



}