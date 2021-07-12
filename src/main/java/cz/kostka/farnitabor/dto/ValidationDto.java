package cz.kostka.farnitabor.dto;

/**
 * Created by dkostka on 7/8/2021.
 */
public class ValidationDto {
    private String name;
    private String code;

    public ValidationDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}
