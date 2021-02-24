package acceptancetests.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {

    @FindBy(xpath = "//a[contains(@href,'create-account')]")
    WebElementFacade createAnAccountButton;

    @FindBy(xpath = "//div[@class='css-108j06w']/a[1]")
    WebElementFacade signInButton;

    @FindBy(xpath = "//div[@class='css-108j06w']/button[1]")
    WebElementFacade signOutButton;

    String successMessage = "//div[contains(@class,'znexR')]/h2";
    String popupCloseButton = "//div[contains(@class,'dialog-close-button')]";
    String accountSection = "//div[contains(@class,'user-button')]/abbr";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyTitile(String title) {
        assertEquals(getDriver().getTitle(), title);
    }

    public void clickCreateAnAccountButtonAndValidate(String label) {
        assertEquals(createAnAccountButton.getText(), label);
        createAnAccountButton.click();
    }

    public void validateTheSuccessfullSignupMessageWith(String firstName) {
        String text = withTimeoutOf(Duration.ofSeconds(5)).find(By.xpath(successMessage)).getText();
        assertTrue(text.contains(firstName));
    }

    public void closeSuccessPopup() {
        withTimeoutOf(Duration.ofSeconds(5)).find(By.xpath(popupCloseButton)).click();
    }

    public void clickSignIn(String label) {
        assertEquals(signInButton.getText(), label);
        signInButton.click();
    }

    public void clickSignOut() {
        signOutButton.click();
    }

    public void verifyLogin(String text, String name) {
        assertEquals(withTimeoutOf(Duration.ofSeconds(5)).find(By.xpath(accountSection)).getText(), text+name);
    }

}
