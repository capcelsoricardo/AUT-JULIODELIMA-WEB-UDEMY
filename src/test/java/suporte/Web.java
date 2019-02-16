package suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {		
	
	  public static final String USERNAME = "celsoricardodeol1";
	  public static final String AUTOMATE_KEY = "fzA6np1xoDNczy9yejqy";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	
	public static WebDriver createChrome() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\CTS\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}
	
	public static WebDriver createBrownserStack() { 
		
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "66.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1280x800");

	    WebDriver navegador = null;
		try {
			navegador = new RemoteWebDriver(new URL(URL), caps);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			navegador.get("http://www.juliodelima.com.br/taskit");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    return navegador;
		
	}

}
