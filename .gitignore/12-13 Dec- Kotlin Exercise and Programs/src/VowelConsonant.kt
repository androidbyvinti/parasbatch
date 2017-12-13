

fun main(args: Array<String>) {

    var value = 'e'

//    if(value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u')
//        println("vowel")
//    else
//        println("consonant")
//

    when(value){
        'a',
        'e',
        'i',
        'o',
        'u' -> println("vowel")
        else -> println("consonant")
    }


}