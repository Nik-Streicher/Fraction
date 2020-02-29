package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import fraction.*;

public class Controller implements Initializable {

    @FXML
    private TextField paramFieldOne1;

    @FXML
    private TextField paramFieldOne2;

    @FXML
    private TextField paramFieldTwo1;

    @FXML
    private TextField paramFieldTwo2;

    @FXML
    private TextField resultLabel1;

    @FXML
    private TextField resultLabel2;

    @FXML
    private ComboBox<Character> comboBox;

    @FXML
    void calc(ActionEvent event) {

        if (Integer.parseInt(paramFieldTwo1.getText()) == 0 || Integer.parseInt(paramFieldTwo2.getText()) == 0) {
            resultLabel1.setText("0");
            resultLabel2.setText("0");

        } else {
            Fraction fraction1 = new Fraction(Integer.parseInt(paramFieldOne1.getText()), Integer.parseInt(paramFieldOne2.getText()));
            Fraction fraction2 = new Fraction(Integer.parseInt(paramFieldTwo1.getText()), Integer.parseInt(paramFieldTwo2.getText()));
            IFraction resultFraction;

            switch (comboBox.getSelectionModel().getSelectedItem()) {
                case '+':
                    resultFraction = fraction1.add(fraction2);
                    resultLabel1.setText(String.valueOf(resultFraction.getNumerator()));
                    resultLabel2.setText(String.valueOf(resultFraction.getDenominator()));
                    break;
                case '-':
                    resultFraction = fraction1.minus(fraction2);
                    resultLabel1.setText(String.valueOf(resultFraction.getNumerator()));
                    resultLabel2.setText(String.valueOf(resultFraction.getDenominator()));
                    break;
                case '*':
                    resultFraction = fraction1.times(fraction2);
                    resultLabel1.setText(String.valueOf(resultFraction.getNumerator()));
                    resultLabel2.setText(String.valueOf(resultFraction.getDenominator()));
                    break;
                case '/':
                    resultFraction = fraction1.dividedBy(fraction2);
                    resultLabel1.setText(String.valueOf(resultFraction.getNumerator()));
                    resultLabel2.setText(String.valueOf(resultFraction.getDenominator()));
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Character> operation = FXCollections.observableArrayList('+', '-', '*', '/');
        comboBox.setItems(operation);
        comboBox.getSelectionModel().selectFirst();
    }
}
