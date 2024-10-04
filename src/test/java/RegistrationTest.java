import api.User;
import api.UserClient;
import api.UserCredentials;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import java.util.concurrent.TimeUnit;
import static constants.RandomData.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest {

    private WebDriver driver;
    private User user;

    @BeforeEach
    public void setUp() {
        driver = BaseTest.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        UserClient userClient = new UserClient();
        UserCredentials credentials = new UserCredentials(user.getEmail(), user.getPassword());
        ValidatableResponse responseLogin = userClient.login(credentials);
        String accessToken = userClient.getAccessToken(responseLogin);
        userClient.deletingUsersAfterTests(accessToken);
        driver.quit();
    }

    @Test
    @DisplayName("Проверка регистрации на странице регистрации с правильным паролем длиной более 5 символов")
    public void registrationOnRegPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.clickRegister();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка регистрации на странице входа в систему с правильным паролем длиной более 5 символов")
    public void registrationOnLoginPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        registrationPage.clickRegister();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка регистрации на главной странице с правильным паролем длиной более 5 символов")
    public void registrationOnMainPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        registrationPage.clickRegister();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка регистрации с использованием неверного пароля, состоящего из 5 символов")
    public void checkRegistrationWithWrongPassError() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS_5, RANDOM_NAME);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        assertTrue(registrationPage.isWrongPasswordDisplayed());
    }

}
