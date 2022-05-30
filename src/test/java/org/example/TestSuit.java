package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    Registration registration = new Registration();
    RegistrationSuccessful registrationSuccessful = new RegistrationSuccessful();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    EmailAFriend emailAFriend = new EmailAFriend();
    Computers computers = new Computers();
    Desktops desktops = new Desktops();
    ShoppingCart shoppingCart = new ShoppingCart();


    @Test
    public void userShouldBeRegisterSuccessfully(){

        homePage.clickOnRegisterButton();
        registration.userEnterDetailsOnRegistrationPageSuccessfully();
        registrationSuccessful.userShouldVerifyThatRegistrationSuccessful();


    }
    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldEmailTheProductToTheFriendSuccessfully(){
        homePage.clickOnRegisterButton();
        registration.userEnterDetailsOnRegistrationPageSuccessfully();
        registrationSuccessful.userShouldVerifyThatRegistrationSuccessful();
        registrationSuccessful.userShouldClickTheContinueButton();
        homePage.selectProductBuildYourOwnComputer();
        buildYourOwnComputer.selectEmailAFriendOption();
        emailAFriend.enterFriendsEmail();
        emailAFriend.clickOnSendEmail();
        emailAFriend.verifyMessageHasBeenSentForTheProduct();
    }

    //------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldSelectTheProductAndAddToTheCartSuccessfully(){
        homePage.selectComputersOption();
        computers.selectDesktopsOption();
        desktops.selectBuildYourOwnComputer();
        buildYourOwnComputer.selectTheGHzIntelPremiumProcessorDualCoreE2200FromTheDropDownMenu();
        buildYourOwnComputer.selectThe2GbRAMFromTheDropDownMenu();
        buildYourOwnComputer.selectThe320GbHDD();
        buildYourOwnComputer.selectTheVistaPremiumOS();
        buildYourOwnComputer.selectTheAcrobatReaderSoftware();
        buildYourOwnComputer.selectTheTotalCommanderSoftware();
        buildYourOwnComputer.selectAddToCartButton();
        buildYourOwnComputer.selectShoppingCartButton();
        shoppingCart.verifyTheItemInTheShoppingCart();
    }

    //-----------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeAbleToSelectAndChangeTheCurrency(){
        homePage.selectTheEuroCurrencyFromTheDropDownMenu();
        homePage.verifyTheProductPriceInEuroCurrency();
        homePage.selectTheUSDollarCurrencyFromTheDropDownMenu();
        homePage.verifyTheProductPriceInUsDollarCurrency();
    }

    //----------------------------------------------------------------------------------------------------------------

    @Test
    public void notRegisterUserShouldNotAbleToVOTE(){
        homePage.selectGoodOptionInCommunityPoll();
        homePage.clickOnVOTEButton();
        homePage.verifyTheMessageThatOnlyRegisteredUsersCanVote();
        homePage.clickOnRegisterButton();
        registration.userEnterDetailsOnRegistrationPageSuccessfully();
        registrationSuccessful.userShouldVerifyThatRegistrationSuccessful();
        registrationSuccessful.userShouldClickTheContinueButton();
        homePage.selectGoodOptionInCommunityPoll();
        homePage.clickOnVOTEButton();
        homePage.verifyTheNumberOfVotesMessage();
    }

}
