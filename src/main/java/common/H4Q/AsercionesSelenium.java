package common.H4Q;

import static common.H4Q.AccionesSelenium.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AsercionesSelenium {
	
	public static void verificarEstado(String elemento, String estado, int tiempo, WebDriver driver) throws InterruptedException {
		switch (estado) {
		case "habilitado":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(driver.findElement(By.cssSelector(elemento)).isEnabled());
				} catch (Exception | AssertionError e) {
					if (e instanceof AssertionError)
						fail("El elemento se encuentra Deshabilitado");
					if (i == tiempo * 10) {
						if (e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
					}
				}
			}
			break;
		case "deshabilitado":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(!driver.findElement(By.cssSelector(elemento)).isEnabled());
				} catch (Exception | AssertionError e) {
					if (e instanceof AssertionError)
						fail("El elemento se encuentra Habilitado");
					if (i == tiempo * 10)
						if (e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "seleccionado":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(driver.findElement(By.cssSelector(elemento)).isSelected());
				} catch (Exception | AssertionError e) {
					if (e instanceof AssertionError)
						fail("El elemento se encuentra Deseleccionado");
					if (i == tiempo * 10)
						if (e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "deseleccionado":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(!driver.findElement(By.cssSelector(elemento)).isSelected());
				} catch (Exception | AssertionError e) {
					if (e instanceof AssertionError)
						fail("El elemento se encuentra Seleccionado");
					if (i == tiempo * 10)
						if (e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "se muestra":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(driver.findElement(By.cssSelector(elemento)).isDisplayed());
				} catch (Exception | AssertionError e) {
					if (e instanceof AssertionError)
						fail("No se muestra el elemento: ");
					if (i == tiempo * 10)
						if (e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "no se muestra":
			try {
				Thread.sleep(100);
				assertTrue(!driver.findElement(By.cssSelector(elemento)).isDisplayed());
			} catch (Exception | AssertionError e) {
				if (e instanceof AssertionError)
					fail("Se muestra el elemento");
				else if (!(e instanceof NoSuchElementException))
					throw e;
			}
			break;
		default:
			fail("El estado ingresado es incorrecto");
			break;
		}
	}

	public static void verificarEstado(String elemento, String estado, WebDriver driver) throws InterruptedException {
		verificarEstado(elemento, estado, 5, driver);
	}

	public static void compararComboConCombo(String combo1, String combo2, WebDriver driver) throws InterruptedException {
		String valorComboUno = obtenerValorCombo(combo1, driver);
		String valorComboDos = obtenerValorCombo(combo2, driver);
		try {
			assertTrue(valorComboUno.equals(valorComboDos));
		} catch (AssertionError e) {
			fail("No coincide la opcion seleccionada en los combos: \n" + valorComboUno + " - " + valorComboDos);
		}
	}

	public static void compararComboConEtiqueta(String combo, String etiqueta, WebDriver driver) throws InterruptedException {
		String valorCombo = obtenerValorCombo(combo, driver);
		String valorEtiqueta = obtenerValorEtiqueta(etiqueta, driver);
		try {
			assertTrue(valorCombo.equals(valorEtiqueta));
		} catch (AssertionError e) {
			fail("No coincide la opcion seleccionada en el combo con el texto de la etiqueta ");
		}
	}

	public static void compararEtiquetaConEtiqueta(String etiqueta1, String etiqueta2, WebDriver driver)
			throws InterruptedException {
		String valorEtiqueta1 = obtenerValorEtiqueta(etiqueta1, driver);
		String valorEtiqueta2 = obtenerValorEtiqueta(etiqueta2, driver);
		try {
			assertTrue(valorEtiqueta1.equals(valorEtiqueta2));
		} catch (AssertionError e) {
			fail("Los textos de las etiquetas no coinciden");
		}
	}
	
	public static void verificarOpcionDeCombo(String combo, String opcion,WebDriver driver) throws InterruptedException{
		try{
			assertTrue(obtenerValorEtiqueta(combo, driver).contains(opcion));
		}catch(AssertionError e){
			fail("No existe la opcion en el combo seleccionado");
		}
	}
	
	public static void verificarTextoEnElemento(String elemento, String texto, int tiempo, WebDriver driver) throws Exception{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				assertTrue(driver.findElement(By.cssSelector(elemento)).getText().contains(texto));
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Click: ");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void verificarTextoEnElemento(String elemento, String texto, WebDriver driver) throws Exception{
		verificarTextoEnElemento(elemento, texto, 5, driver);
	}

}
