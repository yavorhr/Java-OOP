public class MyListImpl extends Collection implements MyList, AddRemovable, Addable{

  @Override
  public int getUsed() {
    return super.getList().size();
  }

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
      super.getList().add( string);
    }
    return super.getList().size();
  }
}
