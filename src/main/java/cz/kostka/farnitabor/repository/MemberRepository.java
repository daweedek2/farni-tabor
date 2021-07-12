package cz.kostka.farnitabor.repository;

import cz.kostka.farnitabor.domain.Group;
import cz.kostka.farnitabor.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by dkostka on 7/8/2021.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByGroup(final Group group);
    Optional<Member> findAllByFullName(final String name);
}
