package fr.arinonia.commandmanager;

import fr.arinonia.commandmanager.ui.FxApplication;
import javafx.application.Application;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager
 */
public class Main {

    public static void main(String[] args) {
        new Main().init();
    }

    private void init(String... args){
        Application.launch(FxApplication.class, args);
    }


}
