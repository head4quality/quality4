package h4grid.client;

import h4grid.GridServer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class ClientSteps {
	
	URL url;
	QName qname;
	Service service;
	GridServer gridServer;
	
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
}
