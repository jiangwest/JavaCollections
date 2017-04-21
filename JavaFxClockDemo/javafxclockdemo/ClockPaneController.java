/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package javafxclockdemo;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class ClockPaneController implements Initializable {
    private double centerX,centerY, radius; //circle center point and radius
    private final double delta = 5;
    private Timeline timeline;
    Duration duration;
    KeyFrame keyFrame;
    private Line lineSec,lineMinu,lineHour;//秒针，分针，时针
    private double x1,x2,x3;//当前时间秒、分、时指向的时间
    
    @FXML
    private Pane clockPane;
    @FXML
    private Circle cirClock;
    @FXML     
    private Text txtDateTime;
    @FXML
    private Button btnExit;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //acquire the centerX, centerY and radius of Circle
        centerX = cirClock.getCenterX();
        centerY = cirClock.getCenterY();
        radius = cirClock.getRadius();
        
        for (int i = 0; i < 60; i++) {//短的表盘指针
            Line line = new Line(centerX+radius*Math.sin(Math.PI*i/30),(centerY-radius*Math.cos(Math.PI*i/30)),centerX+190*Math.sin(Math.PI*i/30),(centerY-190*Math.cos(Math.PI*i/30)));
            clockPane.getChildren().add(line);
        }

        for (int i = 0,j = 0; i < 60; i=i+5,j++) {//长的表盘指针和 表盘数字
            String[] n={"12","1","2","3","4","5","6","7","8","9","10","11"};
            Line line = new Line(centerX+radius*Math.sin(Math.PI*i/30),(centerY-radius*Math.cos(Math.PI*i/30)),centerX+(radius - 4*delta)*Math.sin(Math.PI*i/30),(centerY-(radius - 4*delta)*Math.cos(Math.PI*i/30)));
            clockPane.getChildren().add(line);
            Text text = new Text(centerX - delta +(radius - 6*delta)*Math.sin(Math.PI*i/30),(centerY-(radius - 6*delta)*Math.cos(Math.PI*i/30)),n[j]);
            clockPane.getChildren().add(text);       
        }
            
        lineSec = new Line();
        lineSec.setStrokeWidth(1);    //set the width of line 
        lineMinu = new Line();
        lineMinu.setStrokeWidth(5);
        lineHour = new Line();
        lineHour.setStrokeWidth(8);
        paint();//画出初始时钟指针
        clockPane.getChildren().addAll(lineSec,lineMinu,lineHour);
            
        timeline = new Timeline();//时间轴
        timeline.setCycleCount(Timeline.INDEFINITE);
        duration = Duration.millis(1000);//设定时钟动画每1秒变一次，关键帧时间间隔
        
        keyFrame = new KeyFrame(duration, new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent event) {//动画变化的代码
                    paint();//画出指针  
                    getCurTime();
                }
            });
            
        timeline.getKeyFrames().add(keyFrame);    //时间轴获取关键帧
    }    
    
    @FXML
    protected void handleQueryAction(ActionEvent event) {
        System.out.println("Query button clicked"); 
        timeline.play();//动画开始
    }
    
    @FXML
    protected void handlePauseAction(ActionEvent event) {
        System.out.println("Pause button clicked"); 
        timeline.stop();//动画停止
    }
    
    @FXML
    protected void handleExitAction(ActionEvent event) {
         //Event.fireEvent(primaryStage, new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST ));
         btnExit.getScene().getWindow().hide(); //hide the whole JavaFx Stage
                  
    }
    
    protected void paint(){//画指针的函数           
        Calendar c = Calendar.getInstance();//取当前时间
        x1=c.get(Calendar.SECOND);
        x2=c.get(Calendar.MINUTE);
        x3=c.get(Calendar.HOUR)*5; 
        lineSec.setStartX(centerX);
        lineSec.setStartY(centerY);
        lineSec.setEndX(centerX+160*Math.sin(Math.PI*x1/30));
        lineSec.setEndY(centerY-160*Math.cos(Math.PI*x1/30));//秒针
        lineSec.setStroke(Color.RED);
        lineMinu.setStartX(centerX);
        lineMinu.setStartY(centerY);
        lineMinu.setEndX(centerX+120*Math.sin(Math.PI*x2/30));
        lineMinu.setEndY(centerY-120*Math.cos(Math.PI*x2/30));//分针
        lineMinu.setStroke(Color.BLUE);
        lineHour.setStartX(centerX);
        lineHour.setStartY(centerY);
        lineHour.setEndX(centerX+80*Math.sin(Math.PI*x3/30));
        lineHour.setEndY(centerY-80*Math.cos(Math.PI*x3/30));//时针
        lineHour.setStroke(Color.GREEN);
     }
    
    //to get cuurent time and update Text
    protected void getCurTime(){
        String str1, str2, str3;  
        
        Calendar calendar = new GregorianCalendar();
        
        int hour = calendar.get(Calendar.HOUR_OF_DAY);    
        int minute = calendar.get(Calendar.MINUTE);    
        int second = calendar.get(Calendar.SECOND);  
        
        str1 = String.valueOf(hour);  
        str2 = String.valueOf(minute);  
        str3 = String.valueOf(second);  
        
        if (hour < 10) {  
            str1 = "0" + hour;  
        }  
        if (minute < 10) {  
            str2 = "0" + minute;  
        }  
        if (second < 10) {  
            str3 = "0" + second;  
        }  
        
        String nowTime = str1 + " : " + str2 + " : " + str3;
        txtDateTime.setText(nowTime);   //fill the Text
    }
}
