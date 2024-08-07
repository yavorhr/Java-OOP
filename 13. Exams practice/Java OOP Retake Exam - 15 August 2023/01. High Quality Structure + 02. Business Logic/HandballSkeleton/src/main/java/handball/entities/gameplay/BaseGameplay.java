package handball.entities.gameplay;

import handball.Validator.Validator;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseGameplay implements Gameplay {
  private String name;
  private int capacity;
  private Collection<Equipment> equipments;
  private Collection<Team> teams;

  protected BaseGameplay(String name, int capacity) {
    this.setName(name);
    this.capacity = capacity;
    this.equipments = new ArrayList<>();
    this.teams = new ArrayList<>();
  }

  @Override
  public int allProtection() {
    return this.equipments
            .stream()
            .mapToInt(Equipment::getProtection)
            .sum();
  }

  @Override
  public void addTeam(Team team) {
    this.teams.add(team);
  }

  @Override
  public void removeTeam(Team team) {
    this.teams.remove(team);
  }

  @Override
  public void addEquipment(Equipment equipment) {
    this.equipments.add(equipment);
  }

  @Override
  public void teamsInGameplay() {
    this.teams.forEach(Team::play);
  }

  @Override
  public Collection<Team> getTeam() {
    return Collections.unmodifiableCollection(this.teams);
  }

  @Override
  public Collection<Equipment> getEquipments() {
    return Collections.unmodifiableCollection(this.equipments);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    if (this.getTeam().size() == 0) {
      return "None";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%s %s", this.getName(), this.getClass().getSimpleName()))
            .append(System.lineSeparator());
    sb.append(String.format("Team: %s", getTeamsNames(this.teams)))
            .append(System.lineSeparator());
    sb.append(String.format("Equipment: %d, Protection: %d", this.equipments.size(), this.allProtection()))
            .append(System.lineSeparator());

    return sb.toString();
  }

  private void setName(String name) {
    Validator.validateGamePlayName(name);
    this.name = name;
  }

  // Helpers
  private String getTeamsNames(Collection<Team> teams) {
    return teams.size() == 0
            ? "None"
            : this.teams.stream()
            .map(Team::getName)
            .collect(Collectors.joining(" "));
  }
}
