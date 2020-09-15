package fr.arinonia.commandmanager.ui;

import fr.arinonia.commandmanager.CommandManager;
import fr.arinonia.commandmanager.ui.panel.IPanel;
import fr.arinonia.commandmanager.ui.panels.includes.TopPanel;
import fr.arinonia.commandmanager.utils.Constants;
import fr.arinonia.commandmanager.utils.ResizeHelper;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui
 */
public class PanelManager {

    private final CommandManager manager;
    private final Stage stage;

    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private  GridPane centerPanel = new GridPane();


    public PanelManager(CommandManager manager, Stage stage) {
        this.manager = manager;
        this.stage = stage;
    }

    public void init(){
        this.stage.setTitle(Constants.APP_NAME + " " + Constants.APP_VERSION);
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();

        this.layout = new GridPane();
        this.layout.setStyle("-fx-background-color: #263238");
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25.0D);
        topPanelConstraints.setMaxHeight(25.0D);

        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(), 0, 0);
        this.topPanel.init(this);
        this.layout.add(this.centerPanel,0 , 1);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);

    }

    public void showPanel(IPanel panel){
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public CommandManager getManager() {
        return manager;
    }

    public Stage getStage() {
        return stage;
    }
}
