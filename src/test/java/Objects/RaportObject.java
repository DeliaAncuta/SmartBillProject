package Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter
public class RaportObject {

    private String email;
    private String password;
    private String message;

    private String codProdus;

    private String cantDoc;

    private String denumireProdus;

    public RaportObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    private void populateObject(HashMap<String, String> testData){
        for(String key:testData.keySet()){
            switch (key) {
                case "email":
                    setEmail(testData.get(key));
                    break;
                case "password":
                    setPassword(testData.get(key));
                    break;
                case "message":
                    setMessage(testData.get(key));
                    break;
                case "codProdus":
                    setCodProdus(testData.get(key));
                    break;
                case "cantDoc":
                    setCantDoc(testData.get(key));
                    break;
                case "denumireProdus":
                    setDenumireProdus(testData.get(key));
                    break;
            }
        }
    }
}
