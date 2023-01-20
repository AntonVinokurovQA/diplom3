package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage extends HeaderPage {
    private SelenideElement name = $(By.xpath("//label[text()='Имя']/following::input[@name='name']"));
    private SelenideElement email = $(By.xpath("//label[text()='Email']/following::input[@name='name']"));
    private SelenideElement password = $(By.xpath("//input[@name='Пароль']"));
    private SelenideElement signIn = $(By.xpath("//button[contains(@class,'button_')]"));
    private SelenideElement error = $(By.xpath("//p[@class = 'input__error text_type_main-default']"));
    private SelenideElement logIn = $(By.xpath("//a[@href = '/login']"));

    @Step
    public RegisterPage openRegisterPage() {
        open(PropertyReader.getRegisterUrl());

        return this;
    }

    @Step
    public LogInPage clickLogIn() {
        logIn.shouldBe(Condition.visible).click();

        return new LogInPage();
    }

    @Step
    public RegisterPage fillRegisterForm(String name, String email, String password) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);

        return this;
    }

    @Step
    public LogInPage clickSignIn() {
        signIn.click();

        return new LogInPage();
    }

    @Step
    public void checkBadPasswordErrorVisible() {
        error.shouldBe(Condition.visible);
        error.shouldHave(Condition.ownText("Некорректный пароль"));
    }
}
