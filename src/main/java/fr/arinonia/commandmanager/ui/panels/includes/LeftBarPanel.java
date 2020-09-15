package fr.arinonia.commandmanager.ui.panels.includes;

import com.jfoenix.controls.JFXButton;
import fr.arinonia.commandmanager.instances.Instance;
import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panel.IPanel;
import fr.arinonia.commandmanager.ui.panel.Panel;
import fr.arinonia.commandmanager.ui.panels.HomePanel;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui.panels.includes
 */
public class LeftBarPanel extends Panel {

    private HomePanel homePanel;

    public LeftBarPanel(HomePanel homePanel) {
        super();
        this.homePanel = homePanel;
    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        this.layout.setStyle("-fx-background-color: #32424A;");
        final VBox vBox = new VBox();
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        vBox.setSpacing(5.0D);
        for (Instance instances : this.panelManager.getManager().getInstances()){
            JFXButton jfxButton = new JFXButton(instances.getName());
            jfxButton.setStyle("-fx-text-fill: #fff; -fx-font-size: 16px; -fx-border-color: #80CBC4; -fx-font-family: Roboto;");
            jfxButton.setMinSize(300,40);
            if (instances.getIconView() != null){
                instances.getIconView().setSize("18px");
                instances.getIconView().setFill(Color.WHITE);
                jfxButton.setGraphic(instances.getIconView());
            }else{
                instances.getDesignIconView().setSize("18px");
                instances.getDesignIconView().setFill(Color.WHITE);
                jfxButton.setGraphic(instances.getDesignIconView());
            }
            jfxButton.setOnMouseClicked(e -> {
                this.homePanel.showInstancePanel(instances);
            });
            vBox.getChildren().add(jfxButton);
        }
        layout.setTranslateY(1);
        Separator separator = new Separator();
        GridPane.setVgrow(separator, Priority.ALWAYS);
        GridPane.setHgrow(separator, Priority.ALWAYS);
        GridPane.setHalignment(separator, HPos.RIGHT);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setTranslateX(4);
        separator.setMinWidth(2);
        separator.setMaxWidth(2);
        separator.setOpacity(0.30);
        this.layout.getChildren().add(vBox);
        this.layout.getChildren().add(separator);
    }
}
