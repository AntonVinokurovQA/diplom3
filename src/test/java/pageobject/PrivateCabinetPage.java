package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PrivateCabinetPage {
    private SelenideElement login = $(By.xpath("//input[@name = 'name' and @type = 'text']"));

    @Step
    public void checkLoginIsCorrect(){
        login.shouldBe(Condition.visible).shouldHave(Condition.attribute("value", PropertyReader.getEmail()));
    }

    @Step
    public void checkCabinetPageOpened(){
        webdriver().shouldHave(url(PropertyReader.getCabinetUrl()));
    }
}
