import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		String expectedTitle = "My Store";
		String title = driver.getTitle();
		
		//First Verification
		if(expectedTitle.equals(title)){
			System.out.println("Title is Correct!");
		}else{
			System.out.println("Title is Incorrect!");
		}
		
		driver.findElement(By.className("login")).click();
		
		WebElement inputField = driver.findElement(By.id("email_create"));
		inputField.sendKeys("gofran0125@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Gofran");
		driver.findElement(By.id("customer_lastname")).sendKeys("Khan");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		
		Select date = new Select(driver.findElement(By.name("days")));
		date.selectByValue("22");
		Select months = new Select(driver.findElement(By.name("months")));
		months.selectByValue("7");
		Select years = new Select(driver.findElement(By.name("years")));
		years.selectByValue("1992");
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Gofran");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Khan");
		driver.findElement(By.id("company")).sendKeys("Samsung");
		
		driver.findElement(By.id("address1")).sendKeys("Nabinagar, Savar, Dhaka");
		driver.findElement(By.id("address2")).sendKeys("Nabinagar, Savar, Dhaka");
		
		driver.findElement(By.id("city")).sendKeys("Dhaka");
		
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByValue("2");
		
		driver.findElement(By.id("postcode")).sendKeys("99501");
		
		Select country = new Select(driver.findElement(By.name("id_country")));
		country.selectByValue("21");
		
		driver.findElement(By.id("other")).sendKeys("Thank you");
		driver.findElement(By.id("phone_mobile")).sendKeys("18002527522");
		driver.findElement(By.id("alias")).sendKeys("alias");
		driver.findElement(By.id("submitAccount")).click();
		driver.close();
		
		
		//Log in using created account
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//login with credentials
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("gofran0123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String expectedAccountName = "Gofran Khan";
		String accountName = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")).getText();
		if(expectedAccountName.equals(accountName)){
			System.out.println("Login Success");
		}else{
			System.out.println("Login Failed");
		}
		//Add first Item to cart and go for 2nd
		WebElement ele = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"));
	    Actions action = new Actions(driver);
	    action.moveToElement(ele).build().perform();
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
	    driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span/i")).click();
		
	    //Add second Item to cart and go for payment
	    WebElement ele1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
	    Actions action1 = new Actions(driver);
	    action1.moveToElement(ele1).build().perform();
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[1]/span")).click();
	    driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
	    
	    String items = driver.findElement(By.className("ajax_cart_quantity")).getText();
	    if(items.equals("2")){
	    	System.out.println("Two items added");
	    }else{
	    	System.out.println("Two Items not added");
	    }
	    
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
	    //proceed to checkout
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
	    //agree to the term
	    driver.findElement(By.id("cgv")).click();
	    //Proceed to checkout
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span")).click();
	    //pay by bank wire
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a/span")).click();
	    //I confirm my order
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
	    //Back to order
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p/a")).click();
	    //Back to your account
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/ul/li[1]/a/span")).click();
	}
}
