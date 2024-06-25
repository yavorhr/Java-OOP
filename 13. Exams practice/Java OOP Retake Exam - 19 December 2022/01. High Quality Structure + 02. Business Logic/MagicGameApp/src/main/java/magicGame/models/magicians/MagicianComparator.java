package magicGame.models.magicians;

import java.util.Comparator;

public class MagicianComparator implements Comparator<Magician> {

  @Override
  public int compare(Magician m1, Magician m2) {
    int result = Integer.compare(m1.getHealth(), m2.getHealth());

    if (result == 0) {
      result = m1.getUsername().compareTo(m2.getUsername());
    }

    if (result == 0) {
      result = m1.getClass().getSimpleName().compareTo(m2.getClass().getSimpleName());
    }

    return result;
  }
}
