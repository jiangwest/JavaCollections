## 新浪股票小爬虫

this example is the revision edition of Sina Stock API

- my revision: 增加深市stock信息
  - GIU: swing, I will use **JavaFx** later
  
  
  
```java
//转化为int，并取首位数字。6 -- 沪市；otherwise -- 深市
int code = Integer.parseInt(strCode)/100000;

if(code == 6 ){
	Httpurl = "http://hq.sinajs.cn/list=sh";//沪市接口
}else{
  Httpurl = "http://hq.sinajs.cn/list=sz";//深市
}
```

- **Q**: 中文乱码
- solution: 修改为*GBK*编码,而非utf8编码

Java `BufferedReader br=new BufferedReader(new InputStreamReader(is,"gbk"));`

- `String` 类型转化为 `int` 类型时,需使用 Integer 类中的 `parseInt()` 或 `valueOf()` 方法转换

```java
String str = "123";
try {
    int a = Integer.parseInt(str);
} catch (NumberFormatException e) {
    e.printStackTrace();
}
```

