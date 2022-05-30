package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{
    String browserName = "Chrome";
    public void openBrowser() {
        if(browserName.equalsIgnoreCase( "chrome" )){
            //public static void main(String[] args) {
            System.setProperty( "webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe" );
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase( "firefox" )){
            System.setProperty( "webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase( "edge" )){
            System.setProperty( "webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe" );
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
        //type URL
        driver.get( "https://demo.nopcommerce.com/" );
    }
    public void quit(){
        driver.quit();
    }
}
