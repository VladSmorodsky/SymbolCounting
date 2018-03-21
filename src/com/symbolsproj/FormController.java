package com.symbolsproj;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private TextArea txtAreaResult;
    @FXML
    private TextArea txtAreaSymbols;
    @FXML
    private Button clearBtn;
    @FXML
    private Button countBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        countBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent){

                String str = txtAreaSymbols.getText();

                Map<Character,Integer> map = new HashMap<>();
                for (Character ch : str.toCharArray()){
                    if (map.containsKey(ch)){
                        Integer total = map.get(ch);
                        map.put(ch, total + 1);
                    }
                    else {
                        map.put(ch,1);
                    }
                }

                for (Map.Entry entry: map.entrySet()) {
                    String key = entry.getKey().toString();
                    int value = (int) entry.getValue();
                    txtAreaResult.appendText(key+":"+value+"\n");
                }

            }
        });

        clearBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent){
                txtAreaSymbols.clear();
                txtAreaResult.clear();
            }
        });

    }
}
