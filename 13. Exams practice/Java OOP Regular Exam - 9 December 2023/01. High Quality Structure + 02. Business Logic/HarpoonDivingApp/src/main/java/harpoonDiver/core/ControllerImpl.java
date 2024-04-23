package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.factory.DiverFactory;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private Repository<Diver> divers;
  private Repository<DivingSite> divingSites;
  private Diving diving;

  public ControllerImpl() {
    this.divers = new DiverRepository();
    this.divingSites = new DivingSiteRepository();
    this.diving = new DivingImpl();
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
    validateIfThereAreDiversWithEnoughOxygen();

    DivingSite diving = this.divingSites.byName(siteName);
    Collection<Diver> divers = getDiversWithOxygen();

    this.diving.searching(diving, divers);
    return String.format(ConstantMessages.SITE_DIVING, siteName, divers.size());
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

  private void validateIfThereAreDiversWithEnoughOxygen() {
    boolean noDiversWithEnoughOxygen = this.divers.getCollection()
            .stream()
            .noneMatch(d -> d.getOxygen() > 0);

    if (noDiversWithEnoughOxygen) {
      throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
    }
  }

  private Collection<Diver> getDiversWithOxygen() {
    return this.divers.getCollection()
            .stream()
            .filter(d -> d.getOxygen() >= 30)
            .collect(Collectors.toList());
  }

}
