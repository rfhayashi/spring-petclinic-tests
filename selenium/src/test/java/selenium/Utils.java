package selenium;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Utils {

	public static WebDriver getDriver() {
		String browserType = System.getProperty("browserType", "unknown").toLowerCase();
		if ("firefox".equals(browserType))
			return  new FirefoxDriver();
		if ("htmlunit".equals(browserType))
			return new HtmlUnitDriver() {

				@Override
				protected WebClient getWebClient() {
					WebClient client = super.getWebClient();

					client.setCssErrorHandler(new SilentCssErrorHandler());

					return client;
				}
			};
		
		throw new IllegalStateException("browserType property must be set to ether firefox or htmlunit!");
	}

	public static String getBaseUrl() {
		return System.getProperty("base.url", "http://localhost:8080/petclinic");
	}
}
