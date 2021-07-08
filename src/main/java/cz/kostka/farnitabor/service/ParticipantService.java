package cz.kostka.farnitabor.service;

import cz.kostka.farnitabor.domain.Group;
import cz.kostka.farnitabor.domain.Participant;
import cz.kostka.farnitabor.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by dkostka on 7/8/2021.
 */
@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(final ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    public List<Participant> getAllByGroup(final Group group) {
        return participantRepository.findAllByGroup(group);
    }

    public Optional<Participant> findByName(final String name) {
        return participantRepository.findAllByFullName(name);
    }
}
