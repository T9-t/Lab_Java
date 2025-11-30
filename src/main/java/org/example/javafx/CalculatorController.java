package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorController {

    @FXML
    protected void onButtonOneClick(){ onButtonClick(1); }
    @FXML
    protected void onButtonTwoClick(){ onButtonClick(2); }
    @FXML
    protected void onButtonThreeClick(){ onButtonClick(3); }
    @FXML
    protected void onButtonFourClick(){ onButtonClick(4); }
    @FXML
    protected void onButtonFiveClick(){ onButtonClick(5); }
    @FXML
    protected void onButtonSixClick(){ onButtonClick(6); }
    @FXML
    protected void onButtonSevenClick(){ onButtonClick(7); }
    @FXML
    protected void onButtonEightClick(){ onButtonClick(8); }
    @FXML
    protected void onButtonNineClick(){ onButtonClick(9); }
    @FXML
    protected void onButtonZeroClick(){ onButtonClick(0);}

    @FXML
    protected void onButtonAddingClick(){ onButtonClick('+');}
    @FXML
    protected void onButtonSubtractionClick(){ onButtonClick('-');}
    @FXML
    protected void onButtonMultiplicationClick(){ onButtonClick('*');}
    @FXML
    protected void onButtonDividingClick(){ onButtonClick('/');}

    @FXML
    private TextField input;

    @FXML
    protected void initialize(){

        ArrayList<Character> signs = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));

        input.textProperty().addListener((observable, oldValue, newValue) -> {

            StringBuilder newText = new StringBuilder();
            boolean islastSign = false;

            for (int i = 0; i < newValue.length(); i++) {
                char c = newValue.charAt(i);

                if (Character.isDigit(c)) {

                    newText.append(c);
                    islastSign = false;
                }
                else if (signs.contains(c)) {
                    if (newText.length() == 0) {

                        newText.append('0').append(c);
                        islastSign = true;
                    }
                    else if (islastSign) {
                        newText.setCharAt(newText.length() - 1, c);
                    }
                    else {
                        newText.append(c);
                        islastSign = true;
                    }
                }
            }
            String finalText = newText.toString();
            if (!finalText.equals(newValue)) {
                input.setText(finalText);
                input.positionCaret(finalText.length());
            }
        });
    }
    private void onButtonClick(int i) {

        String text = input.getText();
        String newText = text + i;

        input.setText(newText);
    }
    private void onButtonClick(char s) {

        String text = input.getText();
        int length;
        int lastLetter;
        String newText = "";

        if (text.isEmpty()) {
            newText = 0 + String.valueOf(s);
        }
        else{
            length = text.length() - 1;
            lastLetter = Character.getNumericValue(text.charAt(length));

            if (lastLetter != -1) {
                newText = text + s;
            }
            else {
                newText = text.substring(0,length) + s;
            }
        }
        input.setText(newText);
    }
    @FXML
    protected void onButtonEqualsClick() {

        int j = 1;
        int endNumber;
        String newText = " ";
        boolean isZero = false;

        String text = input.getText();
        String[] textNumbers = text.split("[-/*+]");
        String signsString = text.replaceAll("\\d","");

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String i : textNumbers) {
            numbers.add(Integer.parseInt(i));
        }
        char[] signs = signsString.toCharArray();

        endNumber = numbers.getFirst();
        for (char sign : signs) {

            if (sign == '-') {
                endNumber = endNumber - numbers.get(j);
            } else if (sign == '+') {
                endNumber = endNumber + numbers.get(j);
            } else if (sign == '*') {
                endNumber = endNumber * numbers.get(j);
            } else if (sign == '/') {

                if (numbers.get(j) == 0) {
                    isZero = true;
                } else {
                    endNumber = endNumber / numbers.get(j);
                }
            }
            j++;
        }
        if (!isZero) {
            newText = "" + endNumber;
        }
        else {
            newText = "you can't divide by 0";
        }
        input.setText(newText);
    }
    @FXML
    protected void onButtonClearClick() {
        input.setText("");
    }
    @FXML
    protected void onButtonDelClick() {

        String text = input.getText();

        if (!text.isEmpty()) {
            input.setText(text.substring(0, text.length() - 1));
        }
    }
}