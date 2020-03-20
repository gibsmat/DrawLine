
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	public Boolean test =  true;
    public static void main(String[] args) {
        launch(args);
    }

    private double arrayStartX;
    private double arrayStartY;
    private AnchorPane root;
    private Polyline l;

    @Override
    public void start(Stage stage) {

        root = new AnchorPane();
        
       
        
        root.addEventHandler(MouseEvent.MOUSE_PRESSED, ev -> {
            arrayStartX = ev.getX();
            arrayStartY = ev.getY();

          
            
            System.out.println(ev.getTarget());

        });
        
        root.addEventHandler(MouseEvent.MOUSE_DRAGGED, ev -> {
        	 System.out.println(ev.getX()+ " "+ ev.getY());
        	 if(ev.getTarget() instanceof Polyline) {
        		 Polyline p= (Polyline)ev.getTarget();
        		  p.addEventHandler(MouseEvent.MOUSE_RELEASED, v -> {
                	  if (l == null) {
                          addLine(v.getX(), v.getY());
                      } else {
                      	
                      	
                      	l.getPoints().addAll(new Double[]{ev.getX(), ev.getY()});
                      
                        
                      }
                	  
                });
        
        	 }
        	 
        	 
        	 

        });
        
    
       

        root.addEventHandler(MouseEvent.MOUSE_RELEASED, ev -> {
        	  if (l == null) {
                  addLine(ev.getX(), ev.getY());
              } else {
              	
              	
              	l.getPoints().addAll(new Double[]{ev.getX(), ev.getY()});
              
              }
        	  
        });

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);

        stage.show();
    

    }
    

    private void addLine(double x, double y) {
        l = new Polyline(arrayStartX, arrayStartY,x, y);
        l.setStrokeWidth(5.0);
      
        root.getChildren().add(l);

    }
    
    
    
   


}
