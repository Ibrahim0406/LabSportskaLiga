package unze.ptf.sportsleague.data;

import unze.ptf.sportsleague.model.Player;
import unze.ptf.sportsleague.model.Team;

import java.util.ArrayList;
import java.util.List;

public class LeagueData {
    private static List<Team> teams = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

    static {
        // Kreiranje timova
        Team team1 = new Team(1L, "FK Sarajevo", "Sarajevo", 1946, "Stadion Asim Ferhatović Hase");
        Team team2 = new Team(2L, "FK Željezničar", "Sarajevo", 1921, "Stadion Grbavica");
        Team team3 = new Team(3L, "FK Zrinjski", "Mostar", 1905, "Stadion pod Bijelim Brijegom");
        Team team4 = new Team(4L, "FK Velež", "Mostar", 1922, "Stadion Rođeni");

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        // Kreiranje igrača za FK Sarajevo
        Player p1 = new Player(1L, "Edin Forto", "Golman", 1, 1L, 28);
        Player p2 = new Player(2L, "Amar Rahmanović", "Odbrambeni", 5, 1L, 25);
        Player p3 = new Player(3L, "Mirko Oremuš", "Vezni", 10, 1L, 30);
        Player p4 = new Player(4L, "Dal Varesanović", "Napadač", 9, 1L, 27);

        // Kreiranje igrača za FK Željezničar
        Player p5 = new Player(5L, "Josip Ćorluka", "Golman", 12, 2L, 26);
        Player p6 = new Player(6L, "Kenan Pirić", "Odbrambeni", 4, 2L, 29);
        Player p7 = new Player(7L, "Nemanja Bilbija", "Vezni", 7, 2L, 31);
        Player p8 = new Player(8L, "Ivan Lendrić", "Napadač", 11, 2L, 24);

        // Kreiranje igrača za FK Zrinjski
        Player p9 = new Player(9L, "Marko Marić", "Golman", 33, 3L, 32);
        Player p10 = new Player(10L, "Slobodan Jakovljević", "Odbrambeni", 6, 3L, 28);
        Player p11 = new Player(11L, "Nemanja Bilbija", "Vezni", 8, 3L, 26);
        Player p12 = new Player(12L, "Mario Tičinović", "Napadač", 10, 3L, 29);

        // Kreiranje igrača za FK Velež
        Player p13 = new Player(13L, "Nihad Mujakić", "Golman", 1, 4L, 27);
        Player p14 = new Player(14L, "Haris Handžić", "Odbrambeni", 3, 4L, 30);
        Player p15 = new Player(15L, "Aldin Ćeman", "Vezni", 14, 4L, 25);
        Player p16 = new Player(16L, "Jasmin Mešanović", "Napadač", 9, 4L, 28);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        players.add(p11);
        players.add(p12);
        players.add(p13);
        players.add(p14);
        players.add(p15);
        players.add(p16);

        // Dodavanje igrača u timove
        team1.addPlayer(1L);
        team1.addPlayer(2L);
        team1.addPlayer(3L);
        team1.addPlayer(4L);

        team2.addPlayer(5L);
        team2.addPlayer(6L);
        team2.addPlayer(7L);
        team2.addPlayer(8L);

        team3.addPlayer(9L);
        team3.addPlayer(10L);
        team3.addPlayer(11L);
        team3.addPlayer(12L);

        team4.addPlayer(13L);
        team4.addPlayer(14L);
        team4.addPlayer(15L);
        team4.addPlayer(16L);
    }

    public static List<Team> getTeams() {
        return teams;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static Team getTeamById(Long id) {
        return teams.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Player getPlayerById(Long id) {
        return players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Player> getPlayersByTeamId(Long teamId) {
        return players.stream()
                .filter(player -> player.getTeamId().equals(teamId))
                .toList();
    }
}
