package cz.kostka.farnitabor.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkostka on 7/12/2021.
 */
public class OverviewDto {
    private int done;
    private List<MemberDto> members = new ArrayList<>();

    public OverviewDto(final int done, final List<MemberDto> members) {
        this.done = done;
        this.members = members;
    }

    public int getDone() {
        return done;
    }

    public void setDone(final int done) {
        this.done = done;
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(final List<MemberDto> members) {
        this.members = members;
    }
}
