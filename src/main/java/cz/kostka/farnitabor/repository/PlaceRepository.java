package cz.kostka.farnitabor.repository;

import cz.kostka.farnitabor.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dkostka on 7/8/2021.
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
