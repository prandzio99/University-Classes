public class Blue extends Employee {
    int strength;
    
    public Blue(String n, String s, int a, int e, Address ad, int str){
        setWorkID();
        setName(n);
        setSurname(s);
        setAge(a);
        setEXP(e);
        setAddress(ad);
        setStrength(str);;
    }

    public int getStrength() {return strength;}
    public void setStrength(int str) {
        if(str<1) strength = 1;
        else if (str>100) strength = 100;
        else strength = str;
    }

    public int worth(){return getEXP()*strength/getAge();}
    @Override
    public String toString() {return super.toString()+" Siła: "+strength;}
}