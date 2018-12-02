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

/**
 *
 * @author anvit
 */
public class strartpage extends Application {
    
    @Override
    public void start(final Stage stage) throws IOException {
        Image image = new Image(new FileInputStream("C:\\Users\\anvit\\Documents\\NetBeansProjects\\snakeblockgame\\src\\game.jpg"));
        ImageView imageView = new ImageView(image); 
        imageView.setX(0); 
      imageView.setY(0); 
      final game g=new game();
      final leaderboard lb=new leaderboard();
      final Instructions it=new Instructions();
      //setting the fit height and width of the image view 
      imageView.setFitHeight(1000); 
      imageView.setFitWidth(2000);
        final Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 2000, 900, Color.ALICEBLUE);
        Button btn = new Button();
        Button btn2 = new Button();
        Button btn3= new Button();
          Button btn4= new Button();
        btn.setText("Start Game");
        btn2.setText("Resume Game");
        btn3.setText("Leaderboard");
        btn4.setText("Instructions");
       btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                g.start(stage);
            }
        });
       btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                System.exit(0);
              //  g.start(stage);
            }
        });
       btn3.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                try{
                lb.start(stage);
                }
                catch(Exception e){
                    
                }
            }
        });
       btn4.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                try{
                it.start(stage);
                }
                catch(Exception e){
                    
                }
            }
        });
        StackPane root = new StackPane();
        btn.relocate(1000,300);
        btn2.relocate(1000,400);
        btn3.relocate(1000,500);
        btn4.relocate(1000,600);
        canvas.getChildren().add(imageView);
        canvas.getChildren().add(btn);
        canvas.getChildren().add(btn2);
        canvas.getChildren().add(btn3);
        canvas.getChildren().add(btn4);
      //  Scene scene = new Scene(canvas, 300, 250);
        
        stage.setTitle("Start Page");
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
