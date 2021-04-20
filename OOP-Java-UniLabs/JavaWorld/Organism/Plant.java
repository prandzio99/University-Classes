package prandzio.Organism;
import prandzio.Action.*;
import prandzio.Position.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Plant extends Organism {
    public List<Action> move() {
        List<Action> res = new ArrayList<Action>();
        return res;
    }

    public List<Action> action() {
        List<Action> res = new ArrayList<Action>();
        Organism npt;
        Organism npt2;
        if(this.ifReproduce()) {
            List<Position> hpos = this.getFreeNeighboringPosition(this.getPosition());
            if(!(hpos.isEmpty())) {
                Random randomPosition = new Random();
                int index = randomPosition.nextInt(hpos.size());
                Position npos = hpos.get(index);
                npt = this.clone();
                npt.initParams();
                npt.setPosition(npos);
                hpos.remove(npos);
                if(!(hpos.isEmpty())) {
                    Random randomPosition2 = new Random();
                    int index2 = randomPosition2.nextInt(hpos.size());
                    Position npos2 = hpos.get(index2);
                    npt2 = this.clone();
                    npt2.initParams();
                    npt2.setPosition(npos2);
                    res.add(new Action(ActionEnum.getAction(ActionEnum.A_ADD), npos2, 0, npt2));
                }
                this.setPower(this.getPower()-2);
                res.add(new Action(ActionEnum.getAction(ActionEnum.A_ADD), npos, 0, npt));
            }
        }
        return res;
    }

    public List<Position> getFreeNeighboringPosition(Position pos){
        try {return this.getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(pos));}
        catch (NullPointerException e) {return null;}
    }
}
