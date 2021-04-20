package prandzio.Main;
import prandzio.Organism.*;
import prandzio.World.*;
import prandzio.Action.*;

public class Main {
    public static void main(String [] args){
        World world1 = new World(10, 10);

        Sheep sheep1 = new Sheep(1, 3, world1);
        sheep1.initParams();
        world1.addOrganism(sheep1);

        Sheep sheep2 = new Sheep(3, 4, world1);
        sheep2.initParams();
        world1.addOrganism(sheep2);

        Grass grass = new Grass(2,9,world1);
        grass.initParams();
        world1.addOrganism(grass);

        Grass grass2 = new Grass(8,2,world1);
        grass2.initParams();
        world1.addOrganism(grass2);

        Grass grass3 = new Grass(2, 3, world1);
        grass3.initParams();
        world1.addOrganism(grass3);

        Daffodil daffodil = new Daffodil(4,7,world1);
        daffodil.initParams();
        world1.addOrganism(daffodil);

        Wolf wolf1 = new Wolf(0, 2, world1);
        wolf1.initParams();
        world1.addOrganism(wolf1);

        Wolf wolf2 = new Wolf(6, 8, world1);
        wolf2.initParams();
        world1.addOrganism(wolf2);

        System.out.println(world1);

        for(int i=0; i<50; i++) {
            world1.makeTurn();
            System.out.println(world1);
        }
    }
}
