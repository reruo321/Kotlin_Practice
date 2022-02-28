fun selectSort(arr: Array<Int>){
	var temp: Int
	for(i: Int in 0..arr.size-1){
        for(j: Int in i+1..arr.size-1){
        	if(arr[i] > arr[j]){
            	temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
}


fun main() {
    var arr = arrayOf<Int>(3, 4, 7, 5, 2, 11, 8, 6, 1, 12, 10, 9)
    selectSort(arr)
    for(num in arr)
        print("$num ")
    println()
}
