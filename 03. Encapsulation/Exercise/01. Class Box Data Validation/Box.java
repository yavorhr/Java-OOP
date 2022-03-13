public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        if (isGreaterThanZero(height)) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    private void setLength(double length) {
        if (!isGreaterThanZero(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (!isGreaterThanZero(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    private boolean isGreaterThanZero(double val) {
        return val > 0;
    }

    public double calculateSurfaceArea() {
        return (2 * (length * width)) + (2 * (length * height)) + (2 * (width * height));
    }

    // 2lh + 2wh
    public double calculateLateralSurfaceArea() {
        return (2 * (length * height)) + (2 * (width * height));
    }

    // lwh
    public double calculateVolume() {
        return length * height * width;

    }
}
