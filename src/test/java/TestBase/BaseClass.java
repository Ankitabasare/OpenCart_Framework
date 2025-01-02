package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;    // Correct Logger import
import org.apache.logging.log4j.LogManager;  // Correct LogManager import
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
public class BaseClass 
{

	public static WebDriver driver;
	public Logger logger;     //Log4j
	public Properties pop;
	@BeforeClass(groups = {"Sanity","regression","Master","Datadriven"})
	
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		pop=new Properties();
		pop.load(file);
		file.close();
		
		logger=LogManager.getLogger(this.getClass());
		
		
		if(pop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching OS");
				return;
			}
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("no matching browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if(pop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
		break;
		
		case "edge":driver=new EdgeDriver();
		break;
		
		default:
			System.out.println("Invalid browser");
			return;		
		}
		}	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(pop.getProperty("appUrl"));
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomAlphanumber()
	{
		String generateString=RandomStringUtils.randomAlphabetic(3);
		String generatenumber=RandomStringUtils.randomNumeric(3);
		return(generateString+"@"+generatenumber);
	}
	
	@AfterClass(groups = {"Sanity","regression","Master","Datadriven"})
	public void teardown()
	{
		driver.close();
	}
	public String captureScreen(String tname) {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}

}
