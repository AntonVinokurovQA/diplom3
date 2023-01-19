import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.*;

public class MainTest {
    MainPage mainPage = new MainPage();
    LogInPage logInPage = new LogInPage();
    RegisterPage registerPage = new RegisterPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @AfterEach
    public void setUp() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Login from LogIn button")
    public void logInFromLogInButtonSuccessful() {
        mainPage.openMainPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet();

        new PrivateCabinetPage().checkLoginIsCorrect();
    }

    @Test
    @DisplayName("Login from PrivateCabinet button")
    public void logInFromPrivateCabinetButtonSuccessful() {
        mainPage.openMainPage()
                .clickPrivateCabinet();
        logInPage.logIn()
                .clickPrivateCabinet();

        new PrivateCabinetPage().checkLoginIsCorrect();
    }

    @Test
    @DisplayName("Login from Register page")
    public void logInFromRegisterPage() {
        registerPage.openRegisterPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet();

        new PrivateCabinetPage().checkLoginIsCorrect();
    }

    @Test
    @DisplayName("Login from ForgotPassword page")
    public void logInFromForgotPasswordPage() {
        forgotPasswordPage.openForgotPasswordPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet();

        new PrivateCabinetPage().checkLoginIsCorrect();
    }

    @Test
    @DisplayName("Login and move to private cabinet")
    public void logInAndMoveToCabinet() {
        mainPage.openMainPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet();

        new PrivateCabinetPage().checkCabinetPageOpened();
    }

}
