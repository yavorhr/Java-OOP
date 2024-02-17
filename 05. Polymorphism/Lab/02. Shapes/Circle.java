public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter( 2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
    }

    private void setRadius(double radius) {
        if (Validator.validateInput(radius)) {
            throw new IllegalArgumentException(ConstantMessages.NOT_VALID_INPUT);
        }
        this.radius = radius;
    }
}
