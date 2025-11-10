package unze.ptf.sportsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unze.ptf.sportsleague.model.Coach;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByName(String name);
    List<Coach> findByNationality(String nationality);
    List<Coach> findBySpecialization(String specialization);
}
