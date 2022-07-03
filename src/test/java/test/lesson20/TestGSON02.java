package test.lesson20;

import com.google.gson.Gson;
import test_data.DataObjectBuilder;
import test_data.models.LoginCredData;

public class TestGSON02 {

    public static void main(String[] args) {
        String filePath = "/src/test/java/test_data/authen/LoginCreds.json";
        LoginCredData[] convertedFromJsons = DataObjectBuilder.buildDataObject(filePath, LoginCredData[].class);

        for (LoginCredData credData : convertedFromJsons) {
            System.out.println(credData);
        }
    }
}
