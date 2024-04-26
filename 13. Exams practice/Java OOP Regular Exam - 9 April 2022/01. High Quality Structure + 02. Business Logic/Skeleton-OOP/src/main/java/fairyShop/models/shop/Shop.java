package fairyShop.models.shop;

import fairyShop.models.present.Present;
import fairyShop.models.helper.Helper;

public interface Shop {
    void craft(Present present, Helper helper);
}
