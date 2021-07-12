package cz.kostka.farnitabor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dkostka on 7/8/2021.
 */
@Table(name = "place")
@Entity
public class Place {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    private String coordinates;
    @ManyToMany(mappedBy = "foundPlaces")
    private Set<Member> members = new HashSet<>();

    public Place() {
    }

    public Place(final String name, final String code, final String coordinates, final Set<Member> members) {
        this.name = name;
        this.code = code;
        this.coordinates = coordinates;
        this.members = members;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(final String coordinates) {
        this.coordinates = coordinates;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(final Set<Member> members) {
        this.members = members;
    }
}
