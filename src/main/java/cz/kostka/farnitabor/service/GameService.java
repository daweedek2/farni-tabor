package cz.kostka.farnitabor.service;

import cz.kostka.farnitabor.domain.Member;
import cz.kostka.farnitabor.domain.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by dkostka on 7/8/2021.
 */
@Service
public class GameService {
    private final MemberService memberService;

    @Autowired
    public GameService(final MemberService memberService) {
        this.memberService = memberService;
    }

    public boolean validate(final Member member, final Place place) {
        if (member == null || place == null) {
            return false;
        }

        final Set<Place> memberPlaces = member.getFoundPlaces();

        memberPlaces.add(place);
        memberService.save(member);

        return true;
    }
}
