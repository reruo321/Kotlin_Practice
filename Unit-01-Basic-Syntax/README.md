# Unit 01. Basic Syntax
## Declaration
Use *var* for declaring a variable or *val* for read-only local variable.
The unique thing of Kotlin is: Even if you do not declare them with types, this smart language will infer them automatically.

    var a = 12
    val a: Int = 34
    
It also allows to assign the value later.

    var str: String
    str = "Hello"
    println(str)

**Warning**: To assign the value later on a variable, you must specify its type on declaration.

    var str
    str = "Hello"   // NO!
    println(str)

## Function
Use the keyword *fun* to declare a function. Parameters can have default values.

    fun myFunction(a: Int = 10, b: Int): String{   // return type is String
        return "Sum is ${a+b}"
    }
    
### Unit-Returning Function
If you want to make a function to not return anything useful, use *Unit* as a return type. OR you can just omit it, since the default return type considered by the Kotlin compiler is Unit.

    fun hello: Unit { println("Hello Kotlin~") }   // These two are the same functions.
    fun hello: { println("Hello Kotlin~") }
    
## Keywords
### Unit
**Unit** in Kotlin is a type returning nothing, which is similar to *void* in Java. The only value it can have is Unit. (Expression like Unit? is not available.) Moreover, it can be used in generic functions, while Java users should choose Void instead of void.
