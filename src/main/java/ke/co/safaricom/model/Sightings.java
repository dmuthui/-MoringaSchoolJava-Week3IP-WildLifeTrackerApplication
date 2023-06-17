package ke.co.safaricom.model;


public class Sightings {
    private int sighting_id;
    private String regularAnimal;
    private String endangeredAnimal;
    private String animalName;
    private String location;
    private String rangersName;
    private boolean deleted;

    public Sightings(int sighting_id, String regularAnimal, String endangeredAnimal, String animalName, String location, String rangersName, boolean deleted) {
        this.sighting_id = sighting_id;
        this.regularAnimal = regularAnimal;
        this.endangeredAnimal = endangeredAnimal;
        this.animalName = animalName;
        this.location = location;
        this.rangersName = rangersName;
        this.deleted = deleted;
    }

    public int getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(int sighting_id) {
        this.sighting_id = sighting_id;
    }

    public String getRegularAnimal() {
        return regularAnimal;
    }

    public void setRegularAnimal(String regularAnimal) {
        this.regularAnimal = regularAnimal;
    }

    public String getEndangeredAnimal() {
        return endangeredAnimal;
    }

    public void setEndangeredAnimal(String endangeredAnimal) {
        this.endangeredAnimal = endangeredAnimal;
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
                ", regularAnimal='" + regularAnimal + '\'' +
                ", endangeredAnimal='" + endangeredAnimal + '\'' +
                ", animalName='" + animalName + '\'' +
                ", location='" + location + '\'' +
                ", rangersName='" + rangersName + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
