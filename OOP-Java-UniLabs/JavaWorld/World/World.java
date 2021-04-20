package prandzio.World;
import prandzio.Position.*;
import prandzio.Action.*;
import prandzio.Organism.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    private Integer worldX;
    private Integer worldY;
    private Integer turn = 0;
    private List<Organism> organisms = new ArrayList<Organism>();
    private List<Organism> newOrganisms = new ArrayList<Organism>();
    private String separator = "   ";

    public World(Integer worldX, Integer worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public World() {}

    public Integer getWorldX() {return worldX;}
    public Integer getWorldY() {return worldY;}
    public Integer getTurn() {return turn;}
    public void setTurn(Integer val) {turn = val;}
    public List<Organism> getOrganisms() {return organisms;}
    public void setOrganisms(List<Organism> orgs) {organisms = orgs;}
    public List<Organism> getNewOrganisms() {return newOrganisms;}
    public void setNewOrganisms(List<Organism> norgs) {newOrganisms = norgs;}
    public String getSeparator() {return separator;}

    public void makeTurn() {
        List<Action> actions;
        for(Organism o: this.organisms){
            try {
                if(this.positionOnBoard(o.getPosition())) {
                    actions = o.move();
                    for(Action a: actions) {this.makeMove(a);}
                    actions = new ArrayList<Action>();
                    if(this.positionOnBoard(o.getPosition())) {
                        actions = o.action();
                        for(Action ac: actions) {this.makeMove(ac);}
                        actions = new ArrayList<Action>();
                    }
                }
            }
            catch (NullPointerException e) {System.out.print("");}
        }
        this.setOrganisms(this.getOrganisms().stream().filter(o -> this.positionOnBoard(o.getPosition())).collect(Collectors.toList()));
        for(Organism org: this.organisms) {
            org.setLiveLength(org.getLiveLength() - 1);
            org.setPower(org.getPower() + 1);
            if (org.getLiveLength() < 1) {System.out.println(org.getClass().getSimpleName() + ":died at: " + org.getPosition());}
        }
        this.setOrganisms(this.getOrganisms().stream().filter(o -> o.getLiveLength() > 0).collect(Collectors.toList()));
        this.setNewOrganisms(this.getNewOrganisms().stream().filter(o -> positionOnBoard(o.getPosition())).collect(Collectors.toList()));
        this.organisms.addAll(newOrganisms);
        this.organisms.sort(Comparator.comparing(Organism::getInitiative));
        this.newOrganisms = new ArrayList<Organism>();
        this.setTurn(this.getTurn()+1);
    }

    public void makeMove(Action action) {
        System.out.println(action);
        if(action.getAction() == ActionEnum.getAction(ActionEnum.A_ADD)) {this.newOrganisms.add(action.getOrganism());}
        else if(action.getAction() == ActionEnum.getAction(ActionEnum.A_INCREASE)) {action.getOrganism().setPower(action.getOrganism().getPower() + action.getValue());}
        else if(action.getAction() == ActionEnum.getAction(ActionEnum.A_MOVE)) {action.getOrganism().setPosition(action.getPosition());}
        else if(action.getAction() == ActionEnum.getAction(ActionEnum.A_REMOVE)) {action.getOrganism().setPosition(new Position(-1, -1));}
    }

    public Boolean addOrganism(Organism norg) {
        Position norgpos = norg.getPosition();
        if(this.positionOnBoard(norgpos)) {
            this.organisms.add(norg);
            return true;
        }
        return false;
    }

    public Boolean positionOnBoard(Position pos) {return pos.getX() >= 0 && pos.getY() >= 0 && pos.getX() < this.worldX && pos.getY() < this.worldY;}

    public Organism getOrganismFromPosition(Position pos) {
        Organism horg = null;
        for(Organism org : this.organisms) {
            if (org.getPosition().equals(pos)) {
                horg = org;
                break;
            }
        }
        if(horg == null) {
            for(Organism o : this.newOrganisms){
                if (o.getPosition().equals(pos)) {
                    horg = o;
                    break;
                }
            }
        }
        return horg;
    }

    public List<Position> getNeighboringPositions(Position pos) {
        List<Position> res = new ArrayList<Position>();
        Position hpos;
        try {
            for (int y = -1; y < 2; y++) {
                for (int x = -1; x < 2; x++) {
                    hpos = new Position((pos.getX() + x), (pos.getY() + y));
                    if (this.positionOnBoard(hpos) && !(y == 0 && x == 0)) {res.add(hpos); }
                }
            }
            return res;
        } catch (NullPointerException e) {return null;}
    }

    public List<Position> filterFreePositions(List<Position> fields) {
        List<Position> res = new ArrayList<Position>();
        try {
            for(Position p: fields) {
                if(this.getOrganismFromPosition(p) == null) {res.add(p);}
            }
            return res;
        } catch (NullPointerException e) {return null;}
    }

    public List<Position> filterPositionsWithoutAnimals(List<Position> fields){
        List<Position> res = new ArrayList<Position>();
        Organism horg;
        for(Position f : fields){
            horg = this.getOrganismFromPosition(f);
            if(horg == null || horg instanceof Plant) {res.add(f);}
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "\nturn: " + turn + "\n";
        for (int y = 0; y <= this.getWorldY(); y++){
            for (int x=0; x <= this.getWorldX(); x++){
                Organism org = this.getOrganismFromPosition(new Position(x, y));
                if (!(org == null)) {res+= org.getSign();}
                else {res += this.getSeparator();}
            }
            res += "\n";
        }
        return res;
    }
}
