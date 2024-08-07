package glacialExpedition.core;

public interface Controller {
    String addExplorer(String type, String explorerName);

    String addState(String... strings);

    String retireExplorer(String explorerName);

    String exploreState(String stateName);

    String finalResult();
}
