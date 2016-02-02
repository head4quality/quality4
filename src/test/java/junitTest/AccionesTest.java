
package junitTest;

import static org.junit.Assert.*;
import static h4quality.Acciones.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.BasicPagePage;

public class AccionesTest {
	
	public static final String CHECK = "checkbox";

	private static final String TEXT = "text";

	private static final String SELECT = "select";

	static WebDriver driver;
	
	//url del html de prueba
	private String url="file:///home/gonzalo/workspace/quality4/src/test/resources/basicPage.html";
	
	//Page Object de la pagina de prueba	
	BasicPagePage pageObject;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		driver.get(url);
		pageObject = new BasicPagePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void ocultarElemento(String nombre){
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).css({'display':'none'})"
				, pageObject.getElement(nombre));
	}
	
	private void eliminarElemento(String nombre){
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).remove()"
				, pageObject.getElement(nombre));
	}

	@Test
	public void testClick() throws InterruptedException {
		click(pageObject.getElement(CHECK));
		assertTrue(pageObject.getElement(CHECK).isSelected());
	}
	
	@Test
	public void test_click_elemento_no_visible() throws InterruptedException{
		ocultarElemento(CHECK);
		try {
			click(pageObject.getElement(CHECK),1);
			fail("se hizo click");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_click_elemento_no_presente() throws InterruptedException{
		eliminarElemento(CHECK);
		try {
			click(pageObject.getElement(CHECK),1);
			fail("se hizo click");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_clear() throws InterruptedException{
		clear(pageObject.getElement(TEXT));
		assertEquals(obtenerValorDeCampo(pageObject.getElement(TEXT), driver), "");
	}
	
	@Test
	public void test_clear_elemento_no_visible() throws InterruptedException{
		ocultarElemento(TEXT);
		try {
			clear(pageObject.getElement(TEXT), 1);
			fail("se hizo clear");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_clear_elemento_no_presente() throws InterruptedException{
		eliminarElemento(TEXT);
		try {
			clear(pageObject.getElement(TEXT), 1);
			fail("se hizo clear");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_send_keys() throws InterruptedException{
		clear(pageObject.getElement(TEXT));
		sendKeys(pageObject.getElement(TEXT), "alpha");
		assertEquals(obtenerValorDeCampo(pageObject.getElement(TEXT), driver), "alpha");
	}
	
	@Test
	public void test_send_keys_elemento_no_visible() throws InterruptedException{
		ocultarElemento(TEXT);
		try {
			sendKeys(pageObject.getElement(TEXT), "beta", 1);
			fail("se hizo send keys");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_send_keys_elemento_no_presente() throws InterruptedException{
		eliminarElemento(TEXT);
		try {
			sendKeys(pageObject.getElement(TEXT), "gamma", 1);
			fail("se hizo send keys");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_select_index() throws InterruptedException{
		selectByIndex(pageObject.getElement(SELECT), 1);
		assertEquals(obtenerValorCombo(pageObject.getElement(SELECT)), "uno");
	}
	
	@Test
	public void test_select_index_elemento_no_visible() throws InterruptedException{
		ocultarElemento(SELECT);
		try {
			selectByIndex(pageObject.getElement(SELECT), 1, 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_select_index_elemento_no_presente() throws InterruptedException{
		eliminarElemento(SELECT);
		try {
			selectByIndex(pageObject.getElement(SELECT), 1, 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_select_index_opcion_no_presente() throws InterruptedException{
		try {
			selectByIndex(pageObject.getElement(SELECT), 5, 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("Opcion fuera de rango", e.getMessage());
		}
	}
	
	@Test
	public void test_select_value() throws InterruptedException{
		selectByValue(pageObject.getElement(SELECT), "1");
		assertEquals(obtenerValorCombo(pageObject.getElement(SELECT)), "uno");
	}
	
	@Test
	public void test_select_value_elemento_no_visible() throws InterruptedException{
		ocultarElemento(SELECT);
		try {
			selectByValue(pageObject.getElement(SELECT), "1", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_select_value_elemento_no_presente() throws InterruptedException{
		eliminarElemento(SELECT);
		try {
			selectByValue(pageObject.getElement(SELECT), "1", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_select_value_opcion_no_presente() throws InterruptedException{
		try {
			selectByValue(pageObject.getElement(SELECT), "5", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("Opcion fuera de rango", e.getMessage());
		}
	}
	
	@Test
	public void test_select_visible_text() throws InterruptedException{
		selectByVisibleText(pageObject.getElement(SELECT), "uno");
		assertEquals(obtenerValorCombo(pageObject.getElement(SELECT)), "uno");
	}
	
	@Test
	public void test_select_visible_text_elemento_no_visible() throws InterruptedException{
		ocultarElemento(SELECT);
		try {
			selectByVisibleText(pageObject.getElement(SELECT), "uno", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_select_visible_text_elemento_no_presente() throws InterruptedException{
		eliminarElemento(SELECT);
		try {
			selectByVisibleText(pageObject.getElement(SELECT), "uno", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_select_visible_text_opcion_no_presente() throws InterruptedException{
		try {
			selectByVisibleText(pageObject.getElement(SELECT), "cinco", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("Opcion fuera de rango", e.getMessage());
		}
	}
	
	@Test
	public void test_select_texto_parcial() throws InterruptedException{
		seleccionarComboPorTextoParcial(pageObject.getElement(SELECT), "un");
		assertEquals(obtenerValorCombo(pageObject.getElement(SELECT)), "uno");
	}
	
	@Test
	public void test_select_texto_parcial_elemento_no_visible() throws InterruptedException{
		ocultarElemento(SELECT);
		try {
			seleccionarComboPorTextoParcial(pageObject.getElement(SELECT), "un", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("El elemento no esta visible", e.getMessage());
		}
	}
	
	@Test
	public void test_select_texto_parcial_elemento_no_presente() throws InterruptedException{
		eliminarElemento(SELECT);
		try {
			seleccionarComboPorTextoParcial(pageObject.getElement(SELECT), "un", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("No se encontro el elemento", e.getMessage());
		}
	}
	
	@Test
	public void test_select_texto_parcial_opcion_no_presente() throws InterruptedException{
		try {
			seleccionarComboPorTextoParcial(pageObject.getElement(SELECT), "cinco", 1);
			fail("se hizo select");
		} catch (Throwable e) {
			assertEquals("Opcion fuera de rango", e.getMessage());
		}
	}
}
