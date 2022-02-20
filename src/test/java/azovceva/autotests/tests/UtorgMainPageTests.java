package azovceva.autotests.tests;

import azovceva.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class UtorgMainPageTests extends TestBase {

    String invalidValue="email.ru";
    String invalidBankCard = "1234567890";
    String correctValidEmail = "utorgme@mailforspam.com";

    @Test
    @Description("Test check Main Page have BuyBTN button)")
    @DisplayName("BuyBtcButton should be in MainPage")
    void buyBtnButtonCheckTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });

        step("Check Button BuyBTN on the main page", () -> {
            $(".utorgWidget_button").shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Test check Main Page have FAQ block)")
    @DisplayName("MainPage have FAQ")
    void faqOnMainPageTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });

        step("Check Button BuyBTN on the main page", () -> {
            $(byId("faq")).shouldHave(Condition.text("Frequently asked questions"));
        });
    }

    @Test
    @Description("Test check Main Page have Guide)")
    @DisplayName("MainPage have Step-by-step guide")
    void blogsOnMainPageTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });
        step("Check subtitle Step-by-Step guide", () -> {
            $(byId("guide")).shouldHave(Condition.text("Step-by-Step guide"));
        });
        //guide
    }


    @Test
    @Description("Test check Error message after enter invalid bank card)")
    @DisplayName("Error message for Invalid bank card")
    void invalidCarErrorIdMessageTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });
        step("Enter invalid card number in card field", () -> {
            $(".uw-address").setValue(invalidBankCard);
        });
        step("Check Error message for card number", () -> {
            $(".uw-input-error").shouldHave(Condition.text(
                    "Invalid wallet address"));
        });
    }

    @Test
    @Description("Test check Error message after enter invalid email)")
    @DisplayName("SignIn with invalid email return Error")
    void errorEmailSignInTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });

        step("Click SignIn button on main page", () -> {
            $(".variant-link").click();
        });
        step("Enter invalid email in email field", () -> {
            $(".MuiInputBase-inputAdornedEnd").setValue(invalidValue);
        });
        step("Click on Proceed button for enter email", () -> {
            $(".MuiButton-label").click();
        });
        step("Check Error message", () -> {
            $(".MuiFormHelperText-contained").shouldHave(Condition.text(
                    "Incorrect email, accepted symbols: characters, digits, points, hyphens"));
        });
    }

    @Test
    @Description("Test check Authorization code message after enter correct email)")
    @DisplayName("SignIn with correct email return Authorization code message")
    void authorizationCodeSignInTest() {
        step("Open https://utorg.pro/", () -> {
            open("https://utorg.pro/");
        });
        step("Click SignIn button on main page", () -> {
            $(".variant-link").click();
        });
        step("Enter correct email on email field", () -> {
            $(".MuiInputBase-inputAdornedEnd").setValue(correctValidEmail);
        });
        step("Click on Proceed button for enter email", () -> {
            $(".MuiInputBase-inputAdornedEnd").pressEnter();
        });
        step("Check Authorization code message", () -> {
            $(".MuiTypography-h4").shouldHave(Condition.text(
                    "Authorization code"));
        });
    }

    @Test
    @Description("Test check Page title should have header text")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://utorg.pro/'", () -> {
            open("https://utorg.pro/");
    });

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
            open("https://utorg.pro/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}