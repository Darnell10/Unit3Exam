package org.pursuit.unit_03_assessment.model;

public class Planets {

    private String name;
    private Integer number;
    private String image;

    public Planets(String name, Integer number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}
