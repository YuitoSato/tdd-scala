package co.yuito.user

case class User(
  password: String,
  name: String,
  companyNameOpt: Option[String],
  mailAddressOpt: Option[String]
) {

  def validate: Boolean = password.length >= 8

  def getSignature: String = {
    val result = if (validate) "OK" else "NG"
    val companyName = companyNameOpt.fold("")(_ + ": ")
    companyName + name + " " + result
  }

}
