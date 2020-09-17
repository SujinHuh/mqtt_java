import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class MqttClass implements MqttCallback {


    // MqttCallback -> Led <이벤트가 발생했을때 background에서 처리 / Subscribe에 Data가 들어왔을 때 >
    private MqttClient client = null;

    public MqttClass() {

        // Server Connect - Run
        new Thread(task1).start();

    }

    Runnable task1 = new Runnable() {
        @Override
        public void run() {
            try {
                //clientId -> random Id를 만들 주는 것
                String clientId = UUID.randomUUID().toString();

                // new MqttClient() / client 생성 중요 IP주소 넣기 {자신 ip address}
                client = new MqttClient("tcp://10.0.0.8", clientId);

                MqttConnectOptions connopt = new MqttConnectOptions();
                //Mqtt Disconnect and reconnect
                connopt.setCleanSession(true);
                client.connect(connopt);

                // Function call 자기 자신이 실행됨 messageArrived가 실행
                client.setCallback(MqttClass.this);

                // 수신자나 등록 sub dcuNumber에 정보가 들어오면 setCallback
                client.subscribe("dcuNumber");

                //화면에 뜨는것...? Frame
                new MyFrame(MqttClass.this);
                // String Format Data

            }
            catch (MqttException e) {
                System.out.println("ERR"+e.getStackTrace());
            }
        }
    };

    public void sendMessage(String data) {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload();
    }

    // MqttCallback (Sub에 들어왔을때 처리하는 것 ) - 메서드 구현
    @Override
    public void connectionLost(Throwable throwable) {

    }

    // MqttCallback (Sub에 들어왔을때 처리하는 것 ) - 메서드 구현
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    // MqttCallback (Sub에 들어왔을때 처리하는 것 ) - 메서드 구현
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
