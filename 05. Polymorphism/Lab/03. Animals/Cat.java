public class Cat extends Animal {

    public Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favourite food is %s", super.name, super.favouriteFood
        );
    }


    }


