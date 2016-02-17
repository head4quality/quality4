package suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import quality4.Test;
import reporte.ReporteGeneral;

public class SuiteRunner {

	
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(Test.class);
		ReporteGeneral reporte = new ReporteGeneral(System.getProperty("user.dir")+"/reporte.json", "clienteDePruebaNum2");
		reporte.saveReport();
	}
}
