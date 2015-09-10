package common.steps;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

import pageObjects.GoogleSearchPage;
import pageObjects.PageObjectSeleniumSikuli;
import common.RunDriver;
import common.selenium.Acciones;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {

	WebDriver driver;
	PageObjectSeleniumSikuli page;
	
	@Before
	public void before(){
		driver=RunDriver.getDriver();
	}
	
	@After
	public void after() throws InterruptedException{
		Thread.sleep(1000);
	}
	
	/**
	 * Crea un objeto usando reflect que instancia el page object a partir del nombre
	 * 
	 * @param nombreDeClase a instanciar
	 * @throws Throwable
	 */
	@Given("^se instancia page object \"(.*?)\"$")
	public void se_instancia_page_object(String nombreDeClase) throws Throwable {
	//Se obtiene la clase a partie
	   Class<?> clase = Class.forName(nombreDeClase);
	   Constructor<?> con = clase.getConstructor(WebDriver.class);
	   page = (GoogleSearchPage) con.newInstance(driver);
	}
	
	@Given("^se ingresa a \"(.*?)\"$")
	public void se_ingresa_a(String arg1) throws Throwable {
	    driver.get(arg1);
	}

	@When("^click \"(.*?)\"$")
	public void click_en(String arg1) throws Throwable {
	    Acciones.click(page.obtenerElementoSelenium(arg1));
	}

	@When("^ingresar texto \"(.*?)\" en \"(.*?)\"$")
	public void ingresar_texto_en(String arg1, String arg2) throws Throwable {
		Acciones.sendKeys(page.obtenerElementoSelenium(arg2), arg1);
	}

	@Then("^se verifica \"(.*?)\" \"(.*?)\"$")
	public void se_verifica(String arg1, String arg2) throws Throwable {
	    //Aserciones.verificarEstado(page.obtenerElemento(arg1), arg2);
	}
}
