import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import tools.PropertyReader;

public abstract class BaseTest {
    @BeforeAll
    public static void config() {
        if (PropertyReader.getBrowser().equals("firefox")) {
            Configuration.browser = "firefox";
        } else if (PropertyReader.getBrowser().equals("chrome")) {
            Configuration.browser = "chrome";
        }
    }
}
