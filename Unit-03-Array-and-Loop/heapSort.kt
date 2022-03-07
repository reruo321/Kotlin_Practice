fun swapKey(arr: Array<Int>, n1: Int, n2: Int){
    val temp = arr[n1]
    arr[n1] = arr[n2]
    arr[n2] = temp
}

fun heapify(arr: Array<Int>, parent: Int, n: Int){
    var maxIndex = parent
    val left = (parent * 2) + 1
    val right = (parent * 2) + 2

    if(left < n)
        if(arr[maxIndex] < arr[left])
            maxIndex = left
    if(right < n)
        if(arr[maxIndex] < arr[right])
            maxIndex = right

    if(parent != maxIndex){
        swapKey(arr, parent, maxIndex)
        heapify(arr, maxIndex, n)
    }
}

fun heapSort(arr: Array<Int>){
    // Max Heap (The biggest key becomes the root)
    for(i: Int in (arr.size - 1)/2 downTo 0) heapify(arr, i, arr.size)
    // Remove the root and heapify, again and again
    for(i: Int in (arr.size - 1) downTo 0){
        swapKey(arr, 0, i)
        heapify(arr, 0, i)
    }
}

fun main() {
    val arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    heapSort(arr)
    println(arr.joinToString(" "))
}
