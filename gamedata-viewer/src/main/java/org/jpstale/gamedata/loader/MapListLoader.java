package org.jpstale.gamedata.loader;

import org.jpstale.gamedata.model.SimpleMapData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple map loader implementation
 */
public class MapListLoader extends BaseFileParser {

    public List<SimpleMapData> loadAllMaps(File fieldDir) {
        List<SimpleMapData> maps = new ArrayList<>();

        if (!fieldDir.exists() || !fieldDir.isDirectory()) {
            return maps;
        }

        // Create dummy map for now
        SimpleMapData map = new SimpleMapData();
        map.setId("test");
        map.setName("Test Map");
        map.setMinLevel(1);
        map.setMaxLevel(10);
        maps.add(map);

        return maps;
    }
}