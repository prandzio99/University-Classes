public abstract class Employee implements Comparable<Employee> {
    static int idGen = 0;
    private int workID;
    private String name;
    private String surname;
    private int age;
    private int exp;
    private Address address;
    
    public void setWorkID() {workID = idGen++;}
    public int getWorkID() {return workID;}
    public void setName(String n) {name = n;}
    public String getName() {return name;}
    public void setSurname(String s) {surname = s;}
    public String getSurname() {return surname;}
    public void setAge(int a) {age = a;}
    public int getAge() {return age;}
    public void setEXP(int e) {exp = e;}
    public int getEXP() {return exp;}
    public void setAddress(Address ad) {address = ad;}
    public Address getAddress() {return address;}
    public String toString() {return "ID: "+workID+" Imię: "+name+" Nazwisko: "+surname+" Wiek: "+age+" Doświadczenie: "+exp+" Adres: "+address.toString();}
    public abstract int worth();
    @Override
    public int compareTo(Employee e) {
        int res = this.getEXP()-e.getEXP();
        if(res>0) return -1;
        if(res<0) return 1;
        else {
            res = this.getAge()-e.getAge();
            if(res>0) return 1;
            if(res<0) return -1;
            else {
                res = this.getSurname().compareTo(e.getSurname());
                return res;
            }
        }
    }
}