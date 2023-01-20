import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.*;

public class MainTest extends BaseTest{
    private MainPage mainPage = new MainPage();
    private LogInPage logInPage = new LogInPage();
    private RegisterPage registerPage = new RegisterPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

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

    @Test
    @DisplayName("Move to main page from logo")
    public void moveToMainPageFromLogo() {
        mainPage.openMainPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet()
                .clickLogo();

        mainPage.checkMainPageOpened();
    }

    @Test
    @DisplayName("Move to main page from Konstruktor button")
    public void moveToMainPageFromKonstruktorButton() {
        mainPage.openMainPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet()
                .clickKonstruktor();

        mainPage.checkMainPageOpened();
    }

    @Test
    @DisplayName("Logout Successful")
    public void logOutSuccessful() {
        mainPage.openMainPage()
                .clickLogIn()
                .logIn()
                .clickPrivateCabinet()
                .logOut();

        logInPage.checkLogInPageOpened();
    }

    @Test
    @DisplayName("Check moving between tabs")
    public void checkTabs() {
        mainPage.openMainPage()
                .checkMovingBetweenTabs();
    }
}
