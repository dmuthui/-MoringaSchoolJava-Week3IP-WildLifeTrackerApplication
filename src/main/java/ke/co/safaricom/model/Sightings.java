package ke.co.safaricom.model;

import java.time.LocalDateTime;

public class Sightings {
    private int sighting_id;
    private String animalCategory;
    private String animalName;
    private String location;
    private String rangersName;
    private LocalDateTime timestamp;
    private boolean deleted;

    public Sightings(int sighting_id, String animalCategory, String animalName, String location, String rangersName, LocalDateTime timestamp, boolean deleted) {
        this.sighting_id = sighting_id;
        this.animalCategory = animalCategory;
        this.animalName = animalName;
        this.location = location;
        this.rangersName = rangersName;
        this.timestamp = timestamp;
        this.deleted = deleted;
    }

    public int getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(int sighting_id) {
        this.sighting_id = sighting_id;
    }

    public String getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(String animalCategory) {
        this.animalCategory = animalCategory;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangersName() {
        return rangersName;
    }

    public void setRangersName(String rangersName) {
        this.rangersName = rangersName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Sightings{" +
                "sighting_id=" + sighting_id +
                ", animalCategory='" + animalCategory + '\'' +
                ", animalName='" + animalName + '\'' +
                ", location='" + location + '\'' +
                ", rangersName='" + rangersName + '\'' +
                ", timestamp=" + timestamp +
                ", deleted=" + deleted +
                '}';
    }
}
