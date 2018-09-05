package co.yuito.user

import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class UserSpec extends FunSpec {

  describe(".validate") {
    val table = Table(
      ("description", "password", "expected"),
      ("パスワードが8文字以上の時", "password", true),
      ("パスワードが7文字以下の時", "passwor", false)
    )

    forAll (table) { (description, password, expected) =>
      describe(description) {
        it(s"${expected}を返す") {
          val user = User(password, "name", None, None)
          assert(user.validate == expected)
        }
      }
    }
  }

  describe(".getSignature") {
    val table = Table(
      ("description", "behavior", "user", "expected"),
      ("パスワードが正しい時", "末尾にOKが入る。", User("password", "name", None, None), "name OK"),
      ("パスワードが不正な時", "末尾にNGが入る。", User("passwor", "name", None, None), "name NG"),
      ("会社名と氏名が両方存在する時", "会社名 + 氏名 + 検証結果を署名として返す。", User("password", "name", Some("companyName"), None), "companyName: name OK"),
      ("氏名のみ存在する時", "氏名 + 検証結果を署名として返す。", User("password", "name", None, None), "name OK")
    )

    forAll (table) { (description, behavior, user, expected) =>
      describe(description) {
        it(s"${behavior + "「" + expected}」を返す") {
          assert(user.getSignature == expected)
        }
      }
    }
  }


//  describe(".getSignature") {
//    describe("検証結果が正しい場合") {
//      Seq(
//        (User(password = "password", name = "氏名"), "氏名 OK"),
//        (User(password = "password", name = "氏名2"), "氏名2 OK"),
//        (User(password = "password", name = ""), " OK")
//      ).foreach { case (user, expected) =>
//        describe("氏名のみ存在する場合") {
//          it(s"$expected を返す") {
//            assert(user.getSignature == expected)
//          }
//        }
//      }
//
//      Seq(
//        (User(password = "password", name = "氏名", companyName = "BizReach"), "BizReach: 氏名 OK")
//      ).foreach { case (user, expected) =>
//        describe("氏名と会社名存在する場合") {
//          it(s"$expected を返す") {
//            assert(user.getSignature == expected)
//          }
//        }
//      }
//    }
//
//    describe("検証結果が正しくない場合") {
//      Seq(
//        (User(password = "passwor", name = "氏名"), "氏名 NG")
//      ).foreach { case (user, expected) =>
//        it(s"$expected を返す") {
//          assert(user.getSignature == expected)
//        }
//      }
//    }
//
//    describe("検証結果が失敗の場合") {
//      it("署名にNGを返す") {
//        val name = "氏名"
//        val companyName = "BizReach"
//        val mailAddress = "hrmos@bizreach.co.jp"
//        val user = User(password = "passwor", name = name, companyName = companyName, mailAddress = mailAddress)
//        assert(user.getSignature == s"$companyName: $name NG")
//      }
//    }
//
//    describe("メールアドレスを登録する") {
//      it("メールアドレスが存在する") {
//        val name = "氏名"
//        val companyName = "BizReach"
//        val mailAddress = "hrmos@bizreach.co.jp"
//        val user = User(password = "passwor", name = name, companyName = companyName, mailAddress = mailAddress)
//        assert(user.hasMailaddress)
//      }
//
//      it("メールアドレスが存在しない") {
//        val name = "氏名"
//        val companyName = "BizReach"
//        val mailAddress = ""
//        val user = User(password = "passwor", name = name, companyName = companyName, mailAddress = mailAddress)
//        assert(!user.hasMailaddress)
//      }
//    }
//  }

}
