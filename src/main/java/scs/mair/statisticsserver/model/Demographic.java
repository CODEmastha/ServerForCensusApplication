package scs.mair.statisticsserver.model;

public class Demographic {
    private int population;
    private String gender;
    private String ethnicity;
    private String age;

    public Demographic(int population, String gender, String ethnicity, String age) {
        this.population = population;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.age = age;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
