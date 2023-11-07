package Level;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Textbox {
    protected boolean isActive;
    protected final int x = 22;
    protected final int bottomY = 460;
    protected final int topY = 22;
    protected final int fontX = 35;
    protected final int fontBottomY = 472;
    protected final int fontTopY = 34;
    protected final int width = 750;
    protected final int height = 100;

    private Queue<String> textQueue = new LinkedList<String>();
    private SpriteFont text = null;
    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.SPACE;


    private String currentText = "";
    private boolean isTyping = false;
    private int currentCharacterIndex = 0;
    private int charactersPerSecond = 27; 

    public Textbox(Map map) {
        this.map = map;
    }

    public void addText(String text) {
        if (textQueue.isEmpty()) {
            keyLocker.lockKey(interactKey);
        }
        textQueue.add(text);
    }

    public void addText(String[] text) {
        if (textQueue.isEmpty()) {
            keyLocker.lockKey(interactKey);
        }
        for (String textItem : text) {
            textQueue.add(textItem);
        }
    }

    public boolean isTextQueueEmpty() {
        return textQueue.isEmpty();
    }

    public void update() {
        if (!textQueue.isEmpty() && keyLocker.isKeyLocked(interactKey) && !isTyping) {
            isTyping = true;
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (currentCharacterIndex < textQueue.peek().length()) {
                        currentText = textQueue.peek().substring(0, currentCharacterIndex);
                        currentCharacterIndex++;
                    } else {
                        isTyping = false;
                        keyLocker.unlockKey(interactKey);
                        timer.cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000 / charactersPerSecond);
        }

        if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
            keyLocker.lockKey(interactKey);
            textQueue.poll();
            currentCharacterIndex = 0;
            currentText = "";
            isTyping = false;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        if (!map.getCamera().isAtBottomOfMap()) {
            graphicsHandler.drawFilledRectangleWithBorder(x, bottomY, width, height, Color.white, Color.black, 2);
        } else {
            graphicsHandler.drawFilledRectangleWithBorder(x, topY, width, height, Color.white, Color.black, 2);
        }
        if (!currentText.isEmpty()) {
            int fontY = !map.getCamera().isAtBottomOfMap() ? fontBottomY : fontTopY;
            text = new SpriteFont(currentText, fontX, fontY, "Arial", 30, Color.black);
            text.drawWithParsedNewLines(graphicsHandler, 10);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
}
