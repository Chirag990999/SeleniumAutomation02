package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    Registration registration = new Registration();
    RegistrationSuccessful registrationSuccessful = new RegistrationSuccessful();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    EmailAFriend emailAFriend = new EmailAFriend();
    Computers computers = new Computers();
    Desktops desktops = new Desktops();
    ShoppingCart shoppingCart = new ShoppingCart();
    ProductNikePage productNikePage = new ProductNikePage();
    FacebookPage facebookpage = new FacebookPage();
    NewRelease newRelease = new NewRelease();


    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeRegisterSuccessfully() {

        homePage.clickOnRegisterButton();
        registration.userEnterDetailsOnRegistrationPageSuccessfully();
        registrationSuccessful.userShouldVerifyThatRegistrationSuccessful();


    }

    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldEmailTheProductToTheFriendSuccessfully() {
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

    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldSelectTheProductAndAddToTheCartSuccessfully() {
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

    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeAbleToSelectAndChangeTheCurrency() {
        homePage.selectTheEuroCurrencyFromTheDropDownMenu();
        homePage.verifyTheProductPriceInEuroCurrency();
        homePage.selectTheUSDollarCurrencyFromTheDropDownMenu();
        homePage.verifyTheProductPriceInUsDollarCurrency();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void notRegisterUserShouldNotAbleToVOTE() {
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
    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void getProductTitles() {
        homePage.getProductTitles();

    }
    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void selectTheFacebookAndVerifyTheURLOnPopUpWindow() {
        homePage.selectTheFacebookAndVerifyTheURLOnPopUpWindow();
        facebookpage.verifyFacebookUrlAndHandlePopUPWindow();
    }
    //-----------------------------------------------------------------------------------------------------------------

    @Test
    public void verifyTheMessageOnAlertAndHandleAlert() {
        homePage.verifyTheMessageOnAlertAndHandleAlert();
    }
    //-----------------------------------------------------------------------------------------------------------------

    @Test
    public void verifyVariousAssertForNopCommerceNewReleaseAndComments() {
        homePage.verifyTheNopCommerceNewReleaseOptionAndClickTheOption();
        newRelease.verifyTheURLNopcommerceNewRelease();
        newRelease.verifyTheNopCommerceNewReleaseMessageAboveCommentBox();
        newRelease.enterTheDetailsInTitleBox();
        newRelease.enterTheCommentInTheCommentBox();
        newRelease.clickOnNewComment();
        newRelease.verifyYourCommentInCommentsBox();
        newRelease.verifyYourCommentIsAtLast();
    }
    //------------------------------------------------------------------------------------------------------------------

    @Test
    public void applySortByNameZtoAOptionAndVerifyTheProductInThatOrder() {
        homePage.selectComputersOption();
        computers.selectDesktopsOption();
        desktops.applyTheFilterByNameZtoAThenVerifyTheProductInZtoAOrder();
    }

    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void verifyTheSortByNameZTOAFunctionOnDesktopPage() {
        homePage.selectComputersOption();
        computers.selectDesktopsOption();
        desktops.verifyProductNameInZToAOrderAfterAppliedFilerSortByNameZtoA();
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void searchTheProductNikeAndVerifyTheURLAndProductListContainsNike(){
        homePage.nikeProductSelect();
        productNikePage.verifyTheURL();
        productNikePage.checkTheProductsContainsNikeBrand();
    }

    //------------------------------------------------------------------------------------------------------------------





}