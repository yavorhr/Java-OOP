package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.factory.ExplorerFactory;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;

public class ControllerImpl implements Controller {
  private Repository<Explorer> explorerRepository;

  public ControllerImpl() {
    this.explorerRepository = new ExplorerRepository();
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
    return null;
  }

  @Override
  public String retireExplorer(String explorerName) {
    return null;
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
