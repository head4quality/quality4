package h4grid;

import static org.junit.Assert.fail;

import javax.jws.WebService;

import org.openqa.selenium.firefox.FirefoxDriver;

import common.H4Q.AccionesSelenium;
import common.H4Q.AccionesSikuli;
import common.H4Q.TablaDeElementos;

@WebService(endpointInterface="h4grid.GridServer")
public class GridServerImplementation implements GridServer{

	private FirefoxDriver driver;
	
	TablaDeElementos page;

	@Override
	public void abrirDriver() {
		System.out.println("Abriendo Driver");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
	}

	@Override
	public void click(String elemento) throws Exception {
		if(page.obtenerSelector(elemento).equals("null"))
			fail("El elemento ingresado no esta definido en el archivo Properties. ");
		if(page.es_imagen(page.obtenerSelector(elemento)))
			AccionesSikuli.click(page.obtenerSelector(elemento));
		else
			AccionesSelenium.click(page.obtenerSelector(elemento), driver);
	}
	
	

}
