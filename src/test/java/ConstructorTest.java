import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class ConstructorTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = BaseTest.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    public void menuBunIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    public void menuSaucesIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    @Description("Checking if the button is selected by getting the text")
    public void menuFillingIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
