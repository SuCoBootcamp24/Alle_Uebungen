public class Baum {
    private int id;
    private double height;
    private double radius;
    private boolean isNadelbaum; // Nadelbaum und Laubbaum

    public Baum(double height, double radius, boolean isNadelbaum) {
        // this.id = 
        this.setHeight(height);
        this.setRadius(radius);
        this.setIsNadelbaum(isNadelbaum);
    }

    public void setHeight(double height) {
        if(height <= 0.0) throw new IllegalArgumentException(); 
        this.height = height;
    }
    public void setRadius(double radius) {
        if(radius <= 0.0) throw new IllegalArgumentException(); 
        this.radius = radius;
    }
    public void setIsNadelbaum(boolean isNadelbaum) {
        this.isNadelbaum = isNadelbaum;
    }

    public int getId() { return this.id; }
    public double getHeight() { return this.height; }
    public double getRadius() { return this.radius; }
    public boolean getIsNadelbaum() { return this.isNadelbaum; }
}

// IllegalArgumentException, wenn die Argumente von Parametern ungültige Werte haben
// IndexOfBoundsException, wenn man außerhalb einer index-grenze liegt
// NullPointerException, wenn auf eine null-referenz zugreifen versuchen