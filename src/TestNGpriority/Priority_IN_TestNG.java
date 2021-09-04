package TestNGpriority;

import org.testng.annotations.Test;
import org.openqa.selenium.By;			
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;			

public class Priority_IN_TestNG {
	WebDriver driver;

    // Method 1: Open Browser say Firefox			
    @Test (priority=1)		
    public void openBrowser() {	
    	System.setProperty("webdriver.chrome.driver", "D:\\DevOps Tools\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
    	System.out.println("Priority-1");
		System.out.println("Hello Google...");
		//driver.manage().window().maximize();
		driver.get("http://google.com");
		//driver.close();
    }		

    // Method 2: Launch Google.com			
    @Test (priority=2)		
    public void launchGoogle() {
    	System.out.println("Priority-2");
        driver.get("http://www.google.co.in");						
    }		

    // Method 3: Perform a search using "Facebook"			
    @Test (priority=3)		
    public void peformSeachAndClick1stLink() {	
    	System.out.println("Priority-3");
        WebElement element = driver.findElement(By.xpath(".//*[@title='Search']"));
        element.sendKeys("Facebook");
        element.submit();
    }		

    // Method 4: Verify Google search page title.			
    @Test (priority=4)		
    public void FaceBookPageTitleVerification() throws Exception {	
    	System.out.println("Priority-4");
        driver.findElement(By.xpath(".//*[@value='Search']")).click();						
        Thread.sleep(3000);		
        Assert.assertEquals(driver.getTitle().contains("Facebook - Google Search"), true);
        driver.close();
    }
}
