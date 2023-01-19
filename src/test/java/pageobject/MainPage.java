package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage extends HeaderPage {
    private SelenideElement logIn = $(By.xpath("//button[contains(@class, 'button')]"));
    private SelenideElement ingredientHeader = $(By.xpath("//h2"));
    private SelenideElement tab = $(By.xpath("//h2"));
    private String[] tabs = {"Соусы", "Начинки", "Булки"};

    @Step
    public MainPage openMainPage() {
        open(PropertyReader.getBaseUrl());

        return new MainPage();
    }

    @Step
    public LogInPage clickLogIn() {
        logIn.shouldBe(Condition.visible).click();

        return new LogInPage();
    }

    @Step
    public void checkMainPageOpened() {
        webdriver().shouldHave(url(PropertyReader.getBaseUrl()));
    }

    @Step
    public MainPage clickTab(String name) {
        $(By.xpath("//span[text()='" + name + "']/..")).shouldBe(Condition.visible).click();

        return this;
    }

    @Step
    public void checkTabIsCurrent(String name) {
        $(By.xpath("//span[text()='" + name + "']/..")).shouldHave(attributeMatching("class", ".*current.*"));
    }

    @Step
    public void checkMovingBetweenTabs() {
        for (String tabName : tabs) {
            clickTab(tabName);
            checkTabIsCurrent(tabName);
        }
    }
}
