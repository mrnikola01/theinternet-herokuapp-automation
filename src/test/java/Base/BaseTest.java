package Base;

import Pages.AddRemoveElementsPage;
import Pages.CheckboxesPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public CheckboxesPage checkboxesPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
