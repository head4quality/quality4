package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPagePage {

	private WebDriver driver;

	HashMap<String, WebElement> elements;
	
	@FindBy(name = "checkbox") WebElement checkbox;
	@FindBy(name = "text") WebElement text;
	@FindBy(name = "select") WebElement select;
	
	public BasicPagePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		elements = new HashMap<>();
		elements.put("checkbox", this.checkbox);
		elements.put("text", text);
		elements.put("select", select);
	}
	
	/**
	 * Retorna el valor correspondiente del hashmap elementos
	 */
	public WebElement getElement(String key){
		return elements.get(key);
	}
}
