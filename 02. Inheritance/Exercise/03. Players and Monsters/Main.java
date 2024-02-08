import hero.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
  public static void main(String[] args) {
    Hero darkKnight = new DarkKnight("dark_Knight", 3);
    Hero darkWizard = new DarkWizard("dark_wizard", 42);
    Hero museElf = new MuseElf("muse_elf", 111);
    Hero soulMaster = new SoulMaster("soul_master", 12);

    List<Hero> heroList = new ArrayList<>();
    heroList.add(darkKnight);
    heroList.add(darkWizard);
    heroList.add(museElf);
    heroList.add(soulMaster);

    heroList.forEach(System.out::println);
  }
}