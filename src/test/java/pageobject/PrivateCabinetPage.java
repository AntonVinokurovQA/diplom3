package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PrivateCabinetPage extends HeaderPage {
    private SelenideElement login = $(By.xpath("//input[@name = 'name' and @type = 'text']"));
    private SelenideElement logout = $(By.xpath("//button[text() = 'Выход']"));

    @Step
    public PrivateCabinetPage openCabinetPage() {
        open(PropertyReader.getCabinetUrl());

        return new PrivateCabinetPage();
    }

    @Step
    public void checkLoginIsCorrect() {
        login.shouldBe(Condition.visible).shouldHave(Condition.attribute("value", PropertyReader.getEmail()));
    }

    @Step
    public void checkCabinetPageOpened() {
        webdriver().shouldHave(url(PropertyReader.getCabinetUrl()));
    }

    @Step
    public LogInPage logOut() {
        logout.shouldBe(Condition.visible).click();

        return new LogInPage();
    }
}
