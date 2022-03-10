package azovceva.autotests.tests;

import azovceva.autotests.helpers.DriverUtils;
import azovceva.autotests.pages.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Description("Test check Main Page have BuyBTC Widget)")
    @DisplayName("BuyBtcWidget should be in MainPage")
    void buyBtcButtonCheckTest() {
        step("Open https://utorg.pro/", () -> mainPage.openPage());
        step("Check Widget BuyBTC on the main page", () -> mainPage.widgetBtcShouldVisible());
    }

    @Test
    @Description("Test check Main Page have FAQ block)")
    @DisplayName("MainPage have FAQ")
    void faqOnMainPageTest() {
        step("Open https://utorg.pro/", () -> mainPage.openPage());
        step("Check FAQ on the main page", () -> mainPage.faqShouldOnPage());
    }

    @Test
    @Description("Test check Main Page have Guide)")
    @DisplayName("MainPage have Step-by-step guide")
    void blogsOnMainPageTest() {
        step("Open https://utorg.pro/", () ->
                mainPage.openPage());
        step("Check subtitle Step-by-Step guide", () ->
                mainPage.guideShouldOnPage());
    }


    @Test
    @Description("Test check Error message after enter invalid bank card)")
    @DisplayName("Error message for Invalid bank card")
    void invalidCarErrorIdMessageTest() {
        step("Open https://utorg.pro/", () ->
            mainPage.openPage());
        step("Enter invalid card number in card field", () ->
            mainPage.cardNumberEnter("1234567890"));
        step("Check Error message for card number", () ->
            mainPage.checkErrorMessageNumberCard());
    }

    @Test
    @Description("Test check Error message after enter invalid email)")
    @DisplayName("SignIn with invalid email return Error")
    void errorEmailSignInTest() {
        step("Open https://utorg.pro/", () ->
            mainPage.openPage());
        step("Click SignIn button on main page", () ->
            mainPage.clickSignIn());
        step("Type invalid email in email field", () ->
            mainPage.typeEmail("email.ru"));
        step("Click on Proceed button for enter email", () ->
            mainPage.proceedEmail());
        step("Check Error message", () ->
            mainPage.checkErrorAboutInvalidEmail());
    }

    @Test
    @Description("Test check Authorization code message after enter correct email)")
    @DisplayName("SignIn with correct email return Authorization code message")
    void authorizationCodeSignInTest() {
        step("Open https://utorg.pro/", () ->
            mainPage.openPage());
        step("Click SignIn button on main page", () ->
            mainPage.clickSignIn());
        step("Enter correct email on email field", () ->
            mainPage.typeEmail("utorgme@mailforspam.com"));
        step("Click on Proceed button for enter email", () ->
            mainPage.proceedEmail());
        step("Check Authorization code message", () ->
            mainPage.checkAuthorizationCodeMessage());
    }

    @Test
    @Description("Test check Page title should have header text")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://utorg.pro/'", () ->
            mainPage.openPage());
        step("Page title should have text 'Buy Bitcoin with Credit Card or Debit Card | UTORG'", () -> {
            String expectedTitle = "Buy Bitcoin with Credit Card or Debit Card | UTORG";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Test check log")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://utorg.pro/'", () ->
                mainPage.openPage());
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}