
package martinez_bethsua_project.pkg05;

import java.sql.SQLException;
import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.stage.Stage;
import martinez_bethsua_project.pkg05.MVC.CitationController;
import martinez_bethsua_project.pkg05.MVC.CitationModelDatabase;
import martinez_bethsua_project.pkg05.MVC.CitationView;

/**
 *
 * @author bethsua martinez
 */
public class Martinez_Bethsua_Project05 extends Application {

    
    @Override
    public void start(Stage primaryStage)throws SQLException {
        
        //MVC 
        CitationView citationView = new CitationView();
       
        CitationModelDatabase citationModel = CitationModelDatabase.restore(); 
        
        CitationController citationController = new CitationController(citationView, citationModel);

        Scene scene = new Scene(citationView, 1200, 600);

        primaryStage.setTitle("Parking Citations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
