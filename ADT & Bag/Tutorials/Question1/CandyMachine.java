package Question1;

import java.util.Scanner;
public class CandyMachine {

    public static void main(String[] args) {
        Scanner xr = new Scanner(System.in);
        
        Dispenser ds1 = new Dispenser("Candies", 2.50);
        Dispenser ds2 = new Dispenser("Chips", 4.50);
        Dispenser ds3 = new Dispenser("gum", 3.5);
        Dispenser ds4 = new Dispenser("cookies", 4.5);

        DispenserManager dm = new DispenserManager();

        CashRegister cr1 = new CashRegister();

        //add all the dispenser to array List
        dm.addDispenser(ds1);
        dm.addDispenser(ds2);
        dm.addDispenser(ds3);
        dm.addDispenser(ds4);

        //display the available items
        System.out.println();
        System.out.println("Item List: ");
        dm.printAllDispensers();

        //let user enter the name of item to be chosen, if item not there then return null
        System.out.println();
        System.out.print("Enter name of item: ");
        String choice = xr.next();
        Dispenser dispenserChosen = dm.acceptChoice(choice);

        System.out.println();
        if(dispenserChosen != null){
        System.out.print("Enter number of items: ");
        int number = xr.nextInt();

        System.out.println();
            System.out.print("Total to be paid is: ");
            double total = dm.Total(dispenserChosen.getCost(), number);
            System.out.print(total);
            System.out.println();
        
        System.out.println();
        System.out.print("Insert money: ");
        double money = xr.nextDouble();
        
        System.out.println();
        System.out.println(cr1.processSale(money, total) + " returned");
        }

        xr.close();

    }
    
}
