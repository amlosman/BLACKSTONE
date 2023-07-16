package pages;

import actions.WebActionsForElement;
import fileWrappers.ReadDataFromJSonFile;
import org.openqa.selenium.WebDriver;

public class HomePage {


    WebDriver driver;
    ReadDataFromJSonFile readDataFromJSonFile = new ReadDataFromJSonFile(ReadDataFromJSonFile.jsonPath);
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkUserInfoIsDisplayed() {
        return new WebActionsForElement(driver).checkElementIsDisplayed(readDataFromJSonFile.getValueOfNode("userIcon"), WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.presenceOfElement);
    }
    public void clickOnLogOut()
    {
        new WebActionsForElement(driver).clickOnElement(readDataFromJSonFile.getValueOfNode("userIcon"), WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new WebActionsForElement(driver).clickOnElement(readDataFromJSonFile.getValueOfNode("logoutBtn"), WebActionsForElement.Locators.XPath, WebActionsForElement.ExpectedConditionsEnum.ElementToBeClickable);
    }
}