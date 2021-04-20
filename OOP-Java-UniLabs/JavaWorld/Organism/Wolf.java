package prandzio.Organism;
import prandzio.Position.Position;
import prandzio.World.World;

public class Wolf extends  Animal{
    public Wolf(Integer posx, Integer posy, World world){
        this.setPosition(new Position(posx, posy));
        this.setWorld(world);
    }

    public Wolf(){}

    @Override
    public Wolf clone(){
        Wolf wolf = new Wolf();
        return wolf;
    }

    public void initParams(){
        this.setPower(5);
        this.setInitiative(5);
        this.setLiveLength(26);
        this.setPowerToReproduce(12);
        this.setFoodChain(3);
        this.setSign("\uD83D\uDC3A");
    }
}
