package co.yuito.user

import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class UserSpec extends FunSpec {

  describe(".validate") {
    val fractions = Table(
      ("password", "result"),
      ("password", true),
      ("passwor", false)
    )
    forAll (fractions) { (password , result) =>
      describe(s"パスワードが${password.length}文字のとき") {
        it(s"${result}を返す") {
          val user = User(password, "name")
          assert(user.validate == result)
        }
      }
    }
  }

  describe(".getSignature") {
    describe("会社名がない場合は氏名のみ表示") {
      it("署名を返す") {
        val name = "氏名"
        val user = User("password", name)
        assert(user.getSignature == s"$name OK")
      }

      it("氏名2 OK を返す") {
        val name = "氏名2"
        val user = User("password", name)
        assert(user.getSignature == s"$name OK")
      }
    }
  }

}
