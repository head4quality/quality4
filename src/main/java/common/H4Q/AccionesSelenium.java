package common.H4Q;

import java.util.List;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import common.H4Q.AsercionesSelenium;


public class AccionesSelenium {
	
	public static void click(String elemento, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				driver.findElement(By.cssSelector(elemento)).click();
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Click");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void click(String elemento, WebDriver driver) throws InterruptedException{
		click(elemento, 5, driver);
	}
	
	public static void clear(String elemento, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				driver.findElement(By.cssSelector(elemento)).clear();
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Clear");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void clear(String elemento, WebDriver driver) throws InterruptedException{
		clear(elemento, 5, driver);
	}
	
	public static void sendKeys(String elemento, String texto, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				driver.findElement(By.cssSelector(elemento)).sendKeys(texto);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para ingresar el texto");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void sendKeys(String elemento, String texto, WebDriver driver) throws InterruptedException{
		sendKeys(elemento, texto, 5, driver);
	}
	
	public static void selectByIndex(String elemento, int indice, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(driver.findElement(By.cssSelector(elemento))).selectByIndex(indice);
				break;
			}catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo con indice "+ indice);
					else
						throw e;
				}
			}
		}		
	}
	
	public static void selectByIndex(String elemento, int indice, WebDriver driver) throws InterruptedException{
		selectByIndex(elemento, indice, 5, driver);
	}
	
	public static void selectByValue(String elemento, String valor, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(driver.findElement(By.cssSelector(elemento))).selectByValue(valor);
				break;
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo con value "+ valor);
					else
						throw e;
				}
			}
		}		
	}
	
	public static void selectByValue(String elemento, String valor, WebDriver driver) throws InterruptedException{
		selectByValue(elemento, valor, 5, driver);
	}
	
	public static String obtenerValorCombo(String combo, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{ 
				Thread.sleep(100);
				return new Select(driver.findElement(By.cssSelector(combo))).getFirstSelectedOption().getText();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el combo.");
					else
						throw e;
				}
			}
		}
		return null;
	}
	
	public static String obtenerValorCombo(String combo, WebDriver driver) throws InterruptedException{
		return(obtenerValorCombo(combo, 5, driver));
	}
	
	public static void selectByVisibleText(String combo, String texto, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(driver.findElement(By.cssSelector(combo))).selectByVisibleText(texto);
				if (obtenerValorCombo(combo, driver).equals(texto))
					break;
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo "+ texto);
					else
						throw e;
				}
			}
		}	
	}
	
	public static void selectByVisibleText(String elemento, String texto, WebDriver driver) throws InterruptedException{
		selectByVisibleText(elemento, texto, 5, driver);
	}
	
	public static int cantidadDeOpcionesDeCombo(String combo, int tiempo, WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				return new Select(driver.findElement(By.cssSelector(combo))).getOptions().size();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el combo");
					else
						throw e;
				}
			}
		}
		return 0;
	}
	
	public static int cantidadDeOpcionesDeCombo(String combo, WebDriver driver) throws InterruptedException{
		return(cantidadDeOpcionesDeCombo(combo, 5, driver));
	}
	
	public static void seleccionarComboPorTextoParcial(String combo, String texto, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				if(driver.findElement(By.cssSelector(combo)).isEnabled()){
					List<WebElement> lista = new Select(driver.findElement(By.cssSelector(combo))).getOptions();
					for(int j=0; j<=(lista.size()); j++){
						if(lista.get(j).getText().contains(texto))
							new Select(driver.findElement(By.cssSelector(combo))).selectByIndex(j);
					}
				}
				break;
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo que contenga el texto "+ texto);
					else
						throw e;
				}
			}
		}	
	}
	
	public static void seleccionarComboPorTextoParcial(String combo, String texto, WebDriver driver) throws InterruptedException{
		seleccionarComboPorTextoParcial(combo, texto, 5, driver);
	}
	
	public static String obtenerValorEtiqueta(String etiqueta, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				return driver.findElement(By.cssSelector(etiqueta)).getText();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento");
					else
						throw e;
				}
			}
		}
		return null;
	}
	
	public static String obtenerValorEtiqueta(String etiqueta, WebDriver driver) throws InterruptedException{
		return(obtenerValorEtiqueta(etiqueta, 5, driver));
	}
	
	public static String obtenerValorDeCampo(String campo, WebDriver driver) throws InterruptedException{
		AsercionesSelenium.verificarEstado(campo, "se muestra", driver);
		return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].value;", campo);
		
	}
	
	public static void sendKeyInhabilitado(String elemento, String texto, int tiempo, WebDriver driver) throws Exception{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("$("+elemento+").removeAttr('disabled')");
				js.executeScript("$("+elemento+").removeAttr('readonly')");
				driver.findElement(By.cssSelector(elemento)).clear();
				driver.findElement(By.cssSelector(elemento)).sendKeys(texto);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para ingresar el texto");
					else 
						throw e;
				}
			}
		}
	}

	public static void moverPuntero(String elemento, int tiempo, WebDriver driver) throws Exception{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Actions(driver).moveToElement(driver.findElement(By.cssSelector(elemento))).build().perform();
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para mover el puntero");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void dobleClick(String elemento, int tiempo, WebDriver driver) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Actions(driver).moveToElement(driver.findElement(By.cssSelector(elemento))).doubleClick().build().perform();
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Doble Click");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void dobleClick(String elemento, WebDriver driver) throws InterruptedException{
		dobleClick(elemento, 5, driver);
	}
}
