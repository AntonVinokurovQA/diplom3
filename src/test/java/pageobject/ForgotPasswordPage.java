package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ForgotPasswordPage {
    private SelenideElement logIn = $(By.xpath("//a[@href = '/login']"));

    @Step
    public ForgotPasswordPage openForgotPasswordPage(){
        open(PropertyReader.getForgotPasswordUrl());

        return new ForgotPasswordPage();
    }

    @Step
    public LogInPage clickLogIn(){
        logIn.shouldBe(Condition.visible).click();

        return new LogInPage();
    }
}
