package prandzio.Organism;
import prandzio.Position.Position;
import prandzio.World.World;
import prandzio.Action.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Organism{
    private Position position;
    private World world;
    private Integer power;
    private Integer initiative;
    private Integer liveLength;
    private Integer powerToReproduce;
    private String sign;
    private Integer foodChain;

    public Integer getPower() {return power;}
    public void setPower(Integer val) {power = val;}
    public Integer getInitiative() {return initiative;}
    public void setInitiative(Integer val) {initiative = val;}
    public Integer getLiveLength() {return liveLength;}
    public void setLiveLength(Integer val) {liveLength = val;}
    public Integer getPowerToReproduce() {return powerToReproduce;}
    public void setPowerToReproduce(Integer val) {powerToReproduce = val;}
    public String getSign() {return sign;}
    public void setSign(String s) {sign = s;}
    public Position getPosition() {return position;}
    public void setPosition(Position pos) {position = pos;}
    public World getWorld() {return world;}
    public void setWorld(World wd) {world = wd;}
    public Integer getFoodChain() {return foodChain;}
    public void setFoodChain(Integer val) {foodChain = val;}

    public List<Action> consequences(Organism org2) {
        List<Action> res = new ArrayList<Action>();
        if(this.getFoodChain() > org2.getFoodChain()) {
            res.add(new Action(ActionEnum.getAction(ActionEnum.A_REMOVE), new Position(-1, -1), 0, org2));
            if ((this.getFoodChain() - org2.getFoodChain()) == 1) {
                this.setPower(this.getPower() + 2);
                if(org2 instanceof Daffodil) this.setPower(this.getPower()+3);
            }
            else {
                this.setPower(this.getPower() - 1);
                System.out.print(this.getClass().getSimpleName() + " get sick by eating " + org2.getClass().getSimpleName() + "  ");
            }
        }
        else if (this.getFoodChain() < org2.getFoodChain()) {
            res.add(new Action(ActionEnum.getAction(ActionEnum.A_REMOVE), new Position(-1, -1), 0, this));
            if ((org2.getFoodChain() - this.getFoodChain()) == 1) {
                org2.setPower(org2.getPower() + 2);
                if(this instanceof Daffodil) org2.setPower(org2.getPower() + 3);
            }
            else {
                org2.setPower(org2.getPower() - 1);
                System.out.print(org2.getClass().getSimpleName() + " get sick by eating " + this.getClass().getSimpleName() + "  ");
            }
        }
        else {org2.move();}
        return res;
    }

    public boolean ifReproduce() {
        boolean res = false;
        if(this.getPower() >= this.getPowerToReproduce()){res = true;}
        return res;
    }

    public abstract Organism clone();
    public abstract List<Action> move();
    public abstract List<Action> action();
    public abstract void initParams();


    @Override
    public String toString() {return "Organism{"+"position="+position+", world="+world+", power="+power+", initiative="+initiative+", liveLength="+liveLength+", powerToReproduce="+powerToReproduce+", sign='"+sign+'\''+'}';}
}
