package Question2;

public interface BidCollectionInterface {

    //add bid to collection
    public void addBid(BidInterface bid);

    //return bid with best yearly cost
    public BidInterface bestYearCost();

    //return bid with best initial cost
    //unit cost plus installation cost
    public BidInterface bestIniCost();

    //clear all item from collection
    public void clearAll();

    //get number of items in the collection
    public int getNumber();

    //check whether is empty
    public boolean isEmpty();
}
