package reporte;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;



public class ReporteGeneral implements Runnable{
	
	private String reportPath;
	private String client;
	long time = 0;
	
	public ReporteGeneral(String reportPath, String client){
		this.reportPath=reportPath;
		this.client = client;
		File file = new File(reportPath);
		if(file.exists())
			time = file.lastModified();
	}

	public void saveReport(){
		try {
			sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		File file = new File(reportPath);
		
		while(time==file.lastModified())
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Se envia: \n"+new String(readFile()));
		
	}
	
	private void sendPost() throws Exception {

		String url = "http://192.168.0.7:3000/report/saveReport/"+client;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		String body=new String(readFile());
		body="{report:"+body+"}";
		con.getOutputStream().write(body.getBytes());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}

	byte[] readFile() {
        File f = new File(reportPath);
        try {
            return Files.readAllBytes(f.toPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
}
}
