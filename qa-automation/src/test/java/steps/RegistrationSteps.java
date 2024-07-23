package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationSteps {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    private String username;
    private String password;

    @Given("I am on the Parabank home page")
    public void iAmOnTheParabankHomePage() {
        System.setProperty("webdriver.chrome.driver", "C:/qa-automation/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        homePage.clickRegister();
    }

    @When("I fill in the registration form with random data")
    public void iFillInTheRegistrationFormWithRandomData() {
        String firstName = "John";
        String lastName = "Doe";
        String address = "123 Elm Street";
        String city = "Gotham";
        String state = "NY";
        String zipCode = "10001";
        String phoneNumber = "555-1234";
        String ssn = "123-45-6789";
        username = "johndoe" + System.currentTimeMillis();
        password = "password";

        registerPage.fillRegistrationForm(firstName, lastName, address, city, state, zipCode, phoneNumber, ssn, username, password);
    }

    @When("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        registerPage.submitForm();
    }

    @Then("I should see the success message {string}")
    public void iShouldSeeTheSuccessMessage(String expectedMessage) {
        Assert.assertTrue(driver.getPageSource().contains(expectedMessage), "Success message not found!");
    }

    @When("I navigate back to the Parabank home page")
    public void iNavigateBackToTheParabankHomePage() {
        driver.get("https://parabank.parasoft.com/parabank/logout.htm");
    }

    @When("I log in with the newly created account")
    public void iLogInWithTheNewlyCreatedAccount() {
        loginPage.login(username, password);
    }

    @Then("I should see the welcome message")
    public void iShouldSeeTheWelcomeMessage() {
        Assert.assertTrue(driver.getPageSource().contains("Welcome"), "Login was not successful!");
    }
}