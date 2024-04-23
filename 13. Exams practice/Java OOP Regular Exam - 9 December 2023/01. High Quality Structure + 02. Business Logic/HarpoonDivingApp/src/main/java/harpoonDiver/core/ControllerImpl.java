package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.factory.DiverFactory;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Arrays;

public class ControllerImpl implements Controller {
  private Repository<Diver> divers;
  private Repository<DivingSite> divingSites;

  public ControllerImpl() {
    this.divers = new DiverRepository();
    this.divingSites = new DivingSiteRepository();
  }

  @Override
  public String addDiver(String kind, String diverName) {
    Diver diver = DiverFactory.create(kind, diverName);
    this.divers.add(diver);
    return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
  }

  @Override
  public String addDivingSite(String siteName, String... seaCreatures) {
    DivingSite divingSite = new DivingSiteImpl(siteName);
    addSeaCreaturesToSite(divingSite, seaCreatures);
    this.divingSites.add(divingSite);

    return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
  }

  @Override
  public String removeDiver(String diverName) {
    validateIfDiverExistInRepository(diverName);

    Diver diver = this.divers.byName(diverName);
    this.divers.remove(diver);

    return String.format(ConstantMessages.DIVER_REMOVE, diverName);
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

  //Helpers

  private void addSeaCreaturesToSite(DivingSite divingSite, String[] seaCreatures) {
    Arrays.stream(seaCreatures).forEach(c -> divingSite.getSeaCreatures().add(c));
  }

  private void validateIfDiverExistInRepository(String diverName) {
    if (this.divers.byName(diverName) == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
    }
  }

}
