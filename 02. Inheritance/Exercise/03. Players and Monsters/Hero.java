
public class Hero {
    String username;
    int level;

    public Hero(String userName, int level) {
        this.username = userName;
        this.level = level;
    }

    public String getUsername() {
        return this.username;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
