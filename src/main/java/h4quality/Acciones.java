package h4quality;
import static org.junit.Assert.fail;

import java.util.List;
import static h4quality.Teclas.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;
public class Acciones{
	
	public static void click(WebElement elemento, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				elemento.click();
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
	
	public static void click(WebElement elemento) throws InterruptedException{
		click(elemento, 10);
	}
	
	public static void clear(WebElement elemento, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				elemento.clear();
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Clear: ");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void clear(WebElement elemento) throws InterruptedException{
		clear(elemento, 10);
	}
	
	public static void sendKeys(WebElement elemento, String texto, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				elemento.sendKeys(texto);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el SendKeys: ");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void sendKeys(WebElement elemento, String texto) throws InterruptedException{
		sendKeys(elemento, texto, 10);
	}
	
	public static void selectByIndex(WebElement elemento, int indice, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(elemento).selectByIndex(indice);
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
	
	public static void selectByIndex(WebElement elemento, int indice) throws InterruptedException{
		selectByIndex(elemento, indice, 10);
	}
	
	public static void selectByValue(WebElement elemento, String valor, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(elemento).selectByValue(valor);
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
	
	public static void selectByValue(WebElement elemento, String valor) throws InterruptedException{
		selectByValue(elemento, valor, 10);
	}
	
	public static void selectByVisibleText(WebElement combo, String texto, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				new Select(combo).selectByVisibleText(texto);
				if (obtenerValorCombo(combo).equals(texto))
					break;
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo con texto "+ texto);
					else
						throw e;
				}
			}
		}	
	}
	
	public static void selectByVisibleText(WebElement elemento, String texto) throws InterruptedException{
		selectByVisibleText(elemento, texto, 1);
	}
	
	public static String obtenerValorCombo(WebElement combo, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{ 
				Thread.sleep(100);
				return new Select(combo).getFirstSelectedOption().getText();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento ");
					else
						throw e;
				}
			}
		}
		return null;
	}
	
	public static String obtenerValorCombo(WebElement combo) throws InterruptedException{
		return(obtenerValorCombo(combo, 1));
	}
	
	public static int cantidadDeOpcionesDeCombo(WebElement combo, int tiempo) throws InterruptedException{
		Thread.sleep(1000);
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				return new Select(combo).getOptions().size();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento ");
					else
						throw e;
				}
			}
		}
		return 0;
	}
	
	public static int cantidadDeOpcionesDeCombo(WebElement combo) throws InterruptedException{
		return(cantidadDeOpcionesDeCombo(combo, 1));
	}
	
	public static void seleccionarComboPorTextoParcial(WebElement combo, String texto, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				if(combo.isEnabled()){
					List<WebElement> lista = new Select(combo).getOptions();
					for(int j=0; j<=(lista.size()); j++){
						if(lista.get(j).getText().contains(texto))
							new Select(combo).selectByIndex(j);
					}
				}
				break;
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro la opcion del combo con texto "+ texto);
					else
						throw e;
				}
			}
		}	
	}
	
	public static void seleccionarComboPorTextoParcial(WebElement combo, String texto) throws InterruptedException{
		seleccionarComboPorTextoParcial(combo, texto, 10);
	}
	
	public static String obtenerValorEtiqueta(WebElement etiqueta, int tiempo) throws InterruptedException{
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				return etiqueta.getText();
			}
			catch(Exception e){
				if (tiempo*10==i){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento ");
					else
						throw e;
				}
			}
		}
		return null;
	}
	
	public static String obtenerValorEtiqueta(WebElement etiqueta) throws InterruptedException{
		return(obtenerValorEtiqueta(etiqueta, 1));
	}
	
	public static String obtenerValorDeCampo(WebElement campo, WebDriver driver){
		return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].value;", campo);
	}
	
	
	////////////-----------------Acciones Sikuli-----------------////////////
	
	public static void click(String imagen, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.click(imagen);
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
	
	public static void click(String imagen) throws Exception{
		click(imagen, 10);
	}
	
	public static void waitt(String imagen, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.wait(imagen);
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
	
	public static void waitt(String imagen) throws Exception{
		waitt(imagen, 10);
	}
	
	public static void dobleClick(String imagen, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.doubleClick(imagen);
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
	
	public static void dobleClick(String imagen) throws Exception{
		dobleClick(imagen, 10);
	}
	
	public static void seleccionarCombo(String combo,String opcion, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.click(combo);
				s.click(opcion);
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
	
	public static void seleccionarCombo(String combo, String opcion) throws Exception{
		seleccionarCombo(combo, opcion, 10);
	}
	
	public static void sendKeys(String imagen, String texto, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(null, texto, 0);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el SendKeys: ");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void sendKeys(String imagen, String texto) throws Exception{
		sendKeys(imagen, texto, 10);
	}
	
	public static void move(String imagen, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.mouseMove(imagen);
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
	
	public static void move(String imagen) throws Exception{
		move(imagen, 10);
	}
	
	public static void selectByIndex(String imagen, int indice, int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.click(imagen);
				for (int j=1; j<=indice; j++){
					Abajo();
				}
				Enter();
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
	
	public static void selectByIndex(String imagen, int indice) throws Exception{
		selectByIndex(imagen, indice, 10);
	}
	
	public static void clickDerecho(String imagen) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=100; i++){
			try{
				Thread.sleep(100);
				s.rightClick(imagen);
				break;
			}
			catch(Exception e){
				if(i==100){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Click: ");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void clickDerecho(String imagen, int opcion) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=100; i++){
			try{
				Thread.sleep(100);
				s.rightClick(imagen);
				for (int j=1; j<=opcion; j++){
					Abajo();
				}
				Enter();
				break;
			}
			catch(Exception e){
				if(i==100){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Click: ");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void scroll(String imagen,int direccion, int cantidad) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=100; i++){
			try{
				Thread.sleep(100);
				s.wheel(imagen, direccion, cantidad);
				break;
			}
			catch(Exception e){
				if(i==100){
					if (e instanceof NoSuchElementException)
						fail("No se encontro el elemento para realizar el Click: ");
					else 
						throw e;
				}
			}
		}
	}
	
}