package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.testng.annotations.Test;


public class ResourceHelper {
	
//	private static Logger log = LoggerHelper.getLogger(ResourceHelper.class);
	
	public static String getResourcePath(String resource){
		
		String path = getBaseResourcePath()+"\\src\\main\\resources"+resource;
//		String path = "C:\\Users\\ajit_\\workspace\\GNC_PROJECT\\src\\main\\resources"+resource;
//		log.info("full path is: "+path);
		return path;
	}

		public static String getBaseResourcePath() {
		// uer.dir will give us project location
		// C:\Users\ajit_\workspace\GNC_PROJECT
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
//		ResourceHelper resourceHelper = new ResourceHelper();
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}
	@Test
	public void test1(){
		String path = System.getProperty("user.dir");
		System.out.println(path);
	}


}
