package h4quality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RunDriver{
	
	private static WebDriver driver;

	/**Retorna el driver estatico que se utiliza hasta el final de la prueba
	 * lo instancia si es null
	 * 
	 * @return driver presente en la maquina local o ejecutado con grid
	 */
	public static WebDriver getDriver(){
		if (driver==null){
			//TODO Funcion que instancie el driver local o remoto
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		return driver;
	}
}

//
//import java.io.File;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//public class RunDriver {
//	
//	private static final String REMOTE_WEB_DRIVER_URL = "remoteWebDriver.url";
//	private static final String URL = ".url";
//	//private static final String EVIDENCIA_FOLDER = "evidencias.folder";
//	//private static final String DOWNLOAD_FOLDER = "download.folder";
//	private static final String PROYECT_NAME = "nombreProyecto";
//	private static final String TEST_PLAN = "testPlan";
//	private static final String CORRIDA = "corrida";
//	private static final String ENABLED_EVIDENCE = "evidencia";
//	private static final String HUB_CONFIGURATION = "hub";
//	private static final String HUB_GRID1YML = "grid1Yml";
//	private static final String ENABLED_TESTLINK = "isTestLinkEnabled";
//	
//	
//	public static final String YES = "yes";
//	public static final String SI = "si";
//	public static final String TRUE = "true";
//	
//	private static RunDriver instance;
//	
//	private String browserName;
//	private String grid;
//	private String channel;
//	private String informacionNavegador;
//	
//	
//	private  Map<String, String> hashDatos;
//	private static  Map<String, String> mapCanal;
//	
//	// ruta donde se guardaran las imagenes y logs
//	private static String imgRuta = "";
//	private static String logsRuta = "";
//	public static int timeOut = 60;
//	private static String evidenciasFolder = "";
//	private static String nombreProyecto = "";
//	private static String testPlan = "";
//	private static String corrida = "";
//	private static String ambiente = "";
//	private String versionselenium="";
//	
//	public enum browser {
//		IE, firefox, chrome
//	};
//
//	
//	private EnvironmentSetting() {
//		ExcelUtils.leerPropiedadesLog4j();
//		hashDatos=ExcelUtils.getInstance().leerPropiedadesGenerales();
//		setDefaultValues();
//		setSystemValues();	
//	}
//
//	
//	public static EnvironmentSetting getInstance() {
//		if(instance == null){
//			instance = new EnvironmentSetting();
//		}
//		return instance;
//	}
//
//	/**
//	 * lee los valores de la planilla
//	 */
//	private void setDefaultValues() {
//		setBrowserName(hashDatos.get("browser"));
//		setGrid(hashDatos.get("grid"));
//		setChannel(hashDatos.get("canal"));
//		setAmbiente(hashDatos.get("ambiente"));
//	}
//	
//	/**
//	 * lee los valores del pom, si existen
//	 *  pisa los de la planilla
//	 */
//	private  void setSystemValues() {
//		setBrowserName(System.getProperty("browser"));
//		setGrid(System.getProperty("grid"));
//		setChannel(System.getProperty("canal"));
//		setAmbiente(System.getProperty("ambiente"));
//		setVersionselenium(System.getProperty("selenium"));
//		
//	  
//	}
//	
//
//	public String getAmbiente() {
//		return ambiente;
//	}
//
//
//	public void setAmbiente(String ambiente) {
//		EnvironmentSetting.ambiente = ambiente;
//	}
//
//
//	public String getBrowserName() {
//		return browserName;
//	}
//
//	public void setBrowserName(String browserName) {
//		if(browserName!=null && !browserName.equals("")){
//			this.browserName = browserName;
//		}
//	}
//
//	public boolean getGrid() {
//		if ("true".equals(grid))
//			return true;
//		return false;
//	}
//
//	public void setGrid(String grid) {
//		if(grid!=null && !grid.equals("")){
//			this.grid = grid;
//		}
//	}
//	
//	public String getChannel() {
//		return channel;
//	}
//
//	public void setChannel(String channel) {
//		if(channel!=null && !channel.equals("")){
//			this.channel = channel;
//		}
//	}	
//	
//	public Map<String, String> getHashDatos() {
//		mapCanal=ExcelUtils.getInstance().leerPropiedadesCanal(getChannel());
//		hashDatos.putAll(mapCanal);
//		return hashDatos;
//	}
//
//	public void setHashDatos(HashMap<String, String> hashDatos) {
//		this.hashDatos = hashDatos;
//	}
//	
//	public String getRemoteWebDriverURL(){
//		return hashDatos.get(REMOTE_WEB_DRIVER_URL);
//	}
//	
//	public String getURL(){
//		if(System.getProperty("URLmaven")!=null && !System.getProperty("URLmaven").equals("")){
//			return System.getProperty("URLmaven");
//		}
//		return hashDatos.get(channel + URL);
//	}
//	
//	public String getEvidenciaFolder(){
//		if(System.getProperty(EVIDENCIA_FOLDER)!=null && !System.getProperty(EVIDENCIA_FOLDER).equals("")){
//			return System.getProperty(EVIDENCIA_FOLDER);
//		}
//		return hashDatos.get(EVIDENCIA_FOLDER);
//	}
//	
//	public String getDownloadFolder(){
//		return hashDatos.get(DOWNLOAD_FOLDER);
//	}
//	
//	public String getProyectName(){
//		return hashDatos.get(PROYECT_NAME);
//	}
//	
//	public String getTestPlan(){
//		return hashDatos.get(TEST_PLAN);
//	}
//	
//	public String getCorrida(){
//		return hashDatos.get(CORRIDA);
//	}
//	
//	public String getHubConfiguration(){
//		return hashDatos.get(HUB_CONFIGURATION);
//	}
//	
//	public String getHubGrid1Yml(){
//		return hashDatos.get(HUB_GRID1YML);
//	}
//		
//	public boolean isEnabledEvidence(){
//		String enb = hashDatos.get(ENABLED_EVIDENCE);
//		return (enb!=null) && (enb.equalsIgnoreCase(EnvironmentSetting.YES) || enb.equalsIgnoreCase(EnvironmentSetting.SI) || enb.equalsIgnoreCase(TRUE));
//	}
//
//	public boolean isEnabledTestLink(){
//		String enb = hashDatos.get(ENABLED_TESTLINK);
//		return (enb!=null) && (enb.equalsIgnoreCase(EnvironmentSetting.YES) || enb.equalsIgnoreCase(EnvironmentSetting.SI) || enb.equalsIgnoreCase(TRUE));
//	}
//
//	public String getLogsRuta() {
//		return logsRuta;
//	}
//	
//	public String getImgRuta() {
//		return imgRuta;
//	}
//	
//	public void addFolder(String folder) {
//		File directorio = new File(getImgRuta()+File.separator+folder);
//		if (!directorio.exists()){
//			directorio.mkdirs();
//		}
//		imgRuta = directorio.getAbsolutePath();
//	}
//	
//	public String setFolder(String strEvidenciasFolder, String strNombreProyecto, String strTestPlan, String strCorrida, String strCarpeta) {
//
//		evidenciasFolder = strEvidenciasFolder;
//		nombreProyecto = strNombreProyecto;
//	    testPlan = strTestPlan;
//	    corrida = strCorrida;
//	    File directorio = null;
//	    String strDirectorioBase = getDirectorio(evidenciasFolder, nombreProyecto,testPlan, corrida);
//	    logsRuta = strDirectorioBase;
//	    StringTokenizer tokens = new StringTokenizer(strCarpeta, ".");
//		directorio = null;
//		
//		while (tokens.hasMoreTokens()) {
//			strDirectorioBase = strDirectorioBase + File.separator + tokens.nextToken();
//			directorio = new File(strDirectorioBase);
//			if (!directorio.exists())
//				directorio.mkdirs();
//		}
//		imgRuta = directorio.getAbsolutePath();
//		return imgRuta;
//	}
//
//	public String getDirectorio(String evidencias_Folder, String nombre_Proyecto, String test_Plan, String _corrida) {
//		String strDirectorioBase = "";
//		String strDirectorio = evidencias_Folder.concat(".").concat(nombre_Proyecto).concat(".").concat(test_Plan).concat(".").concat(_corrida);
//	    StringTokenizer tokens = new StringTokenizer(strDirectorio, ".");
//	    	   
//		while (tokens.hasMoreTokens()) {
//			if (!strDirectorioBase.equals("")){
//				strDirectorioBase = strDirectorioBase + File.separator + tokens.nextToken();
//			}else{
//				strDirectorioBase = strDirectorioBase +  tokens.nextToken();
//			}
//			File directorio = new File(strDirectorioBase);
//			if (!directorio.exists()){
//				directorio.mkdirs();
//			}
//		}
//		return strDirectorioBase;
//	}
//	
//
//	public WebDriver setDriver(WebDriver driver, String browserName,String remoteWebDriverUrl) throws Exception {
//		
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		
//		if (instance.getGrid()) {
//			if (browserName.equals(browser.IE.name())) {
//				desiredCapabilities = DesiredCapabilities.internetExplorer();
//				desiredCapabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
//				desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");				
//				
//			}
//			if (browserName.contains(browser.firefox.name())) {				
//				desiredCapabilities = DesiredCapabilities.firefox();	
//				desiredCapabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
//				
//
//			}
//			if (browserName.contains(browser.chrome.name())) {
//				desiredCapabilities = DesiredCapabilities.chrome();
//				desiredCapabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
//				/*ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.addArguments("download.default_directory", EVIDENCIA_FOLDER);
//				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);	*/
//				
//			}
//			
//			  desiredCapabilities.setJavascriptEnabled(true);			  
//			  driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), desiredCapabilities);		      
//		      driver.manage().window().maximize();
//	
//		      
//		} else {
//			if (browserName.equals(browser.IE.name())) {			
//
//				desiredCapabilities.setCapability(CapabilityType.VERSION, "8");
//				desiredCapabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
//				desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//				desiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
//				desiredCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,true);
//				desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//				desiredCapabilities.setCapability (InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//				driver = new InternetExplorerDriver(desiredCapabilities);
//				driver.manage().window().maximize();
//
//			}
//			if (browserName.equals(browser.chrome.name())) {
//				
//				ChromeOptions chromeOptions = new ChromeOptions();
//		//		System.setProperty("webdriver.chrome.driver", "D://Programas//Selenium//chromedriver_win32//chromedriver.exe");
//				chromeOptions.addArguments("download.default_directory", EVIDENCIA_FOLDER);
//				chromeOptions.addArguments("intl.accept_languages", "nl");
//				chromeOptions.addArguments("disable-popup-blocking", "true");
//				chromeOptions.addArguments("--test-type");
//				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);				
//				driver = new ChromeDriver(desiredCapabilities);
//				driver.manage().window().maximize();
//				
//			}
//			if (browserName.equals(browser.firefox.name())) {
//				FirefoxProfile firefoxProfile = new FirefoxProfile();
//				String downloadPath = hashDatos.get(DOWNLOAD_FOLDER);				
//				firefoxProfile.setPreference("browser.download.dir",downloadPath);
//				firefoxProfile.setPreference("browser.download.folderList",2);
//				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf, application/vnd.ms-excel");
//			    firefoxProfile.setPreference("pdfjs.disabled", true);			    
//			    driver = new FirefoxDriver(firefoxProfile);
//				driver.manage().window().maximize();
//			}
//		}
//		
//		//Obtener la version del navegador
//		((JavascriptExecutor)driver).executeScript("elemento=document.createElement('div');"
//				+ "var puntero=document.getElementsByTagName('body')[0];"
//				+ "puntero.appendChild(elemento);elemento.setAttribute('id','version');"
//				+ "elemento.setAttribute('style', 'display:none');"
//				+ "elemento.setAttribute('userAgent', navigator.userAgent)");
//		
//		this.informacionNavegador = parsear(driver.findElement(By.id("version")).getAttribute("userAgent"));
//		
//
//		return driver;
//	}
//
//	public String getInformacionNavegador() {
//		return informacionNavegador;
//	}
//
//
//	private String parsear(String attribute) {
//		if (attribute.contains("Chrome")){
//			
//		}
//		else if (attribute.contains("Firefox")){
//			
//		}
//		else if (attribute.contains("MSIE")){
//			
//		}
//		attribute.replaceAll(";", "");
//		return attribute;
//	}
//
//
//	
//
//
//	public void setVersionselenium(String versionselenium) {
//		this.versionselenium = versionselenium;
//	}
//
//
//	public String getVersionselenium() {
//		// TODO Auto-generated method stub
//		return versionselenium;
//	}
//}
//
//}
