package prandzio.Organism;
import prandzio.Action.*;
import prandzio.Organism.Organism;
import prandzio.Position.Position;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

abstract class Animal extends Organism{
    private Position lastPosition;

    public Position getLastPosition() {return lastPosition;}
    public void setLastPosition(Position pos) {lastPosition = pos;}

    public List<Action> move(){
        List<Action> res = new ArrayList<Action>();
        List<Position> hpos = this.getNeighboringPosition();
        Position npos;
        try {
            if(!(hpos.isEmpty())) {
                Random randomPosition = new Random();
                int index = randomPosition.nextInt(hpos.size());
                npos = hpos.get(index);
                res.add(new Action(ActionEnum.getAction(ActionEnum.A_MOVE), npos, 0, this));
                this.setLastPosition(this.getPosition());
                Organism metOrganism = this.getWorld().getOrganismFromPosition(npos);
                if(metOrganism != null) {res.addAll(metOrganism.consequences(this));}
            } return res;
        } catch(NullPointerException e) {return null;}
    }

    public List<Action> action(){
        List<Action> res = new ArrayList<Action>();
        Organism nanimal;
        List<Position> birthpos = this.getNeighboringBirthPosition();
        if(this.ifReproduce() && !birthpos.isEmpty()){
            Random randomPosition = new Random();
            int index = randomPosition.nextInt(birthpos.size());
            Position newAnimalPosition = birthpos.get(index);
            nanimal = this.clone();
            nanimal.initParams();
            nanimal.setPosition(newAnimalPosition);
            this.setPower(this.getPower()/2);
            res.add(new Action(ActionEnum.getAction(ActionEnum.A_ADD), newAnimalPosition, 0, nanimal));
        }
        return res;
    }

    public List<Position> getNeighboringPosition(){
        try {return this.getWorld().getNeighboringPositions(this.getPosition());}
        catch (NullPointerException e) {return null;}
    }

    public List<Position> getNeighboringBirthPosition(){
        try {return this.getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(this.getPosition()));}
        catch (NullPointerException e) {return null;}
    }
}
