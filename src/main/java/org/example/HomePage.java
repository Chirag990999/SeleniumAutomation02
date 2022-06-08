package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {

    LoadProperty loadProperty = new LoadProperty();


    private By _ClickOnRegister = By.className( "ico-register" );
    private By _SelectTheProductBuildYourOwnComputer = By.xpath( "//div[@class=\"details\"]/h2//a[@href=\"/build-your-own-computer\"]" );
    private By _SelectComputersOption = By.xpath( "//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/computers\"]" );
    private By _SelectEuroCurrencyFromTheDropDownMenu = By.id( "customerCurrency" );
    private By _VerifyTheProductPriceInEuroCurrency = By.xpath( "//div[@data-productid=\"1\"]/div[2]/div[3]/div/span" );
    private By _SelectUSDollarCurrencyFromTheDropDownMenu = By.id( "customerCurrency" );
    private By _VerifyTheProductPriceInUSDollarCurrency = By.xpath( "//div[@data-productid=\"1\"]/div[2]/div[3]/div/span" );
    private By _SelectGoodOptionInCommunityPoll = By.xpath( "//input[@id=\"pollanswers-2\"]" );
    private By _ClickOnVoteButton = By.xpath( "//button[@id=\"vote-poll-1\"]" );
    private By _VerifyTheMessageOnlyRegisteredUserCanVote = By.xpath( "//div[@style=\"display: none;\"]" );
    private By _VerifyTheNumberOfVotesMessage = By.className( "poll-total-votes" );
    private By _GetProductTitles = By.xpath( "//div[contains(@class,'product-grid')]//div[@class='item-box']//h2" );
    private By _ClickOnFacebook = By.xpath( "//li[@class='facebook']" );
    private By _NopCommerceNewReleaseOption = By.xpath( "//div[@class='news-items']/div[2]/div//a[@class='news-title']" );
    private By _SearchStore = By.xpath( "//div[@class='header-lower']/div[2]/form/input" );
    private By _SEARCHButton = By.xpath( "//div[@class='header-lower']/div[2]/form/button" );



    public void getProductTitles() {
        List<WebElement> productTitles = driver.findElements( _GetProductTitles );

        for (WebElement e : productTitles) {
            System.out.println( e.getText() );
        }
    }

    public void clickOnRegisterButton() {
        //Go to Register page by click register
        clickOnElement( _ClickOnRegister );
    }

    public void selectProductBuildYourOwnComputer() {
        //Select and click on "build your own computer" option
        clickOnElement( _SelectTheProductBuildYourOwnComputer );
    }

    public void selectComputersOption() {
        //Click on Computers Category
        clickOnElement( _SelectComputersOption );
    }

    public void selectTheEuroCurrencyFromTheDropDownMenu() {
        // Select Euro from dropdown currency menu
        Select Euro = new Select( driver.findElement( _SelectEuroCurrencyFromTheDropDownMenu ) );
        Euro.selectByVisibleText( loadProperty.getProperty( "CurrencyTwo" ) );
    }

    public void verifyTheProductPriceInEuroCurrency() {
        // Verify product price in Euro currency//Assert
        String actualCurrency = driver.findElement( _VerifyTheProductPriceInEuroCurrency ).getText();
        String expectedCurrency = "€1032.00";
        Assert.assertEquals( actualCurrency, expectedCurrency, "Currency is not match" );
    }

    public void selectTheUSDollarCurrencyFromTheDropDownMenu() {
        // Select US Dollar from dropdown currency menu
        Select USDollar = new Select( driver.findElement( _SelectUSDollarCurrencyFromTheDropDownMenu ) );
        USDollar.selectByVisibleText( loadProperty.getProperty( "CurrencyOne" ) );
    }

    public void verifyTheProductPriceInUsDollarCurrency() {
        // Verify product price in US Dollar currency// Assert
        String ActualCurrency = driver.findElement( _VerifyTheProductPriceInUSDollarCurrency ).getText();
        String ExpectedCurrency = "$1,200.00";
        Assert.assertEquals( ActualCurrency, ExpectedCurrency, "Currency is not match" );
    }

    public void selectGoodOptionInCommunityPoll() {
        //Select Good Option in Community poll
        clickOnElement( _SelectGoodOptionInCommunityPoll );
    }

    public void clickOnVOTEButton() {
        //Click on VOTE Button
        clickOnElement( _ClickOnVoteButton );
    }

    public void verifyTheMessageThatOnlyRegisteredUsersCanVote() {
        //Verify The Message That Only registered users can vote
        String ActualVoteMessage = driver.findElement( _VerifyTheMessageOnlyRegisteredUserCanVote ).getText();
        String ExpectedVoteMessage = "Only registered users can vote";
        Assert.assertNotEquals( ActualVoteMessage, ExpectedVoteMessage, "User is registered" );
    }

    public void verifyTheNumberOfVotesMessage() {
        //verification//Assert
        String messagevoteactual = driver.findElement( _VerifyTheNumberOfVotesMessage ).getText();
        String messagevoteexpected = " vote";
        Assert.assertTrue( messagevoteactual.contains( "vote" ) );
    }

    public void selectTheFacebookAndVerifyTheURLOnPopUpWindow() {
        //Click on Facebook
        clickOnElement( By.xpath( "//li[@class='facebook']" ) );
    }

    public void verifyTheMessageOnAlertAndHandleAlert() {
        //Click On VOTE
        clickOnElement( _ClickOnVoteButton );

        //Switching To Alert
        Alert alert = driver.switchTo().alert();

        //Capture The Alert Message
        String alertMessage = driver.switchTo().alert().getText();

        //Verify The Alert Message
        Assert.assertEquals( alertMessage, "Please select an answer", "Message is not verify" );

        //Accepting Alert
        alert.accept();
    }

    public void verifyTheNopCommerceNewReleaseOptionAndClickTheOption() {
        //Select The Nopcommerce New Release Option On Homepage
        String ActualOption = driver.findElement(_NopCommerceNewReleaseOption ).getText();
        String ExpectedOption = "nopCommerce new release!";
        Assert.assertEquals( ActualOption, ExpectedOption, "nopCommerce new release!Option not match" );
        clickOnElement( _NopCommerceNewReleaseOption );
    }

    public void nikeProductSelect() {
        //Search The product
        typeText( _SearchStore, "nike" );

        //Click On Search Button
        clickOnElement(_SEARCHButton );
    }








}