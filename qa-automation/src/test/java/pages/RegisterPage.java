package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneNumberField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(ssnField).sendKeys(ssn);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(registerButton).click();
    }
}