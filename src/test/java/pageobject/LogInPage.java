package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LogInPage {
    private SelenideElement email = $(By.xpath("//input[@name = 'name']"));
    private SelenideElement password = $(By.xpath("//input[@name = 'Пароль']"));
    private SelenideElement logIn = $(By.xpath("//button[contains(@class, 'button')]"));

    public void checkLogInPageOpened(){
        webdriver().shouldHave(url(PropertyReader.getLoginUrl()));
    }

    @Step
    public MainPage logIn(){
        email.shouldBe(Condition.visible).sendKeys(PropertyReader.getEmail());
        password.shouldBe(Condition.visible).sendKeys(PropertyReader.getPassword());
        logIn.click();

        return new MainPage();
    }
}
