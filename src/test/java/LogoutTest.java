
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void logoutSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

}
