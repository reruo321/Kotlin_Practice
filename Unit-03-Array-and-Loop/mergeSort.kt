fun sublistSort(arr: Array<Int>, n: Int){
    for(i: Int in arr.indices step n){
        var j = i
        while(j < i+n && j < arr.size) {
            var k = j
            while(k < i+n && k < arr.size){
                if(arr[j] > arr[k]){
                    val temp = arr[j]
                    arr[j] = arr[k]
                    arr[k] = temp
                }
                ++k
            }
            ++j
        }
    }
}

fun mergeSort(arr: Array<Int>, n: Int = 2){
    // 2-Way Merge Sort
    sublistSort(arr, n)
    if(n >= arr.size)
        return
    mergeSort(arr, n * 2)
}

fun main() {
    val arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    mergeSort(arr)
    println(arr.joinToString(" "))
}
