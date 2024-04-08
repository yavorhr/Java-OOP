package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.factory.ExplorerFactory;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;
import glacialExpedition.validator.Validator;

public class ControllerImpl implements Controller {
  private Repository<Explorer> explorerRepository;
  private Repository<State> stateRepository;

  public ControllerImpl() {
    this.explorerRepository = new ExplorerRepository();
    this.stateRepository = new StateRepository();
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
  public String addState(String stateName, String... exhibits) {
    this.stateRepository.add(new StateImpl(stateName));

    return String.format(ConstantMessages.STATE_ADDED, stateName);
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
    return null;
  }

  @Override
  public String finalResult() {
    return null;
  }
}
