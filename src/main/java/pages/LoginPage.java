package pages;

import api.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Url.LOGIN_PAGE_URL;

public class LoginPage {

    private final WebDriver driver;
    private final By loginIndicator = By.xpath(".//*[text()='Вход']"); //локатор надписи Вход
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]"); //локатор кнопки зарегистрироваться внизу страницы
    private final By signInButton = By.xpath(".//button[text()='Войти']"); //локатор кнопки войти
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input"); //локатор поля ввода почты
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input"); //локатор поля ввода пароля

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу входа в систему")
    public void open() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Страница авторизации надпись 'Вход'")
    public boolean isLoginIndicatorDisplayed() {
        return driver.findElement(loginIndicator).isDisplayed();
    }

    @Step("Клик кнопки 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Введ данных в поля 'Адрес электронной почты' и 'Пароль'")
    public void enterEmailAndPassword(User user) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
    }

    @Step("Клик на кнопки входа в систему")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

}
