package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Registration extends Utils{
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
        typeText(_FirstName ,"Automation");

        //Enter Last Name
        typeText(_LastName,"LastNameTest" );

        //select day of the birthday
        Select DayOfBirth =new Select( driver.findElement(_SelectTheDayOfBirthDay ) );
        DayOfBirth.selectByIndex( 7 );

        //select month of the birthday
        Select MonthOfBirth= new Select( driver.findElement( _SelectTheMonthOfBirthDay) );
        MonthOfBirth.selectByIndex( 3 );

        // select year of the birthday
        Select YearOfBirth = new Select( driver.findElement( _SelectTheYearOfBirthDay ) );
        YearOfBirth.selectByValue( "1981" );

        //Enter Email
        typeText(_EnterEmail,"Automation"+randomDate()+"@bmail.com" );

        //Enter Password
        typeText(_EnterPassword,"Auto123" );

        //Enter Confirm password
        typeText( _EnterConfirmPassword,"Auto123" );

        //Click register
        clickOnElement(_ClickOnRegister  );
    }
}
