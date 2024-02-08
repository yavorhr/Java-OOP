public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

        // methods are defined in the inherited classes,
        // but objects Cat and Dog are initialized in the Animal class, which has no access to both methods

        Animal cat2 = new Cat();
        cat2.meow();
        Animal dog2 = new Dog();
        dog2.bark();
    }
}
