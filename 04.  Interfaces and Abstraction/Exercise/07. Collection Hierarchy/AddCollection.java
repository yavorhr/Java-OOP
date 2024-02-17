public class AddCollection extends Collection {

  @Override
  public int add(String string) {
    if (super.getMaxSize() > super.getList().size()) {
      super.getList().add(string);
    }
    return getList().lastIndexOf(string);
  }
}
