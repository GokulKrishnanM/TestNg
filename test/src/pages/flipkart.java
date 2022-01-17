package pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriverException;

//import org.openqa.selenium.support.ui.ExpectedCondition;

//import org.openqa.selenium.support.ui.ExpectedConditions;

//import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {
	WebDriver driver;
	By Header=By.xpath("//h1");
	By closebutton=By.xpath("//div[contains(@class,'_2QfC02')]/button");
	By mobileselection=By.xpath("//div[text()='Mobiles']//parent::a");
	By Searchbox=By.xpath("//input[@name='q']");
	By Searchbutton =By.xpath("//button[@class='L0Z3Pu']//*[local-name()='svg']//*[local-name()='g']");
	By ramgb=By.xpath("//*[text()='2 GB']//parent::label//input");
	By validateram=By.xpath("(//div[@class='fMghEO']//li)[1]");
	By validatemobilename=By.xpath("(//div[@class='_4rR01T'])[1]");
	By closeram= By.xpath("(//div[@class='_151IuQ'])[1]");
	
	public flipkart(WebDriver driver) {
	this.driver=driver;

	}
	
	public static void explicitwait(WebDriver driver, WebElement element, int timeout, String value){
		
		//new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		}
	
	public void veryHeader() {
	String getheadertext=driver.findElement(Header).getText();
	assertEquals("Flipkart: The One-stop Shopping Destination", getheadertext);
	}
	
	public void clickOnClose() {
	driver.findElement(closebutton).click();
	}
	
		
	public void mobileselection() {
		driver.findElement(mobileselection).click();
		driver.findElement(mobileselection).sendKeys("Gionee");
		driver.findElement(Searchbutton).click();
		}
	
	public void selectram() {
		driver.findElement(ramgb).click();
	}
	
	public void Validatemobileselection() {
		String mobilename=driver.findElement(validatemobilename).getText();
		String ramname=driver.findElement(validateram).getText();
		if(mobilename.contains("Gionee")) {
			String ramsplit[]=ramname.split("|");
			assertEquals("2 GB",ramsplit[0]);	
		}	
	}
	
	public void closeram() {
		driver.findElement(closeram).click();
	}

}
