package prandzio.Organism;
import prandzio.Position.Position;
import prandzio.World.World;

public class Sheep extends Animal{
    public Sheep(Integer posx, Integer posy, World world){
        this.setPosition(new Position(posx, posy));
        this.setWorld(world);
    }

    public Sheep(){}

    @Override
    public Sheep clone(){
        Sheep sheep = new Sheep();
        return sheep;
    }

    public void initParams(){
        this.setPower(3);
        this.setInitiative(3);
        this.setLiveLength(38);
        this.setPowerToReproduce(5);
        this.setFoodChain(2);
        this.setSign("\uD83D\uDC11");
    }
}
