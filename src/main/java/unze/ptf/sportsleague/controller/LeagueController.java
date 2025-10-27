package unze.ptf.sportsleague.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unze.ptf.sportsleague.data.LeagueData;
import unze.ptf.sportsleague.model.Player;
import unze.ptf.sportsleague.model.Team;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LeagueController {

    @GetMapping("/")
    public String home() {
        return "redirect:/teams";
    }

    // Ruta za prikaz svih timova
    @GetMapping("/teams")
    public String showTeams(Model model) {
        model.addAttribute("teams", LeagueData.getTeams());
        return "teams";
    }

    // Ruta za prikaz svih igrača
    @GetMapping("/players")
    public String showPlayers(@RequestParam(required = false) String position, Model model) {
        List<Player> allPlayers = LeagueData.getPlayers();
        List<Player> filteredPlayers;

        // Filter players by position if parameter is provided
        if (position != null && !position.isEmpty()) {
            filteredPlayers = allPlayers.stream()
                    .filter(player -> player.getPosition().equals(position))
                    .collect(Collectors.toList());
        } else {
            filteredPlayers = allPlayers;
        }

        // Get all unique positions for filter buttons
        List<String> positions = allPlayers.stream()
                .map(Player::getPosition)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        model.addAttribute("players", filteredPlayers);
        model.addAttribute("teams", LeagueData.getTeams());
        model.addAttribute("positions", positions);
        model.addAttribute("selectedPosition", position);
        return "players";
    }

    // Ruta za prikaz roster-a tima (akcija)
    @GetMapping("/teams/roster/{id}")
    public String showTeamRoster(@PathVariable Long id, Model model) {
        Team team = LeagueData.getTeamById(id);
        if (team != null) {
            model.addAttribute("team", team);
            model.addAttribute("players", LeagueData.getPlayersByTeamId(id));
        }
        return "roster";
    }

    // POST ruta za promociju tima (dodavanje pobjede)
    @PostMapping("/teams/promote/{id}")
    public String promoteTeam(@PathVariable Long id, Model model) {
        Team team = LeagueData.getTeamById(id);
        if (team != null) {
            team.setWins(team.getWins() + 1);
            model.addAttribute("team", team);
            model.addAttribute("message", "Tim " + team.getName() + " je promovisan! Nova pobjeda dodana.");
            model.addAttribute("players", LeagueData.getPlayersByTeamId(id));
        }
        return "roster";
    }
    // POST ruta za dodavanje poraza timu
    @PostMapping("/teams/lose/{id}")
    public String addLossToTeam(@PathVariable Long id, Model model) {
        Team team = LeagueData.getTeamById(id);
        if (team != null) {
            team.setLosses(team.getLosses() + 1);
            model.addAttribute("team", team);
            model.addAttribute("message", "Tim " + team.getName() + " je zabilježio novi poraz.");
            model.addAttribute("players", LeagueData.getPlayersByTeamId(id));
        }
        return "roster";
    }

}
