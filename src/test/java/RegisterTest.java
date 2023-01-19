import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.LogInPage;
import pageobject.RegisterPage;

public class RegisterTest {
    private RegisterPage registerPage = new RegisterPage();
    private String name;
    private String email;
    private String pass;

    @BeforeEach
    public void setUp() {
        name = RandomStringUtils.randomAlphabetic(7);
        email = RandomStringUtils.randomAlphabetic(7) + "@yandex.com";
        pass = RandomStringUtils.randomAlphabetic(7);
    }


    @Test
    @DisplayName("Register with valid credentials successful")
    public void registerSuccessful() {
        registerPage.openRegisterPage()
                .fillRegisterForm(name, email, pass)
                .clickSignIn();

        new LogInPage().checkLogInPageOpened();
    }

    @Test
    @DisplayName("Register with invalid password failed")
    public void registerFailedWithIncorrectPass() {
        registerPage.openRegisterPage()
                .fillRegisterForm(name, email, "12345")
                .clickSignIn();

        registerPage.checkBadPasswordErrorVisible();
    }
}
