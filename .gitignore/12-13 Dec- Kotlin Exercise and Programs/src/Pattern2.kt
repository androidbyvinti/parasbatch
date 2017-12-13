/*
A
AB
ABC
ABCD
ABCDE

 */

fun main(args: Array<String>) {

    for(row in 'A'..'E'){
        for(column in 'A'..row){
            print(column)
        }
        println()
    }

}