package Response;

import java.io.*;
import java.util.Properties;

public class ResponseFile {

    public String baseUrl;
    public String consumerKey;
    public String consumerSecret;
    public String accessToken;
    public String tokenSecret;
    public String bearerToken;
    public String userId;


    public ResponseFile(){
        Properties prop = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("config.properties");
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        baseUrl = prop.getProperty("baseUrl");
        consumerKey = prop.getProperty("consumerKey");
        consumerSecret = prop.getProperty("consumerSecret");
        accessToken = prop.getProperty("accessToken");
        tokenSecret = prop.getProperty("tokenSecret");
        bearerToken = prop.getProperty("bearerToken");
        userId = prop.getProperty("userId");

    }



    public void responseMethod(String response) throws IOException {
        File fileObj = new File("response.json");
        if (fileObj.exists()){
            fileObj.delete();
        }
        if(fileObj.createNewFile()) {
            FileWriter myWriter = new FileWriter("response.json");
            myWriter.write(response);
            myWriter.close();
        }else {
            System.out.println("Failed");
        }
    }
}
