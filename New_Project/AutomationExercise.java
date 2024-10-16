package AutomationExercise2;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutomationExercise {

	private static final String Product = null;

	public static void main(String[] args) throws Exception {
		
		//1.Launch Browser
		WebDriver driver = new ChromeDriver();
		
		
		//2.Navigate to URL 'https://automationexercise.com/'
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		//3.Verify that home page is visible successfully
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Automation Exercise")) {
			System.out.println("title is correct");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		//4.. Click on  'Signup / Login' button
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		
		
		//5. Fill all details in Signup and create account
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Vishal");
		driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("vishalchafalkar73@gmail.com");
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Vishal@123");
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Vishal");
	    driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Chafalkar");
	    driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Airoli");
	    driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Maharashtra");
	    driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Mumbai");
	    driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("400708");
	    driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("7620299570");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		
		//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		//7. Verify ' Logged in as' at top
		WebElement name = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a"));
		System.out.println(name.isDisplayed());
		
		
		
		//Verify all products
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		String Product = driver.findElement(By.xpath("//h2[text()='All Products']")).getText();
		assertEquals(Product,"All Products");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
		String ProductName = driver.findElement(By.xpath("//h2[text()='Blue Top']")).getText();
		assertEquals(ProductName,"Blue Top");
		List<WebElement> details = driver.findElements(By.xpath("//div[@class='product-information']//p"));
		for(int i = 0;i<details.size();i++) {
			System.out.println(details.get(i).getText());
		}
		
		
		//Search Products
		/*driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.id("search_product")).sendKeys("jeans");
		driver.findElement(By.id("submit_search")).click();
		String text = driver.findElement(By.xpath("//h2[text()='Searched Products']")).getText();
		assertEquals(text, "Searched Products");
		
		
		
		//View category product
		/*driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[contains(@href,'Women')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'1') and text()='Dress ']")).click();
		Thread.sleep(5000);
		String text =driver.findElement(By.xpath("//h2[text()='Women - Dress Products']")).getText();
		System.out.println(text);
		assertEqual(text, "WOMEN - DRESS PRODUCTS");
		
	
		//8. Add products to cart
		/*driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")).click();
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("7");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
        String qty= driver.findElement(By.xpath("//td[@class='cart_quantity']")).getText();*/
	    
       
		//9.Click 'Cart' button
		driver.findElement(By.xpath("//a[contains(@href, 'view_cart')]")).click();
        System.out.println("cart is displayed");
		
		
		//10.Verify that cart page is displayed
		WebElement cart = driver.findElement(By.xpath("//li[@class='active']"));
		System.out.println(cart.isDisplayed());
		
		//11. Click Proceed To Checkout
     	//driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
     	driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
     	
     	
     	//12. Verify that the delivery address is same address filled at the time registration of account
     	
     	 String add ="";
     	 try {
     	 add = driver.findElement(By.xpath("(//li[text()='Airoli'])[1]")).getText();	
     	 }
     	 catch(NoSuchElementException e) {
     		
     	 }
     	 String exp_lable ="Airoli";
     	 if(add.equals(exp_lable))
     		{
     			System.out.println("Test passed");
     		}
     		else
     		{
     			System.out.println("Test failed");
     		}
     		
     	Thread.sleep(3000);
     	JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0, 400)");
		   
     	//14. Make payment Enter dummy card details
     	 driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
     	 driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("Vishal ");
     	 driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("123456789");
     	 driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("111");
     	 driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("03");
     	 driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2027");
     	
     	 //15. Place Order and verify order status and download invoice
     	 driver.findElement(By.xpath("//button[@id='submit']")).click();
     	 String Cong = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText();	
     	 driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();
     	 System.out.println("Invoice downloaded");
     	 
     	 driver.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();	
     	
     	
     	  
     	 //16. Click 'Delete Account' button
          driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
     	 driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
     	 System.out.println("account deleted");
     	
     	 //17.Click on continue button
     	 driver.findElement(By.xpath("//a[text()='Continue']")).click();
     
		
		
	}

	private static void assertEquals(String text, String string) {
		// TODO Auto-generated method stub
		
	}

	private static void assertEqual(String text, String string) {
		// TODO Auto-generated method stub
		
	}
}
