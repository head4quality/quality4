package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PageObjectSeleniumSikuli {

	/**
	 * Esta clase es superclase de los page objects en proyectos en los que se
	 * usa selenium y sikuli conviviendo en la implementacion de los pasos
	 */
	
	protected WebDriver driver;
	
	protected HashMap<String, WebElement> mapaDeElementosSelenium;
	
	protected HashMap<String, String> mapaDeElementosSikuli;
	
	public PageObjectSeleniumSikuli(WebDriver driver){
		PageFactory.initElements(new DefaultElementLocatorFactory(driver),
				this);
		this.driver = driver;
	}
	
	/**
	 * Retorna el WebElement coincidente
	 * @param clave a buscar en el mapa de elementos de SELENIUM
	 * @return elemento coincidente
	 */
	public WebElement obtenerElementoSelenium(String clave){
		return this.mapaDeElementosSelenium.get(clave);
	}
	
	/**
	 * Retorna el ruta a la imagen coincidente
	 * @param clave a buscar en el mapa de elementos de SIKULI
	 * @return ruta a la imagen del elemento
	 */
	public String obtenerElementoSikuli(String clave){
		return this.mapaDeElementosSikuli.get(clave);
	}
	
}
