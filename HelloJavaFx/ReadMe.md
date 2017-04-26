a simple JavaFx GUI applications, which focus on explaining event handler.
the detailed programming procedure is see [JavaFX快速入门](http://www.yiibai.com/javafx/javafx-tutorial-for-beginners.html)
the keypoint includes three areas

- 设置controls 的`fx:id`
- 设置 control 的 `onAction`，即事件处理函数
- 添加 属性`fx:controller`为UI的控制器


## [JavaFX 文本Text](http://docs.oracle.com/javafx/2/text/jfxpub-text.htm)

- javafx.scene.text.Text类 -> 显示文本
`Text t = new Text (10, 20, "This is a text sample");`
    - 设置字体和颜色:

```java
t.setText("This is a text sample");
t.setFont(Font.font ("Verdana", 20));
t.setFill(Color.RED);
```

```java
// Serif with drop shadow
Text text2 = new Text(50, 50, "JavaFX 8: Intro. by Example");
Font serif = Font.font("Serif", 30);
text2.setFont(serif);
text2.setFill(Color.RED);
```



```java
List<String> strings = new ArrayList<>();
for (String string : strings) {
	System.out.println("Content: " + string);
}
```

JAVA 8 `forEach()` -> functional looping style

```java
List<String> strings = new ArrayList<>();
strings.stream().forEach((string) -> {
	System.out.println("Content: " + string);
});
```


### FXML与Controller

- Q: 如何使得FXML文件与控制器Controller相连接？
假设一按钮定义: `fx:id = btnLogin`
则在FXML文件中声明
```
@FXML
Button btnLogin;
```

按钮与事件关联有两类方法:

```
@Override
public void initialize(URL url, ResourceBundle rb) {
	// TODO  
	if (btnLogin != null) {
	    btnLogin.setOnAction((ActionEvent e) -> {
		System.out.println("Hello World");
	    });
	}
}
```    
 
 或者: 在Scence Builder中设置`On action`为下述*函数名*
 ```
@FXML  
protected void handleSubmitButtonAction(ActionEvent event) {  
	btnLogin.setText("Sign in button pressed");  
	System.out.println("Hello World");
} 
```


## Java事件机制


```
[object].setOnXXX(new EventHandler<[Event_TYPE]>() {
  @Override public void handle([Event_TYPE] e) {
    ...
  }
});
```

Example:

```
Button button = new Button();
 
button.setOnAction(new EventHandler() {
  @Override public void handle(ActionEvent e) {
    ...
  }
});
```

以按鈕的鼠标移动事件为例，其方法为`setOnMouseMoved()`,事件为`MouseEvent`：

```java
Button button = new Button();
 
button.setOnMouseMoved(new EventHandler() {
  @Override public void handle(MouseEvent e) {
    ...
  }
});
```

- 属性绑定

```java
XXX.xxxxProperty().addListener
```

Example: 监听CheckBox的选中事件

```java
CheckBox cb = new CheckBox("CheckBox");  
cb.selectedProperty().addListener(new ChangeListener<Boolean>() {  
	@Override  
	public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {  
	   System.out.println("CheckBox:  " + " old value--" + t.toString() + "     new value--" + t1.toString());  
	}  
});  
```  


