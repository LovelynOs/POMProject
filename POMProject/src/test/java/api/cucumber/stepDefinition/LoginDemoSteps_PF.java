package api.cucumber.stepDefinition;
import api.cucumber.pagefactory.LoginPage_PF;
import api.cucumber.pagefactory.HomePage_PF;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginDemoSteps_PF {
    WebDriver driver = null;
    LoginPage_PF login;
    HomePage_PF home;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("===I am inside LoginDemoSteps_PF class ===");
        System.out.println("Inside Steps _ browser is open");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://example.testproject.io/web/");
    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password)throws InterruptedException {
        login = new LoginPage_PF(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        Thread.sleep(2000);
    }
    @And("clicks login")
    public void clicks_login() {
        login.clickOnLogin();
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        home = new HomePage_PF(driver);
        Assert.assertTrue(home.checkLogOutIsDisplayed());
        //driver.findElement(By.id("logout")).isDisplayed();

        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
