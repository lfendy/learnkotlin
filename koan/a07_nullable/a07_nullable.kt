/*
// Rewrite this into kotlin
public void sendMessageToClient(
    @Nullable Client client,
    @Nullable String message,
    @NotNull Mailer mailer
) {
    if (client == null || message == null) return;

    PersonalInfo personalInfo = client.getPersonalInfo();
    if (personalInfo == null) return;

    String email = personalInfo.getEmail();
    if (email == null) return;

    mailer.sendMessage(email, message);
}
 */

fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
){
  println("sending")

  val email = client?.personalInfo?.email
  if(email == null || message == null) return

  mailer.sendMessage(email, message)

  println("end sending")
  println("")
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun main(args: Array<String> = arrayOf()) {
  val mailer = object : Mailer {
    override fun sendMessage(email: String, message: String): Unit =  println("Sending ${message} to ${email}")
  }

  val email = "some@where.out.there"
  val message = "my message"

  println("everythingIsOK")
  sendMessageToClient(Client(PersonalInfo(email)), message, mailer)

  println("noClient")
  sendMessageToClient(null, message, mailer)

  println("noMessage")
  sendMessageToClient(Client(PersonalInfo(email)), null, mailer)

  println("noPersonalInfo")
  sendMessageToClient(Client(null), message, mailer)

  println("noEmail")
  sendMessageToClient(Client(PersonalInfo(null)), message, mailer)
  println("")
  println("OK")
}

