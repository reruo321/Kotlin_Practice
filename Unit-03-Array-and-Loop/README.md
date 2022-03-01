# Array
## Assignment
To assign an array, use **arrayOf\<TYPE\>(ELEMENTS)** like this.

    var arr = arrayOf<Int>(1, 2, 3, 4, 5)

## Array Parameter
If you want to get an array as a parameter, try this out.
  
    fun myFunction(arr: Array<Int>){...}

## Conversion to Array

To convert a Vector to an array, use toTypedArray().

    import java.util.Vector
    
    var vec = Vector<Int>()
    ...
    var arr = vec.toTypedArray()
    
Let's take another step towards the Kotlin world. It would be quite useful for example when you want to create an Int array by taking integer inputs, split by space.

One more tip! Instead of converting each String-type number to Int with a for loop, just use **map**. It will convert all elements in the String list into integers. After using toTypedArray(), the list will be finally the array of Ints.

    val arr = readLine()!!.split(" ").map{ it.toInt() }.toTypedArray()

## Print Array
You perhaps have used a customary array printing format using for loop in several languages, to submit the output to some online judges such as Baekjoon(백준).

    // Like this
    for(i: Int in 0..arr.size-1) print("${arr[i]} ")
    println()
    
    // OR
    for(i: Int in 0 until arr.size) print("${arr[i]} ")
    println()
    
    // OR
    for(num in arr) print("$num ")
    println()

When I did the same thing to AIZU online judge to verify my sort programs, it showed me an output format error!This judge said wrong for some extra spaces or new lines from the outputs. Then how to do it clearly? Do we need to check the last element or the last loop to not produce them?

Nah! We actually have very simple solution for this problem. Some Java users may know this expression. **Joining**. Before getting the answer, let's check the Java 8 version first. In Java, you can use join and (Int)Stream in various ways.

If you join strings with "---", (일---이---삼---사)

    public class Main
    {
        public static void main(String[] args) {
            String [] arr = {"일", "이", "삼", "사"};
            System.out.println(
            String.join("---", arr)
            );
        }
    }

And if you do it with an integer array and some spaces, (1 2 3 4 5 6)

    import java.util.stream.*;

    public class Main
    {
        public static void main(String[] args) {
            int [] arr = {1, 2, 3, 4, 5, 6};
            System.out.println(
            IntStream.of(arr).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" "))
            );
        }
    }

Finally so, how can we do joining like them in Kotlin? Very simple!

    fun main() { 
       val arr = arrayOf(5, 4, 3, 2, 1)
       println(arr.joinToString(" "))
    }

# Loop
Loop in Kotlin has a little bit unique syntax. Use **for(VAR: TYPE in A..B)** format. For example if you count from 1 to 5 using a for loop,

    for(i: Int in 1..5){ println(i) }
    
And if you print odd numbers from 1 to 10, add **step N**. (N=2 in the example)

    for(i: Int in 1..10 step 2){ println(i) }

This is the same as this below in Java.

    // Java Expression
    for(int i=1; i<=10; i+=2){ System.out.println(i); }
    
Also, if you would like to make a downward loop, use **downTo** keyword, instead of "**..**".

    for(i: Int in 9 downTo 1 step 2){ println(i) }
