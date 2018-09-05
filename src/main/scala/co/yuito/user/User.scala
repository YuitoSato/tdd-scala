package co.yuito.user

case class User(password: String, name: String) {

  def validate: Boolean = password.length >= 8

  def getSignature: String = s"$name OK"

}
