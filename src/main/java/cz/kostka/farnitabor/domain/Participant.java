package cz.kostka.farnitabor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dkostka on 7/8/2021.
 */
@Table
@Entity
public class Participant {
    @Id
    private Long id;
    @Column
    private String fullName;
    @Enumerated
    @Column
    private Group group;

    public Participant(final String fullName, final Group group) {
        this.fullName = fullName;
        this.group = group;
    }

    public Participant() {
        // empty constructor
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }
}
