package fr.arinonia.commandmanager;

import de.jensd.fx.glyphs.GlyphIcons;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.arinonia.commandmanager.instances.Instance;
import fr.arinonia.commandmanager.ui.PanelManager;
import fr.arinonia.commandmanager.ui.panels.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Arinonia on 13/09/2020 inside the package - fr.arinonia.commandmanager
 */
public class CommandManager {

    private final List<Instance> instances = new ArrayList<>();

    private PanelManager panelManager;
    private ExecutorService executorService;

    public void init(Stage stage){
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();

        this.executorService = new ThreadPoolExecutor(1, 1, 1000,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        this.initFonts();
        this.panelManager.showPanel(new LoginPanel());
        this.addInstances();
    }

    private void initFonts() {
        Font.loadFont(Main.class.getResourceAsStream("/fonts/Roboto-Regular.ttf"), 22.0D);
    }

    private void addInstances(){
        instances.add(new Instance("DashBoard", new FontAwesomeIconView(FontAwesomeIcon.DASHBOARD), new DashBoardPanel()));
        instances.add(new Instance("Manage", new FontAwesomeIconView(FontAwesomeIcon.DOLLAR), new ManagePanel()));
        instances.add(new Instance("Current", new FontAwesomeIconView(FontAwesomeIcon.CLOCK_ALT), new CurrentPanel()));
        instances.add(new Instance("Settings", new MaterialDesignIconView(MaterialDesignIcon.SETTINGS), new SettingsPanel()));
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            System.out.println("Termination took too long.");
        }
        System.out.println("Good bye =)");
        System.exit(0);
    }

    public List<Instance> getInstances() {
        return instances;
    }
}
