package acceptancetests.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@name='email']")
    WebElementFacade emailField;

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade passwordField;

    @FindBy(xpath = "//button[@id='btn_login']")
    WebElementFacade loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin(String label) {
        Assert.assertEquals(loginButton.getText(), label);
        loginButton.click();
    }
}
