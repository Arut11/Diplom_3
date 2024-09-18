

import api.User;
import api.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;
import static constants.RandomData.*;

public class BaseTest {

    public WebDriver driver;
    public UserClient userClient;
    public String accessToken;
    public User user;

    @Before
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        userClient = new UserClient();
        ValidatableResponse validatableResponse = userClient.createUser(user);
        accessToken = userClient.getAccessToken(validatableResponse);
    }

    @After
    public void close() {
        userClient.deletingUsersAfterTests(accessToken);
        driver.quit();
    }

    static WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("browser.startup.homepage", "about:blank");
                return new FirefoxDriver(options);
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

}
