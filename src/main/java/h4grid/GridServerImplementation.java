package h4grid;

import static org.junit.Assert.fail;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.openqa.selenium.firefox.FirefoxDriver;

import common.H4Q.AccionesSelenium;
import common.H4Q.AccionesSikuli;
import common.H4Q.TablaDeElementos;

@WebService(endpointInterface="h4grid.GridServer")
public class GridServerImplementation implements GridServer{

	private FirefoxDriver driver;
	

	private boolean es_imagen(String elemento){
		if (elemento.contains("/"))
			return true;
		return false;
	}
	
	private void verifyDriver(){
		if (driver==null)
			fail("You must open the WebDriver first");
	}

	@Override
	public void abrirDriver(String url) {
		System.out.println("Abriendo Driver");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Override
	public void click(String elemento) throws Exception {
		if(es_imagen(elemento))
			AccionesSikuli.click(elemento);
		else
			AccionesSelenium.click(elemento, driver);
	}

	@Override
	public void clear(String elemento) throws Exception {
		verifyDriver();
		AccionesSelenium.clear(elemento, driver);
	}

	@Override
	public void sendKeys(String element, String text) throws Exception {
		verifyDriver();
		if(es_imagen(element))
			AccionesSikuli.sendKeys(element, text);
		else
			AccionesSelenium.sendKeys(element, text, driver);	
	}

	@Override
	public void abrirDriver() {
		System.out.println("Abriendo Driver");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
	}

}
