package cz.kostka.farnitabor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dkostka on 7/8/2021.
 */
@Table
@Entity
public class Place {
    @Id
    private Long id;
    @Column
    private String code;

    public Place() {
    }

    public Place(final String code) {
        this.code = code;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}
