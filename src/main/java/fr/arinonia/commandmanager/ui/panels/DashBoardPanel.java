package fr.arinonia.commandmanager.ui.panels;

import fr.arinonia.commandmanager.Main;
import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

/**
 * Created by Arinonia on 14/09/2020 inside the package - fr.arinonia.commandmanager.ui.panels
 */
public class DashBoardPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        Label title = new Label(this.getClass().getName().substring(this.getClass().getPackage().getName().length() + 1).replace("Panel", ""));
        title.setStyle("-fx-text-fill: #fff; -fx-font-family: Roboto; -fx-font-size: 22px");
        GridPane.setVgrow(title, Priority.ALWAYS);
        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setValignment(title, VPos.TOP);
        title.setTranslateY(15.0D);
        this.layout.getChildren().add(title);
    }
}
