package cz.kostka.farnitabor.service;

import cz.kostka.farnitabor.domain.Place;
import cz.kostka.farnitabor.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dkostka on 7/8/2021.
 */
@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(final PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAll() {
        return placeRepository.findAll();
    }
}
