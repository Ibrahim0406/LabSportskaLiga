package unze.ptf.sportsleague.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unze.ptf.sportsleague.model.Player;
import unze.ptf.sportsleague.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public List<Player> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findByPosition(position);
    }

    public List<Player> getPlayersByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));

        player.setName(playerDetails.getName());
        player.setPosition(playerDetails.getPosition());
        player.setJerseyNumber(playerDetails.getJerseyNumber());
        player.setNationality(playerDetails.getNationality());
        player.setAge(playerDetails.getAge());
        player.setTeam(playerDetails.getTeam());

        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
