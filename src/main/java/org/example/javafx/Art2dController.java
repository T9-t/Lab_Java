package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Art2dController {
    @FXML
    private Pane pane;

    @FXML
    protected void onButtonCircleClick() {

        Circle newCircle = new Circle(Math.floor(Math.random() * 100), Math.floor(Math.random() * 100), Math.floor(Math.random() * 100));
        newCircle.setFill(javafx.scene.paint.Color.color(Math.random(), Math.random(), Math.random()));

        newCircle.setLayoutX(Math.floor(Math.random() * (606 - 100 + 1)));
        newCircle.setLayoutY(Math.floor(Math.random() * (378 - 107 + 1)));

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
                newCircle.setFill(javafx.scene.paint.Color.color(Math.random(), Math.random(), Math.random()));
            }
        });
        pane.getChildren().add(newCircle);
    }
    @FXML
    protected void onButtonRectangleClick() {

        Rectangle newRectangle = new Rectangle(Math.floor(Math.random() * 100), Math.floor(Math.random() * 100));
        newRectangle.setFill(javafx.scene.paint.Color.color(Math.random(), Math.random(), Math.random()));
        newRectangle.setLayoutX(Math.floor(Math.random() * (606 - 100 + 1)));
        newRectangle.setLayoutY(Math.floor(Math.random() * (378 - 107 + 1)));

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
                newRectangle.setFill(javafx.scene.paint.Color.color(Math.random(), Math.random(), Math.random()));
            }
        });
        pane.getChildren().add(newRectangle);
    }
}