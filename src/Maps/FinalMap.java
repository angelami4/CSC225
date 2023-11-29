package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class FinalMap extends Map {
    public FinalMap() {
        super("my_map.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}