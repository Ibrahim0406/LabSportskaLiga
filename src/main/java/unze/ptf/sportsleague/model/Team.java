package unze.ptf.sportsleague.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;
    private String name;
    private String city;
    private int founded;
    private String stadium;
    private int wins;
    private int losses;
    private List<Long> playerIds;

    public Team() {
        this.playerIds = new ArrayList<>();
    }

    public Team(Long id, String name, String city, int founded, String stadium) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.founded = founded;
        this.stadium = stadium;
        this.wins = 0;
        this.losses = 0;
        this.playerIds = new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWinPercentage() {
        int totalGames = wins + losses;
        if (totalGames == 0) {
            return 0.0;
        }
        return (wins * 100.0) / totalGames;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }

    public void addPlayer(Long playerId) {
        this.playerIds.add(playerId);
    }
}
