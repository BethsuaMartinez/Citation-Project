
package martinez_bethsua_project.pkg05.MVC;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import martinez_bethsua_project.pkg05.CustomComponents.CitationInputPane;
import martinez_bethsua_project.pkg05.DataTypes.ParkingTicketCitation;

/**
 *
 * @author bethsua martinez
 */
public class CitationView extends BorderPane {

    CitationInputPane form = new CitationInputPane();

    Button showCurr = new Button("Show Current");
    Button clearBtn = new Button("Clear Fields");
    Button submit = new Button("Add Citation");
    Button right = new Button(">>");
    Button modify = new Button("Update Citation");
    Button left = new Button("<<");
    Button paidBtn = new Button("Mark Current Citation As Paid");
    Button exit = new Button("Exit");
    VBox options = new VBox();
    Label info = new Label("\nPAYMENTS\nPayments can be made in the following office:"
            + "\nBussiness Offic, Tandy 107\nMonday thru Friday 8:00 am-5:00 pm\n"
            + "$25 per citation, other fees may apply\n$100 for boot removal\n"
            + "\nPayments can be mailed to the following address:\n"
            + "\nTSC\nC/O Finance Dept\nAttn: Parking Enforcement\n80FFort Brown\n"
            + "Brownsville, TX 78520\n\nDO NOT MAIL CASH!\n\nFor more informationon "
            + "parking citations please visit:\nwww.tsc.edu/parking\n");
    Label info2 = new Label("This Vehicle's description has been permanently recorded.\nAny additional infraction "
            + "of our regulations may result in \nbooting or towing at vehicle owner's expense and\nrevocation of parking privileges.");

    public CitationView() {

        options.setSpacing(10);
        HBox firstCol = new HBox();
        firstCol.getChildren().addAll(submit, clearBtn, showCurr);
        firstCol.setSpacing(4);

        HBox move = new HBox();
        move.getChildren().addAll(left, modify, right);
        move.setSpacing(4);

        options.getChildren().addAll(firstCol, move, paidBtn, exit);
        options.spacingProperty();
        options.setPadding(new Insets(10, 10, 10, 10));

        form.setPadding(new Insets(0, 20, 40, 20));

        this.setRight(info);
        this.setCenter(form);
        this.setLeft(options);
        this.setBottom(info2);
    }

    Button getExitBtn() {
        return exit;
    }

    Button getAddBtn() {
        return submit;
    }

    ParkingTicketCitation genetateCitationFromFields() {
        ParkingTicketCitation cit = form.getTicketCitation();
        form.clearFields();
        return cit;
    }

    Button getNextCitationBtn() {
        return right;

    }

    void setCitationField(ParkingTicketCitation citation) {
        form.setFieldFromParkingTicket(citation);
    }

    Button getPrevCitationBtn() {
        return left;
    }

    Button getClearBtn() {
        return clearBtn;
    }

    Button getUpdateBtn() {
        return modify;
    }

    Button getshowCurrentBtn() {
        return showCurr;
    }

    boolean isAvalidCitation() {
        return this.form.validateFields();
    }
    
    Button getPaidBtn()
    {
        return paidBtn;
    }
}
