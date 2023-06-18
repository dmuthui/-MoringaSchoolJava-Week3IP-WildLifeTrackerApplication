package ke.co.safaricom.model;

public class Rangers { private Integer rangers_id;
    private String rangers_name;
    private String badge_number;
    private Integer rangers_contact;
    private String rangers_description;
    private String rangers_sightings;
    private Boolean deleted = false;

    public Rangers(Integer rangers_id, String rangers_name, String badge_number, Integer rangers_contact, String rangers_description, String rangers_sightings, Boolean deleted) {
        this.rangers_id = rangers_id;
        this.rangers_name = rangers_name;
        this.badge_number = badge_number;
        this.rangers_contact = rangers_contact;
        this.rangers_description = rangers_description;
        this.rangers_sightings = rangers_sightings;
        this.deleted = deleted;
    }

    public Integer getRangers_id() {
        return rangers_id;
    }

    public void setRangers_id(Integer rangers_id) {
        this.rangers_id = rangers_id;
    }

    public String getRangers_name() {
        return rangers_name;
    }

    public void setRangers_name(String rangers_name) {
        this.rangers_name = rangers_name;
    }

    public String getBadge_number() {
        return badge_number;
    }

    public void setBadge_number(String badge_number) {
        this.badge_number = badge_number;
    }

    public Integer getRangers_contact() {
        return rangers_contact;
    }

    public void setRangers_contact(Integer rangers_contact) {
        this.rangers_contact = rangers_contact;
    }

    public String getRangers_description() {
        return rangers_description;
    }

    public void setRangers_description(String rangers_description) {
        this.rangers_description = rangers_description;
    }

    public String getRangers_sightings() {
        return rangers_sightings;
    }

    public void setRangers_sightings(String rangers_sightings) {
        this.rangers_sightings = rangers_sightings;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Rangers{" +
                "rangers_id=" + rangers_id +
                ", rangers_name='" + rangers_name + '\'' +
                ", badge_number='" + badge_number + '\'' +
                ", rangers_contact=" + rangers_contact +
                ", rangers_description='" + rangers_description + '\'' +
                ", rangers_sightings='" + rangers_sightings + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
