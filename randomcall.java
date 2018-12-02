/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anvit
 */
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.*;
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
public class randomcall {
    blocks b1;
    snake sn;
    Pane canvas;
    Stage stage;
    token t1;
    magnet m;
    shield sh;
    int score;
    Label l;
    Destroyblocks db;
    randomcall(blocks b,snake s,Pane cv,Stage st,token t,magnet m1,shield s1,Destroyblocks d){
        b1=b;
        sn=s;
        canvas=cv;
        stage=st;
        t1=t;
        m=m1;
        sh=s1;
        db=d;
        score=0;
        l=new Label();
        l.setText("0");
    }
    void select(randomcall h){
       // System.out.println("hi");
    //    System.out.println("yo"+sn.al.size());
        canvas.getChildren().remove(l);
        l.setText(Integer.toString(score));
        l.relocate(1700,200);
         l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        canvas.getChildren().add(l);
        Random r=new Random();
        
        int x=r.nextInt(7)+1;
        
      //  System.out.println(b1.score);
       // canvas.getChildren().add(b1.s);
     //  x=2;
    //    x=4;
     //  x=1;
       System.out.println(x);
        if(x==1 || x==2){
            int u=r.nextInt(100);
           t1.c1.relocate(u+1000,b1.b2.getLayoutY()%800 + 200);
           t1.l.relocate(u+1010,b1.b2.getLayoutY()%800 + 200);
            //canvas.getChildren().addAll(t1.as);
           // boolean b=false;
           
            t1.move1(sn,canvas,h);
            //canvas.getChildren().remove(l);
        }
     /*   else if(x==3){
         //   System.out.println(m.mag);
            
            if(m.mag==true){
                final boolean k=true;
                t1.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%800 + 200);
            //canvas.getChildren().addAll(t1.as);
            t1.move1(sn,canvas,h);
         //   System.out.println("hi");
         //   m.mag=false;
            }
            else{
                m.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%700 + 200);
            m.move1(canvas,sn,h);
            }
           //  m.move1(sn, canvas, h);
        }*/
        else if(x==4){
             sh.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%600 + 200);
            sh.move1(canvas,sn,h);
            
        }
    //    else if(x==5){
            //db.move1(sn, canvas, h);
      //  }
        else{
            Random r9=new Random();
            
          //  System.out.println("fuck"+sn.al.size());
           b1. b1.setLayoutX(500);b1.b1.setLayoutY(0);
		    		b1.l1.setTranslateX(0);b1.l1.setTranslateY(15);
		    		b1.l1.setText(Integer.toString(r9.nextInt(50)));
		    		b1.b2.setLayoutX(700);b1.b2.setLayoutY(0);
		    		b1.l2.setTranslateX(0);b1.l2.setTranslateY(15);
		    		b1.l2.setText(Integer.toString(r9.nextInt(50)));
		    		b1.b3.setLayoutX(900);b1.b3.setLayoutY(0);
		    		b1.l3.setTranslateX(0);b1.l3.setTranslateY(15);
		    		b1.l3.setText(Integer.toString(3));
		    		b1.b4.setLayoutX(1100);b1.b4.setLayoutY(0);
		    		b1.l4.setTranslateX(0);b1.l4.setTranslateY(15);
		    		b1.l4.setText(Integer.toString(r9.nextInt(sn.al.size())));
                               // canvas.getChildren().add(b1.b3);
        //    System.out.println(b1.al.size());
            b1.move(sn,canvas,stage,h,sh.bl,score,db.bl);
        }
    }
    void increasescore(int x){
        score+=x;
    }
}
