package fr.arinonia.commandmanager.ui.panels;

import fr.arinonia.commandmanager.instances.Instance;
import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panel.Panel;
import fr.arinonia.commandmanager.ui.panels.includes.LeftBarPanel;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui.panels
 */
public class HomePanel extends Panel {

    private final LeftBarPanel leftPanel = new LeftBarPanel(this);
    private final GridPane centerPanel = new GridPane();

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.LEFT);
        columnConstraints.setMinWidth(300);
        columnConstraints.setMaxWidth(300);



        this.layout.getColumnConstraints().addAll(columnConstraints, new ColumnConstraints());
        this.layout.add(leftPanel.getLayout(),0,  0);
        this.leftPanel.init(this.panelManager);

        this.layout.add(centerPanel,1,  0);
        GridPane.setHgrow(centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(centerPanel, Priority.ALWAYS);

        this.showInstancePanel(panelManager.getManager().getInstances().get(0));


    }

    public void showInstancePanel(Instance instance){
        instance.getPanel().getLayout().getChildren().clear();
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(instance.getPanel().getLayout());

        GridPane.setHgrow(instance.getPanel().getLayout(), Priority.ALWAYS);
        GridPane.setVgrow(instance.getPanel().getLayout(), Priority.ALWAYS);
        instance.getPanel().init(this.panelManager);
    }
}
