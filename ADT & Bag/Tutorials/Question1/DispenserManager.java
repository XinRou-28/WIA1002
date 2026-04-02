package Question1;
import java.util.ArrayList;
public class DispenserManager {

    private ArrayList<Dispenser> dispensers;

    public DispenserManager(){

        dispensers = new ArrayList <>();

    }

    public void addDispenser(Dispenser dis){
        dispensers.add(dis);
    }

    public Dispenser acceptChoice(String choice){
        
        for(Dispenser dispenser : dispensers){
            if(choice.equalsIgnoreCase(dispenser.getItem())){
                System.out.println("Price for each " + choice + " is: " + dispenser.getCost());
                return dispenser;
            }
        }
        System.out.println("Item not available");
        return null;
    }

    public double Total(double cost, int count){
        double total = cost * count;
        return total;
    }

    public void printAllDispensers(){
        for(Dispenser dispenser : dispensers){
        System.out.println("Item: " + dispenser.getItem());
        System.out.println("Cost: " + dispenser.getCost());
    }


}
}
