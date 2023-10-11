package Items;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Item;
import Level.Player;
import Utils.Point;

import java.util.HashMap;

public class Trophy extends Item
{
    public Trophy(int id, Point location)
    {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("NationalTrophy.png"), 14, 17), "DEFAULT");
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0))
                        .withScale(3)
                        .withBounds(7, 13, 11, 7) 
                        .build() 
            }); 
            put("STAND_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0))
                        .withScale(3)
                        .withBounds(7,13, 11, 7)
                        .withImageEffect(ImageEffect.DISAPPEAR)
                        .build()
             });
            put("STAND_RIGHT", new Frame[] {
               new FrameBuilder(spriteSheet.getSprite(0, 0))
                       .withScale(3)
                       .withBounds(7, 13, 11, 7)
                       .withImageEffect(ImageEffect.DISAPPEAR)
                       .build()
            });
        }};
    }

    public void update(Player player) {
        super.update(player);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
