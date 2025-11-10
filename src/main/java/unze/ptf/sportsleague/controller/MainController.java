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
        System.out.println("[v0] Loading teams...");
        var teams = teamService.getAllTeams();
        System.out.println("[v0] Found " + teams.size() + " teams");
        model.addAttribute("teams", teams);
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
        System.out.println("[v0] Loading players...");
        var players = playerService.getAllPlayers();
        System.out.println("[v0] Found " + players.size() + " players");
        model.addAttribute("players", players);
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
        System.out.println("[v0] Loading coaches...");
        var coaches = coachService.getAllCoaches();
        System.out.println("[v0] Found " + coaches.size() + " coaches");
        model.addAttribute("coaches", coaches);
        model.addAttribute("coach", null);
        model.addAttribute("teams", teamService.getAllTeams());
        return "coaches";
    }

    @GetMapping("/coaches/new")
    public String newCoach(Model model) {
        model.addAttribute("coach", new Coach());
        model.addAttribute("coaches", coachService.getAllCoaches());
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
