package fr.arinonia.commandmanager.instances;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphIcons;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.arinonia.commandmanager.ui.panel.Panel;
import javafx.scene.Node;

/**
 * Created by Arinonia on 14/09/2020 inside the package - fr.arinonia.commandmanager.instances
 */
public class Instance {

    private String name;
    private FontAwesomeIconView iconView;
    private MaterialDesignIconView designIconView;
    private Panel panel;

    public Instance(String name, FontAwesomeIconView iconView, Panel panel) {
        this.name = name;
        this.iconView = iconView;
        this.panel = panel;
    }
    public Instance(String name, MaterialDesignIconView designIconView, Panel panel) {
        this.name = name;
        this.designIconView = designIconView;
        this.panel = panel;
    }

    public String getName() {
        return name;
    }

    public Panel getPanel() {
        return panel;
    }

    public FontAwesomeIconView getIconView() {
        return iconView;
    }

    public MaterialDesignIconView getDesignIconView() {
        return designIconView;
    }
}
