package org.example;

import org.openqa.selenium.By;

public class Computers extends Utils{
    private By _ClickOnDesktops = By.xpath( "//h2[@class=\"title\"]//a[@title=\"Show products in category Desktops\"]" );


    public void selectDesktopsOption(){
        //Select and click on Desktops category
        clickOnElement(  _ClickOnDesktops);

    }

}
