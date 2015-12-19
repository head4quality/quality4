package h4grid;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService

@SOAPBinding(style = Style.RPC)

public interface GridServer {

	@WebMethod void abrirDriver();
	
	@WebMethod void click(String elemento) throws Exception;

	@WebMethod void clear(String obtenerSelector) throws Exception;

	@WebMethod void sendKeys(String obtenerSelector, String texto) throws Exception;

	@WebMethod void abrirDriver(String url);
}
