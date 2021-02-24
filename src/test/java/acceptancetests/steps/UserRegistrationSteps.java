package acceptancetests.steps;

import acceptancetests.pages.HomePage;
import acceptancetests.pages.LoginPage;
import acceptancetests.pages.RegistrationFormPage;
import acceptancetests.testdata.MetadataGeneration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class UserRegistrationSteps {

    HomePage homepage;
    RegistrationFormPage registrationFormPage;
    LoginPage loginPage;
    MetadataGeneration metadataGeneration = new MetadataGeneration();

    @Managed
    WebDriver driver;

    @Given("User is on the CrowdStreet home page")
    public void userIsOnTheCrowdStreetHomePage() {
        homepage.open();
        homepage.verifyTitile("Marketplace | CrowdStreet");
    }

    @And("User is able to click on the {string} button")
    public void userIsAbleToClickOnTheButton(String labelOnButton) {
        homepage.clickCreateAnAccountButtonAndValidate(labelOnButton);
    }

    @When("User enters their personal information and complete the registration form")
    public void userEntersTheirPersonalInformationAndCompleteTheRegistrationForm() throws InterruptedException {
        registrationFormPage.enterEmail(metadataGeneration.emailText);
        registrationFormPage.enterFirstName(metadataGeneration.firstName);
        registrationFormPage.enterLastName(metadataGeneration.lastName);
        registrationFormPage.enterPasswords(metadataGeneration.password);
        registrationFormPage.enterPhone(metadataGeneration.phone);
        registrationFormPage.enterAddress(metadataGeneration.address);
        registrationFormPage.enterCity(metadataGeneration.city);
        registrationFormPage.enterState(metadataGeneration.state);
        registrationFormPage.enterZipcode(metadataGeneration.zipcode);
        registrationFormPage.enterCountry(metadataGeneration.country);
        registrationFormPage.clickInvestorYes();
        registrationFormPage.clickCheckBoxes();
        registrationFormPage.clickCaptcha();
    }

    @And("User clicks on the {string} button")
    public void userClicksOnTheButton(String labelOnButton) {
        registrationFormPage.clickSignUp(labelOnButton);
    }

    @Then("User should see that popup that says {string} followed by their {string}")
    public void userShouldSeeThatPopupThatSaysFollowedByTheir(String congrats, String firstName) {
        homepage.validateTheSuccessfullSignupMessageWith(firstName);
        homepage.closeSuccessPopup();
        homepage.clickSignOut();
    }

    @When("User enters their personal information in the sign in page")
    public void userEntersTheirPersonalInformationInTheSignInPage() {
        loginPage.enterLoginEmail(metadataGeneration.constantEmail);
        loginPage.enterLoginPassword(metadataGeneration.constantPass);
    }

    @And("User clicks on {string} button")
    public void userClicksOnButton(String labelOnButton) {
        loginPage.clickLogin(labelOnButton);
    }

    @And("User is able to click on {string} button")
    public void userIsAbleToClickOnButton(String labelOnButton) {
        homepage.clickSignIn(labelOnButton);
    }

    @Then("User should see an account section on the top right of the page that says {string} followed by their firstName")
    public void userShouldSeeAnAccountSectionOnTheTopRightOfThePageThatSaysFollowedByTheirFirstName(String text) {
        homepage.verifyLogin(text, metadataGeneration.firstName);
    }
}
