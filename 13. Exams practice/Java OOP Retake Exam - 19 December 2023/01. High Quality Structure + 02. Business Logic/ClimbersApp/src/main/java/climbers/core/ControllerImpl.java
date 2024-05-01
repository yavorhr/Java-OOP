package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.factory.ClimberFactory;
import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerImpl implements Controller {
  private Repository<Climber> climberRepository;
  private Repository<Mountain> mountainRepository;
  private static int CLIMBED_MOUNTAINS = 0;

  public ControllerImpl() {
    this.climberRepository = new ClimberRepository();
    this.mountainRepository = new MountainRepository();
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

  @Override
  public String startClimbing(String mountainName) {
    validateIfClimbers();
    Mountain mountain = this.mountainRepository.byName(mountainName);
    CLIMBED_MOUNTAINS++;

    List<String> peaks = new ArrayList<>(mountain.getPeaksList());
    int removedClimbers = 0;

    for (Climber climber : this.climberRepository.getCollection()) {
      while (climber.canClimb() && peaks.size() > 0) {
        climber.climb();
        climber.getRoster().getPeaks().add(peaks.remove(0));

        removedClimbers = deleteClimberWithoutStrength(removedClimbers, climber);
      }
    }


    return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, removedClimbers);
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

  private void doesClimberExist(String climberName, Climber climber) {
    if (climber == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
    }
  }

  private void validateIfClimbers() {
    if (this.climberRepository.getCollection().stream().noneMatch(Climber::canClimb)) {
      throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
    }
  }


  private int deleteClimberWithoutStrength(int removedClimbers, Climber climber) {
    if (!climber.canClimb()) {
      removedClimbers++;
      this.climberRepository.remove(climber);
    }
    return removedClimbers;
  }
}
