package common.H4Q;

import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Pasos {
	private WebDriver driver;
	TablaDeElementos page;
	
	/*@Before
	public void setUpBefore() throws Exception{
		
	}
	
	@After
	public void tearDownAfter(){
	
	}*/
	
	@Given("^cargar elementos con propertie \"(.*?)\"$")
	public void cargar_elementos_con_propertie(String propertie) throws Throwable {
		page= new TablaDeElementos(propertie);
	}
	
	@Given("^abrir driver$")
	public void abrir_driver(){
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
	}
	
	@When("^click en \"(.*?)\"$")
	public void click_en(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.click(page.obtenerSelector(elemento));
		else
			AccionesSelenium.click(page.obtenerSelector(elemento), driver);
	}
	
	@When("^limpiar campo \"(.*?)\"$")
	public void limpiar_campo(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AccionesSelenium.clear(page.obtenerSelector(elemento), driver);
	}
	
	@When("^escribir texto \"(.*?)\" en campo \"(.*?)\"$")
	public void esribir_texto_en_campo(String texto, String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.sendKeys(page.obtenerSelector(elemento), texto);
		else
			AccionesSelenium.sendKeys(page.obtenerSelector(elemento), texto, driver);
	}
	
	@When("^cargar combo \"(.*?)\" con opcion numero (\\d+)$")
	public void cargar_combo_con_opcion_numero(String elemento, int indice)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.selectByIndex(page.obtenerSelector(elemento), indice);
		else
			AccionesSelenium.selectByIndex(page.obtenerSelector(elemento), indice, driver);

	}
	
	@When("^cargar combo \"(.*?)\" con opcion de texto \"(.*?)\"$")
	public void cargar_combo_con_opcion_de_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(!driver.findElement(By.cssSelector(elemento)).getText().contains(opcion))
			fail("No existe la opcion seleccionada.");
		AccionesSelenium.selectByVisibleText(page.obtenerSelector(elemento), opcion, driver );
	}
	
	@When("^cargar combo \"(.*?)\" con opcion que contenga el texto \"(.*?)\"$")
	public void cargar_combo_con_opcion_que_contenga_el_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AccionesSelenium.seleccionarComboPorTextoParcial(page.obtenerSelector(elemento), opcion, driver);
	}
	
	@When("^click en elemento numero (\\d+) de la lista \"(.*?)\"$")
	public void click_en_elemento_numero_de_la_lista(int opcion, String lista)throws Throwable {
		if(page.obtenerSelector(lista).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		driver.findElements(By.cssSelector(page.obtenerSelector(lista))).get(opcion).click();
	}
	
	@When("^escribir texto \"(.*?)\" en campo deshabilitado \"(.*?)\"$")
	public void escribir_texto_en_campo_deshabilitado(String texto, String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AccionesSelenium.sendKeyInhabilitado(page.obtenerSelector(elemento), texto, 10, driver);
	}
	
	@When("^dirigirse al elemento \"(.*?)\"$")
	public void dirigirse_al_elemento(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.moverPuntero(page.obtenerSelector(elemento));
		else
			AccionesSelenium.moverPuntero(page.obtenerSelector(elemento), 10, driver);
	}
	
	@When("^doble click en \"(.*?)\"$")
	public void doble_click_en(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.dobleClick(page.obtenerSelector(elemento));
		else
			AccionesSelenium.dobleClick(page.obtenerSelector(elemento), driver);
	}
	
	@When("^click derecho en \"(.*?)\"$")
	public void click_derecho_en(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AccionesSikuli.clickDerecho(page.obtenerSelector(elemento));
	}
	
	@When("^click derecho en \"(.*?)\" y seleccionar opcion numero (\\d+)$")
	public void click_derecho_en_y_seleccionar_opcion_numero(String elemento, int opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AccionesSikuli.clickDerecho(page.obtenerSelector(elemento), opcion);
	}
	
	@When("^presionar boton ENTER$")
	public void presionar_boton_ENTER()throws Throwable {
		Teclas.Enter();
	}
	
	@When("^presionar boton CTRL$")
	public void presionar_boton_CTRL()throws Throwable {
		Teclas.Ctrl();
	}
	
	@When("^presionar boton SHIFT$")
	public void presionar_boton_SHIFT()throws Throwable {
		Teclas.Shift();
	}
	
	@When("^presionar boton TAB$")
	public void presionar_boton_TAB()throws Throwable {
		Teclas.Tab();
	}
	
	@When("^presionar boton ESC$")
	public void presionar_boton_ESC()throws Throwable {
		Teclas.Esc();
	}
	
	@When("^presionar boton INSERT$")
	public void presionar_boton_INSERT()throws Throwable {
		Teclas.Insert();
	}
	
	@When("^presionar boton LEFT$")
	public void presionar_boton_LEFT()throws Throwable {
		Teclas.Izquierda();
	}
	
	@When("^presionar boton RIGTH$")
	public void presionar_boton_RIGTH()throws Throwable {
		Teclas.Derecha();
	}
	
	@When("^presionar boton UP$")
	public void presionar_boton_UP()throws Throwable {
		Teclas.Arriba();
	}
	
	@When("^presionar boton DOWN$")
	public void presionar_boton_DOWN()throws Throwable {
		Teclas.Abajo();
	}
	
	@When("^presionar boton PAUSE$")
	public void presionar_boton_PAUSE()throws Throwable {
		Teclas.Pause();
	}
	
	@When("^presionar boton BACKSPACE$")
	public void presionar_boton_DELETE()throws Throwable {
		Teclas.Delete();
	}
	
	@When("^presionar boton F1$")
	public void presionar_boton_F1()throws Throwable {
		Teclas.F1();
	}
	
	@When("^presionar boton F2$")
	public void presionar_boton_F2()throws Throwable {
		Teclas.F2();
	}
	
	@When("^presionar boton F3$")
	public void presionar_boton_F3()throws Throwable {
		Teclas.F3();
	}
	
	@When("^presionar boton F4$")
	public void presionar_boton_F4()throws Throwable {
		Teclas.F4();
	}
	
	@When("^presionar boton F5$")
	public void presionar_boton_F5()throws Throwable {
		Teclas.F5();
	}
	
	@When("^presionar boton F6$")
	public void presionar_boton_F6()throws Throwable {
		Teclas.F6();
	}
	
	@When("^presionar boton F7$")
	public void presionar_boton_F7()throws Throwable {
		Teclas.F7();
	}
	
	@When("^presionar boton F8$")
	public void presionar_boton_F8()throws Throwable {
		Teclas.F8();
	}
	
	@When("^presionar boton F9$")
	public void presionar_boton_F9()throws Throwable {
		Teclas.F9();
	}
	
	@When("^presionar boton F10$")
	public void presionar_boton_F10()throws Throwable {
		Teclas.F10();
	}
	
	@When("^presionar boton F11$")
	public void presionar_boton_F11()throws Throwable {
		Teclas.F11();
	}
	
	@When("^presionar boton F12$")
	public void presionar_boton_F12()throws Throwable {
		Teclas.F12();
	}
	
	@Then("^verificar combo \"(.*?)\" cargado con la opcion de texto\"(.*?)\"$")
	public void verificar_combo_cargado_con_la_opcion_de_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		assertTrue(AccionesSelenium.obtenerValorCombo(page.obtenerSelector(elemento), driver).equals(opcion));
	}
	
	@Then("^verificar que combo \"(.*?)\" contiene en su seleccion el texto \"(.*?)\"$")
	public void verificar_que_combo_contiene_en_su_seleccion_el_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		assertTrue(AccionesSelenium.obtenerValorCombo(page.obtenerSelector(elemento), driver).contains(opcion));
	}

	@Then("^verificar que el campo de texto \"(.*?)\" tiene cargado el texto \"(.*?)\"$")
	public void verificar_que_el_campo_de_texto_tiene_cargado_el_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		assertTrue(AccionesSelenium.obtenerValorDeCampo(page.obtenerSelector(elemento), driver).equals(opcion));
	}
	
	@Then("^verificar que campo de texto \"(.*?)\" contiene el texto \"(.*?)\"$")
	public void verificar_que_campo_de_texto_contiene_el_texto(String elemento, String opcion)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		assertTrue(AccionesSelenium.obtenerValorDeCampo(page.obtenerSelector(elemento), driver).contains(opcion));
	}
	
	@Then("^verificar elemento \"(.*?)\" \"(.*?)\"$")
	public void verificar_elemento(String elemento, String estado)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AsercionesSikuli.verificarEstado(page.obtenerSelector(elemento), estado);
		else
			AsercionesSelenium.verificarEstado(page.obtenerSelector(elemento), estado, driver);
	}
	
	@Then("^verificar que combo \"(.*?)\" tiene seleccionado el texto de la etiqueta \"(.*?)\"$")
	public void verificar_que_combo_tiene_seleccionado_el_texto_de_la_etiqueta(String combo, String etiqueta)throws Throwable {
		if(page.obtenerSelector(combo).equals("null"))
			fail("El combo ingresado no esta definido en el archivo Properties. ");
		if(page.obtenerSelector(etiqueta).equals("null"))
			fail("La etiqueta ingresada no esta definida en el archivo Properties. ");
		AsercionesSelenium.compararComboConEtiqueta(page.obtenerSelector(combo), etiqueta, driver);
		
	}
	
	@Then("^verificar que combo \"(.*?)\" tiene disponible la opcion \"(.*?)\"$")
	public void verificar_que_combo_tiene_disponible_la_opcion(String combo, String opcion)throws Throwable {
		if(page.obtenerSelector(combo).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AsercionesSelenium.verificarOpcionDeCombo(page.obtenerSelector(combo), opcion, driver);
	}
	
	@Then("^verificar mensaje \"(.*?)\" en el elemento \"(.*?)\"$")
	public void verificar_mensaje_en_el_elemento(String mensaje, String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		AsercionesSelenium.verificarTextoEnElemento(page.obtenerSelector(elemento), mensaje, driver);
	}
	
	@Then("^verificar que existe elemento \"(.*?)\" en el elemento \"(.*?)\"$")
	public void verificar_que_existe_elemento_en_el_elemento(String elementoChico, String elementoContenedor)throws Throwable {
		if(page.obtenerSelector(elementoChico).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.obtenerSelector(elementoContenedor).equals("null"))
			fail("El elemento contenedor ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elementoChico)))
			AsercionesSikuli.existeElemento(page.obtenerSelector(elementoChico), page.obtenerSelector(elementoContenedor));
		//else
		//	AsercionesSelenium.verificarEstado(page.obtenerSelector(elementoChico), estado, driver);
	}
	
	
}
