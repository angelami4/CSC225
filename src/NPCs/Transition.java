package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Maps.FinalMap;
import Utils.Point;

public class Transition extends NPC {

    public Transition(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("arrow.png"), 14, 17), "DEFAULT");
    }

    //add script

   /*  @Override
    public void interact(Player player) {
        player.setMap(new FinalMap());
    } */

        @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(7, 13, 11, 7) 
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL) 
                            .build() 
            }); 
        }};
    }
 
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}


