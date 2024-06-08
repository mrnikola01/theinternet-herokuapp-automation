package Base;

import Pages.*;
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
    public ContextMenuPage contextMenuPage;
    public DragAndDropPage dragAndDropPage;
    public DropdownPage dropdownPage;
    public FloatingMenuPage floatingMenuPage;
    public FormAuthenticationLoginPage formAuthenticationLoginPage;
    public FormAuthenticationSecurePage formAuthenticationSecurePage;
    public HoversPage hoversPage;
    public InputsPage inputsPage;
    public KeyPressesPage keyPressesPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        checkboxesPage = new CheckboxesPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        dropdownPage = new DropdownPage(driver);
        floatingMenuPage = new FloatingMenuPage(driver);
        formAuthenticationLoginPage = new FormAuthenticationLoginPage(driver);
        formAuthenticationSecurePage = new FormAuthenticationSecurePage(driver);
        hoversPage = new HoversPage(driver);
        inputsPage = new InputsPage(driver);
        keyPressesPage = new KeyPressesPage(driver);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
