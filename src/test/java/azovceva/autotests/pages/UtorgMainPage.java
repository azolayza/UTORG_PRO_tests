package azovceva.autotests.pages;

import azovceva.autotests.tests.TestBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UtorgMainPage extends TestBase {
    SelenideElement
        emailInput=$(".MuiInputBase-inputAdornedEnd");

    public UtorgMainPage typeEmail(String value){
        emailInput.setValue(value);
        return this;
    }


}
