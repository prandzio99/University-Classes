public class White extends Employee {
    static int posIDgen = 0;
    int posID;
    int intellect;

    public White(String n, String s, int a, int e, Address ad, int i){
        posID = posIDgen++;
        setWorkID();
        setName(n);
        setSurname(s);
        setAge(a);
        setEXP(e);
        setAddress(ad);
        setIntellect(i);;
    }

    public int getPosID() {return posID;}
    public int getIntellect() {return intellect;}
    public void setIntellect(int i) {
        if(i>150) intellect = 150;
        else if(i<70) intellect = 70;
        else intellect = i;
    }
    public int worth() {return intellect*getEXP();}
    @Override
    public String toString() {return super.toString()+" ID Stanowiska: "+posID+" Intelekt: "+intellect;}
}