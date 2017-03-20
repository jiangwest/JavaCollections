//.properties文件是Java配置文件
//java.util.Properties是对properties这类配置文件的映射。支持key-value类型和xml类型两种
//JDK 内置的java.util.Properties 类为操作.properties 文件提供了便利
import java.io.*; 
import java.util.Properties; 


public class propertyTest { 
      public static void main(String args[]) throws IOException { 
              testProperties(); 
      } 

      public static void testProperties() throws IOException { 
              System.out.println("------------testProperties-------------"); 
              //将properties文件加载到输入字节流中 
              InputStream is = new FileInputStream("D:\\ttt.properties"); 

              Properties prop = new Properties(); 	//创建一个Properties容器 
              prop.load(is);	//从流中加载properties文件信息  
              //循环输出配置信息 
              for (Object key : prop.keySet()) { 
                      System.out.println(key + "=" + prop.get(key)); 
              } 

              //定义输出流 
              OutputStream os1 = new FileOutputStream("C:\\t1.xml"); 
              OutputStream os2 = new FileOutputStream("C:\\t2.properties"); 

              //从Properties对象导出导出到xml 
              prop.storeToXML(os1, "我从properties导出的XML配置文件"); 
              //从Properties对象导出properties文件 
              prop.store(os2, "我从properties导出的XML配置文件"); 

              is.close(); 
              os1.close(); 
              os2.close(); 

              //从xml加载配置信息，填充Properties容器 
              prop.loadFromXML(new FileInputStream("C:\\t3.xml")); 
              //循环输出配置信息 
              System.out.println("我从导出的xml加载配置文件信息！"); 
              for (Object key : prop.keySet()) { 
                      System.out.println(key + "=" + prop.get(key)); 
              } 
              
              prop.put("呵呵呵", "嘎嘎嘎");   //增加新属性和属性值
              OutputStream os3 = new FileOutputStream("C:\\ttt1.xml"); 
              prop.storeToXML(os3, "我从properties导出的XML配置文件"); 
              os3.close(); 
      } 
}
