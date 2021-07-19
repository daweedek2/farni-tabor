package cz.kostka.farnitabor.service;

import cz.kostka.farnitabor.domain.Group;
import cz.kostka.farnitabor.domain.Member;
import cz.kostka.farnitabor.dto.MemberDto;
import cz.kostka.farnitabor.repository.MemberRepository;
import cz.kostka.farnitabor.utils.MemberDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dkostka on 7/8/2021.
 */
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public List<Member> getAllByGroup(final Group group) {
        return memberRepository.findAllByGroup(group);
    }

    public Optional<Member> findByName(final String name) {
        return memberRepository.findAllByFullName(name);
    }

    public Member getById(final Long id) {
        return memberRepository.getOne(id);
    }

    public List<MemberDto> getAllMembersDtos() {
        return getAll().stream()
                .map(MemberDtoUtil::convertMemberToDto)
                .sorted(Comparator.comparing(MemberDto::getGroup))
                .collect(Collectors.toList());
    }

    public Member save(final Member member) {
        return memberRepository.save(member);
    }
}
