package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;
import CounterStriker.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayerRepository implements Repository<Player> {
  private List<Player> players;

  public PlayerRepository() {
    this.players = new ArrayList<>();
  }

  @Override
  public Collection<Player> getModels() {
    return Collections.unmodifiableCollection(this.players);
  }

  @Override
  public void add(Player player) {
    Validator.throwErrorIfNullPlayerIsPassed(player);
    this.players.add(player);
  }

  @Override
  public boolean remove(Player player) {
    return this.players.remove(player);
  }

  @Override
  public Player findByName(String name) {
    return this.players.stream()
            .filter(g -> g.getUsername().equals(name))
            .findFirst()
            .orElse(null);
  }
}


