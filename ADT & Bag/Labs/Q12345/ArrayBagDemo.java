package Labs.Q12345;

public class ArrayBagDemo {


    private static void testAdd(BagInterface<String> aBag, String[] content){

        //this is getCurrentSize???? but its only number of entries?
        //cannot use the aBag current size bcuz what if initially its an empty bag then u trap liao
        for(int i = 0; i < content.length; i++){
            aBag.add(content[i]);
        }


    }

    private static void displayBag(BagInterface<String> aBag){

        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows: ");
        //rmb we had the code 
        //T[] bag = (T[]) new Object[capacity]
        //so this you just temporarily slap the T[] to it to let java assume its T[]
        //but deep down its an object
        //thats why if now here you put String [] it crashes
        Object [] abagArray = aBag.toArray();
        for(int i = 0; i < abagArray.length; i++){
            System.out.print(abagArray[i] + " ");
        }
        System.out.println("\n");


    }

    public static void main(String[] args) {
        
        ArrayBag <String> bag1 = new ArrayBag<>();
        ArrayBag <String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        testAdd(bag1, contentsOfBag1);
        testAdd(bag2, contentsOfBag2);

        System.out.println("bag 1: \nAdding A A B A C A");
        displayBag(bag1);
        System.out.println("bag2: \nAdding A B A C B C D");
        displayBag(bag2);

        //test method union
        BagInterface <String> bag3 = bag1.Union(bag2);
        System.out.println("bag3, test the method union of bag1 and bag2:");
        displayBag(bag3);

        //test method intersection
        BagInterface <String> bag4 = bag1.Intersection(bag2);
        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        displayBag(bag4);

        //testmethod difference
        BagInterface <String> bag5 = bag1.Difference(bag2);
        System.out.println("bag5, test the method difference of bag1 and bag2: ");
        displayBag(bag5);


    
        
    }

}
