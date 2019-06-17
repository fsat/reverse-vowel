package bla

object ReverseVowels {
  private type Vowel = Char
  private type VowelReversed = Char
  private val Vowels = Seq('a', 'e', 'i', 'o', 'u')

  def reverseVowels(input: String): String = {
    def traverse(charsWithIndex: Seq[Char], vowelsWithReverse: Seq[(Char, Char)], result: String): String =
      charsWithIndex.headOption match {
        case None => result
        case Some(v) =>
          if (vowelsWithReverse.headOption.map(_._1).contains(v)) {
            val vowelsToAppend = vowelsWithReverse.head._2
            traverse(charsWithIndex.tail, vowelsWithReverse.tail, result + vowelsToAppend)
          } else
            traverse(charsWithIndex.tail, vowelsWithReverse, result + v)

      }

    val chars = input.iterator.toSeq
    val vowels = chars.filter(Vowels.contains)
    val vowelsReversed = vowels.reverse
    val vowelsWithReverse = vowels.zip(vowelsReversed)
    traverse(chars, vowelsWithReverse, "")
  }
}
