package Level;

import Engine.GraphicsHandler;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Utils.Direction;

import java.util.HashMap;

public class Item extends MapEntity 
{
    protected int id = 0;

    public Item(int id, float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation);
        this.id = id;
    }

    public Item(int id, float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
        super(x, y, animations, startingAnimation);
        this.id = id;
    }

    public Item(int id, float x, float y, Frame[] frames) {
        super(x, y, frames);
        this.id = id;
    }

    public Item(int id, float x, float y, Frame frame) {
        super(x, y, frame);
        this.id = id;
    }

    public Item(int id, float x, float y) {
        super(x, y);
        this.id = id;
    }

    public int getId() { return id; }

    public void update(Player player) {
        super.update();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

    public void walk(Direction direction, float speed) {
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }
        else {
            if (this.currentAnimationName.contains("RIGHT")) {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else {
                this.currentAnimationName = "WALK_LEFT";
            }
        }
        if (direction == Direction.UP) {
            moveY(-speed);
        }
        else if (direction == Direction.DOWN) {
            moveY(speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }
    }

    public void stand(Direction direction) {
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }

    public void facePlayer(Player player) {
        if (Math.round(getBoundsX2()) - (getBounds().getWidth() / 2) < Math.round(player.getBoundsX2())) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (Math.round(getBoundsX1()) + (getBounds().getWidth() / 2) > Math.round(player.getBoundsX1())) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }
}
