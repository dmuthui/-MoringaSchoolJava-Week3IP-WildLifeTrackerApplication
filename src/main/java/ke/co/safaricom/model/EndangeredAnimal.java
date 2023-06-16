package ke.co.safaricom.model;

public class EndangeredAnimal {
    private Integer endangered_animal_id;
    private String endangeredAnimalName;
    private String health;
    private String age;
    private Boolean deleted = false;


    public EndangeredAnimal(Integer endangered_animal_id, String endangeredAnimalName, String health, String age, Boolean deleted) {
        this.endangered_animal_id = endangered_animal_id;
        this.endangeredAnimalName = endangeredAnimalName;
        this.health = health;
        this.age = age;
        this.deleted = deleted;
    }

    public Integer getEndangered_animal_id() {
        return endangered_animal_id;
    }

    public void setEndangered_animal_id(Integer endangered_animal_id) {
        this.endangered_animal_id = endangered_animal_id;
    }

    public String getEndangeredAnimalName() {
        return endangeredAnimalName;
    }

    public void setEndangeredAnimalName(String endangeredAnimalName) {
        this.endangeredAnimalName = endangeredAnimalName;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "EndangeredAnimal{" +
                "endangered_animal_id=" + endangered_animal_id +
                ", endangeredAnimalName='" + endangeredAnimalName + '\'' +
                ", health='" + health + '\'' +
                ", age='" + age + '\'' +
                ", deleted=" + deleted +
        '}';
    }
}
