package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearchPage extends PageObjectSeleniumSikuli {

	
	@FindBy(name="q") public WebElement input_busqueda;
	@FindBy(name="btnG") public WebElement boton_buscar;

	public GoogleSearchPage(WebDriver driver){
		super(driver);
		mapaDeElementosSelenium=new HashMap<String, WebElement>();
		
		// se deben agregar los elementos al hashmap
		mapaDeElementosSelenium.put("input busqueda", input_busqueda);
		mapaDeElementosSelenium.put("boton buscar", boton_buscar);
	}	
}
