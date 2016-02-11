package suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import quality4.TestReporte;
import reporte.ReporteGeneral;

public class SuiteRunner {

	
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(TestReporte.class);
		ReporteGeneral reporte = new ReporteGeneral(System.getProperty("user.dir")+"/reporte.json", "clienteDePrueba");
		reporte.saveReport();
	}
}
