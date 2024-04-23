package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.factory.DiverFactory;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.Repository;

public class ControllerImpl implements Controller {
  private Repository<Diver> divers;

  public ControllerImpl() {
    this.divers = new DiverRepository();
  }

  @Override
  public String addDiver(String kind, String diverName) {
    Diver diver = DiverFactory.create(kind, diverName);
    this.divers.add(diver);
    return String.format(ConstantMessages.DIVER_ADDED,kind,diverName);
  }

  @Override
  public String addDivingSite(String siteName, String... seaCreatures) {
    //TODO
    return null;
  }

  @Override
  public String removeDiver(String diverName) {
    //TODO
    return null;
  }

  @Override
  public String startDiving(String siteName) {
    //TODO
    return null;
  }

  @Override
  public String getStatistics() {
    //TODO
    return null;
  }
}
