package common.H4Q;

import java.io.IOException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.NoSuchElementException;
import org.sikuli.script.Finder;
import org.sikuli.script.Screen;

public class AsercionesSikuli {

	public static boolean existeElemento(String imagen) throws InterruptedException, IOException{
		Screen s = new Screen();
		Finder f = new Finder(s.capture());
		f.findAll(imagen);
		if(f.hasNext()){
			f.destroy();
			return true;}
		f.destroy();
		return false;	
	}
	
	public static boolean existeElemento(String imagenABuscar, String imagenGral) throws InterruptedException, IOException{
		Finder f = new Finder(imagenGral);
		f.findAll(imagenABuscar);
		if(f.hasNext()){
			f.destroy();
			return true;}
		f.destroy();
		return false;		
	}
	
	public static void verificarEstado(String imagen, String estado, int tiempo) throws Throwable{
		switch (estado) {
		case "se muestra":
			for(int i=0; i<=tiempo*10; i++){
				try{
					Thread.sleep(100);
					assertTrue(existeElemento(imagen));
				}catch(Exception | AssertionError e){
					if (e instanceof AssertionError)
						fail("No se muestra el elemento");
					if(i==tiempo*10)
						if(e instanceof NoSuchElementException)
							fail("No se encontro el elemento");
						else
							throw e;
				}
			}
			break;
		case "no se muestra":
			try{
				Thread.sleep(1000);
				assertTrue(!existeElemento(imagen));
				}catch(Exception | AssertionError e){
					if (e instanceof AssertionError)
						fail("Se muestra el elemento");
					else if (!(e instanceof NoSuchElementException))
						throw e;
				}
			break;
		default:
			fail("El estado ingresado es incorrecto");
			break;
		}
	}
	
	public static void verificarEstado(String imagen, String estado) throws Throwable{
		verificarEstado(imagen, estado, 5);
	}
}

