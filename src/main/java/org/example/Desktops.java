package org.example;

import org.openqa.selenium.By;

public class Desktops extends Utils{public By _SelectBuildYourOwnComputer = By.xpath( "//div[@class=\"details\"]/h2//a[@href=\"/build-your-own-computer\"]" );


    public void selectBuildYourOwnComputer(){
        //Select and click on "build your own computer" option
        clickOnElement( _SelectBuildYourOwnComputer );
    }
}
