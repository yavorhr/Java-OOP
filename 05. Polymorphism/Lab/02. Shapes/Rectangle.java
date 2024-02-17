public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height * this.width);
    }

    private void setHeight(double height) {
        if (Validator.validateInput(height)) {
            throw new IllegalArgumentException(ConstantMessages.NOT_VALID_INPUT);
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if (Validator.validateInput(width)) {
            throw new IllegalArgumentException(ConstantMessages.NOT_VALID_INPUT);
        }
        this.width = width;
    }
}
