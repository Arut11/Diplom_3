package pages;

import api.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Url.REGISTER_PAGE_URL;

public class RegistrationPage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]"); //локатор поля ввода имя
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]"); //локатор поля ввода email
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]"); //локатор поля ввода пароль
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']"); //локатор кнопки зарегистрироваться
    private final By signInButton = By.xpath(".//a[text()='Войти']"); //локтор кнопки войти внизу страницы
    private final By wrongPassword = By.xpath(".//*[text()='Некорректный пароль']"); //локатор надписи Некорректный пароль

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(REGISTER_PAGE_URL);
    }

    @Step("Открыть страницу регистрации")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Введ регистрационных данных в поля адрес электронной почты, имя и пароль")
    public void registerUser(User user) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(user.getName());
    }

    @Step("Получение сообщения при вводе неверного пароля")
    public boolean isWrongPasswordDisplayed() {
        return driver.findElement(wrongPassword).isDisplayed();
    }

    @Step("Клик кнопки входа в систему в нижней части страницы")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

}
