package co.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage;
    Cart cart;
    String[] products = {"Samsung galaxy s6", "Sony vaio i5", "HTC One M9" };

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
        cart.findProductClick(this.products[0]);
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        cart.closeAlert();
        //cart.closeAlert();
        cart.toBack();
        Thread.sleep(2000);
        System.out.println(this.products.length);
        cart.findProductClick(this.products[1]);
        Thread.sleep(2000);
        cart.addToCart();
        Thread.sleep(2000);
        cart.closeAlert();
        cart.cart();
        Thread.sleep(2000);
        String totalProducts = cart.totalCartText();
        System.out.println("TOTAL PRODUCTOS: "+totalProducts);
       // int total = Integer.parseInt(totalProducts);
        Thread.sleep(2000);
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

