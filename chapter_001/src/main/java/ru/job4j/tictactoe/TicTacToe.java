package ru.job4j.tictactoe;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * TicTacToe
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.08.2018
 */
public class TicTacToe extends Application {

    /**
     * Label on top
     */
    private static final String JOB4J = "Крестики-нолики www.job4j.ru";

    /**
     * Amount of rows and columns
     */
    private final int size = 3;

    /**
     * Empty array of Figure3T objects
     */
    private final Figure3T[][] cells = new Figure3T[size][size];

    /**
     * Object with checking logic
     */
    private final Logic3T logic = new Logic3T(cells);

    /**
     * Create a Rectangle
     * @param x value of the property X coordinate of the upper-left corner of the rectangle
     * @param y value of the property Y coordinate of the upper-left corner of the rectangle
     * @param size
     * @return Rectangle
     */
    private Figure3T buildRectangle(int x, int y, int size) {
        Figure3T rect = new Figure3T();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        return rect;
    }

    /**
     * Method buildMarkO
     * @param x
     * @param y
     * @param size
     * @return MarkO
     */
    private Group buildMarkO(double x, double y, int size) {
        Group group = new Group();
        int radius = size / 2;
        Circle circle = new Circle(x + radius, y + radius, radius - 10);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        group.getChildren().add(circle);
        return group;
    }

    /**
     * Method showAlert shows Alert
     * @param message contain message
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(JOB4J);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Method checkState check, if empty cell exist
     * @return boolean, if empty cell exist than true
     */
    private boolean checkState() {
        boolean gap = this.logic.hasGap();
        if (!gap) {
            this.showAlert("Все поля запонены! Начните новую Игру!");
        }
        return gap;
    }

    /**
     * Method checkWinner check who is won
     */
    private void checkWinner() {
        if (this.logic.isWinnerX()) {
            this.showAlert("Победили Крестики! Начните новую Игру!");
        } else if (this.logic.isWinnerO()) {
            this.showAlert("Победили Нолики! Начните новую Игру!");
        }
    }

    /**
     * Method buildMarkX
     * @param x
     * @param y
     * @param size
     * @return buildMarkX
     */
    private Group buildMarkX(double x, double y, int size) {
        Group group = new Group();
        group.getChildren().addAll(
                new Line(
                        x + 10, y  + 10,
                        x + size - 10, y + size - 10
                ),
                new Line(
                        x + size - 10, y + 10,
                        x + 10, y + size - 10
                )
        );
        return group;
    }

    /**
     * Method buildMouseEvent
     * @param panel
     * @return event
     */
    private EventHandler<MouseEvent> buildMouseEvent(Group panel) {
        return event -> {
            Figure3T rect = (Figure3T) event.getTarget();
            if (this.checkState()) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    rect.take(true);
                    panel.getChildren().add(
                            this.buildMarkX(rect.getX(), rect.getY(), 50)
                    );
                } else {
                    rect.take(false);
                    panel.getChildren().add(
                            this.buildMarkO(rect.getX(), rect.getY(), 50)
                    );
                }
                this.checkWinner();
                this.checkState();
            }
        };
    }

    /**
     * Method buildGrid
     * @return
     */
    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                Figure3T rect = this.buildRectangle(x, y, 50);
                this.cells[y][x] = rect;
                panel.getChildren().add(rect);
                rect.setOnMouseClicked(this.buildMouseEvent(panel));
            }
        }
        return panel;
    }

    /**
     * Method start this game
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Начать");
        start.setOnMouseClicked(
                event -> border.setCenter(this.buildGrid())
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 300, 300));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }
}
