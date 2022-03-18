public abstract class Animal {
    protected String name;
    protected String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood=favouriteFood;
    }

    abstract String explainSelf();
    }

