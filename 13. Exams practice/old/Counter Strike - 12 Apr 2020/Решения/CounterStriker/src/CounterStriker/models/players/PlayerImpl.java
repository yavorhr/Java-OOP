package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;


    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (points >= this.armor) {
            points -= this.armor;
            this.armor = 0;
            this.health -= points;
            if (this.health < 0) {
                this.health = 0;
            }
        } else {
            this.armor -= points;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //"{player type}: {player username}
        sb.append(String.format("%s: %s", getClass().getSimpleName(), getUsername())).append(System.lineSeparator());
        //--Health: {player health}
        sb.append(String.format("--Health: %d", getHealth())).append(System.lineSeparator());
        //--Armor: {player armor}
        sb.append(String.format("--Armor: %d", getArmor())).append(System.lineSeparator());
        //--Gun: {player gun name}"
        sb.append(String.format("--Gun: %s", getGun().getName()));

        return sb.toString().trim();
    }
}
