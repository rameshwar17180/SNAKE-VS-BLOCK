import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javafx.stage.Stage;
class blocks{
    boolean bq=false;
	ArrayList <Rectangle> ar=new ArrayList<Rectangle>();
	ArrayList <Label> al=new ArrayList<Label>();
        int score=0;
	Rectangle b1,b2,b3,b4;
	Label l1,l2,l3,l4,s;
        
	public blocks(){
		Random r=new Random();
		int t1=r.nextInt(10);
		int t2=r.nextInt(50);
		int t3=r.nextInt(70);
		int t4=r.nextInt(snake.length);
		l1=new Label();l2=new Label();l3=new Label();l4=new Label();s=new Label();
		l1.setText(Integer.toString(t1));l2.setText(Integer.toString(t2));l3.setText(Integer.toString(t3));
                l3.setText(Integer.toString(3));
		l1.relocate(600, 15);l2.relocate(800, 15);l3.relocate(1000, 15);l4.relocate(1200, 15);s.relocate(1800, 150);
		l4.setText(Integer.toString(t4));s.setText(Integer.toString(0));
                s.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
                al.add(l1);al.add(l2);al.add(l3);al.add(l4);al.add(s);
		b1=new Rectangle(200,100,Color.CHOCOLATE);
		b2=new Rectangle(200,100,Color.AQUA);
		b3=new Rectangle(200,100,Color.BLANCHEDALMOND);
		b4=new Rectangle(200,100,Color.RED);
		b1.relocate(500, 0);
		b2.relocate(700, 0);
		b3.relocate(900, 0);
		b4.relocate(1100, 0);
		ar.add(b1);ar.add(b2);ar.add(b3);ar.add(b4);
		
	}
	void move(final snake sn,final Pane canvas,final Stage st,final randomcall h,final boolean z,final int score,boolean q) {
        //    System.out.println(ar.size());
           // for(int j=0;j<4;j++){
             //   canvas.getChildren().add(ar.get(j));
              //  canvas.getChildren().add(al.get(j));
            //}
           //  canvas.getChildren().addAll(ar);
            //canvas.getChildren().addAll(al);
           final int x=sn.al.size();
            canvas.getChildren().add(b1);
           canvas.getChildren().add(b2);
            canvas.getChildren().add(b3);
            canvas.getChildren().add(b4);
           canvas.getChildren().add(l1);
            canvas.getChildren().add(l2);
            canvas.getChildren().add(l3);
            canvas.getChildren().add(l4);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
		        new EventHandler<ActionEvent>() {
		        
			//double dx = 7; //Step on x or velocity
			double dy = 3;
			double dx = 3;
		        //Step on y
			
		    @Override
		    public void handle(ActionEvent t) {
                        if(bq==true)
                                {dy=0;}
                        else{
                            dy=3;
                        }
                       //move the ball
		    //	ball.setLayoutX(ball.getLayoutX() + dx);
		       Random r9=new Random();
		    	b1.setLayoutY(b1.getLayoutY() + dy);
		    	b2.setLayoutY(b2.getLayoutY() + dy);
		    	b3.setLayoutY(b3.getLayoutY() + dy);
		    	b4.setLayoutY(b4.getLayoutY() + dy);
		    	
		        
		    	l1.setTranslateY(l1.getTranslateY()+dy);
		    	l2.setTranslateY(l2.getTranslateY()+dy);
		    	l3.setTranslateY(l3.getTranslateY()+dy);	
		    	l4.setTranslateY(l4.getTranslateY()+dy);
                 //      System.out.println(sn.al.get(0).getLayoutX());
                        
                   //     System.out.println(sn.al.get(0).getLayoutY());
                     //   System.out.println(b3.getLayoutX());
                       //  System.out.println(b3.getLayoutY());
                       // final Stage stage;
                        //stage=new Stage();
                        int nl=0;
                       
                        if(sn.al.get(0).getLayoutX()>=900 && sn.al.get(0).getLayoutX()<=1100 && (int)sn.al.get(0).getLayoutY()/3==(int)b3.getLayoutY()/3 ){
                         //   System.out.println("mc"+x);
                            if(Integer.parseInt(l3.getText())>x){
                           //     System.out.println("bc");
                               // System.out.println("hi"+l3.getText());
                             //   System.out.println(sn.al.size());
                               // TextField t4=new TextField();
                               // t4.setText("GAME OVER");
                              //  canvas.getChildren().add(t4);
                                 for(long i=0;i<1000000000;i++);
                                 strartpage g=new strartpage();
                                 try{
                                   
                                // Dialogs.create().message("Hi!").showInformation();
                                   st.close();
                                    g.start(st);
                              //   System.exit(0);
                                 
                                // stage.close();
                                 }
                                 catch(Exception e){
                                     
                                 }
                              //  System.exit(0);
                            }
                            else{
                                if(Integer.parseInt(l3.getText())>5){
                                for(int i=0;i<1000000000;i++);
                               // System.out.println("hi");
                            }
                               h.increasescore(Integer.parseInt(l3.getText())) ;
                         //   score+=Integer.parseInt(l3.getText());
                            nl=Integer.parseInt(l3.getText());
                      //      System.out.println(nl);
                            canvas.getChildren().removeAll(sn.al);
                            if(z==false){
                            sn.decrease(nl);
                            }
                              canvas.getChildren().remove(b3);
                        canvas.getChildren().remove(l3);
                     //   System.out.println(sn.al.size());
                        canvas.getChildren().addAll(sn.al);
                            }
                        
                            //Duration.seconds(5);
                         //   System.exit(0);
             }
                    else    if(sn.al.get(0).getLayoutX()>=1100 && sn.al.get(0).getLayoutX()<=1300 && (int)sn.al.get(0).getLayoutY()/3==(int)b4.getLayoutY()/3  ){
                        nl=Integer.parseInt(l4.getText());
                      // sn.decrease(nl);
                        if(Integer.parseInt(l4.getText())>x){
                         //   System.out.println("maa ki chut");
                              for(long i=0;i<1000000000;i++);
                                 strartpage g=new strartpage();
                                 try{
                                   
                                // Dialogs.create().message("Hi!").showInformation();
                                   st.close();
                                    g.start(st);
                              //   System.exit(0);
                                 
                                // stage.close();
                                 }
                                 catch(Exception e){
                                     
                                 }
                               // System.exit(0);
                            }
                        else{
                            if(Integer.parseInt(l4.getText())>5){
                                for(int i=0;i<1000000000;i++);
                            }
                             h.increasescore(Integer.parseInt(l4.getText())) ;
                      //score+=Integer.parseInt(l4.getText());
                            nl=Integer.parseInt(l4.getText());
                         //   System.out.println(nl);
                         //   canvas.getChildren().removeAll(sn.al);
                           //  System.out.println("maa ki chut");
                              canvas.getChildren().removeAll(sn.al);
                              if(z==false){
                           sn.decrease(nl);
                              }
                              canvas.getChildren().remove(b4);
                        canvas.getChildren().remove(l4);
                        
                        //System.out.println(sn.al.size());
                        canvas.getChildren().addAll(sn.al);
                        }
                       //     Duration.seconds(5);
                         //   System.exit(0);
             }
                      else  if(sn.al.get(0).getLayoutX()>=500 && sn.al.get(0).getLayoutX()<=700 && (int)sn.al.get(0).getLayoutY()/3==(int)b1.getLayoutY()/3 ){
                          if(Integer.parseInt(l1.getText())>x){
                                for(long i=0;i<1000000000;i++);
                                 strartpage g=new strartpage();
                                 try{
                                   
                                // Dialogs.create().message("Hi!").showInformation();
                                   st.close();
                                    g.start(st);
                              //   System.exit(0);
                                 
                                // stage.close();
                                 }
                                 catch(Exception e){
                                     
                                 }
                               // System.exit(0);
                            }
                          else{
                              if(Integer.parseInt(l1.getText())>5){
                                for(int i=0;i<1000000000;i++);
                            }
                               h.increasescore(Integer.parseInt(l1.getText())) ;
                    //   score+=Integer.parseInt(l1.getText());
                            nl=Integer.parseInt(l1.getText());
                            canvas.getChildren().removeAll(sn.al);
                            System.out.println(nl);
                            canvas.getChildren().removeAll(sn.al);
                            if(z==false){
                            sn.decrease(nl);
                            }
                              canvas.getChildren().remove(b1);
                        canvas.getChildren().remove(l1);
                      //  System.out.println(sn.al.size());
                        canvas.getChildren().addAll(sn.al);
                          }
                           // Duration.seconds(5);
                         //   System.exit(0);
             }
                      else  if(sn.al.get(0).getLayoutX()>=700 && sn.al.get(0).getLayoutX()<=900 && (int)sn.al.get(0).getLayoutY()/3==(int)b2.getLayoutY()/3 ){
                          if(Integer.parseInt(l2.getText())>x){
                                for(long i=0;i<1000000000;i++);
                                 strartpage g=new strartpage();
                                 try{
                                   
                                // Dialogs.create().message("Hi!").showInformation();
                                   st.close();
                                    g.start(st);
                              //   System.exit(0);
                                 
                                // stage.close();
                                 }
                                 catch(Exception e){
                                     
                                 }
                             //   System.exit(0);
                            }
                          else{
                              if(Integer.parseInt(l2.getText())>5){
                                for(int i=0;i<1000000000;i++);
                            }
                               h.increasescore(Integer.parseInt(l2.getText())) ;
                    //    score+=Integer.parseInt(l2.getText());
                            nl=Integer.parseInt(l2.getText());
                            System.out.println(nl);
                            canvas.getChildren().removeAll(sn.al);
                          //  canvas.getChildren().removeAll(sn.al);
                            if(z==false){
                            sn.decrease(nl);
                            }
                              canvas.getChildren().remove(b2);
                        canvas.getChildren().remove(l2);
                        System.out.println(sn.al.size());
                        canvas.getChildren().addAll(sn.al);
                          }
                           // Duration.seconds(5);
                         //   System.exit(0);
             }
                      //  if(nl>0){
                        s.setText(Integer.toString(score));
                        //snake s1=new snake(sn.al.size()-nl);
                        //snake s2=sn;
                       // System.out.println(nl);
                       // System.out.println(sn.al.size()-nl);
                      //  sn.decrease(nl);
                     //   canvas.getChildren().removeAll(sn.al);
                       // canvas.getChildren().addAll(s1.al);
                        // sn=s1;
                        //}
		    	//Bounds bounds = canvas.getBoundsInLocal();
		    	if(b1.getLayoutY()>1000 && l1.getTranslateY()>1000) {
                            
		    		/*b1.setLayoutX(500);b1.setLayoutY(0);
		    		l1.setTranslateX(0);l1.setTranslateY(15);
		    		l1.setText(Integer.toString(r9.nextInt(50)));
		    		b2.setLayoutX(700);b2.setLayoutY(0);
		    		l2.setTranslateX(0);l2.setTranslateY(15);
		    		l2.setText(Integer.toString(r9.nextInt(50)));
		    		b3.setLayoutX(900);b3.setLayoutY(0);
		    		l3.setTranslateX(0);l3.setTranslateY(15);
		    		l3.setText(Integer.toString(r9.nextInt(50)));
		    		b4.setLayoutX(1100);b4.setLayoutY(0);
		    		l4.setTranslateX(0);l4.setTranslateY(15);
		    		l4.setText(Integer.toString(r9.nextInt(50)));*/
                                canvas.getChildren().removeAll(al);
                                canvas.getChildren().removeAll(ar);
                            h.select(h);
                                /*canvas.getChildren().add(b3);
                               canvas.getChildren().add(l3);
                                canvas.getChildren().add(b4);
                               canvas.getChildren().add(l4);
                               canvas.getChildren().add(b1);
                               canvas.getChildren().add(l1);
                               canvas.getChildren().add(b2);
                               canvas.getChildren().add(l2);*/
                            //   for(int i=0;i<20;i++){
                              // canvas.getChildren().add(sn.al.get(i));
                               //}
		    	}
		        
		    }
		}));
		       
		       
		        timeline.setCycleCount(335);
		        timeline.play();
	}
        public void stop(Stage st){
            st.close();
        }
}