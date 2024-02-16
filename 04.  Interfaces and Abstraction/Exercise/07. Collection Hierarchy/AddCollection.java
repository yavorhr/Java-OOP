public class AddCollection extends Collection implements Addable {

  @Override
  public int add(String string) {
    if (super.getMaxSize() > super.getList().size()) {
      super.getList().add( string);
    }
    return super.getList().size();
  }
}
