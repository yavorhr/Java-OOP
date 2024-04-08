package glacialExpedition.core;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;

    public ControllerImpl() {
        this.explorerRepository  = new ExplorerRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        return null;
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
