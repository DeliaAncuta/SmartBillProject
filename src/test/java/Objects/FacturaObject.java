package Objects;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class FacturaObject {

    private String email;
    private String password;
    private String message;

    private String client;

    private String codProdus;

    private String pret;

    private String message2;

    private String statusFactura;
    private String emailTrimitere;

    public FacturaObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    private void populateObject(HashMap <String, String> testData){
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
                case "client":
                    setClient(testData.get(key));
                    break;
                case "codProdus":
                    setCodProdus(testData.get(key));
                    break;
                case "pret":
                    setPret(testData.get(key));
                    break;
                case "messageValidare":
                    setMessage2(testData.get(key));
                    break;
                case "statusFactura":
                    setStatusFactura(testData.get(key));
                    break;
                case "emailTrimitere":
                    setEmailTrimitere(testData.get(key));
                    break;
            }
        }
    }
}
