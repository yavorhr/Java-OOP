public class Main {
  public static void main(String[] args) {
    
    Hero hero = new Hero("Pesho", new Axe(10, 10));
    Weapon weapon = hero.getWeapon();
  }
}
