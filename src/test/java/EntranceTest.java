

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntranceTest extends BaseTest {

    @Test
    @DisplayName("Проверка входа в систему с помощью кнопки Входа на главной странице")
    public void loginThroughSignInButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа в систему с помощью кнопки 'Личный кабинет'")
    public void loginThroughPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа в систему с помощью кнопки в регистрационной форме")
    public void loginThroughTheButtonInTheRegistrationForm() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа в систему с помощью кнопки в форме восстановления пароля")
    public void loginFromRecoveryPage() {
        PasswordRecoveryPage passRecoveryPage = new PasswordRecoveryPage(driver);
        passRecoveryPage.open();
        passRecoveryPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isMainPageOpen());

    }

}
