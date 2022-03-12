# Null Safety
## let
To make a conditional operation works only for non-null values, use **let** with a safe call operator.

    child?.let { println(it.name) }   // If child is not null, it will print its name.
                                        // Otherwise, ignores printing.
                                        
The interesting point is, it can also return the result in the final statement. (If no specified return, it just returns unit. (nothing))

    var a = 1
    var b = 2
    a = a.let{ it + 2 }.let{ val c = it + b
        c }   // This returns the value of c, which is 5, as a.
    println(a)   // Therefore it prints 5.

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
                                
## run
**run** is the expression resembles let, and it also returns the last statement. However, it does not support *it* keyword.

    var hello = "Hello"
    println(hello)   // Hello
    hello = run{ val hello = "Hi"
            hello
            }
    println(hello)   // Hi

## also
An **also** expression is similar to let, but the biggest difference is that *also* returns the original object (context object), instead of any new return data. (lambda result)

    var a = 1
    a = a.also{ it + 1 }.also{ it + 2 }
    println(a)   // Prints 1.

## apply
**apply** is an extension function on a type, running on the object reference into the expression and returning it. It does not support *it*, unlike *also*.

    data class Animal(var name: String, var leg: Int)
    var animal = Animal("Dog", 4)
    
    animal.apply{ name = "Cat" }   // If it were also, it.name = "Cat"
    println(animal)   // Animal(name=Cat, leg=4)

## with
