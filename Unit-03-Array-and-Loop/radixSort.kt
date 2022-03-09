import kotlin.math.pow

fun digit(num: Int, dec: Int): Int {
    return (num % 10.toDouble().pow(dec).toInt()) / (10.toDouble().pow(dec-1).toInt())
}

fun countingSort(arr: Array<Int>, dec: Int){
    var max_digit = digit(arr[0], dec)
    for(i: Int in arr.indices)
        if(max_digit < digit(arr[i], dec))
            max_digit = digit(arr[i], dec)

    val cArr = Array<Int>(max_digit+1){ 0 }
    for(i: Int in arr.indices)
        for(j: Int in digit(arr[i], dec) until cArr.size)
            ++cArr[j]

    val rArr = Array<Int>(arr.size){ 0 }
    for(i: Int in arr.size-1 downTo 0){
        val digit = digit(arr[i], dec)
        rArr[(cArr[digit]--)-1] = arr[i]
    }
    for(i: Int in rArr.indices)
        arr[i] = rArr[i]
}

fun radixSort(arr: Array<Int>){
    // Find the maximum length of all elements
    var max_length = arr[0].toString().length
    arr.map{
        if(max_length < it.toString().length)
            max_length = it.toString().length
    }
    // Radix Sort - feat. Counting Sort
    for(i: Int in 1..max_length)
        countingSort(arr, i)

}

fun main() {
    val arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    radixSort(arr)
    println(arr.joinToString(" "))
}
