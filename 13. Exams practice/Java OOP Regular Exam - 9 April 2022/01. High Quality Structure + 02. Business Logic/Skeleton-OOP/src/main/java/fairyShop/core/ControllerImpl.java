package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.factory.HelperFactory;
import fairyShop.models.helper.Helper;
import fairyShop.models.instrument.Instrument;
import fairyShop.models.instrument.InstrumentImpl;
import fairyShop.models.present.Present;
import fairyShop.models.present.PresentImpl;
import fairyShop.models.shop.Shop;
import fairyShop.models.shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private static int CRAFTER_PRESENTS_COUNT = 0;
  private Repository<Helper> helperRepository;
  private Repository<Present> presentRepository;
  private Shop shop;

  public ControllerImpl() {
    this.helperRepository = new HelperRepository();
    this.presentRepository = new PresentRepository();
    this.shop = new ShopImpl();
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
    Present present = this.presentRepository.findByName(presentName);
    Collection<Helper> helpers = getHelpersWithEnergyAbove50energy();

    if (helpers.size() == 0) {
      return ExceptionMessages.NO_HELPER_READY;
    }

    for (Helper helper : helpers) {
      this.shop.craft(present, helper);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(String.format(ConstantMessages.PRESENT_DONE,
            presentName,
            present.isDone() ? "done" : "not done")).append(System.lineSeparator());

    if (present.isDone()) {
      CRAFTER_PRESENTS_COUNT++;
    }

    sb.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, getCountBrokenInstruments(helpers)))
            .append(System.lineSeparator());

    return sb.toString().trim();

  }

  @Override
  public String report() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%d presents are done!", CRAFTER_PRESENTS_COUNT))
            .append(System.lineSeparator());
    sb.append("Helpers info:")
            .append(System.lineSeparator());

    for (Helper helper : this.helperRepository.getModels()) {
      sb.append(String.format("Name: %s", helper.getName()))
              .append(System.lineSeparator());
      sb.append(String.format("Energy: %d", helper.getEnergy()))
              .append(String.format("Instruments: %d not broken left", countNotBrokenInstruments(helper.getInstruments())))
              .append(System.lineSeparator());
    }
    return sb.toString().trim();
  }

  // Helpers

  private Collection<Helper> getHelpersWithEnergyAbove50energy() {
    return this.helperRepository
            .getModels()
            .stream()
            .filter(h -> h.getEnergy() > 50)
            .collect(Collectors.toList());
  }

  private int getCountBrokenInstruments(Collection<Helper> helpers) {
    int count = 0;
    for (Helper helper : helpers) {
      for (Instrument instrument : helper.getInstruments()) {
        if (instrument.isBroken()) {
          count++;
        }
      }
    }
    return count;
  }

  private long countNotBrokenInstruments(Collection<Instrument> instruments) {
    return instruments.stream().filter(i -> !i.isBroken()).count();
  }
}

