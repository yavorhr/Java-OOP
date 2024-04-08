package glacialExpedition.factory;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;

public class ExplorerFactory {
  private static Explorer create(String type, String name) {
    Explorer explorer = null;

    switch (type) {
      case "AnimalExplorer" -> explorer = new AnimalExplorer(name);
      case "GlacierExplorer" -> explorer = new GlacierExplorer(name);
      case "NaturalExplorer" -> explorer = new NaturalExplorer(name);
    }

    return explorer;
  }
}
