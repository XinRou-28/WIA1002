Imagine you are building a generic ObjectBag (no <T>). Because it accepts any Object, it's like a cardboard box with "MISC STUFF" written on it.

```java
ObjectBag myBag = new ObjectBag();

myBag.add("Apple");  // You put a String in. 
myBag.add(100);      // Your teammate accidentally puts an Integer in.
```

Notice that Java doesn't stop your teammate. It says, "Sure, 100 is an Object, throw it in the box!"

Now, let's say a week later, you write the code to empty the bag. You assume it only has Strings in it, so you use that translation trick we talked about:
```java
// Pull out the first item
String item1 = (String) myBag.remove(); // Pulls out "Apple". Works perfectly!

// Pull out the second item
String item2 = (String) myBag.remove(); // Pulls out the number 100...
// 💥 BOOM! CRASH! 💥
```

The New Way: The Bouncer at the Door
By using Generics (<T>), you put a strict bouncer at the door of your bag.
```java
BagInterface<String> myBag = new ArrayBag<>();

myBag.add("Apple");  // Bouncer says: "Yep, that's a String. Come in."
myBag.add(100);      // Bouncer says: "HALT! This is a String club only!"
```
Here, Java stops you immediately. The moment your teammate types myBag.add(100);, Java draws a giant red error line under it. The code literally refuses to compile or run.
