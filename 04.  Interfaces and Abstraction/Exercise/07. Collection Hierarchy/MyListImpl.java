public class MyListImpl extends Collection implements MyList{

  @Override
  public String remove() {
    if (super.getList().isEmpty()) {
      return "List is empty, nothing to remove!";
    }
    return super.getList().remove(0);
  }

  @Override
  public int add(String string) {
    if (super.getMaxSize() > super.getList().size()) {
      super.getList().add(0, string);
    }
    return super.getList().indexOf(string);
  }

  @Override
  public int getUsed() {
    return super.getList().size();
  }
}
