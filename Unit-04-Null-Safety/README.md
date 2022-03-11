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

By using "Nesting let", we can set a let expression inside another let expression. We cannot use *it* keyword, but instead need to assign explicit names to them.

    var str = "Hello"
    str.let{ first -> first.let { second -> println("First: $first, Second: $second") } }
    // Prints
    // First: Hello, Second: Hello

If the expression is nesting let, only the outermost one returns the value.

    var str = "Hello"
    str = str.let{ first - > first.let{ second -> println("First: $first, Second: $second")
                                        "Hi" }
                                "Bye" }
    println(str)   // Bye                                
                                
## also
## run
## apply
## with
