package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Prueba000 extends PageObjectSeleniumSikuli{

	
	@FindBy(id="search-term") public WebElement buscadorJuegos;
	
	@FindBy(id="Email") public WebElement ingresarMail;
	@FindBy(id="Passwd") public WebElement ingresarContrasenia;
	@FindBy(id="next") public WebElement botonNext;
	@FindBy(id="signIn") public WebElement botonIngresar;
	@FindBy(css=".T-I-KE") public WebElement botonRedactar;
	@FindBy(id=":a4") public WebElement campoPara;
	@FindBy(id=":9p") public WebElement campoAsunto;
	@FindBy(id=":ar") public WebElement campoMensaje;
	@FindBy(id=":9f") public WebElement botonEnviar;
	
	@FindBy(css="#search-form > div > input.icon--search") public WebElement botonLupa;
	
	public Prueba000(WebDriver driver) {
		super(driver);
		mapaDeElementosSelenium=new HashMap<String, WebElement>();
		mapaDeElementosSikuli=new HashMap<String, String>();
		
		mapaDeElementosSikuli.put("buscadorJuegos",  "/home/andres/Escritorio/imagenes/buscadorJuegos.png");
		mapaDeElementosSikuli.put("botonLupa",  "/home/andres/Escritorio/imagenes/botonLupa.png");
		mapaDeElementosSikuli.put("fondoCeleste",  "/home/andres/Escritorio/imagenes/fondoCeleste.png");
		mapaDeElementosSikuli.put("navChrome", "/home/andres/Escritorio/imagenes/chrome.png");
		mapaDeElementosSikuli.put("buscadorDeChrome", "/home/andres/Escritorio/imagenes/buscador.png" );
		mapaDeElementosSikuli.put("juegoSonic", "/home/andres/Escritorio/imagenes/juegoSonic.png");
		mapaDeElementosSikuli.put("botonStart","/home/andres/Escritorio/imagenes/botonStart.png");
		mapaDeElementosSikuli.put("botonStarDos","/home/andres/Escritorio/imagenes/botonStarDos.png");
		mapaDeElementosSikuli.put("botonAnillo","/home/andres/Escritorio/imagenes/botonAnillo.png");
		mapaDeElementosSikuli.put("mario","/home/andres/Escritorio/imagenes/mario.png");
		mapaDeElementosSikuli.put("buscadorDeFirefox","/home/andres/Escritorio/imagenes/buscadorDeFirefox.png");
		mapaDeElementosSikuli.put("botonCuenta","/home/andres/Escritorio/imagenes/botonCuenta.png");
		mapaDeElementosSikuli.put("botonIngresarS","/home/andres/Escritorio/imagenes/botonIngresarS.png");
		mapaDeElementosSikuli.put("mailRecibido","/home/andres/Escritorio/imagenes/mailRecibido.png");
		mapaDeElementosSikuli.put("popoutMensajeEnviado","/home/andres/Escritorio/imagenes/popoutMensajeEnviado.png");
		 
		mapaDeElementosSelenium.put("ingresarMail", ingresarMail);
		mapaDeElementosSelenium.put("ingresarContraseña",ingresarContrasenia );
		mapaDeElementosSelenium.put("botonIngresar", botonIngresar);
		mapaDeElementosSelenium.put("botonRedactar", botonRedactar);
		mapaDeElementosSikuli.put("campoPara", "/home/andres/Escritorio/imagenes/campoPara.png");
		mapaDeElementosSikuli.put("campoAsunto", "/home/andres/Escritorio/imagenes/campoAsunto.png");
		mapaDeElementosSikuli.put("campoMensaje", "/home/andres/Escritorio/imagenes/campoMensaje.png");
		mapaDeElementosSikuli.put("botonEnviar", "/home/andres/Escritorio/imagenes/botonEnviar.png");
		mapaDeElementosSelenium.put("botonNext", botonNext);
	}
	
	/**
	 * Retorna un boolean si el elemento existe 
	 * @param clave a buscar en el mapa de elementos de SELENIUM
	 * @return true si existe el elemento, false si no
	 */
	public boolean existeElementoSelenium(String clave){
		return this.mapaDeElementosSelenium.containsKey(clave);
	}
	
	/**
	 * Retorna un boolean si el elemento existe 
	 * @param clave a buscar en el mapa de elementos de SIKULI
	 * @return true si existe el elemento, false si no
	 */
	public boolean existeElementoSikuli(String clave){
		return this.mapaDeElementosSikuli.containsKey(clave);
	}
	
	/**
	 * Retorna el WebElement coincidente
	 * @param clave a buscar en el mapa de elementos de SELENIUM
	 * @return elemento coincidente
	 */
	public WebElement obtenerElementoSelenium(String clave){
		if (existeElementoSelenium(clave))
				return this.mapaDeElementosSelenium.get(clave);
		return null;
	}
	
	/**
	 * Retorna el ruta a la imagen coincidente
	 * @param clave a buscar en el mapa de elementos de SIKULI
	 * @return ruta a la imagen del elemento
	 */
	public String obtenerElementoSikuli(String clave){
		if (existeElementoSikuli(clave))
			return this.mapaDeElementosSikuli.get(clave);
		else
			return null;
	}
}
	
	
	
	
	
	



