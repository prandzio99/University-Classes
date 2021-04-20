package prandzio.Position;
import java.util.Objects;

public class Position{
    private Integer x;
    private Integer y;

    public Position(Integer val_x, Integer val_y) {x = val_x; y = val_y;}
    public Integer getX() {return x;}
    public Integer getY() {return y;}
    public void setX(Integer val) {x = val;}
    public void setY(Integer val) {y = val;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getX(), position.getX()) && Objects.equals(getY(), position.getY());
    }

    @Override
    public String toString() {return "Position{"+"x="+x+", y="+y+'}';}
}
