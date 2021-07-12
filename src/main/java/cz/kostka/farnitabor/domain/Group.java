package cz.kostka.farnitabor.domain;

/**
 * Created by dkostka on 7/8/2021.
 */
public enum Group {
    RED("Červená"),
    GREEN("Zelená"),
    BLUE("Modrá"),
    YELLOW("Žlutá");

    private String czechColor;

    Group(final String czechColor) {
        this.czechColor = czechColor;
    }

    public String getCzechColor() {
        return czechColor;
    }

    public void setCzechColor(final String czechColor) {
        this.czechColor = czechColor;
    }
}
