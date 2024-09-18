package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Url.BASE_URL;

public class MainPage {

    private final WebDriver driver;
    private final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]"); //локатор текущего меню
    private final By loginToAccount = By.xpath(".//button[text()='Войти в аккаунт']"); //локатор кнопки Войти в аккаунт
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']"); //локатор кнопки Личный кабинет
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']"); //локатор кнопки Оформить заказ
    private final By bunsButton = By.xpath(".//span[contains(text(),'Булки')]"); //локатор текста Булки в конструкторе
    private final By saucesButton = By.xpath(".//span[contains(text(),'Соусы')]"); //локатор текста Соусы
    private final By fillingButton = By.xpath(".//span[contains(text(),'Начинки')]"); //локатор текста Начинки
    private final By setBurgerIndicator = By.xpath(".//*[text()='Соберите бургер']"); //локатор надписи Соберите бургер

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void open() {//открыть страницу сайта stellar burgers
        driver.get(BASE_URL);
    }

    @Step("Клик кнопки входа в систему")
    public void clickLogin() {
        driver.findElement(loginToAccount).click();
    }

    @Step("Провка, отображения надписи 'Соберите бургер' на главной странице")
    public boolean isBurgerInscriptionDisplayed() {
        return driver.findElement(setBurgerIndicator).isDisplayed();
    }

    @Step("Провка отображения кнопки оформления заказа на главной странице")
    public boolean isMainPageOpen() {
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Клик кнопки 'Личный кабинет'")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Нажмите кнопку 'Булки'")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("Клик кнопки 'Соусы'")
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("Клик нкнопки 'Начинки'")
    public void clickFillingsButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Проверка текста меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(currentMenu).getText();
    }

}
