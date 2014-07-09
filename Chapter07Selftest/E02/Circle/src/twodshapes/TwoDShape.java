package twodshapes;

/**
 * A class for various two dimensional shapes.
 * 
 * @author Henrik Samuelsson
 */
public class TwoDShape {
   private double width;
   private double height;
   
   /**
    * Default constructor.
    */
   TwoDShape() {
       width = height = 0.0;
   }
   
   /**
    * Constructs a TwoDShape with user defined width and height.
    * 
    * @param width Width of the shape.
    * @param height Height of the shape. 
    */
   TwoDShape(double width, double height) {
       this.width = width;
       this.height = height;
   }
   
   /**
    * Constructs a TwoDShape with equal width and size.
    * 
    * @param size 
    */
   TwoDShape(double size) {
       width = height = size;
   }
   
    /**
     * Getter method for the width.
     * 
     * @return Width of shape.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Getter method for the height.
     * @return Height of the shape.
     */
    public double getHeight() {
        return height;
    }
}
