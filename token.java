import javafx.animation.KeyFrame;
import java.util.*;
import javafx.scene.control.*;
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
public class token {
	ArrayList <Circle> as=new ArrayList<Circle>();
	Circle c1;
	int t1=1000;
	int t2=1000;
	int x,y;
        Label l;
	token(){
		Random r=new Random();
		
		x=1025;
		y=0;
		c1=new Circle(10, Color.CORAL);
                c1.relocate(x,y);
		//c1.relocate(r.nextInt(x), r.nextInt(y)+50);
		as.add(c1);
                l=new Label();
                l.setText("1");
                l.relocate(x+10, y);
		
	}
	void move1(final snake sn,final Pane canvas,final randomcall h) {
            
            System.out.println("ball");
            Random r=new Random();
            canvas.getChildren().addAll(as);
            canvas.getChildren().add(l);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
		        new EventHandler<ActionEvent>() {
		        
			//double dx = 7; //Step on x or velocity
			double dy = 3;
			double dx = 3;
		        //Step on y
			
		    @Override
		    public void handle(ActionEvent t) {
                        //System.out.println("hey");
		    	//move the ball
		    //	ball.setLayoutX(ball.getLayoutX() + dx);
		       Random r9=new Random();
		    	c1.setLayoutY(c1.getLayoutY() + dy);
                        l.setLayoutY(l.getLayoutY()+dy);
                       // System.out.println(c1.getLayoutX()+" "+c1.getLayoutY());
                        if(collision(sn)==true){
                        //    System.out.println("hi");
                            canvas.getChildren().removeAll(sn.al);
                            sn.increase(1);
                            canvas.getChildren().removeAll(as);
                            canvas.getChildren().remove(l);
                            canvas.getChildren().addAll(sn.al);
                        }
		    	//Bounds bounds = canvas.getBoundsInLocal();
                      //  System.out.println(c1.getLayoutY());
		    	if(c1.getLayoutY()>1000) {
                        //    timeline.stop();
                           // c1.relocate(r.nextInt(100)+t2,0);
                           canvas.getChildren().removeAll(as);
                           canvas.getChildren().remove(l);
                            h.select(h);
		    		//c1.relocate(r.nextInt(20)+t2, r.nextInt(10)+t1);
		    	}
		        
		    }
		}));
		       
		       
		        timeline.setCycleCount(335);
                      /*  if(c1.getLayoutY()>1000) {
                            timeline.stop();
                           // c1.relocate(r.nextInt(100)+t2,0);
                            canvas.getChildren().removeAll(as);
                            h.select(h);
		    		//c1.relocate(r.nextInt(20)+t2, r.nextInt(10)+t1);
		    	}*/
		        timeline.play();
	}
        boolean collision(snake s){
         //   System.out.println(c1.getLayoutX());
            //System.out.println(c1.getLayoutY()) ;
           //System.out.println(s.al.get(0).getLayoutX());
          // System.out.println(s.al.get(0).getLayoutY());
          // System.out.println();
           if(s.al.get(0).getLayoutX()>=c1.getLayoutX()-35 && (int)s.al.get(0).getLayoutY()/3==(int)c1.getLayoutY()/3 && s.al.get(0).getLayoutX()<=c1.getLayoutX()+35  ){
          //     System.out.println("hello");
                return true;
            }
            else {
           //    System.out.println("bye");
                return false;
            }
        }

}
class magnet extends token {
	ArrayList <Circle> as=new ArrayList<Circle>();
        boolean mag;
	magnet(){
		x=1025;
		y=0;
		this.t1=1000;
		this.t2=0;
		Random r=new Random();
		this.c1=new Circle(10,Color.BLACK);
                this.c1.relocate(x,y);
                mag=false;
		//this.c1.relocate(r.nextInt(x)+25, r.nextInt(y)+20);
		this.as.add(this.c1);
	}
	void reloc(boolean t) {
		if(t) {
			Random r=new Random();
			this.c1.relocate(r.nextInt(x)+25, r.nextInt(y)+20);
		}
	}
        void move1(final Pane canvas,final snake sn,final randomcall h) {
            canvas.getChildren().addAll(as);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
		        new EventHandler<ActionEvent>() {
		        
			//double dx = 7; //Step on x or velocity
			double dy = 3;
			double dx = 3;
		        //Step on y
			Random r=new Random();
		    @Override
		    public void handle(ActionEvent t) {
		    	//move the ball
		    //	ball.setLayoutX(ball.getLayoutX() + dx);
		       Random r9=new Random();
		    	c1.setLayoutY(c1.getLayoutY() + dy);
                        if(collision(sn)==true){
                            mag=true;
                            canvas.getChildren().removeAll(as);
                        }
		    	//Bounds bounds = canvas.getBoundsInLocal();
		    	if(c1.getLayoutY()>1000) {
		    		canvas.getChildren().removeAll(as);
                            h.select(h);
		    	}
		        
		    }
		}));
		       
		       
		        timeline.setCycleCount(335);
		        timeline.play();
	}
	
}
class shield extends token{
	ArrayList <Circle> as=new ArrayList<Circle>();
        boolean bl;
	shield(){
		this.x=1000;
		this.y=0;
		this.t1=1000;
		this.t2=1000;
		Random r=new Random();
		this.c1=new Circle(10,Color.BLUE);
		this.c1.relocate(x,y);
		this.as.add(this.c1);
                bl=false;
	}
	void reloc(boolean t) {
		if(t) {
			Random r=new Random();
			this.c1.relocate(r.nextInt(x)+75, r.nextInt(y)+20);
		}
	}
        void move1(final Pane canvas,final snake sn,final randomcall h) {
              canvas.getChildren().addAll(as);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
		        new EventHandler<ActionEvent>() {
		        
			//double dx = 7; //Step on x or velocity
			double dy = 3;
			double dx = 3;
		        //Step on y
			Random r=new Random();
		    @Override
		    public void handle(ActionEvent t) {
		    	//move the ball
		    //	ball.setLayoutX(ball.getLayoutX() + dx);
		       Random r9=new Random();
		    	c1.setLayoutY(c1.getLayoutY() + dy);
                        if(collision(sn)==true){
                            bl=true;
                           // mag=true;
                            canvas.getChildren().removeAll(as);
                         //   timeline.pause();
                        }
		    	//Bounds bounds = canvas.getBoundsInLocal();
		    	if(c1.getLayoutY()>1000) {
		    		canvas.getChildren().removeAll(as);
                            h.select(h);
		    	}
		        
		    }
		}));
		       
		       
		        timeline.setCycleCount(335);
		        timeline.play();
                        
	}
}
class Destroyblocks extends token{
    ArrayList <Circle> as=new ArrayList<Circle>();
        boolean bl;
    Destroyblocks(){
		this.x=1000;
		this.y=0;
		this.t1=1000;
		this.t2=1000;
		Random r=new Random();
		this.c1=new Circle(10,Color.LIGHTYELLOW);
		this.c1.relocate(x,y);
		this.as.add(this.c1);
                bl=false;
	}
     void move1(final Pane canvas,final snake sn,final randomcall h) {
              canvas.getChildren().addAll(as);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
		        new EventHandler<ActionEvent>() {
		        
			//double dx = 7; //Step on x or velocity
			double dy = 3;
			double dx = 3;
		        //Step on y
			Random r=new Random();
		    @Override
		    public void handle(ActionEvent t) {
		    	//move the ball
		    //	ball.setLayoutX(ball.getLayoutX() + dx);
		       Random r9=new Random();
		    	c1.setLayoutY(c1.getLayoutY() + dy);
                        if(collision(sn)==true){
                            bl=true;
                           // mag=true;
                            canvas.getChildren().removeAll(as);
                         //   timeline.pause();
                        }
		    	//Bounds bounds = canvas.getBoundsInLocal();
		    	if(c1.getLayoutY()>1000) {
		    		canvas.getChildren().removeAll(as);
                            h.select(h);
		    	}
		        
		    }
		}));
		       
		       
		        timeline.setCycleCount(335);
		        timeline.play();
                        
	}
}
/*class magnet extends token{
	magnet(){
		super();
		this.x=50;
		this.y=20;
	}
}
class magnet extends token{
	magnet(){
		super();
		this.x=50;
		this.y=20;
	}
}*/
