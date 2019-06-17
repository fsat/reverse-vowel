package bla

import org.scalatest.{ FunSpec, Matchers }
import ReverseVowels.reverseVowels

class ReverseVowelsTest extends FunSpec with Matchers {
  Seq(
    "pttg" -> "pttg",
    "hello darling" -> "hilla dorleng",
    "hello peeps how are you today" -> "hallo puops hew aro yee todey").foreach { v =>
      val (input, expected) = v

      it(s"reverses [$input] correctly") {
        val result = reverseVowels(input)
        result shouldBe expected
      }

      it(s"revert everything back if double reverse is applied to [$input]") {
        reverseVowels(reverseVowels(input)) shouldBe input
      }
    }
}
