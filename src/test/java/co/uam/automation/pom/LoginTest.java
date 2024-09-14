package co.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage;
    Cart cart;

    @BeforeMethod
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        driver.manage().window().maximize();
        loginPage.visit("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
         //driver.quit();
    }

    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);
        assertEquals(loginPage.loginSuccessfulText(),
                "Welcome username");
        Thread.sleep(2000);
        cart = new Cart(driver);
        cart.findProductClick("Samsung galaxy s6");
        Thread.sleep(2000);
        cart.addToCart();
        cart.cart();
        cart.placeOrder();
        cart.formPlaceOrder(
                "Germán Arenas",
                "Colombia",
                "Manizales",
                "123455678",
                "09",
                "2024");
    }

}

