import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;


public class crawlerData {
	public String data="";
	
	public crawlerData(String strCode)
	{
		String Httpurl;		
		StringBuffer content=new StringBuffer();
		//转化为int，并取首位数字。6 -- 沪市；otherwise -- 深市
		int code = Integer.parseInt(strCode)/100000;	
	
		try{			
			if(code == 6 ){
				Httpurl = "http://hq.sinajs.cn/list=sh";//沪市接口
			}else{
				Httpurl = "http://hq.sinajs.cn/list=sz";//深市
			}
			
			URL httpURL=new URL(Httpurl+strCode);
			HttpURLConnection connection=(HttpURLConnection)httpURL.openConnection();
			connection.connect();
			InputStream is=connection.getInputStream();
			//BufferedReader br=new BufferedReader(new InputStreamReader(is));
			BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));
			String str="";

			while((str=br.readLine())!=null){
				System.out.println(str);
				content.append(str);
			}

			br.close();
			is.close();
		}catch(Exception e){
		}

		String cont=content.toString();
		//规整化所检索string
		if(code == 6){
			data=cont.replace("var hq_str_sh"+strCode+"=\"", "").replace(",00\";", "");
		} else {
			data=cont.replace("var hq_str_sz"+strCode+"=\"", "").replace("\";", "");
		}		
	}
}
