package twodshapes;

/**
 *  A subclass of TwoDShape for circles.
 * 
 * @author Henrik Samuelsson
 */
public class Circle extends TwoDShape {
    
    /**
     * Constructs a circle.
     * 
     * @param diameter Diameter of the circle.
     */
    Circle(double diameter) {
        super(diameter); // Call constructor of superclass.
    }
    
    double area() {
        double diameter = getWidth();
        double radius = diameter / 2;
        double area = radius * radius * Math.PI;
        return (area);
    }
    
    /**
     * Entry point to application, tests the class by creating a
     * circle and calculate the area of this circle.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(3.0);
        System.out.println(c.area());
    }
    
}
