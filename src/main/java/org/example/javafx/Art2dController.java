package org.example.javafx;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.security.SecureRandom;

public class Art2dController {
    @FXML
    private Pane pane;

    @FXML
    protected void onButtonCircleClick() {

        SecureRandom randomInt = new SecureRandom();

        final double[] red = {randomInt.nextDouble()};
        final double[] green = {randomInt.nextDouble()};
        final double[] blue = {randomInt.nextDouble()};

        Circle newCircle = new Circle(randomInt.nextInt(100), randomInt.nextInt(100), randomInt.nextInt(100));
        newCircle.setFill(new Color(red[0], green[0], blue[0],1.0));

        newCircle.setLayoutX(randomInt.nextInt(700 - 100 + 1));
        newCircle.setLayoutY(randomInt.nextInt(580 - 107 + 1));

        newCircle.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                newCircle.setUserData(new double[]{e.getX(), e.getY()});
                newCircle.toFront();
            }
        });
        newCircle.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                double[] start = (double[]) newCircle.getUserData();
                double deltaX = e.getX() - start[0];
                double deltaY = e.getY() - start[1];

                newCircle.setCenterX(newCircle.getCenterX() + deltaX);
                newCircle.setCenterY(newCircle.getCenterY() + deltaY);

                newCircle.setUserData(new double[]{e.getX(), e.getY()});
            }
        });
        newCircle.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {

                red[0] = randomInt.nextDouble();
                green[0] = randomInt.nextDouble();
                blue[0] = randomInt.nextDouble();

                newCircle.setFill(new Color(red[0], green[0], blue[0],1.0));
            }
        });
        pane.getChildren().add(newCircle);
    }
    @FXML
    protected void onButtonRectangleClick() {

        SecureRandom randomInt = new SecureRandom();

        final double[] red = {randomInt.nextDouble()};
        final double[] green = {randomInt.nextDouble()};
        final double[] blue = {randomInt.nextDouble()};

        Rectangle newRectangle = new Rectangle(randomInt.nextInt(100), randomInt.nextInt(100));
        newRectangle.setFill(new Color(red[0], green[0], blue[0],1.0));

        newRectangle.setLayoutX(randomInt.nextInt(700 - 100 + 1));
        newRectangle.setLayoutY(randomInt.nextInt(580 - 107 + 1));

        newRectangle.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                newRectangle.setUserData(new double[]{e.getX(), e.getY()});
                newRectangle.toFront();
            }
        });
        newRectangle.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                double[] start = (double[]) newRectangle.getUserData();
                double deltaX = e.getX() - start[0];
                double deltaY = e.getY() - start[1];

                newRectangle.setX(newRectangle.getX() + deltaX);
                newRectangle.setY(newRectangle.getY() + deltaY);

                newRectangle.setUserData(new double[]{e.getX(), e.getY()});
            }
        });
        newRectangle.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {

                red[0] = randomInt.nextDouble();
                green[0] = randomInt.nextDouble();
                blue[0] = randomInt.nextDouble();

                newRectangle.setFill(new Color(red[0], green[0], blue[0],1.0));
            }
        });
        pane.getChildren().add(newRectangle);
    }
}