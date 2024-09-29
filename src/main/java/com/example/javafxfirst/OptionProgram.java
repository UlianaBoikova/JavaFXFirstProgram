package com.example.javafxfirst;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Peggy Fisher
 */
public class Hello extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Создаем ComboBox и добавляем элементы
        ComboBox<String> comboBox = new ComboBox<>();

        comboBox.getItems().addAll("Option 1", "Option 2", "Option 3", "Option 4");


        // Создаем Label для отображения выбранного элемента
        Label label = new Label("");

        VBox layout = new VBox(10, label, comboBox);

        // Создаем сцену и настраиваем окно
        Scene scene = new Scene(layout, 300, 200);

        // Обработчик события выбора элемента
        comboBox.setOnAction(event -> {
            String selectedItem = comboBox.getSelectionModel().getSelectedItem();
            switch (selectedItem) {
                case "Option 1" -> label.setText(String.valueOf(java.time.LocalDateTime.now()));
                case "Option 2" -> {
                    try {
                        FileWriter writer = new FileWriter("log.txt");
                        writer.write(String.valueOf(java.time.LocalDateTime.now()));
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка при записи в файл");
                        e.printStackTrace();
                    }
                }
                case "Option 3" -> {
                    Random rn = new Random();
                    int randomNum = rn.nextInt(255 - 30 + 1) + 30;
                    layout.setBackground(new Background(new BackgroundFill(Color.rgb(randomNum / 3, randomNum, randomNum / 3), null, null)));
                }
                default -> System.exit(0);
            }

        });

        // Создаем макет и добавляем элементы

        primaryStage.setTitle("Пример ComboBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
