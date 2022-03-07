# Null Safety
## let
To make a conditional operation works only for non-null values, use **let** with a safe call operator.

    쵀child?.let { println(it.name) }
