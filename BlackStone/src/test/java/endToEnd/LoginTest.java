package endToEnd;

import base.Base;
;
import fileWrappers.ReadDataFromJSonFile;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends Base {
    ReadDataFromJSonFile readDataFromJSonFile = new ReadDataFromJSonFile("src/test/resources/data/UserData.json");
    HomePage homePage;
    LoginPage loginPage;
    @Test(description = "User login to store")
    public void userLoginToStore(){
        loginPage = new LoginPage(getDriver());
        loginPage.setUserName(readDataFromJSonFile.getValueOfNode("UserName"));
        loginPage.setPassword(readDataFromJSonFile.getValueOfNode("Password"));
        loginPage.clickOnLogin();
    }
    @Test(description = "Validate user logged in successfully" , dependsOnMethods = "userLoginToStore")
    public void validateUserLoggedSuccessfully(){
        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkUserInfoIsDisplayed());
    }
    @Test(description = "User logged out" , dependsOnMethods = "validateUserLoggedSuccessfully")
    public void userLoggedOut(){
       homePage.clickOnLogOut();
    }
    @Test(description = "Validate user logged out successfully" , dependsOnMethods = "userLoggedOut")
    public void validateUserLoggedOutSuccessfully(){
        homePage = new HomePage(getDriver());
        Assert.assertTrue(loginPage.loginPageIsDisplayed());
    }
}
