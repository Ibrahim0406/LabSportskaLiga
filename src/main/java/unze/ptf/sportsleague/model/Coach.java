package unze.ptf.sportsleague.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coaches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nationality;

    private Integer age;

    private Integer experienceYears;

    private String specialization;

    // One-to-Many relationship with Team
    // Jedan trener može trenirati više timova tokom karijere
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Team> teams = new ArrayList<>();
}
