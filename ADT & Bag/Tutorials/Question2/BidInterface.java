package Question2;

public interface BidInterface {

    //return name of company making bid
    public String getName();

    //return String description
    public String getDescription();

    //return the capacity in int
    public int getCapacity();

    //return the efficiency in int
    public int getEfficiency();

    //return AC's cost
    public double cost();

    //return installing cost
    public double costInstall();

    //return yearly cost
    public double yearCost();


}

