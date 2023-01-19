package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src\\test\\resources\\test.properties");
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("Cannot read property value for " + propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }

    public static String getRegisterUrl() {
        return getProperty("register_url");
    }

    public static String getBaseUrl() {
        return getProperty("base_url");
    }

    public static String getLoginUrl() {
        return getProperty("login_url");
    }

    public static String getForgotPasswordUrl() {
        return getProperty("forgot_password_url");
    }

    public static String getCabinetUrl() {
        return getProperty("cabinet_url");
    }

    public static String getEmail() {
        return getProperty("login");
    }

    public static String getPassword() {
        return getProperty("password");
    }
}
