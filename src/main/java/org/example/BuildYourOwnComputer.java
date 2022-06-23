package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.example.BasePage.driver;
import static org.example.Utils.clickOnElement;

public class BuildYourOwnComputer extends Utils {

    LoadProperty loadProperty = new LoadProperty();

    private By _EmailFriend = By.xpath( "//form[@action=\"/build-your-own-computer\"]/div[2]/div[1]/div[2]/div[10]/div[3]" );
    private By _IntelPremiumDualCoreE2200Processor = By.xpath( "//select[@name=\"product_attribute_1\"]" );
    private By _RAM2Gb = By.xpath( "//select[@name=\"product_attribute_2\"]" );
    private By _320GbHDD = By.xpath( "//label[@for=\"product_attribute_3_6\"]" );
    private By _VistaPremiumOS = By.xpath( "//label[@for=\"product_attribute_4_9\"]" );
    private By _AcrobatSoftware = By.xpath("//label[@for=\"product_attribute_5_11\"]" );
    private By _TotalCommanderSoftware = By.xpath( "//label[@for=\"product_attribute_5_12\"]" );
    private By _AddToCart = By.xpath( "//button[@id=\"add-to-cart-button-1\"]" );
    private By _ShoppingCart = By.xpath( "//div[@class=\"header-links\"]/ul/li[4]/a/span[2]" );


    public void selectEmailAFriendOption (){
        //Select Email a friend option
        clickOnElement(  _EmailFriend);
    }
    public void selectTheGHzIntelPremiumProcessorDualCoreE2200FromTheDropDownMenu(){
        //Select the Processor 2.2 GHz Intel Premium
        Select Processor = new Select( driver.findElement(_IntelPremiumDualCoreE2200Processor) );
        Processor.selectByValue(loadProperty.getProperty( "2.2GHzIntelPremiumDualCoreProcessor" ) );
    }
    public void selectThe2GbRAMFromTheDropDownMenu(){
        //Select the RAM 2GB
        Select RAM = new Select( driver.findElement( _RAM2Gb ) );
        RAM.selectByValue( loadProperty.getProperty( "RAM2GB" ) );
    }
    public void selectThe320GbHDD(){
        //select the HDD 320GB
        clickOnElement( _320GbHDD );
    }
    public void selectTheVistaPremiumOS(){
        //Select OS Vista Premium
        clickOnElement( _VistaPremiumOS );
    }
    public void selectTheAcrobatReaderSoftware(){
        //Select Software Acrobat Reader Software Category
        clickOnElement(_AcrobatSoftware );
    }
    public void selectTheTotalCommanderSoftware(){
        //Select Software Total Commander Software Category
        clickOnElement(_TotalCommanderSoftware);
    }
    public void selectAddToCartButton(){
        //Select ADD TO CART
        clickOnElement(_AddToCart  );
    }
    public void selectShoppingCartButton(){
        // Select SHOPPING CART
        clickOnElement( _ShoppingCart );
    }

}
