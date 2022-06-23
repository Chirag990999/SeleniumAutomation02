package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NewRelease extends Utils{
    private By _NopCommerceNewReleaseMessageAboveCommentBox = By.xpath( "//div[@class='center-2']/div/div/h1" );
    private By _TitleBox = By.className( "enter-comment-title" );
    private By _CommentBox = By.className( "enter-comment-text" );
    private By _ClickOnNewComment =  By.name( "add-comment" );
    private By _VerifyYourCommentInCommentsBox =  By.xpath( "//div[@class='comments']//p[.='Amazing New Release']" );
    private By _CommentByTitleToVerifyYourMessageAtLast = By.xpath( "//div[@class='comment-title']" );




    public void verifyTheURLNopcommerceNewRelease() {
        //verify The URL for New-release
        String URL = driver.getCurrentUrl();
        Assert.assertEquals( URL, "https://demo.nopcommerce.com/nopcommerce-new-release", "URL Not Match" );
    }

    public void verifyTheNopCommerceNewReleaseMessageAboveCommentBox() {
        //Verify The Message above Comment Box
        String ActualMessage = driver.findElement(_NopCommerceNewReleaseMessageAboveCommentBox  ).getText();
        Assert.assertEquals( ActualMessage, "nopCommerce new release!", "Messgae Not Verified" );
    }

    public void enterTheDetailsInTitleBox() {
        //Type in Title Box
        typeText(_TitleBox , "Charlie" );
    }

    public void enterTheCommentInTheCommentBox() {
        //Type The Comment
        typeText(_CommentBox , "Amazing New Release" );
    }

    public void clickOnNewComment() {
        //Click On New Comment
        clickOnElement( _ClickOnNewComment);
    }

    public void verifyYourCommentInCommentsBox() {
        String ActualComment = driver.findElement( _VerifyYourCommentInCommentsBox).getText();
        String ExpectedComment = "Amazing New Release";
        Assert.assertEquals( ActualComment, ExpectedComment, "message not verified" );
    }


    public void verifyYourCommentIsAtLast(){
        String title = "Charlie";
        List<WebElement> commentsEntered = driver.findElements(_CommentByTitleToVerifyYourMessageAtLast);
        List<String>commentsLists = new ArrayList<>();
        for (WebElement c : commentsEntered){
            commentsLists.add(c.getText());
        }
        Assert.assertTrue( commentsLists.contains( title ) );
        String lastComment = commentsLists.get(commentsLists.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals( lastComment,title,"Your Comment is not last" );

    }


}
