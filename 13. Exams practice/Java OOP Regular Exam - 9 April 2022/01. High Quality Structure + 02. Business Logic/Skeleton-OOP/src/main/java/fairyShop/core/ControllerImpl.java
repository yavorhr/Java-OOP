package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.factory.HelperFactory;
import fairyShop.models.helper.Helper;
import fairyShop.models.instrument.InstrumentImpl;
import fairyShop.models.present.Present;
import fairyShop.models.present.PresentImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

public class ControllerImpl implements Controller {
  private Repository<Helper> helperRepository;
  private Repository<Present> presentRepository;

  public ControllerImpl() {
    this.helperRepository = new HelperRepository();
    this.presentRepository = new PresentRepository();
  }

  @Override
  public String addHelper(String type, String helperName) {
    Helper helper = HelperFactory.create(type, helperName);
    this.helperRepository.add(helper);
    return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
  }

  @Override
  public String addInstrumentToHelper(String helperName, int power) {
    Helper helper = this.helperRepository.findByName(helperName);

    if (helper == null) {
      return ExceptionMessages.HELPER_DOESNT_EXIST;
    }

    helper.addInstrument(new InstrumentImpl(power));
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
  }

  @Override
  public String addPresent(String presentName, int energyRequired) {
    this.presentRepository.add(new PresentImpl(presentName, energyRequired));
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
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
