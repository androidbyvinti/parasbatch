


fun main(args: Array<String>) {

    var value = 1

    while(value<=10) //only conditions are allowed, no assignment work is done inside loop
    {
        println(value)
        value++
    }

    do{ // exit controlled loop
        println(value)
        value++
    }while(value<=10)

}