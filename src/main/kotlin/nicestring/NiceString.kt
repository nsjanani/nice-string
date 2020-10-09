package nicestring

fun String.isNice() : Boolean {

    val noSubStringPredicate= (!this.contains("bu"))
            .and(!this.contains("ba"))
            .and(!this.contains("be"))

    val atLeastThreeVowelPredicate = this.count{
        it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
    } >= 3

    val doubleLetterPredicate = this.zipWithNext().firstOrNull {
        (first, second) ->  first == second
    } != null

    return (noSubStringPredicate && atLeastThreeVowelPredicate)
            .or(atLeastThreeVowelPredicate && doubleLetterPredicate)
            .or(doubleLetterPredicate && noSubStringPredicate)

}