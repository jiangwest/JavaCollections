import java.io.IOException;

import org.apache.log4j.Logger;  
import org.apache.log4j.PropertyConfigurator;  

public class Log4jTest {
	public static void main(String[] args) throws IOException{  
		// 1. create log  获取日志记录器
        Logger log = Logger.getLogger(Log4jTest.class);  
        // 2. get log config file  
        PropertyConfigurator.configure("log4j.properties");  
        // 3. start log  插入记录信息
        log.debug("Here is some DEBUG");  
        log.info("Here is some INFO");  
        log.warn("Here is some WARN");  
        log.error("Here is some ERROR");  
        log.fatal("Here is some FATAL");      
    }    
}  
  
