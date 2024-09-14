package co.uam.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;


public class Cart extends BasePage {

    public By addToCartButton = By.xpath("//*[text()='Add to cart']");
    public By cart = By.id("cartur");
    public By placeOrder = By.xpath("//button[text()='Place Order']");
    public By purchaseOrder = By.xpath("//button[text()='Purchase']");

    // form place order
    public By nameFormPlaceOrder = By.id("name");
    public By countryFormPlaceOrder = By.id("country");
    public By cityFormPlaceOrder = By.id("city");
    public By creditCardFormPlaceOrder = By.id("card");
    public By monthFormPlaceOrder = By.id("month");
    public By yearFormPlaceOrder = By.id("year");

    public Cart (WebDriver driver) {
        super(driver);
    }

    public void findProductClick(String productName){
        getProduct(productName).click();
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public void cart() {
        click(cart);
    }

    public void placeOrder() {
        click(placeOrder);
    }

    public void formPlaceOrder(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        Thread.sleep(2000);
        type(name, this.nameFormPlaceOrder);
        type(country, this.countryFormPlaceOrder);
        type(city, this.cityFormPlaceOrder);
        type(country, this.creditCardFormPlaceOrder);
        type(month, this.monthFormPlaceOrder);
        type(year, this.yearFormPlaceOrder);
        click(purchaseOrder);
    }

}
