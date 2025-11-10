package unze.ptf.sportsleague.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unze.ptf.sportsleague.model.Coach;
import unze.ptf.sportsleague.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoachService {

    private final CoachRepository coachRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public Optional<Coach> getCoachByName(String name) {
        return coachRepository.findByName(name);
    }

    public List<Coach> getCoachesByNationality(String nationality) {
        return coachRepository.findByNationality(nationality);
    }

    public List<Coach> getCoachesBySpecialization(String specialization) {
        return coachRepository.findBySpecialization(specialization);
    }

    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach updateCoach(Long id, Coach coachDetails) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach not found with id: " + id));

        coach.setName(coachDetails.getName());
        coach.setNationality(coachDetails.getNationality());
        coach.setAge(coachDetails.getAge());
        coach.setExperienceYears(coachDetails.getExperienceYears());
        coach.setSpecialization(coachDetails.getSpecialization());

        return coachRepository.save(coach);
    }

    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}
