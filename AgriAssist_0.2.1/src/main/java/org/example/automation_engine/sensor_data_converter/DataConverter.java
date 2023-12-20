package org.example.automation_engine.sensor_data_converter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataConverter {
    public static SensorData convertSensorData(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        if (jsonObject.has("sensorType")) {
            String sensorType = jsonObject.get("sensorType").getAsString();
            switch (sensorType) {
                case "Weather Sensor":
                    return convertWeatherDataToObject(json);
                case "Soil Sensor":
                    return convertSoilDataToObject(json);
                default:
                    System.out.println("Unknown sensor type");
                    return null;
            }
        } else {
            System.out.println("JSON does not contain 'sensorType'");
            return null;
        }
    }

    public static WeatherSensorData convertWeatherDataToObject(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, WeatherSensorData.class);
    }

    public static SoilSensorData convertSoilDataToObject(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, SoilSensorData.class);
    }
}
