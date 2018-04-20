/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import martinez_bethsua_project.pkg05.DataTypes.ParkingTicketCitation;

/**
 *
 * @author beths
 */
public class DatabaseCitationHelper {

    private static DatabaseCitationHelper instance = null;

    public static DatabaseCitationHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseCitationHelper();
        }

        return instance;
    }

    public ParkingTicketCitation getCitationById(String citationId) {

        MysqlConnect database = MysqlConnect.getDbCon();

        try {
            ResultSet rs;
            rs = database.query(String.format("select * from citation where id = '%s';", citationId));

            while (rs.next()) {
                int id = rs.getInt("id"); 
                ParkingTicketCitation citation = new ParkingTicketCitation(id, rs.getString("licenseNo"), rs.getString("state"), rs.getString("permitNo"), rs.getString("vehicleModel"), rs.getString("vehicleColor"), rs.getString("violationType").split(","), rs.getString("date"), rs.getString("time"), rs.getString("location"), rs.getString("issuedBy"), rs.getString("otherViolation"), rs.getBoolean("isPaid"));
                return citation;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCitationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<ParkingTicketCitation> getCitations() {
        ArrayList<ParkingTicketCitation> cit = new ArrayList<>();

        MysqlConnect database = MysqlConnect.getDbCon();

        try {
            ResultSet rs;
            rs = database.query("select * from citation;");

            while (rs.next()) {
                int id = rs.getInt("id");

                ParkingTicketCitation citation = new ParkingTicketCitation(id, rs.getString("licenseNo"), rs.getString("state"), rs.getString("permitNo"), rs.getString("vehicleModel"), rs.getString("vehicleColor"), rs.getString("violationType").split(","), rs.getString("date"), rs.getString("time"), rs.getString("location"), rs.getString("issuedBy"), rs.getString("otherViolation"), rs.getBoolean("isPaid"));
                cit.add(citation);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCitationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cit;
    }

    public int addCitation(ParkingTicketCitation citation) {

        try {
            MysqlConnect database = MysqlConnect.getDbCon();

            String sql = String.format("INSERT INTO citation (`id`, `licenseNo`, `state`, `permitNo`, `vehicleModel`, `vehicleColor`, `violationType`, `date`, `time`, `location`, `issuedBy`, `otherViolation`, `isPaid`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", citation.getId(), citation.getLicenseN(), citation.getState(), citation.getPermitN(), citation.getVehicleModel(),
                    citation.getVehicleColor(), citation.getViolationTypeString(), citation.getDate(), citation.getTime(),
                    citation.getLocation(), citation.getIssuedBy(), citation.getOtherViolation(), citation.Ispaid() == true ? "1" : "0");

            return database.insert(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCitationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void updateCitation(ParkingTicketCitation citation) {

        try {
            MysqlConnect database = MysqlConnect.getDbCon();

            String sql = String.format("UPDATE citation SET `licenseNo` = '%s', `state`= '%s', `permitNo`= '%s', `vehicleModel`= '%s', `vehicleColor`= '%s', `violationType`= '%s', `date`= '%s', `time`= '%s', `location`= '%s', `issuedBy`= '%s', `otherViolation`= '%s', `isPaid`= '%s' WHERE `id` = '%s'", citation.getLicenseN(), citation.getState(), citation.getPermitN(), citation.getVehicleModel(),
                    citation.getVehicleColor(), citation.getViolationTypeString(), citation.getDate(), citation.getTime(),
                    citation.getLocation(), citation.getIssuedBy(), citation.getOtherViolation(), citation.Ispaid() == true ? "1" : "0", citation.getId());

            database.insert(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseCitationHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean containCitation(String citationNumb) {

        return getCitationById(citationNumb) != null;
    }
}
