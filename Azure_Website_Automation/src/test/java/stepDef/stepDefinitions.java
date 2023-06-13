package stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class stepDefinitions {
	
	WebDriver driver = null;
	private String selectedGender;
	private String selectedList1;
	private String selectedList2;
	private String selectedOption;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/asus/git/Azure_Website_Automation/Azure_Website_Automation/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@And(".*?is on Automation page$")
	public void on_automation_page() {
		driver.navigate().to("https://itera-qa.azurewebsites.net/home/automation");
	}

	@And(".*? set delay .*?(\\d+).*?$")
	public void set_delay(long timeout) {
		long multipliedTimedOut = timeout * 1000;
		try {
			Thread.sleep(multipliedTimedOut);
		}catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

	@When(".*? enters (.*), (.*), (.*), (.*) and (.*)$")
	public void enters_biodata(String name, String number, String email, String pass, String address) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(number);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("address")).sendKeys(address);
	}

	@Then(".*?clicks submit button$")
	public void clicks_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@When(".*?clicks (.*) gender$")
	public void clicks_gender(String gender) {
		driver.findElement(By.xpath("//input[@id='"+ gender + "']")).click();
		selectedGender = gender;
	}

	@And(".*?clicks first box (.*)$")
	public void clicks_first_box(String list1) {
		driver.findElement(By.xpath("//input[@id='" + list1 + "']")).click();
		selectedList1 = list1;
	}
	
	@And(".*?clicks second box (.*)$")
	public void clicks_second_box(String list2) {
		driver.findElement(By.xpath("//input[@id='" + list2 + "']")).click();
		selectedList2 = list2;

	}

	@Then("the selection gender is (.*)$")
	public void gender_selected(String expected_gender) {
		assert selectedGender.equals(expected_gender);
	}

	@Then("the selection days are (.*) and (.*)$")
	public void days_are_selected(String expected_list1, String expected_list2) {
		assert selectedList1.equals(expected_list1);
		assert selectedList2.equals(expected_list2);
	}

	@When(".*? selects (.*) from the dropdown$")
	public void select_from_the_dropdown(String option) {
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='custom-select']"));
		
		// Buat objek Select untuk mengelola dropdown
		Select select = new Select(dropdown);
		
		// Pilih opsi berdasarkan teks visibel
		select.selectByVisibleText(option);
		selectedOption = option;
		
	}

	@Then("the selected option is (.*)$")
	public void country_is_selected(String expected_option) {
		assert selectedOption.equals(expected_option);
	}

	@When(".*? uploads file (.*)$")
	public void uploads_file(String file) {
		driver.findElement(By.id("inputGroupFile02")).sendKeys(file);
	}

	@And("close browser")
	public void close_browser() {
	    driver.quit();
	}

}
