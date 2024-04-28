package fairyShop.models.shop;

import fairyShop.models.helper.Helper;
import fairyShop.models.instrument.Instrument;
import fairyShop.models.present.Present;

public class ShopImpl implements Shop {

  @Override
  public void craft(Present present, Helper helper) {
    while (helper.canWork() && !noMoreInstrumentsLeft(helper)) {
      for (Instrument currentInstrument : helper.getInstruments()) {
        while (!currentInstrument.isBroken()) {
          currentInstrument.use();
          present.getCrafted();
          helper.work();

          if (present.isDone()) {
            return;
          }
        }

      }
    }

  }

  // Helpers

  private boolean noMoreInstrumentsLeft(Helper helper) {
    return helper.getInstruments().stream().allMatch(Instrument::isBroken);
  }
}
