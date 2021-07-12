package cz.kostka.farnitabor.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dkostka on 7/8/2021.
 */
@Table
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String fullName;
    @Enumerated
    @Column(name = "groupie")
    private Group group;
    @ManyToMany
    @JoinTable(name = "member_place", joinColumns = @JoinColumn(name = "member_id"))
    private Set<Place> foundPlaces = new HashSet<>();

    public Member(final String fullName, final Group group, final Set<Place> foundPlaces) {
        this.fullName = fullName;
        this.group = group;
        this.foundPlaces = foundPlaces != null ? foundPlaces : Collections.emptySet();
    }

    public Member() {
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

    public Set<Place> getFoundPlaces() {
        return foundPlaces;
    }

    public void setFoundPlaces(final Set<Place> foundPlaces) {
        this.foundPlaces = foundPlaces;
    }
}
