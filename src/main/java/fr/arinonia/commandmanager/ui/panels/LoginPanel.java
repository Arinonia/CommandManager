package fr.arinonia.commandmanager.ui.panels;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui.panels
 */
public class LoginPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        this.layout.getChildren().add(createLoginPanel());
    }

    private GridPane createLoginPanel(){
        GridPane layout = new GridPane();
        GridPane.setHgrow(layout, Priority.ALWAYS);
        GridPane.setVgrow(layout, Priority.ALWAYS);
        GridPane.setHalignment(layout, HPos.CENTER);
        GridPane.setValignment(layout, VPos.CENTER);
        layout.setMaxWidth(600.0D);
        layout.setMaxHeight(380.0D);
        layout.setStyle("-fx-background-color: #32424A");

        Label label = new Label("Welcome on CommandManager");
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setVgrow(label, Priority.ALWAYS);
        GridPane.setValignment(label, VPos.TOP);
        GridPane.setHalignment(label, HPos.CENTER);
        label.setStyle("-fx-font-size: 22px; -fx-text-fill: #80cbc4; -fx-font-family: Roboto;");
        label.setTranslateY(10.0D);
        layout.getChildren().add(label);


        Label emailLabel = new Label("Email:");
        GridPane.setHgrow(emailLabel, Priority.ALWAYS);
        GridPane.setVgrow(emailLabel, Priority.ALWAYS);
        GridPane.setValignment(emailLabel, VPos.TOP);
        GridPane.setHalignment(emailLabel, HPos.CENTER);
        emailLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #82aaff; -fx-font-family: Roboto;");
        emailLabel.setTranslateY(70.0D);
        emailLabel.setTranslateX(-108.0D);
        layout.getChildren().add(emailLabel);

        JFXTextField emailField = new JFXTextField();
        GridPane.setHgrow(emailField, Priority.ALWAYS);
        GridPane.setVgrow(emailField, Priority.ALWAYS);
        GridPane.setValignment(emailField, VPos.CENTER);
        GridPane.setHalignment(emailField, HPos.CENTER);

        emailField.setTranslateY(-75.0D);
        emailField.setMaxSize(250.0D, 40.0D);
        emailField.setMinSize(250.0D, 40.0D);
        emailField.setStyle("-fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4; -fx-font-family: Roboto;");
        layout.getChildren().add(emailField);

        Label passwordLabel = new Label("Mot de passe:");
        GridPane.setHgrow(passwordLabel, Priority.ALWAYS);
        GridPane.setVgrow(passwordLabel, Priority.ALWAYS);
        GridPane.setValignment(passwordLabel, VPos.CENTER);
        GridPane.setHalignment(passwordLabel, HPos.CENTER);
        passwordLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #82aaff; -fx-font-family: Roboto;");
        passwordLabel.setTranslateY(-10.0D);
        passwordLabel.setTranslateX(-81.0D);
        layout.getChildren().add(passwordLabel);

        JFXPasswordField passwordField = new JFXPasswordField();
        GridPane.setHgrow(passwordField, Priority.ALWAYS);
        GridPane.setVgrow(passwordField, Priority.ALWAYS);
        GridPane.setValignment(passwordField, VPos.CENTER);
        GridPane.setHalignment(passwordField, HPos.CENTER);

        passwordField.setTranslateY(25.0D);
        passwordField.setMaxSize(250.0D, 40.0D);
        passwordField.setMinSize(250.0D, 40.0D);
        passwordField.setStyle("-fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4; -fx-font-family: Roboto;");
        layout.getChildren().add(passwordField);

        JFXButton connectButton = new JFXButton("SE CONNECTER");
        GridPane.setHgrow(connectButton, Priority.ALWAYS);
        GridPane.setVgrow(connectButton, Priority.ALWAYS);
        GridPane.setValignment(connectButton, VPos.BOTTOM);
        GridPane.setHalignment(connectButton, HPos.CENTER);
        connectButton.setTranslateY(-50.0D);
        connectButton.setMaxSize(200.0D, 50.0D);
        connectButton.setMinSize(200.0D, 50.0D);
        connectButton.setStyle("-fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4; -fx-font-family: Roboto;");
        connectButton.setOnMouseEntered(e -> this.layout.setCursor(Cursor.HAND));
        connectButton.setOnMouseExited(e -> this.layout.setCursor(Cursor.DEFAULT));
        connectButton.setOnMouseClicked(e -> this.tryToConnect(emailField, passwordField));
        layout.getChildren().add(connectButton);
        return layout;
    }

    private void tryToConnect(JFXTextField emailField, JFXPasswordField passwordField){
        /*if (emailField.getText().isEmpty()){
            emailField.requestFocus();
            emailField.setStyle("-jfx-focus-color: #aa141a; -fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4");
            return;
        }
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailField.getText());
        if (!matcher.matches()){
            emailField.setText("");
            emailField.setPromptText("Veuillez entrer un email valide!");
            emailField.requestFocus();
            emailField.setStyle("-jfx-focus-color: #aa141a; -fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4; -fx-prompt-text-fill: #fff");
            return;
        }
        if (passwordField.getText().isEmpty()){
            passwordField.requestFocus();
            passwordField.setStyle("-jfx-focus-color: #aa141a; -fx-font-size: 16px; -fx-background-color: #3e4f57; -fx-text-fill: #80cbc4");
            return;
        }

        final String email = emailField.getText();
        final String password = passwordField.getText();
        passwordField.setText("");
        System.out.println(email);*/

        this.panelManager.showPanel(new HomePanel());
    }

}
