package martinez_bethsua_project.pkg05.CustomComponents;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import martinez_bethsua_project.pkg05.DataTypes.ParkingTicketCitation;

/**
 *
 * @author bethsua martinez
 */
public class CitationInputPane extends GridPane {

    
    //citation panel where Labels and Textfield are declared for the central part of Border Pane on CitationView
    private Label citations = new Label("Parking Citation");
    private Label licenseN = new Label("License No.");
    private Label state = new Label("State");
    private Label permitN = new Label("Permit No.");
    private Label vehicleModel = new Label("Vehicle Make/Model");
    private Label vehicleColor = new Label("Color");
    private Label violationType = new Label();
    private Label date = new Label("Date:");
    private Label time = new Label("Time:");
    private Label location = new Label("Location:");
    private Label issuedBy = new Label("Issued By:");
    private Label paidLabel = new Label("");
    private Label citationNum = new Label("Citation ID");

    private TextField btnOther = new TextField();
    private TextField licenseNTF = new TextField();
    private TextField stateTF = new TextField();
    private TextField permitNFT = new TextField();
    private TextField vehicleModelTF = new TextField();
    private TextField vehicleColorTF = new TextField();
    private TextField violationTypeTF = new TextField();
    private TextField dateTF = new TextField();
    private TextField timeTF = new TextField();
    private TextField locationTF = new TextField();
    private TextField issuedByTF = new TextField();
    private TextField citationNumTF = new TextField();

    
    //check boxes for the options on violation Type
    private CheckBox ck1 = new CheckBox("Vehicle has No Parking Permit");
    private CheckBox ck2 = new CheckBox("Parked in No Parking Area/Space");
    private CheckBox ck3 = new CheckBox("Parked in Fire Lane");
    private CheckBox ck4 = new CheckBox("Parked in Handicap Space");
    private CheckBox ck5 = new CheckBox("Parked in Reserved or Assigned Space");
    private CheckBox ck6 = new CheckBox("Blocking Driveway, Access, or Other Vehicle");
    private CheckBox ck7 = new CheckBox("Parked in Two Spaces");
    private CheckBox ck8 = new CheckBox("Expired Meter");
    private CheckBox ck9 = new CheckBox("Other");
    private boolean paidStatus = false;

    ArrayList<CheckBox> checkboxes = new ArrayList<>();

    public ParkingTicketCitation getTicketCitation() {
        return new ParkingTicketCitation( Integer.parseInt(citationNumTF.getText()), licenseNTF.getText(), stateTF.getText(), permitNFT.getText(), vehicleModelTF.getText(), vehicleColorTF.getText(), getInfractions(), dateTF.getText(), timeTF.getText(), locationTF.getText(), issuedByTF.getText(), violationTypeTF.getText(), false);
    }

