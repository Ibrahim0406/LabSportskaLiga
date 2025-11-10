package unze.ptf.sportsleague.data;

import unze.ptf.sportsleague.model.Player;
import unze.ptf.sportsleague.model.Team;
import unze.ptf.sportsleague.model.Coach;

import java.util.ArrayList;
import java.util.List;

public class LeagueData {
    private static List<Team> teams = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();
    private static List<Coach> coaches = new ArrayList<>();

    static {
        Coach coach1 = new Coach();
        coach1.setId(1L);
        coach1.setName("Vinko Marinović");
        coach1.setNationality("Bosna i Hercegovina");
        coach1.setExperienceYears(15);

        Coach coach2 = new Coach();
        coach2.setId(2L);
        coach2.setName("Blaž Slišković");
        coach2.setNationality("Bosna i Hercegovina");
        coach2.setExperienceYears(20);

        Coach coach3 = new Coach();
        coach3.setId(3L);
        coach3.setName("Sergej Jakirović");
        coach3.setNationality("Hrvatska");
        coach3.setExperienceYears(12);

        Coach coach4 = new Coach();
        coach4.setId(4L);
        coach4.setName("Goran Bogdanović");
        coach4.setNationality("Srbija");
        coach4.setExperienceYears(18);

        coaches.add(coach1);
        coaches.add(coach2);
        coaches.add(coach3);
        coaches.add(coach4);

        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("FK Sarajevo");
        team1.setCity("Sarajevo");
        team1.setFounded("1946");
        team1.setStadium("Stadion Asim Ferhatović Hase");
        team1.setCoach(coach1);

        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("FK Željezničar");
        team2.setCity("Sarajevo");
        team2.setFounded("1921");
        team2.setStadium("Stadion Grbavica");
        team2.setCoach(coach2);

        Team team3 = new Team();
        team3.setId(3L);
        team3.setName("FK Zrinjski");
        team3.setCity("Mostar");
        team3.setFounded("1905");
        team3.setStadium("Stadion pod Bijelim Brijegom");
        team3.setCoach(coach3);

        Team team4 = new Team();
        team4.setId(4L);
        team4.setName("FK Velež");
        team4.setCity("Mostar");
        team4.setFounded("1922");
        team4.setStadium("Stadion Rođeni");
        team4.setCoach(coach4);

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        // Kreiranje igrača za FK Sarajevo
        Player p1 = new Player();
        p1.setId(1L);
        p1.setName("Edin Forto");
        p1.setPosition("Golman");
        p1.setJerseyNumber(1);
        p1.setTeam(team1);
        p1.setAge(28);

        Player p2 = new Player();
        p2.setId(2L);
        p2.setName("Amar Rahmanović");
        p2.setPosition("Odbrambeni");
        p2.setJerseyNumber(5);
        p2.setTeam(team1);
        p2.setAge(25);

        Player p3 = new Player();
        p3.setId(3L);
        p3.setName("Mirko Oremuš");
        p3.setPosition("Vezni");
        p3.setJerseyNumber(10);
        p3.setTeam(team1);
        p3.setAge(30);

        Player p4 = new Player();
        p4.setId(4L);
        p4.setName("Dal Varesanović");
        p4.setPosition("Napadač");
        p4.setJerseyNumber(9);
        p4.setTeam(team1);
        p4.setAge(27);

        // Kreiranje igrača za FK Željezničar
        Player p5 = new Player();
        p5.setId(5L);
        p5.setName("Josip Ćorluka");
        p5.setPosition("Golman");
        p5.setJerseyNumber(12);
        p5.setTeam(team2);
        p5.setAge(26);

        Player p6 = new Player();
        p6.setId(6L);
        p6.setName("Kenan Pirić");
        p6.setPosition("Odbrambeni");
        p6.setJerseyNumber(4);
        p6.setTeam(team2);
        p6.setAge(29);

        Player p7 = new Player();
        p7.setId(7L);
        p7.setName("Nemanja Bilbija");
        p7.setPosition("Vezni");
        p7.setJerseyNumber(7);
        p7.setTeam(team2);
        p7.setAge(31);

        Player p8 = new Player();
        p8.setId(8L);
        p8.setName("Ivan Lendrić");
        p8.setPosition("Napadač");
        p8.setJerseyNumber(11);
        p8.setTeam(team2);
        p8.setAge(24);

        // Kreiranje igrača za FK Zrinjski
        Player p9 = new Player();
        p9.setId(9L);
        p9.setName("Marko Marić");
        p9.setPosition("Golman");
        p9.setJerseyNumber(33);
        p9.setTeam(team3);
        p9.setAge(32);

        Player p10 = new Player();
        p10.setId(10L);
        p10.setName("Slobodan Jakovljević");
        p10.setPosition("Odbrambeni");
        p10.setJerseyNumber(6);
        p10.setTeam(team3);
        p10.setAge(28);

        Player p11 = new Player();
        p11.setId(11L);
        p11.setName("Nemanja Bilbija");
        p11.setPosition("Vezni");
        p11.setJerseyNumber(8);
        p11.setTeam(team3);
        p11.setAge(26);

        Player p12 = new Player();
        p12.setId(12L);
        p12.setName("Mario Tičinović");
        p12.setPosition("Napadač");
        p12.setJerseyNumber(10);
        p12.setTeam(team3);
        p12.setAge(29);

        // Kreiranje igrača za FK Velež
        Player p13 = new Player();
        p13.setId(13L);
        p13.setName("Nihad Mujakić");
        p13.setPosition("Golman");
        p13.setJerseyNumber(1);
        p13.setTeam(team4);
        p13.setAge(27);

        Player p14 = new Player();
        p14.setId(14L);
        p14.setName("Haris Handžić");
        p14.setPosition("Odbrambeni");
        p14.setJerseyNumber(3);
        p14.setTeam(team4);
        p14.setAge(30);

        Player p15 = new Player();
        p15.setId(15L);
        p15.setName("Aldin Ćeman");
        p15.setPosition("Vezni");
        p15.setJerseyNumber(14);
        p15.setTeam(team4);
        p15.setAge(25);

        Player p16 = new Player();
        p16.setId(16L);
        p16.setName("Jasmin Mešanović");
        p16.setPosition("Napadač");
        p16.setJerseyNumber(9);
        p16.setTeam(team4);
        p16.setAge(28);

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
    }

    public static List<Team> getTeams() {
        return teams;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static List<Coach> getCoaches() {
        return coaches;
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

    public static Coach getCoachById(Long id) {
        return coaches.stream()
                .filter(coach -> coach.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
