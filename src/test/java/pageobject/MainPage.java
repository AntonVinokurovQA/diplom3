package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.beans.PropertyWrapper;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement header = $(By.xpath("//h2"));
    private SelenideElement privateCabinet = $(By.xpath("//p[text() = 'Личный Кабинет']"));
    private SelenideElement logIn = $(By.xpath("//button[contains(@class, 'button')]"));


    @Step
    public MainPage openMainPage(){
        open(PropertyReader.getBaseUrl());

        return new MainPage();
    }
    @Step
    public PrivateCabinetPage clickPrivateCabinet(){
        privateCabinet.shouldBe(Condition.visible).click();

        return new PrivateCabinetPage();
    }

    @Step
    public LogInPage clickLogIn(){
        logIn.shouldBe(Condition.visible).click();

        return new LogInPage();
    }
}
