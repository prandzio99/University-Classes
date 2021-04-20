package prandzio.Organism;
import prandzio.Position.Position;
import prandzio.World.World;

public class Daffodil extends Plant{
    public Daffodil(Integer posx, Integer posy, World world){
        this.setPosition(new Position(posx, posy));
        this.setWorld(world);
    }
    
    public Daffodil(){}

    @Override
    public Daffodil clone(){
        Daffodil flower = new Daffodil();
        return flower;
    }

    public void initParams(){
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(75);
        this.setPowerToReproduce(5);
        this.setFoodChain(1);
        this.setSign("\uD83C\uDF3C");
    }
}
