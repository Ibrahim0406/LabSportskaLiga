package unze.ptf.sportsleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unze.ptf.sportsleague.model.Coach;
import unze.ptf.sportsleague.service.CoachService;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachRestController {

    private final CoachService coachService;

    @Autowired
    public CoachRestController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        return ResponseEntity.ok(coaches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<Coach>> getCoachesByNationality(@PathVariable String nationality) {
        List<Coach> coaches = coachService.getCoachesByNationality(nationality);
        return ResponseEntity.ok(coaches);
    }

    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach savedCoach = coachService.saveCoach(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoach);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        try {
            Coach updatedCoach = coachService.updateCoach(id, coachDetails);
            return ResponseEntity.ok(updatedCoach);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}
