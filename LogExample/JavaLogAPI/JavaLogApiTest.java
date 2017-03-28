import java.io.IOException;  
import java.util.Date;  
import java.util.logging.FileHandler;  
import java.util.logging.Formatter;  
import java.util.logging.Level;  
import java.util.logging.LogRecord;  
import java.util.logging.Logger;  

public class JavaLogApiTest {
	public static void main(String[] args) throws IOException{  
        Logger log = Logger.getLogger("tesglog");  //查找或创建一个 logger
        log.setLevel(Level.ALL);  //Logger的级别
        //Handler 对象从 Logger 中获取日志信息，并将这些信息导出
        FileHandler fileHandler = new FileHandler("testlog.log");  
        fileHandler.setLevel(Level.ALL);  
        fileHandler.setFormatter(new LogFormatter());	//日志记录格式 ，如 XML
        log.addHandler(fileHandler);  //日志输出文件 
        log.info("This is test java util log");     
    }    
}  
  
class LogFormatter extends Formatter {  
    @Override  
    public String format(LogRecord record) {  
        Date date = new Date();  
        String sDate = date.toString();  
        return "[" + sDate + "]" + "[" + record.getLevel() + "]"  
                + record.getClass() + record.getMessage() + "\n";  
    }  
  
}  
