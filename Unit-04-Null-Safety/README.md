# Null Safety
## let
To make a conditional operation works only for non-null values, use **let** with a safe call operator.

    쵀child?.let { println(it.name) }   // If child is not null, it will print its name.
                                        // Otherwise, ignores printing.
                                        
The interesting point is, it can also return the result.

    var a = 1
    var b = 2
    a = a.let{ it + 2 }.let{ val c = it + b
        i }
    println(a)   // This prints 5.



## also
## run
## apply
## with
