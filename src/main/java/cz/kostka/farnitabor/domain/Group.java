package cz.kostka.farnitabor.domain;

/**
 * Created by dkostka on 7/8/2021.
 */
public enum Group {
    A("Modrá"),
    B("Zelená"),
    C("Červená"),
    D("Oranžová");

    private String colour;

    Group(final String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(final String colour) {
        this.colour = colour;
    }
}
