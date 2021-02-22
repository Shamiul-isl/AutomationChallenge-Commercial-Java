package acceptancetests.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationFormPage extends PageObject {

    @FindBy(xpath = "//input[@id='create_account_email']")
    WebElementFacade email;

    @FindBy(xpath = "//span[text()='First Name']/following::input[1]")
    WebElementFacade firstNameInput;
    @FindBy(xpath = "//span[text()='Last Name']/following::input[1]")
    WebElementFacade lastNameInput;
    @FindBy(xpath = "//span[text()='Create a Password']/following::input[1]")
    WebElementFacade passwordField;
    @FindBy(xpath = "//span[text()='Confirm Password']/following::input[1]")
    WebElementFacade confirmPasswordField;
    @FindBy(xpath = "//span[text()='Phone Number']/following::input[1]")
    WebElementFacade phoneField;
    @FindBy(xpath = "//span[text()='Street Address']/following::input[1]")
    WebElementFacade addressField;
    @FindBy(xpath = "//span[text()='City']/following::input[1]")
    WebElementFacade cityField;
    @FindBy(xpath = "//span[text()='State']/following-sibling::div/div")
    WebElementFacade stateSelection;
    @FindBy(xpath = "//span[text()='Zip or Postal Code']/following::input[1]")
    WebElementFacade zipcodeField;
    @FindBy(xpath = "//span[text()='Country']/following-sibling::div/div")
    WebElementFacade countrySelection;
    @FindBy(xpath = "//span[text()='Yes']/preceding-sibling::div")
    WebElementFacade radioYes;
    @FindBy(xpath = "//div[@data-react-toolbox='check']")
    List<WebElementFacade> checkBoxes;
    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    WebElementFacade captcha;
    @FindBy(xpath = "//button[text()='Sign Up']")
    WebElementFacade signUpButton;



    public void enterEmail(String input) {
        email.sendKeys(input);
    }

    public void enterFirstName(String input) {
        firstNameInput.sendKeys(input);
    }

    public void enterLastName(String input) {
        lastNameInput.sendKeys(input);
    }

    public void enterPasswords(String input) {
        passwordField.sendKeys(input);
        confirmPasswordField.sendKeys(input);
    }

    public void enterPhone(String input) {
        phoneField.sendKeys(input);
    }

    public void enterAddress(String input) {
        addressField.sendKeys(input);
    }

    public void enterCity(String input) {
        cityField.sendKeys(input);
    }

    public void enterState(String input) {
        stateSelection.click();
        stateSelection.find(By.xpath("//div[@role='listbox']/div/span[contains(text(),'"+input+"')]")).click();
    }

    public void enterZipcode(String input) {
        zipcodeField.sendKeys(input);
    }

    public void enterCountry(String input) {
        countrySelection.click();
        countrySelection.find(By.xpath("//div[@role='listbox']/div/span[contains(text(),'"+input+"')]")).click();
    }

    public void clickInvestorYes() {
        radioYes.click();
    }

    public void clickCheckBoxes() {
        for (WebElementFacade checkbox : checkBoxes) {
            checkbox.click();
        }
    }

    public void clickCaptcha() throws InterruptedException {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
        Thread.sleep(1000);
        captcha.click();
        getDriver().switchTo().defaultContent();
    }

    public void clickSignUp(String label) {
        Assert.assertEquals(signUpButton.getText(), label);
        signUpButton.click();
    }

}
