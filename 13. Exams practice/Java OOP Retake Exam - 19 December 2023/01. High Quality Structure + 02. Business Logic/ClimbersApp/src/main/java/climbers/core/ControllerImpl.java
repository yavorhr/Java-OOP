package climbers.core;

import climbers.common.ConstantMessages;
import climbers.factory.ClimberFactory;
import climbers.models.climber.Climber;
import climbers.repositories.ClimberRepository;
import climbers.repositories.Repository;

public class ControllerImpl implements Controller {
  private Repository<Climber> climberRepository;

  public ControllerImpl() {
    this.climberRepository = new ClimberRepository();
  }

  @Override
  public String addClimber(String type, String climberName) {
    Climber climber = ClimberFactory.create(type,climberName);
    this.climberRepository.add(climber);
    return String.format(ConstantMessages.CLIMBER_ADDED,type,climberName);
  }

  @Override
  public String addMountain(String mountainName, String... peaks) {
    return null;
  }

  @Override
  public String removeClimber(String climberName) {
    return null;
  }

  @Override
  public String startClimbing(String mountainName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
