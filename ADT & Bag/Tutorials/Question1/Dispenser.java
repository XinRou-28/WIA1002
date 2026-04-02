package Question1;
public class Dispenser{

    private String item;
    private double itemCost;

    public Dispenser(String item, double itemCost){

        this.item = item;
        this.itemCost = itemCost;
    }

    public String getItem(){
        return item;
    }

    public double getCost(){
        return itemCost;
    }
}