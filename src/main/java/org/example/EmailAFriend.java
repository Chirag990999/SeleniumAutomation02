package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriend extends Utils{
    private By _EnterFriendsEmailAddress = By.className( "friend-email" );
    private By _ClickOnSendEmail =  By.xpath( "//form[@action=\"/productemailafriend/1\"]/div[2]" );
    private By _VerifyMessageHasBeenSentToTheFriend =  By.className( "result" );



    public void enterFriendsEmail(){
        //Enter friend's E-mail address
        typeText( _EnterFriendsEmailAddress,"mark" + randomDate() + "waugh@bmail.com");
    }
    public void clickOnSendEmail(){
        //Click on SEND EMAIL
        clickOnElement(_ClickOnSendEmail );
    }
    public void verifyMessageHasBeenSentForTheProduct(){
        //verification Message//Assert
        String actualMessage=driver.findElement( _VerifyMessageHasBeenSentToTheFriend).getText();
        String expectedMessage = "Your message has been sent.";
        Assert.assertEquals( actualMessage,expectedMessage,"Message  is not match" );

    }
}
