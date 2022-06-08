package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {
    DriverManager driverManager = new DriverManager();
    @BeforeMethod
    public void openSetup(){
        driverManager.openBrowser();
    }
    @AfterMethod
    public void closeSetup(ITestResult result){
        if(!result.isSuccess()){
            takeSnapShot( result.getName() );
        }
        driverManager.quit( );
    }
}
