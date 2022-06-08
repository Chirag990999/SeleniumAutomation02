package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Registration extends Utils{
    LoadProperty loadProperty = new LoadProperty();

    private By _MaleGender =  By.xpath( "//input[@id='gender-male']" );
    private By _FirstName = By.xpath( "//input[@name='FirstName']");
    private By _LastName =  By.id( "LastName" );
    private By _SelectTheDayOfBirthDay = By.xpath( "//select[@name='DateOfBirthDay']" );
    private By _SelectTheMonthOfBirthDay = By.xpath("//select[@name='DateOfBirthMonth']" );
    private By _SelectTheYearOfBirthDay = By.xpath( "//select[@name='DateOfBirthYear']" );
    private By _EnterEmail =  By.xpath( "//input[@name=\"Email\"]" );
    private By _EnterPassword =  By.xpath( "//input[@name=\"Password\"]" );
    private By _EnterConfirmPassword = By.xpath( "//input[@name=\"ConfirmPassword\"]" );
    private By _ClickOnRegister = By.xpath( "//button[@id=\"register-button\"]" );

    public void userEnterDetailsOnRegistrationPageSuccessfully(){
        //Select Male or Female
        driver.findElement(_MaleGender).click();

        //Enter First Name
        typeText(_FirstName ,loadProperty.getProperty( "FirstName" ));

        //Enter Last Name
        typeText(_LastName,loadProperty.getProperty( "LastName" ) );

        //select day of the birthday
        Select DayOfBirth =new Select( driver.findElement(_SelectTheDayOfBirthDay ) );
        int DayOfBirthday = Integer.parseInt( loadProperty.getProperty( "DayOfBirthday" ) );
        DayOfBirth.selectByIndex(DayOfBirthday);

        //select month of the birthday
        Select MonthOfBirth= new Select( driver.findElement( _SelectTheMonthOfBirthDay) );
        MonthOfBirth.selectByVisibleText(loadProperty.getProperty( "MonthOfBirthday" ) );

        // select year of the birthday
        Select YearOfBirth = new Select( driver.findElement( _SelectTheYearOfBirthDay ) );
        YearOfBirth.selectByValue( loadProperty.getProperty( "YearOfBirthday" ) );

        //Enter Email
        typeText(_EnterEmail,loadProperty.getProperty( "EmailFirstPart" )+randomDate()+loadProperty.getProperty( "EmailLastPart") );

        //Enter Password
        typeText(_EnterPassword,loadProperty.getProperty( "Password" ) );

        //Enter Confirm password
        typeText( _EnterConfirmPassword,loadProperty.getProperty( "ConfirmPassword" ));

        //Click register
        clickOnElement(_ClickOnRegister  );
    }
}
