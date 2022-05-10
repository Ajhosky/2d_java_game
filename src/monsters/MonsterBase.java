package monsters;

import javax.swing.*;
import java.awt.*;

public class MonsterBase {
    public Image image;
    private int x, y, health;
    public MonsterBase(int x, int y){
        this.x = x;
        this.y = y;
        this.health = 200;
        String baseImage = "/res/player/monster.png";
        this.image = new ImageIcon(baseImage).getImage();

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
