package h4grid;

import javax.xml.ws.Endpoint;


public class GridServerPublisher {

	public static void main(String[] args) {
		GridServerImplementation server = new GridServerImplementation();
		Endpoint.publish("http://127.0.0.1:5335/h4grid", server);
	}

}
