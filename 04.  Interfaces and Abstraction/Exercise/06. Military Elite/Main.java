import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<Integer, Soldier> soldierMap = new LinkedHashMap<>();

    String input = scanner.nextLine();
    while (!"end".equals(input)) {
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

          for (int i = 5; i < tokens.length; i++) {
            int privateId = Integer.parseInt(tokens[i]);
            PrivateImpl currentPrivate = (PrivateImpl) soldierMap.get(privateId);
            lieutenantGeneral.addPrivate(currentPrivate);
          }
          soldierMap.put(id, lieutenantGeneral);
        }
        case "Commando" -> {
          double salary = Double.parseDouble(tokens[4]);
          SpecialCorpsEnum specialCorpsEnum = SpecialCorpsEnum.valueOf(tokens[5]);

          CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, specialCorpsEnum);

          if (tokens.length > 6) {
            for (int i = 6; i < tokens.length; i += 2) {
              String missionName = tokens[i];
              StateEnum state = StateEnum.valueOf(tokens[i + 1]);
              Mission mission = new Mission(missionName, state);
              commando.addMission(mission);
            }
          }
          soldierMap.put(id, commando);
        }

        case "Engineer" -> {
          double salary = Double.parseDouble(tokens[4]);
          SpecialCorpsEnum specialCorpsEnum = SpecialCorpsEnum.valueOf(tokens[5]);
          EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, specialCorpsEnum);

          if (tokens.length > 6) {
            for (int i = 6; i < tokens.length; i += 2) {
              String partName = tokens[i];
              int hours = Integer.parseInt(tokens[i + 1]);
              RepairPart repairPart = new RepairPart(partName, hours);
              engineer.addRepair(repairPart);
            }
          }
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
  }
}

