package unze.ptf.sportsleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unze.ptf.sportsleague.model.Coach;
import unze.ptf.sportsleague.model.Player;
import unze.ptf.sportsleague.model.Team;
import unze.ptf.sportsleague.service.CoachService;
import unze.ptf.sportsleague.service.PlayerService;
import unze.ptf.sportsleague.service.TeamService;

@Controller
public class MainController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private CoachService coachService;

    // Team routes
    @GetMapping("/teams")
    public String showTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @PostMapping("/teams")
    public String addTeam(@ModelAttribute Team team) {
        teamService.saveTeam(team);
        return "redirect:/teams";
    }

    // Player routes
    @GetMapping("/players")
    public String showPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }

    @PostMapping("/players")
    public String addPlayer(@ModelAttribute Player player) {
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    // Roster routes
    @GetMapping("/roster/{teamId}")
    public String showRoster(@PathVariable Long teamId, Model model) {
        Team team = teamService.getTeamById(teamId).orElse(null);
        if (team != null) {
            model.addAttribute("team", team);
            model.addAttribute("players", playerService.getPlayersByTeam(teamId));
        }
        return "roster";
    }

    // Coach routes
    @GetMapping("/coaches")
    public String showCoaches(Model model) {
        model.addAttribute("coaches", coachService.getAllCoaches());
        model.addAttribute("coach", new Coach());
        model.addAttribute("teams", teamService.getAllTeams());
        return "coaches";
    }

    @PostMapping("/coaches")
    public String addCoach(@ModelAttribute Coach coach) {
        coachService.saveCoach(coach);
        return "redirect:/coaches";
    }

    @GetMapping("/coaches/edit/{id}")
    public String editCoach(@PathVariable Long id, Model model) {
        Coach coach = coachService.getCoachById(id).orElse(null);
        if (coach != null) {
            model.addAttribute("coach", coach);
            model.addAttribute("coaches", coachService.getAllCoaches());
            model.addAttribute("teams", teamService.getAllTeams());
            model.addAttribute("editMode", true);
        }
        return "coaches";
    }

    @PostMapping("/coaches/update/{id}")
    public String updateCoach(@PathVariable Long id, @ModelAttribute Coach coachDetails) {
        coachService.updateCoach(id, coachDetails);
        return "redirect:/coaches";
    }

    @GetMapping("/coaches/delete/{id}")
    public String deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return "redirect:/coaches";
    }
}
