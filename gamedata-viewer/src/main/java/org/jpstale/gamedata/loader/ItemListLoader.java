package org.jpstale.gamedata.loader;

import org.jpstale.gamedata.model.SimpleItemData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple item loader implementation
 */
public class ItemListLoader extends BaseFileParser {

    public List<SimpleItemData> loadAllItems(File itemDir) {
        List<SimpleItemData> items = new ArrayList<>();

        if (!itemDir.exists() || !itemDir.isDirectory()) {
            return items;
        }

        // Create dummy item for now
        SimpleItemData item = new SimpleItemData();
        item.setId("TEST");
        item.setName("Test Item");
        item.setCategory(1);
        item.setLevel(1);
        item.setPrice(100);
        items.add(item);

        return items;
    }
}