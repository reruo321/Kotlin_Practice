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

**Warning**: To assign the value later on a variable, you must specify its type.

    var str
    str = "Hello"   // NO!
    println(str)
