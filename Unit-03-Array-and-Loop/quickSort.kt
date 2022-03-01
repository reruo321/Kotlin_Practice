import java.util.Vector

fun quickSort(arr: Array<Int>, sortArr: Array<Int> = arr, first: Int = 0, arrsize: Int = arr.size){
    if(arrsize < 1)
        return

    var left = Vector<Int>()
    var right = Vector<Int>()

    // pivot: last element
    val pivot = sortArr[arrsize-1]
    for(i: Int in 0..arrsize-1){
        if(pivot > sortArr[i])
            left.addElement(sortArr[i])
        else if(pivot < sortArr[i])
            right.addElement(sortArr[i])
    }
    arr[first+left.size] = sortArr[arrsize-1]

    quickSort(arr, left.toTypedArray(), first, left.size)
    quickSort(arr, right.toTypedArray(), first+left.size+1, right.size)
}

fun main() {
    var arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    quickSort(arr)
    for(num in arr)
        print("$num ")
    println()
}
