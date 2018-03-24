
package martinez_bethsua_project.pkg05.DataTypes;

import java.io.Serializable;

/**
 *
 * @author bethsua martinez
 */
public class ParkingTicketCitation implements Serializable {

  //Parking ticket citation that will be the type of array on citation Model 
    private String licenseN;
    private String state;
    private String permitN;
    private String vehicleModel;
    private String vehicleColor;
    private int[] violationType;
    private String date;
    private String time;
    private String location;
    private String issuedBy;
    private String otherViolation;
    private boolean ispaid;

    public ParkingTicketCitation(String licenseN, String state, String permitN, String vehicleModel,
            String vehicleColor, int[] violationType, String date, String time, String location, String issuedBy, String otherViolation, boolean ispaid) {
        this.licenseN = licenseN;
        this.state = state;
        this.permitN = permitN;
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.violationType = violationType;
        this.date = date;
        this.time = time;
        this.location = location;
        this.issuedBy = issuedBy;
        this.otherViolation = otherViolation;
        this.ispaid = ispaid;
    }

    /**
     * @return the getOtherViolation
     */
    public String getOtherViolation() {
        return this.otherViolation;
    }
    
    /**
     * @return the licenseN
     */
    public String getLicenseN() {
        return licenseN;
    }

    /**
     * @param licenseN the licenseN to set
     */
    public void setLicenseN(String licenseN) {
        this.licenseN = licenseN;
    }

    public boolean Ispaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }

    
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the permitN
     */
    public String getPermitN() {
        return permitN;
    }

    /**
     * @param permitN the permitN to set
     */
    public void setPermitN(String permitN) {
        this.permitN = permitN;
    }

    /**
     * @return the vehicleModel
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * @param vehicleModel the vehicleModel to set
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * @return the vehicleColor
     */
    public String getVehicleColor() {
        return vehicleColor;
    }

    /**
     * @param vehicleColor the vehicleColor to set
     */
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * @return the violationType
     */
    public int[] getViolationType() {
        return violationType;
    }

    /**
     * @param violationType the violationType to set
     */
    public void setViolationType(int[] violationType) {
        this.violationType = violationType;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the issuedBy
     */
    public String getIssuedBy() {
        return issuedBy;
    }

    /**
     * @param issuedBy the issuedBy to set
     */
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

}
