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

## `BackgroundProcesses.java` 

- aim
  - 进度指示器: ProgressIndicator(饼状图)
  - JavaFx Task
  
  
```java
ProgressBar pb = new ProgressBar(0.6);  
ProgressIndicator pi = new ProgressIndicator(0.6); 
```


### JavaFX Task

JavaFX多线程核心包`javafx.async`，其中有三个类，分别是：

1. `Task`：一个接口类，表示一个工作任务，定义对任务操作方法以及回调
2. `JavaTaskBase`：实现Task接口，是一个抽象类
3. `RunnableFuture`：表示一个任务要执行的某个工作

Task启动方法

```java
Thread th = new Thread(task);
th.setDeamon(true);
th.start();
```

- Task updatet
  - `updateProgress()`和`updateMessage()` -> 更新Task progress和message属性
  

**Question**: why use `Node` to receive keyboard input? more direct way?

in a example [Getting Started with JavaFX Game Programming](http://www.java-gaming.org/index.php?PHPSESSID=38vkk8nnm3m5g4do2eklsuqbu3&topic=37201.0), I don't understand why author use `Node` to handle `setOnKeyPressed()`:

```java
// need to attach KeyEvent caller to a Node of some sort.
// How about an invisible Box? (arbitrary choice)
final Box keyboardNode = new Box();
keyboardNode.setFocusTraversable(true);
keyboardNode.requestFocus();

keyboardNode.setOnKeyPressed(this); // call to the EventHandler

root.getChildren().add(keyboardNode);
```

Why？
