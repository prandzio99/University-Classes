import java.util.*;

public class Company {
    ArrayList<Employee> register;

    public Company() {register = new ArrayList<Employee>();}

    public void insert(Employee a) {register.add(a);}

    public void remove(int id) {
        for(int i = 0; i < register.size(); i++) {
            if(register.get(i).getWorkID() == id) register.remove(i);
        }
    }

    public void insertMore(List<Employee> a) {register.addAll(a);}

    public void showSorted() {
        ArrayList<Employee> sorted = register;
        Collections.sort(sorted);
        for(int i = 0; i < sorted.size(); i++) {System.out.println(sorted.get(i).toString());}
    }

    public void showByCity(String pred) {
        for(int i = 0; i < register.size(); i++) {
            if(register.get(i).getAddress().getCity().equals(pred)) {
                System.out.println(register.get(i).toString());
            }
        }
    }

    public void showWorth() {
        for(int i = 0; i < register.size(); i++) {
            System.out.println(register.get(i).toString()+" Wartość: "+register.get(i).worth());
        }
    }
}