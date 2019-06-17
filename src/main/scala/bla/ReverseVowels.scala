package bla

import scala.annotation.tailrec

object ReverseVowels {
  private type Vowel = Char
  private type VowelReversed = Char
  private val Vowels = Seq('a', 'e', 'i', 'o', 'u')

  def reverseVowels(input: String): String = {
    /**
     * Traverses the sequence (or [[Seq]] in Scala) of [[Char]] using recursive call.
     *
     * If the head of the list is the vowel to be reversed, we'll just reverse the vowel.
     *
     * Otherwise, we'll just leave the char as is.
     */
    @tailrec
    def traverse(charsWithIndex: Seq[Char], vowelsWithReverse: Seq[(Vowel, VowelReversed)], result: String): String =
      // Calling headOption on a Sequence will return None if the list is empty
      charsWithIndex.headOption match {
        case None => result // In this case, we're done
        case Some(char) =>
          // See if there's more vowels to be reversed
          vowelsWithReverse.headOption match {
            case Some((vowel, reverse)) if char == vowel =>
              // If the vowels to be reversed is the same as the current character, we'll append the reverse.
              traverse(charsWithIndex.drop(1), vowelsWithReverse.drop(1), result + reverse.toString)
            case _ =>
              // Otherwise, we'll leave it as-is
              traverse(charsWithIndex.drop(1), vowelsWithReverse, result + char.toString)
          }
      }

    // Converts String to a sequence of Char
    val chars = input.iterator.toSeq
    val vowels = chars.filter(c => Vowels.contains(c))
    val vowelsReversed = vowels.reverse

    // Zip combines two sequence, i.e. Seq('a', 'i', 'o').zipWith(Seq('o', 'i', 'a')) gives
    // Seq(('a', 'o'), ('i', 'i'), ('o', 'a')) where ('a', 'o') is a tuple of 2 Chars.
    val vowelsWithReverse = vowels.zip(vowelsReversed)

    traverse(chars, vowelsWithReverse, "")
  }
}
