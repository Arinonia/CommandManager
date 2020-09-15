package fr.arinonia.commandmanager.ui;

import fr.arinonia.commandmanager.CommandManager;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager.ui
 */
public class FxApplication extends Application {


    @Override
    public void start(Stage stage){
        new CommandManager().init(stage);
    }
}
