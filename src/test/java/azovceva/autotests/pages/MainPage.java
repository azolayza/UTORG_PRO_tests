package azovceva.autotests.pages;

import azovceva.autotests.tests.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends TestBase {
    SelenideElement
            emailInput=$(".MuiInputBase-inputAdornedEnd"),
            utorgBtcWidget=$("#widget-container"),
            faq=$(byId("faq")),
            guide=$("#guide"),
            cardNumberField=$(".uw-address"),
            errorOfBankCard=$(".uw-input-error"),
            signInButton=$(".variant-link"),
            proceedEmailButton=$(".MuiButton-contained"),
            errorMessageEmailConteiner = $(".MuiFormHelperText-contained"),
            authorizationBlock=$(".MuiCardContent-root");


    public MainPage openPage(){
        open("https://utorg.pro/");
        return this;
    }

    public MainPage widgetBtcShouldVisible(){
        utorgBtcWidget.shouldBe(Condition.visible);;
        return this;
    }

    public MainPage faqShouldOnPage(){
        faq.shouldHave(Condition.text("Frequently asked questions"));
        return this;
    }

    public MainPage guideShouldOnPage(){
        guide.shouldHave(Condition.text("Step-by-Step guide"));
        return this;
    }

    public MainPage cardNumberEnter(String cardNumber){
        cardNumberField.setValue(cardNumber);
        return this;
    }

    public MainPage checkErrorMessageNumberCard(){
        errorOfBankCard.shouldHave(Condition.text(
                "Invalid wallet address"));
        return this;
    }

    public MainPage clickSignIn(){
        signInButton.click();
        return this;
    }

    public MainPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public MainPage proceedEmail(){
        proceedEmailButton.click();
        return this;
    }

    public MainPage checkErrorAboutInvalidEmail(){
        errorMessageEmailConteiner.shouldHave(Condition.text(
                "Incorrect email, accepted symbols: characters, digits, points, hyphens"));
        return this;
    }

    public MainPage checkAuthorizationCodeMessage(){
        authorizationBlock.shouldHave(Condition.text(
                "Authorization code"));
        return this;
    }
}
