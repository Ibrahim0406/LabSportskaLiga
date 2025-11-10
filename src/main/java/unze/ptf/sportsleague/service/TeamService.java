package unze.ptf.sportsleague.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unze.ptf.sportsleague.model.Team;
import unze.ptf.sportsleague.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Optional<Team> getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> getTeamsByCity(String city) {
        return teamRepository.findByCity(city);
    }

    public List<Team> getTeamsByCoach(Long coachId) {
        return teamRepository.findByCoachId(coachId);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + id));

        team.setName(teamDetails.getName());
        team.setCity(teamDetails.getCity());
        team.setFounded(teamDetails.getFounded());
        team.setStadium(teamDetails.getStadium());
        team.setCoach(teamDetails.getCoach());

        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
