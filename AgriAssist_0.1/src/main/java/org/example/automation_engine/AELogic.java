package org.example.automation_engine;

import com.google.gson.Gson;

public class AELogic {
    public static void startEngineLogic(String data) {
        //convert json to java object
        createObjectFromJson(data);

    }

    public static SensorData createObjectFromJson(String json) {
        //Gson gson = new Gson();
        //return gson.fromJson(json, SensorData.class);
        return null;
    }
}
