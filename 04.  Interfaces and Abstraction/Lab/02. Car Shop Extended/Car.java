import java.io.Serializable;

public interface Car extends Serializable {
    public static final Integer TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();


}
