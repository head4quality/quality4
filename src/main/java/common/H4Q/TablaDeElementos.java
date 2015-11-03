package common.H4Q;

import java.io.FileInputStream;
import java.util.Properties;

public class TablaDeElementos {

	Properties elementos = new Properties();
	
	public TablaDeElementos(String archivoProperties) {
		try {
			elementos
			 .load(new FileInputStream("src/test/resources/properties/"+archivoProperties));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public String obtenerSelector(String nombreElemento){
		return elementos.getProperty(nombreElemento);
	}

	public boolean es_imagen(String elemento){
		if (elementos.getProperty(elemento).contains("/"))
			return true;
		return false;
	}
}

