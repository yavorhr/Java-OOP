package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.factory.ClimberFactory;
import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.Repository;

import java.util.Arrays;

public class ControllerImpl implements Controller {
  private Repository<Climber> climberRepository;

  public ControllerImpl() {
    this.climberRepository = new ClimberRepository();
  }

  @Override
  public String addClimber(String type, String climberName) {
    Climber climber = ClimberFactory.create(type, climberName);
    this.climberRepository.add(climber);
    return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
  }

  @Override
  public String addMountain(String mountainName, String... peaks) {
    Mountain mountain = new MountainImpl(mountainName);
    addPeaksToMountain(mountain, peaks);
    return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
  }

  @Override
  public String removeClimber(String climberName) {
    Climber climber = this.climberRepository.byName(climberName);
    doesClimberExist(climberName, climber);
    this.climberRepository.remove(climber);

    return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
  }

  private void doesClimberExist(String climberName, Climber climber) {
    if (climber == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
    }
  }

  @Override
  public String startClimbing(String mountainName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }

  // Helpers

  private void addPeaksToMountain(Mountain mountain, String[] peaks) {
    if (peaks.length > 0) {
      Arrays.stream(peaks).forEach(p -> mountain.getPeaksList().add(p));
    }
  }
}
