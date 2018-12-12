package gr.teicm.ieee.madc.disasternotifierservice.dto.entity;

import gr.teicm.ieee.madc.disasternotifierservice.dto.embeddable.LocationDTO;

public class DisasterDTO extends BaseEntityDTO {

    private String disasterType;

    private LocationDTO disasterLocation;

    private LocationDTO safeLocation;

    private UserDTO creator;

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public LocationDTO getDisasterLocation() {
        return disasterLocation;
    }

    public void setDisasterLocation(LocationDTO disasterLocation) {
        this.disasterLocation = disasterLocation;
    }

    public LocationDTO getSafeLocation() {
        return safeLocation;
    }

    public void setSafeLocation(LocationDTO safeLocation) {
        this.safeLocation = safeLocation;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
