package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private SelenideElement konstructor = $(By.xpath("//p[text() = 'Конструктор']"));
    private SelenideElement cabinet = $(By.xpath("//p[text() = 'Личный Кабинет']"));
    private SelenideElement logo = $(By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']/a"));

    @Step
    public PrivateCabinetPage clickPrivateCabinet() {
        cabinet.shouldBe(Condition.visible).click();

        return new PrivateCabinetPage();
    }

    @Step
    public MainPage clickLogo() {
        logo.shouldBe(Condition.visible).click();

        return new MainPage();
    }

    @Step
    public MainPage clickKonstruktor() {
        konstructor.shouldBe(Condition.visible).click();

        return new MainPage();
    }
}
