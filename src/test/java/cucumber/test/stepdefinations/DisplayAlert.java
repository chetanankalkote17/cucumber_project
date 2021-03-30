package cucumber.test.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayAlert {

	WebDriver driver;
	
	@Given("User opened url")
	public void user_opened_url() {
	    
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}




	@Given("User click on alert with ok button")
	public void user_click_on_alert_with_ok_button() {
	    
		WebElement okButton=driver.findElement(By.xpath("//a[@href='#OKTab']"));
		okButton.click();
	    
	}
	@When("User click display alert box button in red color")
	public void user_click_display_alert_box_button_in_red_color() {
	   
		WebElement displayAlertButton=driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
		displayAlertButton.click();
	    
	}
	@Then("Alert is displayed")
	public void alert_is_displayed() throws InterruptedException {
        Thread.sleep(3000);
        
		
	    Alert alert1=driver.switchTo().alert();
	    
	  System.out.println(alert1.getText());
	  
	  alert1.accept();
	   
	  driver.quit();
	  
	  
	  
	}

}
