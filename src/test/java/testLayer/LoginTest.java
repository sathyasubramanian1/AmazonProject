package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pompackage.PomLogin;

public class LoginTest extends BaseAmazonClass{
	
	PomLogin Log;
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	
	public LoginTest() {
		super();	
	}
	
	@BeforeSuite() 
	public void initsetup() 
	{
		initiate();
		Log = new PomLogin();
		Log.login();
	}
	
	@Test
	//Verify Title TestCase
	public void verifyTitle()
	{
		String actual = Log.verify();
		System.out.println("The actual page title is " + actual);
		Assert.assertEquals(actual, "Amazon.ca Shopping Cart");
	}
	
	@Test
	public void LowToHighFilterFeature() throws InterruptedException {
		Log.searchFeature();
		Log.sortByLowToHigh();
	}
	
	@Test
	public void HighToLowFilterFeature() throws InterruptedException {
		Log.searchFeature();
		Log.sortByHighToLow();
	}
	
	@Test
	public void CustomerReviewFilterFeature() throws InterruptedException {
		Log.searchFeature();
		Log.sortByFeatureCustomerReview();
	}
	
	@Test
	public void NewestArrivalsFilterFeature() throws InterruptedException {
		Log.searchFeature();
		Log.sortByFeatureNewestArrivals();
	}
	
	@Test
	public void VerifySearchFeature() throws InterruptedException
	{
		Log.searchFeature();
	}

	@AfterSuite
	public void close() throws InterruptedException {
		Log.signinMouseHover();
		Thread.sleep(1000);
		Log.signOut();
		Thread.sleep(1000);
		driver.quit();
	} 	
	
	@Test
	public void validateYourAddress( ) throws InterruptedException{
		Log.signinMouseHover();
		Thread.sleep(1000);
		Log.clickSignIn();
		Log.yourAddress();
	}
	
	@Test
	public void verifyAddToCart(){
		Log.addtocart();
	} 
	
	@Test
	public void yourOrdersVerification() throws InterruptedException {
		Log.signinMouseHover();
		Thread.sleep(3000);
		Log.clickSignIn();
		Log.accessYourAccount();
		Thread.sleep(1000);
	} 
	
	@Test 
	public void yourPaymentVerification() throws InterruptedException {
		Log.signinMouseHover();
		Thread.sleep(3000);
		Log.clickSignIn();
		Log.accessYourPayments();
	} 
}
