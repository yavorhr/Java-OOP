import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements MyList{
  private int maxSize = 100;
  private List<String> list;

  public Collection() {
    this.list = new ArrayList<>();
  }

  public int getMaxSize() {
    return this.maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  public List<String> getList() {
    return this.list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }
}
