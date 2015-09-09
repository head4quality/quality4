package common.selenium;

import static common.selenium.Acciones.informacionDeElemento;
import static common.selenium.Acciones.obtenerValorCombo;
import static common.selenium.Acciones.obtenerValorEtiqueta;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Finder;
import org.sikuli.script.Screen;

public class Aserciones {
	private WebDriver driver;
	public Aserciones(WebDriver driver) {
		this.driver= driver;
	}

	public static void verificarEstado(WebElement elemento, String estado, int tiempo) throws InterruptedException {
		switch (estado) {
		case "habilitado":
			for (int i = 0; i <= tiempo * 10; i++) {
				try {
					Thread.sleep(100);
					assertTrue(elemento.isEnabled());
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
					assertTrue(!elemento.isEnabled());
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
					assertTrue(elemento.isSelected());
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
					assertTrue(!elemento.isSelected());
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
					assertTrue(elemento.isDisplayed());
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
				assertTrue(!elemento.isDisplayed());
				Thread.sleep(1000);
				assertTrue(!elemento.isDisplayed());
			} catch (Exception | AssertionError e) {
				if (e instanceof AssertionError)
					fail("Se muestra el elemento: " + informacionDeElemento(elemento));
				else if (!(e instanceof NoSuchElementException))
					throw e;
			}
			break;
		default:
			fail("El estado ingresado es incorrecto");
			break;
		}
	}

	public static void verificarEstado(WebElement elemento, String estado) throws InterruptedException {
		verificarEstado(elemento, estado, 1);
	}

	public static void compararComboConCombo(WebElement combo1, WebElement combo2) throws InterruptedException {
		String valorComboUno = obtenerValorCombo(combo1);
		String valorComboDos = obtenerValorCombo(combo2);
		try {
			assertTrue(valorComboUno.equals(valorComboDos));
		} catch (AssertionError e) {
			fail("No coincide la opcion seleccionada en los combos: \n" + valorComboUno + " - " + valorComboDos);
		}
	}

	public static void compararComboConEtiqueta(WebElement combo, WebElement etiqueta) throws InterruptedException {
		String valorCombo = obtenerValorCombo(combo);
		String valorEtiqueta = obtenerValorEtiqueta(etiqueta);
		try {
			assertTrue(valorCombo.equals(valorEtiqueta));
		} catch (AssertionError e) {
			fail("No coincide la opcion seleccionada en el combo - " + valorCombo + " -\ncon el texto de la etiqueta - "
					+ valorEtiqueta + " -");
		}
	}

	public static void compararEtiquetaConEtiqueta(WebElement etiqueta1, WebElement etiqueta2)
			throws InterruptedException {
		String valorEtiqueta1 = obtenerValorEtiqueta(etiqueta1);
		String valorEtiqueta2 = obtenerValorEtiqueta(etiqueta2);
		try {
			assertTrue(valorEtiqueta1.equals(valorEtiqueta2));
		} catch (AssertionError e) {
			fail("Los textos de las etiquetas no coinciden: \n" + valorEtiqueta1 + " - " + valorEtiqueta2);
		}
	}
	
	///////////////////////---------------- Aserciones Sikuli ----------------///////////////////////
	
	public static boolean existeElemento(String imagen) throws InterruptedException, IOException{
		Screen s = new Screen();
		Finder f = new Finder(s.capture());
		f.findAll(imagen);
		if(f.hasNext()){
			f.destroy();
			return true;}
		f.destroy();
		return false;	
	}
	
	public static boolean existeElemento(String imagenGral, String imagenABuscar) throws InterruptedException, IOException{
		Finder f = new Finder(imagenGral);
		f.findAll(imagenABuscar);
		if(f.hasNext()){
			f.destroy();
			return true;}
		f.destroy();
		return false;		
	}
	
	public static void verificarEstado(String imagen, String estado, int tiempo) throws Throwable{
		switch (estado) {
		case "se muestra":
			for(int i=0; i<=tiempo*10; i++){
				try{
					Thread.sleep(100);
					assertTrue(existeElemento(imagen));
				}catch(Exception | AssertionError e){
					if (e instanceof AssertionError)
						fail("No se muestra el elemento");
					if(i==tiempo*10)
						if(e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "no se muestra":
			try{
				Thread.sleep(1000);
				assertTrue(!existeElemento(imagen));
				}catch(Exception | AssertionError e){
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
	
	public static void verificarEstado(String imagen, String estado) throws Throwable{
		verificarEstado(imagen, estado, 10);
	}
}