package color;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Button btn_run;

    @FXML
    private Button btn_reset;

    @FXML
    private Slider slider_amber;

    @FXML
    private Slider slider_green;

    @FXML
    private Slider slider_white;

    @FXML
    private Slider slider_blue;

    @FXML
    private Slider slider_red;

    @FXML
    private TextField textField_red;

    @FXML
    private TextField textField_green;

    @FXML
    private TextField textField_blue;

    @FXML
    private TextField textField_white;

    @FXML
    private TextField textField_amber;

    @FXML
    private ChoiceBox<String> presets;

    @FXML
    void run(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        textField_red.focusedProperty().addListener((obs, oldVal, newVal) ->
                textField_red.fireEvent(new ActionEvent()));
        textField_green.focusedProperty().addListener((obs, oldVal, newVal) ->
                textField_green.fireEvent(new ActionEvent()));
        textField_blue.focusedProperty().addListener((obs, oldVal, newVal) ->
                textField_blue.fireEvent(new ActionEvent()));
        textField_white.focusedProperty().addListener((obs, oldVal, newVal) ->
                textField_white.fireEvent(new ActionEvent()));
        textField_amber.focusedProperty().addListener((obs, oldVal, newVal) ->
                textField_amber.fireEvent(new ActionEvent()));


        presets.setItems(FXCollections.observableArrayList(
                "First", "Second", "Third"));
    }

    @FXML
    void setColor(MouseEvent event) {
        Slider slider = (Slider) event.getSource();
        if (slider.equals(slider_red)) textField_red.setText(Long.toString(Math.round(slider.getValue())));
        else if (slider.equals(slider_green)) textField_green.setText(Long.toString(Math.round(slider.getValue())));
        else if (slider.equals(slider_blue)) textField_blue.setText(Long.toString(Math.round(slider.getValue())));
        else if (slider.equals(slider_white)) textField_white.setText(Long.toString(Math.round(slider.getValue())));
        else if (slider.equals(slider_amber)) textField_amber.setText(Long.toString(Math.round(slider.getValue())));
    }


    @FXML
    void setColorValue(ActionEvent event) {
        TextField textField = (TextField) event.getSource();
        int value;
        try {
            value = Integer.parseInt(textField.getText());
            if (value < 0 || value > 255) throw new IllegalArgumentException("Value must be between 0 and 255");

            else if (textField.equals(textField_red)) slider_red.setValue(value);
            else if (textField.equals(textField_green)) slider_green.setValue(value);
            else if (textField.equals(textField_blue)) slider_blue.setValue(value);
            else if (textField.equals(textField_white)) slider_white.setValue(value);
            else if (textField.equals(textField_amber)) slider_amber.setValue(value);
        } catch (Exception e) {
            textField.setText("");
        }
    }

    @FXML
    void highlightText(MouseEvent event) {
        TextField textField = (TextField) event.getSource();
        textField.selectAll();
    }

}
