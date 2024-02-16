import Engineer.EngineerImpl;
import Engineer.RepairPart;
import LieutenantGeneral.LieutenantGeneralImpl;
import Private.*;
import Soldier.Soldier;
import Spy.Spy;
import Commando.CommandoImpl;
import Commando.Mission;
import Enums.*;
import Enums.StateEnum;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<Integer, Soldier> soldierMap = new LinkedHashMap<>();

    String input = scanner.nextLine();
    while (!"End".equals(input)) {
      String[] tokens = input.split(" ");
      String rank = tokens[0];
      int id = Integer.parseInt(tokens[1]);
      String firstName = tokens[2];
      String lastName = tokens[3];

      switch (rank) {
        case "Private" -> {
          double salary = Double.parseDouble(tokens[4]);
          soldierMap.put(id, new PrivateImpl(id, firstName, lastName, salary));
        }
        case "LieutenantGeneral" -> {
          double salary = Double.parseDouble(tokens[4]);
          LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
          addPrivates(soldierMap, tokens, lieutenantGeneral);
          soldierMap.put(id, lieutenantGeneral);
        }
        case "Commando" -> {
          double salary = Double.parseDouble(tokens[4]);
          SpecialCorpsEnum specialCorpsEnum = SpecialCorpsEnum.valueOf(tokens[5]);
          CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, specialCorpsEnum);
          addMissions(tokens, commando);
          soldierMap.put(id, commando);
        }

        case "Engineer" -> {
          double salary = Double.parseDouble(tokens[4]);
          SpecialCorpsEnum specialCorpsEnum = SpecialCorpsEnum.valueOf(tokens[5]);
          EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, specialCorpsEnum);

          addRepairParts(tokens, engineer);
          soldierMap.put(id, engineer);
        }
        case "Spy" -> {
          String codeNumber = tokens[4];
          Spy spy = new Spy(id, firstName, lastName, codeNumber);
          soldierMap.put(id, spy);
        }
      }
      input = scanner.nextLine();
    }

    printOutput(soldierMap);
  }

  private static void printOutput(Map<Integer, Soldier> soldierMap) {
    soldierMap.values().forEach(System.out::println);
  }

  private static void addRepairParts(String[] tokens, EngineerImpl engineer) {
    if (tokens.length > 6) {
      for (int i = 6; i < tokens.length; i += 2) {
        String partName = tokens[i];
        int hours = Integer.parseInt(tokens[i + 1]);
        RepairPart repairPart = new RepairPart(partName, hours);
        engineer.addRepair(repairPart);
      }
    }
  }

  private static void addMissions(String[] tokens, CommandoImpl commando) {
    if (tokens.length > 6) {
      for (int i = 6; i < tokens.length; i += 2) {
        String missionName = tokens[i];
        StateEnum state = StateEnum.valueOf(tokens[i + 1]);
        Mission mission = new Mission(missionName, state);
        commando.addMission(mission);
      }
    }
  }

  private static void addPrivates(Map<Integer, Soldier> soldierMap, String[] tokens, LieutenantGeneralImpl lieutenantGeneral) {
    for (int i = 5; i < tokens.length; i++) {
      int privateId = Integer.parseInt(tokens[i]);
      PrivateImpl currentPrivate = (PrivateImpl) soldierMap.get(privateId);
      lieutenantGeneral.addPrivate(currentPrivate);
    }
  }
}

