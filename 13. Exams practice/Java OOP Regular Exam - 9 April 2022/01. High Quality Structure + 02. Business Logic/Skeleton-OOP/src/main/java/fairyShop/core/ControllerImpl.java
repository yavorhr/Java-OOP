package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.factory.HelperFactory;
import fairyShop.models.helper.Helper;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.Repository;

public class ControllerImpl implements Controller {
  private Repository<Helper> helperRepository;

  public ControllerImpl() {
    this.helperRepository = new HelperRepository();
  }

  @Override
  public String addHelper(String type, String helperName) {
    Helper helper = HelperFactory.create(type, helperName);
    this.helperRepository.add(helper);
    return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
  }

  @Override
  public String addInstrumentToHelper(String helperName, int power) {
    return null;
  }

  @Override
  public String addPresent(String presentName, int energyRequired) {
    return null;
  }

  @Override
  public String craftPresent(String presentName) {
    return null;
  }

  @Override
  public String report() {
    return null;
  }
}
