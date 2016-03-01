package esi.atl.g39121.td3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label titleDonnees = new Label("Données");
        titleDonnees.setUnderline(true);
        Label size = new Label("Taille(cm)");
        Label weight = new Label("Poids(kg)");
        Label age = new Label("Age (années)");
        Label sex = new Label("Sexe");
        Label style = new Label("Style de vie");

        gridPane.add(titleDonnees,0,0);
        gridPane.add(size,0,1);
        gridPane.add(weight,0,2);
        gridPane.add(age,0,3);
        gridPane.add(sex,0,4);
        gridPane.add(style,0,5);

        TextField sizeT = new TextField();
        sizeT.setPromptText("Taille en cm");
        TextField weightT = new TextField();
        weightT.setPromptText("Poids en kg");
        TextField ageT = new TextField();
        ageT.setPromptText("Age en années");
        RadioButton sexeF = new RadioButton("Femme");
        sexeF.setSelected(true);
        RadioButton sexeM = new RadioButton("Homme");
        ToggleGroup toggleGroupSex = new ToggleGroup();
        sexeF.setToggleGroup(toggleGroupSex);
        sexeM.setToggleGroup(toggleGroupSex);
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll(StyleOfLife.values());
        choiceBox.getSelectionModel().selectFirst();


        gridPane.add(sizeT,1,1);
        gridPane.add(weightT,1,2);
        gridPane.add(ageT,1,3);
        HBox hBox = new HBox();
        hBox.getChildren().add(sexeF);
        hBox.getChildren().add(sexeM);
        gridPane.add(hBox,1,4);
        gridPane.add(choiceBox,1,5);

        Label result = new Label("Résultats");
        result.setUnderline(true);
        Label bmr = new Label("BMR");
        Label calo = new Label("Calories ");

        gridPane.add(result,2,0);
        gridPane.add(bmr,2,1);
        gridPane.add(calo,2,2);

        TextField bmrT = new TextField();
        bmrT.setEditable(false);
        bmrT.setPromptText("Résultats de BMR");
        TextField caloT = new TextField();
        caloT.setEditable(false);
        caloT.setPromptText("Dépense en calories");

        gridPane.add(bmrT,3,1);
        gridPane.add(caloT,3,2);

        Button button = new Button("Calculer");
        GridPane.setHalignment(button, HPos.CENTER);
        button.setMinWidth(500);
        gridPane.add(button,0,6,4,1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int taille, poids, age;
                boolean sexe;
                double val;
                try {
                    taille = Integer.parseInt(sizeT.getText());
                    poids = Integer.parseInt(weightT.getText());
                    age = Integer.parseInt(ageT.getText());
                    val = ((StyleOfLife) choiceBox.getValue()).getVal();
                    Double result = BmrCalcul.bmr(poids,taille,age,sexeF.isSelected());
                    bmrT.setText(result.toString());
                    Double calo = result * val;
                    caloT.setText(calo.toString());
                } catch (Exception e) {
                    bmrT.setText("Failed");
                    caloT.setText("Failed");
                }
            }
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
