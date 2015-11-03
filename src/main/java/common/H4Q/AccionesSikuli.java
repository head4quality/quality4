package common.H4Q;

import static common.H4Q.Teclas.Abajo;
import static common.H4Q.Teclas.Enter;
import static org.junit.Assert.fail;
import org.openqa.selenium.NoSuchElementException;
import org.sikuli.script.Screen;



public class AccionesSikuli {

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
						fail("No se encontro la imagen para realizar el Click");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void click(String imagen) throws Exception{
		click(imagen, 5);
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
						fail("No se encontro la imagen que desea esperar");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void waitt(String imagen) throws Exception{
		waitt(imagen, 5);
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
						fail("No se encontro la imagen para realizar el Doble Click");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void dobleClick(String imagen) throws Exception{
		dobleClick(imagen, 5);
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
						fail("No se encontro la imagen (combo) a seleccionar ó su opción");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void seleccionarCombo(String combo, String opcion) throws Exception{
		seleccionarCombo(combo, opcion, 5);
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
						fail("No se encontro la imagen para ingresar el texto");
					else 
						throw e;
				}
			}
		}		
	}
	
	public static void sendKeys(String imagen, String texto) throws Exception{
		sendKeys(imagen, texto, 5);
	}
	
	public static void moverPuntero(String imagen, int tiempo) throws Exception{
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
						fail("No se encontro la imagen para Mover el Puntero");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void moverPuntero(String imagen) throws Exception{
		moverPuntero(imagen, 5);
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
						fail("No se encontro la imagen (combo) a seleccionar ó su opción");
					else
						throw e;
				}
			}
		}		
	}
	
	public static void selectByIndex(String imagen, int indice) throws Exception{
		selectByIndex(imagen, indice, 5);
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
						fail("No se encontro la imagen para realizar el Click Derecho");
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
						fail("No se encontro la imagen para realizar el Click Derecho");
					else 
						throw e;
				}
			}
		}
	}
	
	
	
}
