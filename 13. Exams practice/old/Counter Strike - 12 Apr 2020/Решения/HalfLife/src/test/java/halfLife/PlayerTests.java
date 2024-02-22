package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTests {
    private Player playerTest;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void SetUp() {
        playerTest = new Player("Pesho", 100);
        playerOne = new Player("PlayerOne", 36);
        playerTwo = new Player("PlayerTwo", 42);
    }

    //1. Object is not null
    @Test
    public void testSetUpCreateInstance(){
        Assert.assertNotNull(playerOne);
    }

    //2. Object name is VALID
    @Test
    public void testPlayerUsername() {
        String actualName = playerTest.getUsername();
        String expectedName = "Pesho";
        Assert.assertEquals(expectedName, actualName);
    }

    //3. Object name is NULL
    @Test(expected = NullPointerException.class)
    public void testPlayerNameNotNull() {
        playerTest = new Player(null, 20);
    }

    //4.Object health is NOT valid
    @Test(expected = IllegalArgumentException.class)
    public void testPlayerHealthIsValid() {
        new Player("Pesho", -1);
    }

    //5. Object health is VALID
    @Test
    public void testGetHealth() {
        int expectedHealth = 100;
        int actualHealth = playerTest.getHealth();
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test
    public void testGetGuns() {
        int guns = playerTest.getGuns().size();
        int expectedNumberOfGuns = 0;
        Assert.assertEquals(expectedNumberOfGuns, guns);
    }


    @Test
    public void testTakeDamageWorkCorrect() {
        playerTest.takeDamage(50);
        int actualHealth = playerTest.getHealth();
        int expectedHealth = 50;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test
    public void testUserName() {
        String expectedUsername = "Pesho";
        String actual = playerTest.getUsername();
        Assert.assertEquals(expectedUsername, actual);
    }

    @Test(expected = NullPointerException.class)
    public void userNameNullTest() {
        Player player = new Player(null, 30);
    }

    @Test(expected = NullPointerException.class)
    public void gunIsNull() {
        playerTest.addGun(null);
    }

    @Test
    public void testAddGun() {
        Gun gun = new Gun("Pistol", 123);
        playerTest.addGun(gun);
        Assert.assertEquals(1, playerTest.getGuns().size());
    }

    @Test
    public void testRemoveGun() {
        Gun gun = new Gun("Rifle", 13);
        playerTest.addGun(gun);
        boolean actualResult = playerTest.removeGun(gun);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testGetGun() {
        Gun gun = new Gun("Rifle", 13);
        playerTest.addGun(gun);
        boolean actualResult = playerTest.removeGun(gun);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testGetValidGun() {
        Gun gun = new Gun("Rifle", 123);
        playerTest.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = playerTest.getGun(gun.getName());
        Assert.assertEquals(gun, actualGun);
    }
}
