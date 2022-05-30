package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessful extends Utils{
    private By _VerifyTheMessageYourRegistrationCompleted =  By.className( "result" );
    private By _ClickOnContinueButton =  By.xpath( "//a[@class=\"button-1 register-continue-button\"]" );



    public void userShouldVerifyThatRegistrationSuccessful(){
        //verification//Assert
        String actualMessage=driver.findElement( _VerifyTheMessageYourRegistrationCompleted).getText();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals( actualMessage,expectedMessage,"Registration is not match" );
    }
    public void userShouldClickTheContinueButton(){
        //Click on Continue button
        clickOnElement(_ClickOnContinueButton );
    }
}
