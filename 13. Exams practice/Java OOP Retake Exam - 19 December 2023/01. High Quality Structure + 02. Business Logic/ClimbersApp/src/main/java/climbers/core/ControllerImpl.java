package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.factory.ClimberFactory;
import climbers.models.climber.Climber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private Repository<Climber> climberRepository;
  private Repository<Mountain> mountainRepository;
  private Climbing climbing;

  public ControllerImpl() {
    this.climberRepository = new ClimberRepository();
    this.mountainRepository = new MountainRepository();
    this.climbing = new ClimbingImpl();
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
    this.mountainRepository.add(mountain);

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

    climbing.conqueringPeaks(this.mountainRepository.byName(mountainName), climbersWithEnoughStrengthToClimb(climberRepository.getCollection()));

    return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, this.climbing.getRemovedClimbers());
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.climbing.getClimbedMountainsCnt()))
            .append(System.lineSeparator());
    sb.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS)
            .append(System.lineSeparator());

    this.climberRepository.getCollection().forEach(c -> sb.append(c.toString()));

    return sb.toString();
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

  private Collection<Climber> climbersWithEnoughStrengthToClimb(Collection<Climber> climbers) {
    return climbers.stream().filter(Climber::canClimb).collect(Collectors.toList());
  }
}
