package monsters;

import com.company.GamePanel;

import java.util.ArrayList;
import java.util.Random;

public class MonstersFactory {
    public GamePanel gamePanel;
    private ArrayList<MonsterBase> monsters;
    public MonstersFactory(GamePanel gamePanel, ArrayList<MonsterBase> monsters){
        this.gamePanel = gamePanel;
        this.monsters = monsters;
    }

    public void run(){
        if(this.monsters.size() < 3){
            Random rnd =  new Random();
            int x, y;

            do {
                x = rnd.nextInt(16) * GamePanel.tileSize;
                y = rnd.nextInt(12) * GamePanel.tileSize;
            } while (CharacterClass.occupiedCells[x][y] > 0);

            CharacterClass.occupiedCells[x][y] = 10;
            MonsterBase monster = new MonsterBase(x, y);

            monsters.add(monster);
            gameField.repaint();
        }
    }

}
