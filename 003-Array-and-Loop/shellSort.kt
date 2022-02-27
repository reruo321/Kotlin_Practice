fun shellSort(arr: Array<Int>, n: Int){
    if(n >= arr.size || n < 1){
        println("Failed to Sort! Put the positive parameter smaller than ${arr.size}.")
        return
    }
    for(i: Int in n downTo 1){
        for(j: Int in i..arr.size-1){
            var key = arr[j]
            var k = j-i
            while(k >= 0 && arr[k] > key){
                arr[k+i] = arr[k]
                k -= i
            }
            arr[k+i] = key
        }
    }
}

fun main() {
    var arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    shellSort(arr, 4)
    for(num in arr)
        print("$num ")
    println()
}
