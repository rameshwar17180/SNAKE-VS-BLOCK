/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<ANVIT SACHDEV 2017333><RAMESHWAR MISHRA 2017180>
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

/**
 *
 * @author anvit
 */
public class Instructions extends Application {
    
    @Override
    public void start(final Stage stage) throws IOException{
         Image image = new Image(new FileInputStream("C:\\Users\\anvit\\Documents\\NetBeansProjects\\snakeblockgame\\src\\snake.png"));
        ImageView imageView = new ImageView(image); 
        imageView.setX(0); 
      imageView.setY(0); 
      
      //setting the fit height and width of the image view 
      imageView.setFitHeight(1000); 
      imageView.setFitWidth(2000);
        final Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 2000, 900, Color.ALICEBLUE);
          Button btn = new Button();
          btn.setText("Back to Start Page");
           btn.relocate(1600,800);
           final strartpage sp=new strartpage();
           btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                try{
                sp.start(stage);
                }
                catch(Exception e){
                    
                }
            }
        });
       Text t=new Text("INSTRUCTIONS");
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
          t.setX(500);
          t.setY(100);
         Text t1=new Text("1. Grab laddus to increase your length. Snake's length will increase by the value\n  written on laddu.\n\n2.Destroy the blocks to increase your score. Snake's length would decrease by the\n  value written on block. If you destroy the block by the value more then your length,\n  your game will end.\n\n3.If you grab a shield you candestroy a block without decreasing your length\n\n4.Grab magnets to attract laddus. ");
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
          t1.setX(0);
          t1.setY(200);
      //  StackPane root = new StackPane();
          canvas.getChildren().add(imageView);
        canvas.getChildren().add(t);
          canvas.getChildren().add(t1); 
          canvas.getChildren().add(btn);
       // Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("Instructions");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
