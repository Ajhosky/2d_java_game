package tile;

import com.company.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile =  new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));



        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap () {

        try {
            InputStream is = getClass().getResourceAsStream("res/maps/01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            System.out.println("test1");
            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                System.out.println("test2");
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    System.out.println("test3");
                    int num =  Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                    if (col == gp.maxScreenCol) {
                        col = 0;
                        row++;
                    }
                }
                br.close();
            }

        }catch (Exception e ){

        }
    }

    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image , x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
//    g2.drawImage(tile[0].image,0,0,gp.tileSize, gp.tileSize, null);
//    g2.drawImage(tile[1].image,48,0,gp.tileSize, gp.tileSize, null);
//    g2.drawImage(tile[2].image,96,0,gp.tileSize, gp.tileSize, null);
    }


}
