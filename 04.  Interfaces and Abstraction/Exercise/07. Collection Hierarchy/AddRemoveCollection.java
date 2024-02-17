public class AddRemoveCollection extends Collection implements AddRemovable {

  @Override
  public String remove() {
    if (super.getList().isEmpty()) {
      return "List is empty, nothing to remove!";
    }
    int lastIndex = super.getList().size() - 1;
    return super.getList().remove(lastIndex);
  }

  @Override
  public int add(String string) {
    if (super.getMaxSize() > super.getList().size()) {
      super.getList().add(0, string);
    }
    return super.getList().indexOf(string);
  }
}

