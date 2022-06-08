package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductNikePage extends Utils{
    private By _ProductContainsNike =  By.xpath( "//div[contains(@class,'product-grid')]//div[@class='item-box']//h2" );



    public void verifyTheURL() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals( URL, "https://demo.nopcommerce.com/search?q=nike", "URL is not match" );
    }

    public void checkTheProductsContainsNikeBrand(){
        List<WebElement>nikeProductTitles = driver.findElements(_ProductContainsNike );
        for (WebElement n : nikeProductTitles){
            System.out.println(n.getText());
            Assert.assertTrue(n.getText().contains( "Nike" ) );
        }
    }



}
