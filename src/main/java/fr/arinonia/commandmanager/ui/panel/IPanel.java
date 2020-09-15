package fr.arinonia.commandmanager.ui.panel;

import fr.arinonia.commandmanager.ui.PanelManager;
import javafx.scene.layout.GridPane;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui.panel
 */
public interface IPanel {

    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();

}
