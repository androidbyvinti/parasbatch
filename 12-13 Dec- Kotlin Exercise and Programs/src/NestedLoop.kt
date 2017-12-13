
/*

*
**
***
****
*****

 */

fun main(args: Array<String>) {

//    for(i in 1..3){
//     for(j in 1..3){
//         println("value of i = $i value of j = $j")
//     }
//    }

    for(row in 1..5){
        for(column in 1..row){
            print("*")
        }
        println()
    }
}