import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class employee{
   private String name;
    private int id;

    public employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public abstract double calculateSalary();
@Override
    public String toString(){
    return "Employee [Name : "+name+", Id : "+id+", Salary : "+calculateSalary()+"]";
    }


}
class FullTimeEmployee extends employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<employee> employeelist;

    public PayrollSystem() {
        employeelist=new ArrayList<>();
    }
    public void addEmployee(employee employee){
        employeelist.add(employee);
    }
    public void removeEmployee(int id){
        employee employeeToRemove=null;
        for(employee employee: employeelist){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeelist.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for (employee employee:employeelist){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Rahul",1,56600);
        PartTimeEmployee emp2=new PartTimeEmployee("Kamal",2,4,200);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("current employee details : ");
        payrollSystem.displayEmployees();
    }
}
