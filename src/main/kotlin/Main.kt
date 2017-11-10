import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

fun main(args: Array<String>) {
    val mqtt = MqttClient("tcp://localhost:1883", MqttClient.generateClientId(), MemoryPersistence())
    mqtt.setCallback(Handlers)
    mqtt.connect(MqttConnectOptions())
    mqtt.subscribe("/commands/apps/#")
}
