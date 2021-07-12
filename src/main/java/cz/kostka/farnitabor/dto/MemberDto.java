package cz.kostka.farnitabor.dto;

import cz.kostka.farnitabor.domain.Group;

/**
 * Created by dkostka on 7/8/2021.
 */
public class MemberDto {
    private String name;
    private int foundPlacesCount;
    private int progress;
    private Group group;

    public MemberDto(final String name, final int foundPlacesCount, final int progress, final Group group) {
        this.name = name;
        this.foundPlacesCount = foundPlacesCount;
        this.progress = progress;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getFoundPlacesCount() {
        return foundPlacesCount;
    }

    public void setFoundPlacesCount(final int foundPlacesCount) {
        this.foundPlacesCount = foundPlacesCount;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(final int progress) {
        this.progress = progress;
    }
}
