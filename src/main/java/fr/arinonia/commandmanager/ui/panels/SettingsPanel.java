package fr.arinonia.commandmanager.ui.panels;

import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panel.Panel;
import javafx.scene.control.Label;

/**
 * Created by Arinonia on 14/09/2020 inside the package - fr.arinonia.commandmanager.ui.panels
 */
public class SettingsPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        Label label = new Label(this.getClass().getName().substring(this.getClass().getPackage().getName().length() + 1).replace("Panel", ""));
        label.setStyle("-fx-text-fill: #fff; -fx-font-size: 22px;");
        this.layout.getChildren().add(label);
    }
}
