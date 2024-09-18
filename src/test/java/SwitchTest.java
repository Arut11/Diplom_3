
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class SwitchTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода, кликом на кнопку 'Личный кабинет'")
    public void checkClickOnPersonalAccButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    public void switchFromProfileByClickDesignerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор через логотип")
    public void switchFromProfileByClickLogoBurger() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

}
