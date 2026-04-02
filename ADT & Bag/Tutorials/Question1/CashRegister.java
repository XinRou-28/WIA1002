package Question1;
public class CashRegister {

    private double machineCash;

    public CashRegister(){

        this.machineCash = 0.0;

    }

    public double processSale(double moneyInserted, double itemCost){
        if (moneyInserted >= itemCost) {
            // tracks how much money machine has
            this.machineCash += itemCost; 
            
            // Calculate and return the customer's change
            double change = moneyInserted - itemCost; 
            return change;
        } 
        else {
            System.out.println("Insufficient money inserted!");
            return moneyInserted; 
        }
    }
    
}
