package Labs.Q12345;


public class ArrayBag<T> implements BagInterface<T> {
    
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    //constructor for user to pass nothing so use default capacity
    public ArrayBag(){
        bag = (T[]) new Object[DEFAULT_CAPACITY];
        this.numberOfEntries = 0;
    }
    //at first when create the bag got nothing
    public ArrayBag(int capacity){

        //bag = new T[capacity] will gives an error 
        //cuz java hates it when not specific here
        //so you slap a T[] on it so that it can be treated like a T array
        bag = (T[]) new Object[capacity];
        this.numberOfEntries = 0;

    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean isFull(){
        //so we dont use capacity or default capacity here cuz got two different parameter constructor
        if(numberOfEntries >= bag.length){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(numberOfEntries == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //numberOfEntries tell the next index
    //lets say its empty now, numberOfEntries 0, so the next index also bag[0]
    public boolean add (T newEntry){
        //here isFull no need write like ArrayBag.isFull() bcuz isFull() is already a method inside ArrayBag
        //also its wrong to write ArrayBag.isFull() becuz ArrayBag is just a blueprint
        //u only use the class name to call out static method remember that
        //so here either isFull() or this.isFull(), and when outside the class, you can create an ArrayBag object and calls it out
        if(isFull() == true){
            return false;
        }

        else{
            bag[numberOfEntries] = newEntry;

            numberOfEntries++;

            return true;
        }
    }

    //here i choose to remove the last item in the array
    public T remove(){

        if(isEmpty() == true){
            return null;
        }

        else{
            T result = bag[numberOfEntries - 1];
            //null makes it empty
            //so later on u want fill it in with others oso can
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return result;
        }


    }

    public boolean remove(T anEntry){
        for(int i = 0; i < numberOfEntries; i++){
            //every class comes from a mother class call Object
            //so this Object class will already have this built in .equals
            //so what about what if is int and double? they got no .equals
            //soulution is Generic wont even allow int and double cuz they are primitive
            //you can only put the wrapper class of them in it which is Integer and Double where these class will have .equals
            if(bag[i].equals(anEntry)){

                //bcuz if you straigh away bag[i] = null
                //then its a hole lets say your thing is middle, so later on when add things, will go wrong
                //meaning you must remove thing at the end, only when add the index will be correct
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
                return true;
            }        
    }
    return false;
}

    //remove everythingg
    public void clear(){
        for(int i = 0; i < numberOfEntries; i++){
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry){
        int count = 0;
        for(int i = 0; i < numberOfEntries; i++){
            if(bag[i].equals(anEntry)){
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry){
        for(int i = 0; i < numberOfEntries; i++){
            if(bag[i].equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        T[] newArray = (T[]) new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++){
            newArray[i] = bag[i];
        }
        return newArray;
    }

    public BagInterface<T> Union (BagInterface<T> bag2){

        //- need to return bag Interface
        //- so need to have new bag interface first
        //so here we use ArrayBag to instatantiate a new one

        //bag length and current size difference?
        //bag length is the capacity, size is the num of entries

        //here cant write BagInterface cuz BagInterface is interface cant be instatiate
        ArrayBag<T> UnionBag = new ArrayBag<>(getCurrentSize() + bag2.getCurrentSize());

        //add the first bag
        T[] thisBag = this.toArray();
        for(int i = 0; i < getCurrentSize(); i++){
            UnionBag.add(thisBag[i]);
        }

        //add the second bag
        T[] bag2Array = bag2.toArray();
        for(int i = 0; i < bag2.getCurrentSize(); i++){
            UnionBag.add(bag2Array[i]);
        }

        return UnionBag;
            
        };

        public BagInterface<T> Intersection (BagInterface <T> otherBag){

            ArrayBag <T> IntersectionBag = new ArrayBag<>();

            T[] thisArray = this.toArray();
            T[] otherArray = otherBag.toArray();
    
            for(int i = 0; i < thisArray.length; i++){
                T currentItem = thisArray[i];

                for(int j = 0; j < otherArray.length; j++){

                    if(otherArray[j] != null && currentItem.equals(otherArray[j])){


                        IntersectionBag.add(otherArray[j]);

                        //remove it if found
                        otherArray[j] = null;

                        //so will move on to check the next item in the thisArray
                        break;

                    }
                }
            }

            return IntersectionBag;
        }

        //difference bag , check contains, then remove??????
        public BagInterface<T> Difference(BagInterface<T> otherBag){

            //can this be this??? no!!! cannot copy like put "this" on the right hand side 
            ArrayBag<T> differenceBag = new ArrayBag<>(this.getCurrentSize());
            T[] otherArray = otherBag.toArray();
            T[] thisArray = this.toArray();

            for(int i = 0; i < thisArray.length; i++){
                differenceBag.add(thisArray[i]);
            }

            //if you check if this.contains(other), the danger is mayb they two different size
            //
            for(int i = 0; i < otherArray.length; i++){
                if(differenceBag.contains(otherArray[i])){
                    differenceBag.remove(otherArray[i]);
                }
            }

            return differenceBag;
            
        }


    }

