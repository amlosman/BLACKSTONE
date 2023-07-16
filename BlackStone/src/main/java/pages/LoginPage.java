package pages;

import actions.WebActionsForElement;
import fileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    ReadDataFromJSonFile readDataFromJSonFile = new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPath);
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUserName(String userName)
    {
        new WebActionsForElement(driver).setTextToElement(readDataFromJSonFile.getValueOfNode("emailField"), WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable,userName);
    }
    public void setPassword(String password)
    {
        new WebActionsForElement(driver).setTextToElement(readDataFromJSonFile.getValueOfNode("passwordField"), WebActionsForElement.Locators.id, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable,password);
    }
    public void clickOnLogin()
    {
        new WebActionsForElement(driver).clickOnElement(readDataFromJSonFile.getValueOfNode("LoginBtn"), WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }
    public boolean loginPageIsDisplayed()
    {
        return new WebActionsForElement(driver).checkElementIsDisplayed(readDataFromJSonFile.getValueOfNode("LoginBtn"), WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.presenceOfElement);

    }
}
