package magicGame.core;

import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

public class ControllerImpl implements Controller {
  private MagicRepository<Magic> magicRepository;
  private MagicianRepository<Magician> magicianRepository;
  private Region region;

  public ControllerImpl() {
    this.magicRepository = new MagicRepositoryImpl();
    this.magicianRepository = new MagicianRepositoryImpl();
    this.region = new RegionImpl();
  }

  @Override
  public String addMagic(String type, String name, int bulletsCount) {
    return null;
  }

  @Override
  public String addMagician(String type, String username, int health, int protection, String magicName) {
    return null;
  }

  @Override
  public String startGame() {
    return null;
  }

  @Override
  public String report() {
    return null;
  }
}
