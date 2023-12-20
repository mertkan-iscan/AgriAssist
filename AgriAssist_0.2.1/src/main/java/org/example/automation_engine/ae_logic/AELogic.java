package org.example.automation_engine.ae_logic;

import org.example.automation_engine.AEServer;
import org.example.automation_engine.sensor_data_converter.DataConverter;
import org.example.automation_engine.sensor_data_converter.SensorData;

public class AELogic {
    public static void startOperations(String json){
        SensorData sensorData = DataConverter.convertSensorData(json);


        assert sensorData != null;
        System.out.println(sensorData.getSensorType());
        AEServer.sendDataToApp(json);
    }
    //notes:
    //add cool down procedure for sensor data (it will take time to change received sensor data after actuators started)
}
