package _01_Introduction_To_OOPs;

public class _01_Employee {
    // Attributes
    private int salary; //Instance Variable
    public String name; 

    //Methods
    public void setName(String s){
        name = s;
    }

    public void setSalary(int val) {
        salary = val;
    }

    public int getSalary() {
        return salary;
    }
}
