package co.yuito.calculator

import org.scalatest.FunSpec

class CalculatorSpec extends FunSpec {

  describe("#add") {
    describe("when x = 2, y = 2") {
      it("should return 4.") {
        assert(Calculator.add(2,2) == 4)
      }
    }
  }

}
