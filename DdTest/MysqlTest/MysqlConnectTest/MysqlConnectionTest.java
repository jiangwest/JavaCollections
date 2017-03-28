import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;           //数据库连接的获取
        Statement stmt = null;                    //创建Statement对象
        ResultSet rst = null;                 //创建数据库执行对象
        String driver= "com.mysql.cj.jdbc.Driver";	//数据库驱动
        //操作的数据库地址，端口及库名
        //world: 数据库名; 3306为port
        //"jdbc:mysql://localhost: database address
        String dbURL="jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC";  
        String user = "root"; //数据库用户名
        String password = ""; //数据库密码
        
        try{
            //调用Class.forName()方法加载驱动程序
        	Class.forName(driver);      //驱动注册
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        

        try {
            connection = DriverManager.getConnection(dbURL,user,password);	//连接数据库   
            System.out.print("成功连接到数据库！");
        } catch (SQLException e) {
            e.printStackTrace();
        }             
        
        stmt = connection.createStatement();	// 实例化Statement对象
        String sql="select * from city"; //需要查询的语句
        rst=stmt.executeQuery(sql);
        System.out.println(rst.toString());
        
        System.out.println("ID"+"\t"+"Name"+"\t"+"CountryCode"+ "\t"+"District" + "\t"+"Population");
        while (rst.next()){
            System.out.print(rst.getInt(1) + "\t");
            System.out.print(rst.getString(2) + "\t");
            System.out.print(rst.getString(3) + "\t");
            System.out.print(rst.getString(4) + "\t");
            System.out.print(rst.getInt(5) + "\t");
            System.out.println();
        }
        
        rst.close();
        stmt.close();	// 关闭操作
        connection.close();	// 数据库关闭
    }

}