    public boolean getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean status) {
        paidStatus = status;
    }

    
    public CitationInputPane() {

        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();
        VBox vbox4 = new VBox();
        VBox vbox5 = new VBox();
        VBox vbox6 = new VBox();
        VBox vbox7 = new VBox();

        VBox hbox1 = new VBox();
        VBox hbox2 = new VBox();
        HBox hbox3 = new HBox();
        hbox3.getChildren().addAll(ck9, violationTypeTF);

        vbox1.getChildren().addAll(licenseN, licenseNTF);

        vbox2.getChildren().addAll(state, stateTF);
        vbox3.getChildren().addAll(permitN, permitNFT);
        vbox4.getChildren().addAll(vehicleModel, vehicleModelTF);
        vbox5.getChildren().addAll(vehicleColor, vehicleColorTF);
        vbox7.getChildren().addAll(citationNum, citationNumTF);

        checkboxes.add(ck1);
        checkboxes.add(ck2);
        checkboxes.add(ck3);
        checkboxes.add(ck4);
        checkboxes.add(ck5);
        checkboxes.add(ck6);
        checkboxes.add(ck7);
        checkboxes.add(ck8);
        checkboxes.add(ck9);

        vbox6.getChildren().addAll(ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, hbox3);

        hbox1.getChildren().addAll(date, dateTF, location, locationTF);
        hbox2.getChildren().addAll(time, timeTF, issuedBy, issuedByTF);

        this.citations.setFont(Font.font("Times New Roman", 30));

        HBox pbox = new HBox();
        pbox.setPadding(new Insets(10));
        pbox.setSpacing(4);

        pbox.getChildren().addAll(new Label("Paid Status:"), paidLabel);

        this.addRow(0, citations, pbox);
        this.addRow(1, vbox1, vbox2, vbox3);
        this.addRow(2, vbox4, vbox5, vbox7);
        this.addRow(3, vbox6);
        this.addRow(4, hbox1);
        this.addRow(5, hbox2);
    }

    /**
     * @return the citations
     */
    public Label getCitations() {
        return citations;
    }

    /**
     * @param citations the citations to set
     */
    public void setCitations(Label citations) {
        this.citations = citations;
    }

    /**
     * @return the licenseN
     */
    public Label getLicenseN() {
        return licenseN;
    }

    /**
     * @param licenseN the licenseN to set
     */
    public void setLicenseN(Label licenseN) {
        this.licenseN = licenseN;
    }

    /**
     * @return the state
     */
    public Label getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Label state) {
        this.state = state;
    }

    /**
     * @return the permitN
     */
    public Label getPermitN() {
        return permitN;
    }

    /**
     * @param permitN the permitN to set
     */
    public void setPermitN(Label permitN) {
        this.permitN = permitN;
    }

    /**
     * @return the vehicleModel
     */
    public Label getVehicleModel() {
        return vehicleModel;
    }

    /**
     * @param vehicleModel the vehicleModel to set
     */
    public void setVehicleModel(Label vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * @return the vehicleColor
     */
    public Label getVehicleColor() {
        return vehicleColor;
    }

    /**
     * @param vehicleColor the vehicleColor to set
     */
    public void setVehicleColor(Label vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * @return the violationType
     */
    public Label getViolationType() {
        return violationType;
    }

    /**
     * @param violationType the violationType to set
     */
    public void setViolationType(Label violationType) {
        this.violationType = violationType;
    }

    /**
     * @return the date
     */
    public Label getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Label date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public Label getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Label time) {
        this.time = time;
    }

    /**
     * @return the location
     */
    public Label getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Label location) {
        this.location = location;
    }

    /**
     * @return the issuedBy
     */
    public Label getIssuedBy() {
        return issuedBy;
    }

    /**
     * @param issuedBy the issuedBy to set
     */
    public void setIssuedBy(Label issuedBy) {
        this.issuedBy = issuedBy;
    }

    /**
     * @return the licenseNTF
     */
    public TextField getLicenseNTF() {
        return licenseNTF;
    }

    /**
     * @param licenseNTF the licenseNTF to set
     */
    public void setLicenseNTF(TextField licenseNTF) {
        this.licenseNTF = licenseNTF;
    }

    /**
     * @return the stateTF
     */
    public TextField getStateTF() {
        return stateTF;
    }

    /**
     * @param stateTF the stateTF to set
     */
    public void setStateTF(TextField stateTF) {
        this.stateTF = stateTF;
    }

    /**
     * @return the permitNFT
     */
    public TextField getPermitNFT() {
        return permitNFT;
    }

    /**
     * @param permitNFT the permitNFT to set
     */
    public void setPermitNFT(TextField permitNFT) {
        this.permitNFT = permitNFT;
    }

    /**
     * @return the vehicleModelTF
     */
    public TextField getVehicleModelTF() {
        return vehicleModelTF;
    }

    /**
     * @param vehicleModelTF the vehicleModelTF to set
     */
    public void setVehicleModelTF(TextField vehicleModelTF) {
        this.vehicleModelTF = vehicleModelTF;
    }

    /**
     * @return the vehicleColorTF
     */
    public TextField getVehicleColorTF() {
        return vehicleColorTF;
    }

    /**
     * @param vehicleColorTF the vehicleColorTF to set
     */
    public void setVehicleColorTF(TextField vehicleColorTF) {
        this.vehicleColorTF = vehicleColorTF;
    }

    /**
     * @return the violationTypeTF
     */
    public TextField getViolationTypeTF() {
        return violationTypeTF;
    }

    /**
     * @param violationTypeTF the violationTypeTF to set
     */
    public void setViolationTypeTF(TextField violationTypeTF) {
        this.violationTypeTF = violationTypeTF;
    }

    /**
     * @return the dateTF
     */
    public TextField getDateTF() {
        return dateTF;
    }

    /**
     * @param dateTF the dateTF to set
     */
    public void setDateTF(TextField dateTF) {
        this.dateTF = dateTF;
    }

    /**
     * @return the timeTF
     */
    public TextField getTimeTF() {
        return timeTF;
    }

    /**
     * @param timeTF the timeTF to set
     */
    public void setTimeTF(TextField timeTF) {
        this.timeTF = timeTF;
    }

    /**
     * @return the locationTF
     */
    public TextField getLocationTF() {
        return locationTF;
    }

    /**
     * @param locationTF the locationTF to set
     */
    public void setLocationTF(TextField locationTF) {
        this.locationTF = locationTF;
    }

    /**
     * @return the issuedByTF
     */
    public TextField getIssuedByTF() {
        return issuedByTF;
    }

    /**
     * @param issuedByTF the issuedByTF to set
     */
    public void setIssuedByTF(TextField issuedByTF) {
        this.issuedByTF = issuedByTF;
    }

    /**
     * @return the rb1
     */
    public CheckBox getRb1() {
        return ck1;
    }

    /**
     * @param rb1 the rb1 to set
     */
    public void setRb1(CheckBox rb1) {
        this.ck1 = rb1;
    }

    /**
     * @return the rb2
     */
    public CheckBox getRb2() {
        return ck2;
    }

    /**
     * @param rb2 the rb2 to set
     */
    public void setRb2(CheckBox rb2) {
        this.ck2 = rb2;
    }

    /**
     * @return the rb3
     */
    public CheckBox getRb3() {
        return ck3;
    }

    /**
     * @param rb3 the rb3 to set
     */
    public void setRb3(CheckBox rb3) {
        this.ck3 = rb3;
    }

    /**
     * @return the rb4
     */
    public CheckBox getRb4() {
        return ck4;
    }

    /**
     * @param rb4 the rb4 to set
     */
    public void setRb4(CheckBox rb4) {
        this.ck4 = rb4;
    }

    /**
     * @return the rb5
     */
    public CheckBox getRb5() {
        return ck5;
    }

    /**
     * @param rb5 the rb5 to set
     */
    public void setRb5(CheckBox rb5) {
        this.ck5 = rb5;
    }

    /**
     * @return the rb6
     */
    public CheckBox getRb6() {
        return ck6;
    }

    /**
     * @param rb6 the rb6 to set
     */
    public void setRb6(CheckBox rb6) {
        this.ck6 = rb6;
    }

    /**
     * @return the rb7
     */
    public CheckBox getRb7() {
        return ck7;
    }

    /**
     * @param rb7 the rb7 to set
     */
    public void setRb7(CheckBox rb7) {
        this.ck7 = rb7;
    }

    /**
     * @return the rb8
     */
    public CheckBox getRb8() {
        return ck8;
    }

    /**
     * @param rb8 the rb8 to set
     */
    public void setRb8(CheckBox rb8) {
        this.ck8 = rb8;
    }

    /**
     * @return the rb9
     */
    public CheckBox getRb9() {
        return ck9;
    }

    /**
     * @param rb9 the rb9 to set
     */
    public void setRb9(CheckBox rb9) {
        this.ck9 = rb9;
    }

    /**
     * @return the btnOther
     */
    public TextField getBtnOther() {
        return btnOther;
    }

    /**
     * @param btnOther the btnOther to set
     */
    public void setBtnOther(TextField btnOther) {
        this.btnOther = btnOther;
    }

    public void setFieldFromParkingTicket(ParkingTicketCitation citation) {

        this.licenseNTF.setText(citation.getLicenseN());
        this.stateTF.setText(citation.getState());
        this.permitNFT.setText(citation.getPermitN());
        this.vehicleModelTF.setText(citation.getVehicleModel());
        this.vehicleColorTF.setText(citation.getVehicleColor());
        this.violationTypeTF.setText(citation.getOtherViolation());
        this.dateTF.setText(citation.getDate());
        this.timeTF.setText(citation.getTime());
        this.locationTF.setText(citation.getLocation());
        this.issuedByTF.setText(citation.getIssuedBy());
        this.setPaidStatus(citation.Ispaid());

        if (getPaidStatus()) {
            paidLabel.setTextFill(Color.web("#00FF00"));
            paidLabel.setText("Paid");
        } else {

            paidLabel.setTextFill(Color.web("#FF0000"));
            paidLabel.setText("Unpaid");
        }

        for (int i = 0; i < this.checkboxes.size(); i++) {
            this.checkboxes.get(i).selectedProperty().set(false);
        }

        int[] inf = citation.getViolationType();
        for (int i = 0; i < inf.length; i++) {
            this.checkboxes.get(inf[i]).selectedProperty().set(true);
        }

    }

    public void clearFields() {
        this.licenseNTF.setText("");
        this.stateTF.setText("");
        this.permitNFT.setText("");
        this.vehicleModelTF.setText("");
        this.vehicleColorTF.setText("");
        this.violationTypeTF.setText("");
        this.dateTF.setText("");
        this.timeTF.setText("");
        this.locationTF.setText("");
        this.issuedByTF.setText("");
        this.btnOther.setText("");

        for (int i = 0; i < this.checkboxes.size(); i++) {
            this.checkboxes.get(i).selectedProperty().set(false);
        }
    }

    public int[] getInfractions() {
        String rw = "";
        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                rw += (i) + ",";
            }

        }

        if (rw.isEmpty()) {
            return new int[0];
        }

        rw = rw.substring(0, rw.length() - 1);

        String[] sinf = rw.split(",");
        int[] iinf = new int[sinf.length];

        for (int i = 0; i < sinf.length; i++) {
            iinf[i] = Integer.parseInt(sinf[i]);
        }

        return iinf;
    }

    public boolean validateFields() {
        if (this.licenseNTF.getText().isEmpty() || this.vehicleModelTF.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @return the citationNum
     */
    public Label getCitationNum() {
        return citationNum;
    }

    /**
     * @param citationNum the citationNum to set
     */
    public void setCitationNum(Label citationNum) {
        this.citationNum = citationNum;
    }

    /**
     * @return the citationNumTF
     */
    public TextField getCitationNumTF() {
        return citationNumTF;
    }

    /**
     * @param citationNumTF the citationNumTF to set
     */
    public void setCitationNumTF(TextField citationNumTF) {
        this.citationNumTF = citationNumTF;
    }

}
