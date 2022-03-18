public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return this.height;
    }
    
    private void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public void calculatePerimeter() {
     setPerimeter(this.height * 2 + this.width*2);
    }

    @Override
    public void calculateArea() {
        setArea(this.height * this.width);
    }
}

