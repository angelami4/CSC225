package MapEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    JMenu options;
    JCheckBoxMenuItem showNpcs;
    JCheckBoxMenuItem showItems;
    JCheckBoxMenuItem showEnchancedMapTiles;
    JCheckBoxMenuItem showTriggers;

    public MenuBar(TileBuilder tileBuilder) {
        options = new JMenu("Options");
        showNpcs = new JCheckBoxMenuItem("Show NPCs");
        showNpcs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowNPCs(!tileBuilder.getShowNPCs());
            }
        });
        options.add(showNpcs);
        showItems = new JCheckBoxMenuItem("Show Items");
        showItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowItems(!tileBuilder.getShowItems());
            }
        });
        options.add(showItems);
        showEnchancedMapTiles = new JCheckBoxMenuItem("Show Enhanced Map Tiles");
        showEnchancedMapTiles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowEnhancedMapTiles(!tileBuilder.getShowEnhancedMapTiles());
            }
        });
        options.add(showEnchancedMapTiles);
        showTriggers = new JCheckBoxMenuItem("Show Triggers");
        showTriggers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tileBuilder.setShowTriggers(!tileBuilder.getShowTriggers());
            }
        });
        options.add(showTriggers);
        add(options);
    }
}
