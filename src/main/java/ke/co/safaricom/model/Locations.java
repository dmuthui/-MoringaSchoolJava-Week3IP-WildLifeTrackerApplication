package ke.co.safaricom.model;

public class Locations {
    private Integer locations_id;
    private String zones_name;
    private String zones_descriptions;
    private String zones_quadrant;
    private String location_sightings;
    private Boolean deleted = false;

    public Locations(Integer locations_id, String zones_name, String zones_descriptions, String zones_quadrant, String location_sightings, Boolean deleted) {
        this.locations_id = locations_id;
        this.zones_name = zones_name;
        this.zones_descriptions = zones_descriptions;
        this.zones_quadrant = zones_quadrant;
        this.location_sightings = location_sightings;
        this.deleted = deleted;
    }

    public Integer getLocations_id() {
        return locations_id;
    }

    public void setLocations_id(Integer locations_id) {
        this.locations_id = locations_id;
    }

    public String getZones_name() {
        return zones_name;
    }

    public void setZones_name(String zones_name) {
        this.zones_name = zones_name;
    }

    public String getZones_descriptions() {
        return zones_descriptions;
    }

    public void setZones_descriptions(String zones_descriptions) {
        this.zones_descriptions = zones_descriptions;
    }

    public String getZones_quadrant() {
        return zones_quadrant;
    }

    public void setZones_quadrant(String zones_quadrant) {
        this.zones_quadrant = zones_quadrant;
    }

    public String getLocation_sightings() {
        return location_sightings;
    }

    public void setLocation_sightings(String location_sightings) {
        this.location_sightings = location_sightings;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locations_id=" + locations_id +
                ", zones_name='" + zones_name + '\'' +
                ", zones_descriptions='" + zones_descriptions + '\'' +
                ", zones_quadrant='" + zones_quadrant + '\'' +
                ", location_sightings='" + location_sightings + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
