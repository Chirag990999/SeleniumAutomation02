package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utils{
    LoadProperty loadProperty = new LoadProperty();

    private By _SelectBuildYourOwnComputer = By.xpath( "//div[@class=\"details\"]/h2//a[@href=\"/build-your-own-computer\"]" );
    private By _SelectSortByNameZtoAOption = By.xpath( "//select[@name='products-orderby']" );
    private By _GetDesktopsProductTitles = By.xpath( "//div[contains(@class,'product-grid')]//div[@class='item-box']//h2" );
    private By _GetDesktopsProductTitlesAfterFilterNameZTOA = By.xpath( "//div[contains(@class,'product-grid')]//div[@class='item-box']//h2" );



    public void selectBuildYourOwnComputer(){
        //Select and click on "build your own computer" option
        clickOnElement( _SelectBuildYourOwnComputer );
    }

    public void selectSortByNameZToAOption(){
        Select NameZToA = new Select( driver.findElement( _SelectSortByNameZtoAOption ) );
        NameZToA.selectByValue(loadProperty.getProperty( "NameZToA.selectByValue" ));
    }

    public void getDesktopsProductTitles(){
        List<WebElement> desktopsProductTitles = driver.findElements(_GetDesktopsProductTitles);
        for(WebElement e: desktopsProductTitles){
            System.out.println(e.getText());
        }
    }

    public void getDesktopsProductTitlesAfterFilterNameZTOA(){
        List<WebElement> desktopsProductTitlesAfterFilter = driver.findElements(_GetDesktopsProductTitlesAfterFilterNameZTOA  );
        for (WebElement e: desktopsProductTitlesAfterFilter){
            System.out.println(e.getText());
        }
    }

    public void verifyProductNameInZToAOrderAfterAppliedFilerSortByNameZtoA(){
        List<WebElement> desktopsProductTitles = driver.findElements(_GetDesktopsProductTitles);
        for(WebElement e: desktopsProductTitles){
            System.out.println(e.getText());
        }

        Select NameZToA = new Select( driver.findElement( _SelectSortByNameZtoAOption) );
        NameZToA.selectByValue(loadProperty.getProperty( "NameZToA.selectByValue" ));

        List<WebElement> desktopsProductTitlesAfterFilter = driver.findElements( _GetDesktopsProductTitlesAfterFilterNameZTOA );
        for (WebElement e: desktopsProductTitlesAfterFilter){
            System.out.println(e.getText());
        }
        List<String>expectedDesktopProductTitles = Arrays.asList( "Lenovo IdeaCentre 600 All-in-One PC","Digital Storm VANQUISH 3 Custom Performance PC","Build your own computer" );
        List<String>actualDesktopProductTitles = new ArrayList<>();
        for (WebElement e: desktopsProductTitles){
            actualDesktopProductTitles.add(e.getText());
        }
        Assert.assertEquals( actualDesktopProductTitles,expectedDesktopProductTitles,"Products are not in order as expected" );
    }

    public void applyTheFilterByNameZtoAThenVerifyTheProductInZtoAOrder(){
        ArrayList<String> advanceList = new ArrayList<>();
        List<WebElement>beforeFilterList = driver.findElements( _GetDesktopsProductTitles );
        for (WebElement x : beforeFilterList){
            advanceList.add( x.getText() );
        }
        ArrayList<String>sortedList = new ArrayList<>();
        for (String y : advanceList){
            sortedList.add( y );
        }
        Collections.sort( sortedList );
        Collections.reverse( sortedList );
        Assert.assertTrue(sortedList.equals( advanceList ));


    }



}
