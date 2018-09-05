package co.yuito.fizzbuzz

import org.scalatest.FunSpec

class FizzBuzzSpec extends FunSpec {

  describe(".run") {
    Seq(
      ("1", 1),
      ("Fizz", 3),
      ("Fizz", -3),
      ("Fizz", 6),
      ("Buzz", 5),
      ("Buzz", 10),
      ("FizzBuzz", 15),
      ("FizzBuzz", 30)
    ).foreach { case (expected, x) =>
      it(s"value = $x , expect = $expected") {
        assert(FizzBuzz.run(x) == expected)
      }
    }
  }

}
