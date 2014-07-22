package trafficlights;

/**
 * Test of the TrafficLightSimulator
 * 
 * @author Henrik Samuelsson
 */
public class TrafficLightDemo {
    public static void main(String args[]) {  
    TrafficLightSimulator tl =
      new TrafficLightSimulator(TrafficLightColor.GREEN);
    tl.start();
 
    for(int i=0; i < 9; i++) { 
      System.out.println(tl.getColor()); 
      tl.waitForChange(); 
    } 
 
    tl.cancel(); 
  }  
}
