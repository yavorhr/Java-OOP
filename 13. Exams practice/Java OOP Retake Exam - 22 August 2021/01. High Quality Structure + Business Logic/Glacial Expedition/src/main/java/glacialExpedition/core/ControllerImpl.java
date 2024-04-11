package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.factory.ExplorerFactory;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;
import glacialExpedition.validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerImpl implements Controller {
  private Repository<Explorer> explorerRepository;
  private Repository<State> stateRepository;
  private Mission mission;

  public ControllerImpl() {
    this.explorerRepository = new ExplorerRepository();
    this.stateRepository = new StateRepository();
    this.mission = new MissionImpl();
  }

  @Override
  public String addExplorer(String type, String explorerName) {
    Explorer explorer = ExplorerFactory.create(type, explorerName);

    if (explorer == null) {
      return "Explorer type doesn't exists.";
    }
    this.explorerRepository.add(explorer);

    return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
  }

  @Override
  public String addState(String... strings) {
    String stateName = strings[0];

    List<String> exhibits = getExhibitsIfAny(strings);
    this.stateRepository.add(new StateImpl(stateName, exhibits));

    return String.format(ConstantMessages.STATE_ADDED, stateName);
  }

  private List<String> getExhibitsIfAny(String[] strings) {
    List<String> exhibits = new ArrayList<>();
    if (strings.length > 1) {
      Arrays.stream(strings).skip(1).forEach(exhibits::add);
    }
    return exhibits;
  }

  @Override
  public String retireExplorer(String explorerName) {
    Explorer explorer = this.explorerRepository.byName(explorerName);
    Validator.validateExplorer(explorer);

    this.explorerRepository.remove(explorer);

    return String.format(ConstantMessages.EXPLORER_RETIRED, explorer.getName());
  }

  @Override
  public String exploreState(String stateName) {
    this.mission.explore(this.stateRepository.byName(stateName), this.explorerRepository.getCollection());

    return "";
  }

  @Override
  public String finalResult() {
    return null;
  }
}
