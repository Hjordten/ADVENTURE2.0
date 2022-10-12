//TODO IF TIME move get methods here.

public class Adventure {

    Map map = new Map();
    Player player;

    public Adventure(Player player){
        this.player = player;
    }

    public boolean go(String direction){
        return player.move(direction);
    }





}