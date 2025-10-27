package unze.ptf.sportsleague.model;

public class Player {
    private Long id;
    private String name;
    private String position;
    private int jerseyNumber;
    private Long teamId;
    private int age;

    public Player() {
    }

    public Player(Long id, String name, String position, int jerseyNumber, Long teamId, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.teamId = teamId;
        this.age = age;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
