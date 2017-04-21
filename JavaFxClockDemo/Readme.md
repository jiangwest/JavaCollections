## How to realize a *Clock* by using JavaFX

- use Scence Build to design FXML

```java
//load fxml file
Parent root = FXMLLoader.load(getClass().getResource("*.fxml"));
```

- use `FXMLController` class to handle GUI input

获取JavaFx Stage

```
Stage primaryStage = (Stage) 组件.getScene().getWindow();
```
- **Q**: 如何让fxml对应controll代码实现关闭当前所控制的fxml页面?
```
//
组件.getScene().getWindow().hide();
```



- **Question**: don't understand the difference of *Text* and *TextField*?

> it seem like that *TextField* can't setText() -> compiler will error!


## Ref

- [javafx一个时钟代码](http://bbs.csdn.net/topics/390954186)
- [使用JavaFX设置一个简单日历](http://blog.csdn.net/smart_snail/article/details/52843497)
