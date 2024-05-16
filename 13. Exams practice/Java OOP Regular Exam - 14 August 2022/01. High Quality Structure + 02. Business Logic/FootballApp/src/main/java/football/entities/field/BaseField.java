package football.entities.field;

import football.Validator.Validator;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {
  private String name;
  private int capacity;
  private List<Supplement> supplements;
  private List<Player> players;

  public BaseField(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.supplements = new ArrayList<>();
    this.players = new ArrayList<>();
  }

  @Override
  public int sumEnergy() {
    return this.supplements
            .stream()
            .mapToInt(Supplement::getEnergy)
            .sum();
  }

  @Override
  public void addPlayer(Player player) {
    Validator.validateIfCapacity(this.capacity);

    this.players.add(player);
    this.capacity--;
  }

  @Override
  public void removePlayer(Player player) {
    this.players.remove(player);
    this.capacity++;
  }

  @Override
  public void addSupplement(Supplement supplement) {
    this.supplements.add(supplement);
  }

  @Override
  public void drag() {
    this.players.forEach(Player::stimulation);
  }

  @Override
  public String getInfo() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
            .append(System.lineSeparator());
    sb.append(String.format("Player: %s", playersOutput()))
            .append(System.lineSeparator());
    sb.append(String.format("Supplement: %d", this.supplements.size()))
            .append(System.lineSeparator());
    sb.append(String.format("Energy: %d", this.sumEnergy()))
            .append(System.lineSeparator());

    return sb.toString().trim();
  }

  protected String playersOutput() {
    return this.players.size() == 0
            ? "None"
            : this.players.stream()
            .map(Player::getName)
            .collect(Collectors.joining(", "));
  }

  @Override
  public Collection<Player> getPlayers() {
    return Collections.unmodifiableCollection(this.players);
  }

  @Override
  public Collection<Supplement> getSupplements() {
    return Collections.unmodifiableCollection(this.supplements);
  }

  @Override
  public String getName() {
    return this.name;
  }
}
