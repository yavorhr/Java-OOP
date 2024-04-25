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
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private static int DIVING_COUNT = 0;
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
    DIVING_COUNT++;
    DivingSite diving = this.divingSites.byName(siteName);
    Collection<Diver> divers = getDiversWithOxygen();

    this.diving.searching(diving, divers);

    int removedDivers = getRemovedDivers(divers);

    return String.format(ConstantMessages.SITE_DIVING, siteName, removedDivers);
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format(ConstantMessages.FINAL_DIVING_SITES, DIVING_COUNT))
            .append(System.lineSeparator());
    sb.append(ConstantMessages.FINAL_DIVERS_STATISTICS)
            .append(System.lineSeparator());
    this.divers.getCollection().forEach(d -> {
      sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME, d.getName()))
              .append(System.lineSeparator());
      sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, d.getOxygen()))
              .append(System.lineSeparator());
      sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, getDiversCatch(d.getSeaCatch().getSeaCreatures())))
              .append(System.lineSeparator());
    });
    return sb.toString().trim();
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
            .filter(d -> d.getOxygen() > 30)
            .collect(Collectors.toList());
  }

  private String getDiversCatch(Collection<String> seaCreatures) {
    return seaCreatures.size() == 0
            ? "None"
            : String.join(", ", seaCreatures);
  }

  private int getRemovedDivers(Collection<Diver> divers) {
    int initialCount = divers.size();
    int filteredDivers = divers
            .stream()
            .filter(d -> d.getOxygen() >= 30)
            .collect(Collectors.toList())
            .size();

    return initialCount - filteredDivers;
  }
}
