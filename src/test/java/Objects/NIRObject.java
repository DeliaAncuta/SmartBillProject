package Objects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class NIRObject {
    private String email;
    private String password;
    private String message;

    private String furnizor;

    private String nrDocFurnizor;

    private String denumireProdus;
    private String codProdus;

    private String umProdus;
    private String cantDoc;
    private String cantPrimita;
    private String pret;

    private String message2;

    //Constructor
    public NIRObject(HashMap <String, String> testData) {
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
                case "furnizor":
                    setFurnizor(testData.get(key));
                    break;
                case "nrDocFurnizor":
                    setNrDocFurnizor(testData.get(key));
                    break;
                case "denumireProdus":
                    setDenumireProdus(testData.get(key));
                    break;
                case "codProdus":
                    setCodProdus(testData.get(key));
                    break;
                case "umProdus":
                    setUmProdus(testData.get(key));
                    break;
                case "cantDoc":
                    setCantDoc(testData.get(key));
                    break;
                case "cantPrimita":
                    setCantPrimita(testData.get(key));
                    break;
                case "pret":
                    setPret(testData.get(key));
                    break;
                case "messageValidare":
                    setMessage2(testData.get(key));
                    break;
            }
        }
    }

}
