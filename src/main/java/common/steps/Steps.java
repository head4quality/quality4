package common.steps;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

import pageObjects.GoogleSearchPage;
import pageObjects.PageObjectSeleniumSikuli;
import common.RunDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static common.selenium.Acciones.*;
import static common.selenium.Aserciones.*;
import static common.selenium.Teclas.*;
import static org.junit.Assert.fail;


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
	
////////////////////---------- When's ----------////////////////////
	
	
	@When("^click en \"(.*?)\"$")
	public void click_en(String elemento) throws Throwable {
	   if(page.existeElementoSelenium(elemento))
		   click(page.obtenerElementoSelenium(elemento));
	   else
		   if(page.existeElementoSikuli(elemento))
			   click(page.obtenerElementoSikuli(elemento));
		   else 
			   fail("No existe el elemento ingresado.");
	}

	@When("^ingresar texto \"(.*?)\" en \"(.*?)\"$")
	public void ingresar_texto_en(String texto, String elemento) throws Throwable {
		if(page.existeElementoSelenium(elemento)){
				clear(page.obtenerElementoSelenium(elemento));
			   sendKeys(page.obtenerElementoSelenium(elemento), texto);}
		   else
			   if(page.existeElementoSikuli(elemento)){
				   click(page.obtenerElementoSikuli(elemento));
				   sendKeys(page.obtenerElementoSikuli(elemento), texto);}
			   else 
				   fail("No existe el elemento ingresado.");
	}
	
	@When("^seleccionar combo \"(.*?)\" con la opcion de orden (\\d+)$")
	public void seleccionar_combo_con_la_opcion_de_orden(String elemento, int opcion) throws Throwable {
		if(page.existeElementoSelenium(elemento))
			selectByIndex(page.obtenerElementoSelenium(elemento), opcion);
	   else
		   if(page.existeElementoSikuli(elemento))
			   selectByIndex(page.obtenerElementoSikuli(elemento), opcion);
		   else 
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^seleccionar combo \"(.*?)\" con la opcion \"(.*?)\"$")
	public void seleccionar_combo_con_la_opcion(String elemento, String opcion) throws Throwable {
		if(page.existeElementoSelenium(elemento))
			   selectByVisibleText(page.obtenerElementoSelenium(elemento), opcion);
		   else
			   if(page.existeElementoSikuli(elemento))
				   seleccionarCombo(page.obtenerElementoSikuli(elemento), page.obtenerElementoSikuli(opcion));
			   else 
				   fail("No existe el elemento ingresado.");
	}
	
	@When("^mover mousse a \"(.*?)\"$")
	public void mover_mousse_a(String elemento) throws Throwable {
		 if(page.existeElementoSikuli(elemento))
			   move(page.obtenerElementoSikuli(elemento));
		   else 
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^doble click en \"(.*?)\"$")
	public void doble_click_en(String elemento) throws Throwable {
		 if(page.existeElementoSikuli(elemento))
			   dobleClick(page.obtenerElementoSikuli(elemento));
		   else 
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^click derecho en \"(.*?)\"$")
	public void click_derecho_en(String elemento) throws Throwable {
		 if(page.existeElementoSikuli(elemento))
			   clickDerecho(page.obtenerElementoSikuli(elemento));
		   else 
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^click derecho en \"(.*?)\" y selecciono la opcion de orden (\\d+)$")
	public void click_derecho_en_y_selecciono_la_opcion_de_orden(String elemento, int opcion) throws Throwable {
		 if(page.existeElementoSikuli(elemento))
			   clickDerecho(page.obtenerElementoSikuli(elemento), opcion);
		   else 
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^seleccionar combo \"(.*?)\" con la opcion que contenga\"(.*?)\"$")
	public void seleccionar_combo_con_la_opcion_que_contenga(String elemento, String opcion) throws Throwable {
		if(page.existeElementoSelenium(elemento))
			   seleccionarComboPorTextoParcial(page.obtenerElementoSelenium(elemento), opcion);
		   else
			   fail("No existe el elemento ingresado.");
	}
	
	@When("^presiono el boton ENTER$")
	public void presiono_el_boton_ENTER() throws Throwable {
		Enter();
	}
	
	@When("^presiono la tecla de navegacion UP$")
	public void presiono_la_tecla_de_navegacion_UP() throws Throwable {
		Arriba();
	}
	
	@When("^presiono la tecla de navegacion DOWN$")
	public void presiono_la_tecla_de_navegacion_DOWN() throws Throwable {
		Abajo();
	}
	
	@When("^presiono la tecla de navegacion LEFT$")
	public void presiono_la_tecla_de_navegacion_LEFT() throws Throwable {
		Izquierda();
	}
	
	@When("^presiono la tecla de navegacion RIGTH$")
	public void presiono_la_tecla_de_navegacion_RIGTH() throws Throwable {
		Derecha();
	}
	
////////////////////---------- Then's ----------////////////////////
	
	
	@Then("^se verifica el elemento\"(.*?)\" \"(.*?)\"$")
	public void se_verifica_el_elemento(String elemento, String estado) throws Throwable {
		if(page.existeElementoSelenium(elemento))
			   verificarEstado(page.obtenerElementoSelenium(elemento), estado);
		   else
			   if(page.existeElementoSikuli(elemento))
				   verificarEstado(page.obtenerElementoSikuli(elemento), estado);
			   else 
				   fail("No existe el elemento ingresado.");
	}
	
	@Then("^verificar que existe el elemento\"(.*?)\"$")
	public void verificar_que_existe_el_elemento(String elemento) throws Throwable {
		if(page.existeElementoSikuli(elemento))
		   existeElemento(page.obtenerElementoSikuli(elemento));
		else 
		   fail("No existe el elemento ingresado.");
	}
	
	@Then("^verificar que existe el elemento\"(.*?)\" dentro del elemento\"(.*?)\"$")
	public void verificar_que_existe_el_elemento_dentro_del_elemento(String elementoContenedor, String elementoBuscado) throws Throwable {
		if(page.existeElementoSikuli(elementoContenedor) && page.existeElementoSikuli(elementoBuscado))
		   existeElemento(page.obtenerElementoSikuli(elementoContenedor), page.obtenerElementoSikuli(elementoBuscado));
		else 
		   fail("No existe uno (o ninguno) de los elementos ingresados.");
	}
	
}
