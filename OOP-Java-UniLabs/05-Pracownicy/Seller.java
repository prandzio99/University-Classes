public class Seller extends Employee {
    String effectiveness;
    int commission;

    public Seller(String n, String s, int a, int e, Address ad, String ef, int com) {
        setWorkID();
        setName(n);
        setSurname(s);
        setAge(a);
        setEXP(e);
        setAddress(ad);
        setEffectiveness(ef);;
        commission = com;
    }

    public String getEffectiveness() {return effectiveness;}
    private void setEffectiveness(String ef) {effectiveness = ef;}
    public void setEffectiveness(int lvl) {
        switch(lvl) {
            case 1 : effectiveness = "NISKA"; break;
            case 2 : effectiveness = "ŚREDNIA"; break;
            case 3 : effectiveness = "WYSOKA"; break;
            default : effectiveness = "NISKA"; break;
        }
    }
    public int getCommission() {return commission;}
    public void setCommission(int com) {commission = com;}
    @Override
    public String toString() {return super.toString()+" Efektywność: "+effectiveness+" Prowizja: "+commission;}
    public int worth() {
        int res = 0;
        switch(effectiveness) {
            case "NISKA" : res = getEXP()*60; break;
            case "ŚREDNIA" : res = getEXP()*90; break;
            case "WYSOKA" : res = getEXP()*120; break;
        }
        return res;
    }
}