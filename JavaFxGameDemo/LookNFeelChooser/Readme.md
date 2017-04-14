## Example **LookNFeelChooser** 
-- come from book *JavaFX 8: Introduction by Example*.

- [Using JavaFX UI Controls](http://docs.oracle.com/javafx/2/ui_controls/jfxpub-ui_controls.htm): 使用JavaFX2.0的控件

- LookNFeelChooser: 
  - Menu 
  - Button
  - Scrollbar
  - CSS设定UI控件风格

- `FXMLLoader.load()`: 从资源文件(`.fxml`)中加载对象的层次结构

```java
Scene scene = new Scene();  
scene.getStylesheets().add(".css");  
```

- 创建一个按钮

```java
//空按钮  
Button button1 = new Button();  
//使用特定本文为标题的按钮  
Button button2 = new Button("Accept");  
//使用标题和图标的按钮  
Image imageOk = newImage(getClass().getResourceAsStream("ok.png"));  
Button button3 = new Button("Accept", new ImageView(imageOk));  
```

> I'm soory the book *JavaFX 8: Introduction by Example**, its code is not good
