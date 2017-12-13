
fun main(args: Array<String>) {

    var first = 10
    var second = 20

    first += second
    second = first - second
    first -= second

    println("First value is $first")
    println("Second value is $second")
}