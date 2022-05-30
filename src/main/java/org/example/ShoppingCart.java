package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCart extends Utils{
    private By _VerifyTheCorrectItemInTheShoppingCart =  By.xpath( "//td[@class=\"product\"]/a" );




    public void verifyTheItemInTheShoppingCart(){
        //verification Message//Assert
        String ActualProduct = driver.findElement( _VerifyTheCorrectItemInTheShoppingCart).getText();
        String ExpectedProduct = "Build your own computer";
        Assert.assertEquals( ActualProduct,ExpectedProduct,"Product is not match" );
    }
}
