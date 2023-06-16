package ke.co.safaricom.model;

public class RegularAnimal {
    private Integer regular_animal_id;
    private String animalName;
    private String health;
    private String age;
    private Boolean deleted = false;

    public RegularAnimal(Integer regular_animal_id, String animalName, String health, String age, Boolean deleted) {
        this.regular_animal_id = regular_animal_id;
        this.animalName = animalName;
        this.health = health;
        this.age = age;
        this.deleted = deleted;
    }

    public Integer getRegular_animal_id() {
        return regular_animal_id;
    }

    public void setRegular_animal_id(Integer regular_animal_id) {
        this.regular_animal_id = regular_animal_id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
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
        return "RegularAnimal{" +
                "regular_animal_id=" + regular_animal_id +
                ", animalName='" + animalName + '\'' +
                ", health='" + health + '\'' +
                ", age='" + age + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
