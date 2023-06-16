package juspayJioMart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JioMartOrderProductTest
{
	@Test
	public void automateJioMartUpipay()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 15);
		driver.get("https://www.jiomart.com/"); //load Jio Mart Web App
		driver.findElement(By.xpath("//input[@placeholder='Search JioMart']")).sendKeys("Tata toor Dal"); //Search for Product
		driver.findElement(By.xpath("//div[@id='search_initial']//ul[@role='listbox']//span[contains(.,'tata toor dal 1kg')]")).click(); //select the product in suggested list
		driver.findElement(By.xpath("//div[.=' Tata Sampann Unpolished Tur / Arhar Dal 1 kg ']/../../following-sibling::div[1]//button[contains(.,' Add ')]//img")).click();//click on add to cart button
		driver.findElement(By.xpath("//button[@id='btn_minicart']")).click();//click on cart button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[.=' Login ']"))));//wait till visibility Login button
		driver.findElement(By.xpath("//button[.=' Login ']")).click();//click on login button
		driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("9731503672");//enter mobile number(enter your registered mob number while running the script)
		driver.findElement(By.xpath("//div[.=' Get OTP ']")).click();//click on get OTP button
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//pausing execution to enter OTP
		WebElement verifyButton = driver.findElement(By.xpath("//div[.=' Verify ']"));
		wait.until(ExpectedConditions.elementToBeClickable(verifyButton));//wait till verify button to be clickable
		verifyButton.click();//click on verify button
		driver.findElement(By.xpath("//jds-container[@id='login-container']/section//button[@type='submit']/div[.=' Place Order ']")).click(); //click on Place order button
		driver.findElement(By.xpath("//div[.='Select Address']/../div[2]//jds-button[@title='Deliver Here']/button/div")).click(); //select address in address tab
		driver.findElement(By.xpath("//div[@class='place-order ng-star-inserted']/jds-button/button/div")).click();
		WebElement radioButton = driver.findElement(By.xpath("//span[.='Google Pay']/../div[1]/div/span"));
		wait.until(ExpectedConditions.visibilityOf(radioButton));//wait till radio button visible
		driver.findElement(By.xpath("//span[.='Google Pay']/../div[1]/div/span")).click();//select radio button
		driver.findElement(By.xpath("//input[@id='desktopUpiInput']")).sendKeys("9731503672"); //enter upi id
		driver.findElement(By.xpath("//button[contains(.,'Pay ')]")).click();//click on pay button
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();//close app


	}
	@Test
	public void automateJioMartWalletPay()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 15);
		driver.get("https://www.jiomart.com/"); //load Jio Mart Web App
		driver.findElement(By.xpath("//input[@placeholder='Search JioMart']")).sendKeys("Tata toor Dal"); //Search for Product
		driver.findElement(By.xpath("//div[@id='search_initial']//ul[@role='listbox']//span[contains(.,'tata toor dal 1kg')]")).click(); //select the product in suggested list
		driver.findElement(By.xpath("//div[.=' Tata Sampann Unpolished Tur / Arhar Dal 1 kg ']/../../following-sibling::div[1]//button[contains(.,' Add ')]//img")).click();//click on add to cart button
		driver.findElement(By.xpath("//button[@id='btn_minicart']")).click();//click on cart button
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[.=' Login ']"))));//wait till visibility Login button
		driver.findElement(By.xpath("//button[.=' Login ']")).click();//click on login button
		driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys("9731503672");//enter mobile number(enter your registered mob number while running the script)
		driver.findElement(By.xpath("//div[.=' Get OTP ']")).click();//click on get OTP button
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//pausing execution to enter OTP
		WebElement verifyButton = driver.findElement(By.xpath("//div[.=' Verify ']"));
		wait.until(ExpectedConditions.elementToBeClickable(verifyButton));//wait till verify button to be clickable
		verifyButton.click();//click on verify button
		driver.findElement(By.xpath("//jds-container[@id='login-container']/section//button[@type='submit']/div[.=' Place Order ']")).click(); //click on Place order button
		driver.findElement(By.xpath("//div[.='Select Address']/../div[2]//jds-button[@title='Deliver Here']/button/div")).click(); //select address in address tab
		driver.findElement(By.xpath("//div[@class='place-order ng-star-inserted']/jds-button/button/div")).click();
		driver.findElement(By.xpath("//div[@data-testid='wallets-tab']/div")).click();//click on Wallet payment options
		driver.findElement(By.xpath("//div[.='PhonePe']/..//button")).click();//select phonepe option
		WebElement proceed = driver.findElement(By.xpath("//button[.='Proceed']"));
		wait.until(ExpectedConditions.elementToBeClickable(proceed));//wait till  proceed button clickable
		proceed.click();//click on proceed button

		driver.findElement(By.xpath("//button[.='Submit']")).click();//click otp submit button
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();//close app
	}
}
