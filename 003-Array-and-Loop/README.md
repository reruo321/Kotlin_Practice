# Array
To assign an array, use **arrayOf\<TYPE\>(ELEMENTS)** like this.

    var arr = arrayOf<Int>(1, 2, 3, 4, 5)

If you want to get an array as a parameter, try this out.
  
    fun myFunction(arr: Array<Int>){...}
  
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
