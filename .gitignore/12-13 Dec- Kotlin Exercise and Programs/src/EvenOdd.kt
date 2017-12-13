

fun main(args: Array<String>) {

    var value = 67

    val max = if(value%2==0) {
        println("Even")
        value
    }else{
        println("Odd")
        value
    }
    println(max)
}