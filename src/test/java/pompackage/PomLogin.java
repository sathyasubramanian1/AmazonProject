package pompackage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import basePackage.BaseAmazonClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PomLogin extends BaseAmazonClass{
	Actions action = new Actions(driver);
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	
	//Object Repository
	//LOGIN RELATED OBJECTS
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement SignIn;
	@FindBy(id="continue") WebElement Continue;
	@FindBy(id="ap_email") WebElement Username;
	@FindBy(id="ap_password") WebElement Password;
	@FindBy(id="signInSubmit") WebElement Submit;

	//SEARCH RELATED OBJECTS
	@FindBy(id="twotabsearchtextbox") WebElement searchText;
	@FindBy(id="nav-search-submit-button") WebElement searchIcon;
	@FindBy(className="a-color-state") WebElement searchResults;
	
	//Your Orders
	@FindBy(xpath="//h2[normalize-space()='Your Orders']") WebElement yourOrders;
	@FindBy(xpath="//h1[normalize-space()='Your Orders']") WebElement yourOrdersText;
	
	//Your Payments
	@FindBy(xpath="//h2[normalize-space()='Your Payments']") WebElement yourPayments;
	@FindBy(xpath="//span[normalize-space()='Cards and accounts']") WebElement yourPaymentsText;
	@FindBy(xpath="//span[@id='pp-C6fbeS-14']//input[@type='submit']") WebElement addPaymentMethod;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement addCreditOrDebitCard;
	
	//Sort By: Feature
	@FindBy(xpath="//span[@class='a-dropdown-prompt']") WebElement sortFeature; 
	@FindBy(xpath="//a[@id='s-result-sort-select_1']") WebElement lowToHigh;
	@FindBy(xpath="//a[@id='s-result-sort-select_2']") WebElement highToLow;
	@FindBy(xpath="//a[@id='s-result-sort-select_3']") WebElement customerReview;
	@FindBy(xpath="//a[@id='s-result-sort-select_4']") WebElement newestArrivals;
	
	//Signout
	@FindBy(xpath="//span[normalize-space()='Sign Out']") WebElement signout;
	
	
	//Your Address
	@FindBy(xpath="//h2[normalize-space()='Your Addresses']") WebElement yourAddress;
	@FindBy(id="ya-myab-plus-address-icon")WebElement addAddress; 
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']") WebElement fullName;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']") WebElement yourPhone;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']") 	WebElement address1;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")	WebElement address2;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")	WebElement city;
	@FindBy(xpath="//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@role='button']")	WebElement province;
	@FindBy(xpath="//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8']")	WebElement selectState;
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")	WebElement postalCode;
	@FindBy(xpath="//input[@class='a-button-input']")	WebElement addAddressbtn;
	@FindBy(xpath="//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']") WebElement saveAddress;
	
	//Add to cart Elements
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']") WebElement firstProduct;
	//Add to cart btn
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement addtoCartbtn;
	//Cart Icon
	@FindBy(xpath="//span[@id='nav-cart-count']") WebElement cartIcon;
	//Click the quantity
	@FindBy(xpath="//span[@class='a-dropdown-label']") WebElement clickQuantity;
	//Increase the Quantity
	@FindBy(xpath="//a[@id='quantity_3']") WebElement increaseQuantity;
	//add different item
	@FindBy(xpath=" //div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Mens 2-Pack Crewneck T-Shirts']") WebElement differentitem;
	//to delete items
	@FindBy(xpath="//input[@data-action=\"delete\"]") WebElement deleteItem;
	//click tshirt to show more info
	@FindBy(xpath="//span[@class='a-truncate-full']") WebElement moreInfo;
	@FindBy(xpath="//span[@id='a-autoid-1-announce']") WebElement deleteQuantity;
	@FindBy(xpath="//a[@id='quantity_0']") WebElement zeroQuantity;

	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
    public void addtocart() {
    	searchText.sendKeys("drills");
    	searchIcon.click();
    	firstProduct.click();
    	addtoCartbtn.click();
    	cartIcon.click();
    	clickQuantity.click();
    	increaseQuantity.click();
    	searchText.sendKeys("tshirt");
    	searchIcon.click();
    	differentitem.click();
    	addtoCartbtn.click();
    	cartIcon.click();	
    	deleteQuantity.click();
    	zeroQuantity.click();
    	moreInfo.click();
    }
    
	public void clickSignIn() {
		SignIn.click();
	}
	
	public void typeEmail(String email) {
		Username.sendKeys(email);
	}
	
	public void clickContinue() {
		Continue.click();
	}
	
	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		Submit.click();
	}
	
	public String verify(){
		return driver.getTitle();
	}
	
	public void login() {		
		SignIn.click();
		Username.sendKeys(username);
		Continue.click();
		Password.sendKeys(password);
		Submit.click();	
	}
	
	public void signinMouseHover() throws InterruptedException {
		action.moveToElement(SignIn).build().perform();
		Thread.sleep(3000);
	}
	
	public void searchFeature() throws InterruptedException {
		searchText.sendKeys("Hammer");
		searchIcon.click();
		String actualResults = searchResults.getText();
		String expectedResults = "Hammer";
		// Assert.assertEquals(actualResults, expectedResults);
		}

	public void yourAddress() {
		yourAddress.click();
		addAddress.click();
		fullName.sendKeys("Sathyass");
		yourPhone.sendKeys("6533433322");
		address1.sendKeys("10 front street west");
		address2.sendKeys("35");
		city.sendKeys("Toronto");
		province.click();
		selectState.click();
		postalCode.sendKeys("M5V 3S1");
		addAddressbtn.click();
		saveAddress.click();
	}
	
	public void accessYourAccount() throws InterruptedException {
		yourOrders.click();
		Thread.sleep(1000);
		String actualOrderResults = yourOrdersText.getText();
		String expectedResults = "Your Orders";
		Assert.assertEquals(actualOrderResults, expectedResults);
	}
	
	public void accessYourPayments() throws InterruptedException {
		yourPayments.click();
		Thread.sleep(1000);
		String actualPaymentResults = yourPaymentsText.getText();
		String expectedResults = "Cards and accounts";
		Assert.assertEquals(actualPaymentResults, expectedResults);
	}
	
	public void addPayments() {
		addPaymentMethod.click();
		addCreditOrDebitCard.click();
		
	}
	public void sortByLowToHigh() throws InterruptedException {
		sortFeature.click();
		lowToHigh.click();
		Thread.sleep(2000);
	}
	
	public void sortByHighToLow() throws InterruptedException {
		sortFeature.click();
		highToLow.click();
		Thread.sleep(1000);
	}
	public void sortByFeatureCustomerReview() throws InterruptedException {
		sortFeature.click();
		customerReview.click();
		Thread.sleep(1000);
	}
	public void sortByFeatureNewestArrivals() throws InterruptedException {
		sortFeature.click();
		newestArrivals.click();
		Thread.sleep(1000);
	}
	
	public void signOut() throws InterruptedException {
		signout.click();
	}
}
