package martinez_bethsua_project.pkg05.MVC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import martinez_bethsua_project.pkg05.DataTypes.ParkingTicketCitation;

/**
 *
 * @author bethsua martinez
 */
public class CitationModel {

    ArrayList<ParkingTicketCitation> citationsDatabase;
    ParkingTicketCitation currentCitation;

    int indexCounter = 0;

    public CitationModel() {
        citationsDatabase = new ArrayList<>();
    }

    public CitationModel(ArrayList<ParkingTicketCitation> list) {
        citationsDatabase = list;
    }

    public void save(String path) throws FileNotFoundException, IOException {
        FileOutputStream fileOut
                = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(citationsDatabase);
        out.close();
        fileOut.close();
    }

    public static CitationModel restore(String path) {
        ArrayList<ParkingTicketCitation> e;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (ArrayList<ParkingTicketCitation>) in.readObject();
            in.close();
            fileIn.close();

            return new CitationModel(e);
        } catch (Exception i) {
            i.printStackTrace();
        }
        return new CitationModel();
    }

    //method to get next citation for next button
    public ParkingTicketCitation getNextCition() {
        if (this.citationsDatabase.isEmpty()) {
            return null;
        }
        //counter to get the index value of nextCitation
        indexCounter++;

        if (indexCounter >= this.citationsDatabase.size()) {
            indexCounter = 0;
        }

        ParkingTicketCitation cit = this.citationsDatabase.get(indexCounter);

        return cit;
    }

    //method to get previous citation for previous button
    public ParkingTicketCitation getPrevCition() {
        if (this.citationsDatabase.isEmpty()) {
            return null;
        }
        //counter to get the index value of previousCitation
        indexCounter--;

        if (indexCounter < 0) {
            indexCounter = this.citationsDatabase.size() - 1;
        }

        ParkingTicketCitation cit = this.citationsDatabase.get(indexCounter);

        return cit;
    }

    //method to add a a new citation to the database
    public void addCitation(ParkingTicketCitation citation) {
        citationsDatabase.add(citation);
    }

    public ParkingTicketCitation findCitationByLicense(String license) {
        for (int i = 0; i < this.citationsDatabase.size(); i++) {
            if (this.citationsDatabase.get(i).getLicenseN().toLowerCase().equals(license.toLowerCase())) {
                return this.citationsDatabase.get(i);
            }
        }
        return null;
    }

    public boolean upateCurrentCitation(ParkingTicketCitation citation) {
        if (this.citationsDatabase.isEmpty()) {
            return false;
        }

        this.citationsDatabase.set(indexCounter, citation);

        return true;
    }

    public ArrayList<ParkingTicketCitation> getAllCitations() {
        return citationsDatabase;
    }

    ParkingTicketCitation getCurrentTicket() {
        if (this.citationsDatabase.isEmpty()) {
            return null;
        }
        ParkingTicketCitation cit = this.citationsDatabase.get(indexCounter);

        return cit;
    }
}
