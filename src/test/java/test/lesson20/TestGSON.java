package test.lesson20;

import com.google.gson.Gson;
import test_data.models.LoginCredData;
import test_flows.authentication.LoginFlow;

public class TestGSON {

    public static void main(String[] args) {

        // Convert from Object to JSON
        LoginCredData loginCredData = new LoginCredData("Teo", "teo@sth.com");

        Gson gson = new Gson();
        System.out.println(gson.toJson(loginCredData));

        // Convert from JSON to Object
//        String loginCredJSONData = "{\"email\":\"Teo\",\"password\":\"teo@sth.com\"}";
        String loginCredJSONData = "[\n" +
                "  {\n" +
                "    \"email\": \"teo@sth.com\",\n" +
                "    \"password\": \"12345678\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"ti@sth.com\",\n" +
                "    \"password\": \"87654321\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"email\": \"tun@sth.com\",\n" +
                "    \"password\": \"12345678\"\n" +
                "  }\n" +
                "]";
        LoginCredData[] convertedFromJsons = gson.fromJson(loginCredJSONData, LoginCredData[].class);
        for (LoginCredData credData : convertedFromJsons) {
            System.out.println(credData);
        }
    }
}
