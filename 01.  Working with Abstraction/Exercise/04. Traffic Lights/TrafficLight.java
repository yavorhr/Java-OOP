import java.util.Collections;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void update() {
        // RED -> GREEN
        //GREEN -> YELLOW
        //YELLOW - RED

        switch (color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }

    public Color getColor() {
        return this.color;
    }
}
