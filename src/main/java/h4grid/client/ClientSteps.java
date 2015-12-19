package h4grid.client;

import static org.junit.Assert.fail;
import h4grid.GridServer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.openqa.selenium.firefox.FirefoxDriver;

import common.H4Q.TablaDeElementos;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ClientSteps {
	
	URL url;
	QName qname;
	Service service;
	GridServer gridServer;
	TablaDeElementos page;
	
	@Before
	public void before() throws MalformedURLException{
		url = new URL("http://192.168.0.5:5335/h4grid?wsdl");
		qname = new QName("http://h4grid/",
				"GridServerImplementationService");
		service = Service.create(url, qname);
		gridServer = service.getPort(GridServer.class);
	}

	@Given("^abrir driver$")
	public void abrir_driver(){
		gridServer.abrirDriver();
	}
	
	@Given("^abrir driver \"(.*?)\"$")
	public void abrir_driver(String url){
		gridServer.abrirDriver(url);
	}
	
	@When("^click en \"(.*?)\"$")
	public void click_en(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		gridServer.click(page.obtenerSelector(elemento));
	}
	
	@When("^limpiar campo \"(.*?)\"$")
	public void limpiar_campo(String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		gridServer.clear(page.obtenerSelector(elemento));
	}
	
	@When("^escribir texto \"(.*?)\" en campo \"(.*?)\"$")
	public void esribir_texto_en_campo(String texto, String elemento)throws Throwable {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			gridServer.sendKeys(page.obtenerSelector(elemento), texto);
	}
}
