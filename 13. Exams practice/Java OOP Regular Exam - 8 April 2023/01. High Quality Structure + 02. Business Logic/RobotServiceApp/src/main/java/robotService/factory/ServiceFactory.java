package robotService.factory;

import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import validator.Validator;

public class ServiceFactory {
  public static Service create(String type, String name) {
    Validator.validateServiceType(type);

    Service service = null;

    switch (type) {
      case "MainService" -> service = new MainService(name);
      case "SecondaryService" -> service= new SecondaryService(name);
    }

    return service;
  }
}
