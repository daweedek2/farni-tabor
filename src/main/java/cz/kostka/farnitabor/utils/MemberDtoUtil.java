package cz.kostka.farnitabor.utils;

import cz.kostka.farnitabor.domain.Member;
import cz.kostka.farnitabor.dto.MemberDto;

/**
 * Created by dkostka on 7/11/2021.
 */
public class MemberDtoUtil {
    public static MemberDto convertMemberToDto(final Member member) {
        if (member == null) {
            return null;
        }

        final int foundPlaces = member.getFoundPlaces().size();
        return new MemberDto(member.getFullName(),foundPlaces, foundPlaces * 100 / 2, member.getGroup());
    }
}
