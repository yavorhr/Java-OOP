package magicGame.core;

import magicGame.common.OutputMessages;
import magicGame.factory.MagicFactory;
import magicGame.factory.MagicianFactory;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianComparator;
import magicGame.models.magics.Magic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicRepository;
import magicGame.repositories.interfaces.MagicianRepository;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;
import validator.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    Magic magic = MagicFactory.create(type, name, bulletsCount);
    this.magicRepository.addMagic(magic);

    return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
  }

  @Override
  public String addMagician(String type, String username, int health, int protection, String magicName) {
    Magic magic = this.magicRepository.findByName(magicName);
    Validator.validateIfMagicExists(magic);

    Magician magician = MagicianFactory.create(type, username, health, protection, magic);
    magicianRepository.addMagician(magician);

    return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
  }

  @Override
  public String startGame() {
    List<Magician> magicians = getAllAliveMagicians();

    return this.region.start(magicians);
  }


  @Override
  public String report() {
    StringBuilder sb = new StringBuilder();

    List<Magician> collect = this.magicianRepository
            .getData()
            .stream()
            .sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());

    System.out.println();
    return sb.toString();
  }

  // Helpers
  private List<Magician> getAllAliveMagicians() {
    return this.magicianRepository
            .getData()
            .stream()
            .filter(Magician::isAlive)
            .collect(Collectors.toList());
  }
}
