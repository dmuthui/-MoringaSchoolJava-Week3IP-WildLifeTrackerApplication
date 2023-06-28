package ke.co.safaricom.model;


import java.time.LocalDateTime;
import java.util.Date;

public class Sightings {
    private Integer sighting_id;
    private String animal_category;
    private String animal_name;
    private String location;
    private String rangers_name;
    private Date sighting_time;
    private Boolean deleted = false;

    public Sightings(Integer sighting_id, String animal_category, String animal_name, String location, String rangers_name, Date sighting_time, Boolean deleted) {
        this.sighting_id = sighting_id;
        this.animal_category = animal_category;
        this.animal_name = animal_name;
        this.location = location;
        this.rangers_name = rangers_name;
        this.sighting_time = sighting_time;
        this.deleted = deleted;
    }

    public Integer getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(Integer sighting_id) {
        this.sighting_id = sighting_id;
    }

    public String getAnimal_category() {
        return animal_category;
    }

    public void setAnimal_category(String animal_category) {
        this.animal_category = animal_category;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangers_name() {
        return rangers_name;
    }

    public void setRangers_name(String rangers_name) {
        this.rangers_name = rangers_name;
    }

    public Date getSighting_time() {
        return sighting_time;
    }

    public void setSighting_time(Date sighting_time) {
        this.sighting_time = sighting_time;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Sightings{" +
                "sighting_id=" + sighting_id +
                ", animal_category='" + animal_category + '\'' +
                ", animal_name='" + animal_name + '\'' +
                ", location='" + location + '\'' +
                ", rangers_name='" + rangers_name + '\'' +
                ", sighting_time=" + sighting_time +
                ", deleted=" + deleted +
                '}';
    }
}