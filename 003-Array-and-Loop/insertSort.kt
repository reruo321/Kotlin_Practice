fun insertSort(arr: Array<Int>){
    for(i: Int in 1..arr.size-1){
        var key = arr[i]
        var j = i-1
        while(j >= 0 && arr[j] > key){
            arr[j+1] = arr[j]
            --j
        }
        arr[j+1] = key
    }
}

fun main() {
    var arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    insertSort(arr)
    for(num in arr)
        print("$num ")
    println()
}
