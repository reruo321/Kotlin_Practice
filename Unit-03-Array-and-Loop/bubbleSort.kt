fun bubbleSort(arr: Array<Int>){
	var temp: Int
    for(i: Int in 0..arr.size-2){
    	for(j: Int in 0..arr.size-i-2){
        	if(arr[j] > arr[j+1]){
            	temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
        }
    }
}

fun main() {
    var arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    bubbleSort(arr)
    for(num in arr)
        print("$num ")
    println()
}
