import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener, ReceiveEventListner {
    private final MqttClass mqtt;

    public MyFrame(MqttClass mqtt) {
        this();
        this.mqtt = mqtt;
        //receive msg Call
        this.mqtt.setMyEventListner(this);
    }

    @Override
    public void recvMsg(String topic, MqttMessage msg) {
        //msg -> String 형태로 저장
        //MqttMessage json 바이트 배열로만든다음에 new String 해야함 ..
        System.out.println(topic+":"+msg);
        //데이터를 가져와서 저장.......?9999
        String tmp =


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
