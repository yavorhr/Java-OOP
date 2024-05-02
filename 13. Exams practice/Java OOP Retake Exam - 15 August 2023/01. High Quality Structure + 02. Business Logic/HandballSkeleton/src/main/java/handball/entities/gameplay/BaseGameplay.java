package handball.entities.gameplay;

import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.Collection;
import java.util.Collections;

public abstract class BaseGameplay implements Gameplay {
  private String name;
  private int capacity;
  private Collection<Equipment> equipments;
  private Collection<Team> teams;

  public BaseGameplay(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
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
}
