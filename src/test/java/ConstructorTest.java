
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = BaseTest.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    public void menuBunIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    public void menuSaucesIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    public void menuFillingIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

}
