package h4grid;

import javax.jws.WebService;

import org.openqa.selenium.firefox.FirefoxDriver;

@WebService(endpointInterface="h4grid.GridServer")
public class GridServerImplementation implements GridServer{

	private FirefoxDriver driver;

	@Override
	public void abrirDriver() {
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
	}
	
	

}
