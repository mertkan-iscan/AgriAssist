package org.example.automation_engine.ae_logic;

import com.google.gson.Gson;
import org.example.automation_engine.sensor_data_converter.DataConverter;
import org.example.automation_engine.sensor_data_converter.SensorData;

public class AELogic {
    public void startOperations(String json){
        SensorData sensorData = DataConverter.convertSensorData(json);

        assert sensorData != null;
        System.out.println(sensorData.getSensorType());
    }
}
