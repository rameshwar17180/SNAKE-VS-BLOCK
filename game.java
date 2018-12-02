/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author anvit
 */
import javafx.animation.KeyFrame;
import java.util.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;
import javafx.scene.input.*;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.scene.layout.HBox;
public class game extends Application{
	 public void start(final Stage stage) {
	    	
	    	final Pane canvas = new Pane();
	    	Scene scene = new Scene(canvas, 2000, 900, Color.ALICEBLUE);
	        
	       final Ellipse ellipse = new Ellipse(); {
	        ellipse.setCenterX(1300f);
	        ellipse.setCenterY(300f);
	        ellipse.setRadiusX(50.0f);
	        ellipse.setRadiusY(25.0f);
	            }
	       
	     final snake sn=new snake(5);
        //      System.out.println(sn.al.get(0).getCenterX());
	    final  blocks b1=new blocks();
            final token t1=new token();
            final magnet m=new magnet();
            final shield sh=new shield();
            final Destroyblocks db=new Destroyblocks();
                Text t=new Text("SCORE");
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        t.setX(1700);
        t.setY(100);
       final randomcall r=new randomcall(b1,sn,canvas,stage, t1,m,sh,db);
       final strartpage sp=new strartpage();
      final  Button btn = new Button();
              btn.setText("Start");
               btn.relocate(1000,300);
               final  Button btn2 = new Button();
              btn2.setText("Exit and go to main page");
               btn2.relocate(100,300);
               
               final  Button btn3 = new Button();
               btn3.setText("Pause");
               btn3.relocate(100,300);
        canvas.getChildren().add(t);
        canvas.getChildren().add(btn);
         canvas.getChildren().add(btn2);
	  //    canvas.getChildren().addAll(b1.ar);
	      canvas.getChildren().addAll(sn.al);
	   //   canvas.getChildren().addAll(b1.al);
              //canvas.getChildren().addAll(t1.as);
              btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                canvas.getChildren().remove(btn);
                r.select(r);
               // t1.move1(sn,canvas);
               //
            }
        });
                btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
               // canvas.getChildren().remove(btn);
                //r.select(r);
               // t1.move1(sn,canvas);
                try{
                sp.start(stage);
                }
                catch(Exception e){
                    
                }
               //
            }
        });
              scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent ke) {
                   // double dy=3;
                    if(ke.getCode()==KeyCode.L) {
                        sn.moveleft();
                       
                    }
                    else if(ke.getCode()==KeyCode.R) {
                       // dy=-3;
                        sn.moveright();
                    }
                }
            });
	     //b1.move(sn,canvas);
             
            // if(sn.al.get(0).getCenterX()==b1.b3.getLayoutX() && sn.al.get(0).getCenterY()==b1.b3.getLayoutY() ){
             //    System.exit(0);
            // }
	     /*blocks b22=new blocks();
	     canvas.getChildren().addAll(b22.ar);
	     canvas.getChildren().addAll(b22.al);*/
	     
	      /*Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
	    	        new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent t) {
	    		  blocks b2;
	    		  if(b1.b1.getLayoutY()>500) {
	    			  b1.reset();
	    			new blocks().move();;
	    			
	    			System.out.println(b1.b1.getLayoutX());
	    		  }
	    		  
	    	  }
	      }));
	      timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.play();*/
	     //new reminder();
	       stage.setTitle("Game");
	        stage.setScene(scene);
	        stage.show();
	 }
	 public static void main(String args[]) {
		 launch();
	 }
}
/*class reminder{
	Timer t;
	public reminder() {
		t=new Timer();
		t.schedule(new remindtask(),0, 1*1000);
	}
	class remindtask extends TimerTask{
		public void run() {
			blocks b=new blocks();
			b.move();
			t.cancel();
		}
	}
	public void main(String args[]) {
		new reminder();
	}
}*/

