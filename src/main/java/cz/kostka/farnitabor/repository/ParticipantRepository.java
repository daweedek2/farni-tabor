package cz.kostka.farnitabor.repository;

import cz.kostka.farnitabor.domain.Group;
import cz.kostka.farnitabor.domain.Participant;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by dkostka on 7/8/2021.
 */
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findAllByGroup(final Group group);
    Optional<Participant> findAllByFullName(final String name);
}
