import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

fun startApp(payload: String) {
    println("Starting app: $payload")
}

fun stopApp(payload: String) {
    println("Stopping app: $payload")
}

object Handlers : MqttCallback {
    override fun connectionLost(cause: Throwable) {}
    override fun deliveryComplete(token: IMqttDeliveryToken) {}

    @Throws(Exception::class)
    override fun messageArrived(topic: String, message: MqttMessage) {
        val command = topic.split("/")[3]
        val payload = String(message.payload)
        when (command) {
            "start" -> startApp(payload)
            "stop" -> stopApp(payload)
            else -> {
                println("Unknown command $command; mqtt topic $topic")
            }
        }
    }
}