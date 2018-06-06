package loggerHelper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import util.ResourceHelper;

public class LoggerHelper {
	private static boolean root = false;
	@SuppressWarnings("rawtypes")
	public static Logger getLogger( Class clas) {
		if(root){
			return Logger.getLogger(clas);	
		}
		//PropertyConfig
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\conFig\\log4j.properties"));
		root = true;
		return Logger.getLogger(clas);

}
}
