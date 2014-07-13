package vehicle;

/**
 * Interface for a vehicle.
 *
 * @author Henrik Samuelsson
 */
interface IVehicle {

    /**
     * Calculates the range on one tank of fuel.
     *
     * @return the range
     */
    int range();

    /**
     * Calculates the fuel needed to go a specific distance.
     *
     * @param miles The distance in miles
     * @return amount of fuel needed
     */
    double fuelNeeded(int miles);

    /**
     * Getter for number of passengers the vehicle takes.
     *
     * @return number of passengers
     */
    int getPassengers();

    /**
     * Setter for number of passengers the vehicle takes.
     *
     * @param f number of passengers
     */
    void setPassengers(int p);

    /**
     * Getter for amount of fuel the vehicle tank takes.
     *
     * @return gallons of fuel
     */
    int getFuelCap();

    /**
     * Setter for amount of fuel the vehicel tank takes.
     *
     * @param f gallons of fuel
     */
    void setFuelCap(int f);

    /**
     * Getter for the fuel consumption in miles per gallon.
     *
     * @return consumtion measured in miles per gallon
     */
    int getMpg();

    /**
     * Setter for the fuel consumption in miles per gallon.
     *
     * @param m fuel consumption
     */
    void setMpg(int m);

}
