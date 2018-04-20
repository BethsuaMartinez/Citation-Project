package martinez_bethsua_project.pkg05.MVC;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import martinez_bethsua_project.pkg05.DataTypes.ParkingTicketCitation;

/**
 *
 * @author beths
 */
public class CitationController {

    CitationView citationView;
    CitationModelDatabase citationModel;

    public CitationController(CitationView citationView, CitationModelDatabase citationModel) {
        this.citationView = citationView;
        this.citationModel = citationModel;

        attachHandlers();
    }

    private void showMessage(String heading, String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(heading);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Handlers for buttons declared on the model 
    private void attachHandlers() {

        citationView.getPaidBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ParkingTicketCitation cit = citationModel.getCurrentTicket();
                if (cit != null) {
                    if (!cit.Ispaid()) {
                        cit.setIspaid(true); // is paid
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("The Current Citation Status");
                        alert.setHeaderText("Paid Status");
                        alert.setContentText("The Current Citation had already been paid!");
                        alert.showAndWait();
                        return;
                    }
                    citationModel.upateCurrentCitation(cit);
                   citationView.setCitationField(cit);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Citation Retrieve Error");
                    alert.setHeaderText("No Citations in Database");
                    alert.setContentText("Please Add Citations!");
                    alert.showAndWait();
                }
            }
        });

        citationView.getUpdateBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ParkingTicketCitation cit = citationView.genetateCitationFromFields();
                 cit.setId(citationModel.getCurrentTicket().getId());
                 cit.setIspaid(citationModel.getCurrentTicket().Ispaid());
                if (citationModel.upateCurrentCitation(citationView.genetateCitationFromFields())) {
                    showMessage("Update Status", "Current Citation Status Update", "Current Citation Has Been Updated");
                } else {
                    showMessage("Citation Retrieve Error", "No Citations in Database", "Please Add Citations, Before trying to update!");
                }
            }
        });

        citationView.getClearBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                citationView.form.clearFields();
            }
        });

        citationView.getshowCurrentBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ParkingTicketCitation cit = citationModel.getCurrentTicket();
                if (cit != null) {
                    citationView.setCitationField(cit);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Citation Retrieve Error");
                    alert.setHeaderText("No Citations in Database");
                    alert.setContentText("Please Add Citations!");
                    alert.showAndWait();
                }
            }
        });

        citationView.getNextCitationBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ParkingTicketCitation cit = citationModel.getNextCition();
                if (cit != null) {
                    citationView.setCitationField(cit);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Citation Retrieve Error");
                    alert.setHeaderText("No Citations in Database");
                    alert.setContentText("Please Add Citations!");
                    alert.showAndWait();
                }
            }
        });

        citationView.getPrevCitationBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ParkingTicketCitation cit = citationModel.getPrevCition();
                if (cit != null) {
                    citationView.setCitationField(cit);
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Citation Retrieve Error");
                    alert.setHeaderText("No Citations of Database");
                    alert.setContentText("Please Add Citations!");
                    alert.showAndWait();
                }
            }
        });

        citationView.getAddBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (citationView.isAvalidCitation()) {
                    ParkingTicketCitation generatedCit = citationView.genetateCitationFromFields();
                    citationModel.addCitation(generatedCit);
                } else {
                    showMessage("Citation Form Error", "Citation Form Missing Fields or Duplicate Citation Number", "Please make sure Citation includes at least Citation Number is Unique!");
                }
            }

        });

        citationView.getExitBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
             //   try {
             //       citationModel.save("tickets.dat");
             //   } catch (IOException ex) {
             //       Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
             //   }
                
                
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            }

        });
    }

}
