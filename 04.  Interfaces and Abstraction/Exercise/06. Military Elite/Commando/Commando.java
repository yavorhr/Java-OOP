package Commando;

import java.util.List;

public interface Commando {
  void addMission(Mission mission);
  List<Mission> getMissions();

}
