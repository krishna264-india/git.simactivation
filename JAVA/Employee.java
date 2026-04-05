public class Employee {

     private int id;
     private String name;
     private int age;
     private int userId;
     private double amount;

     public Employee(int userId,double amount) {
            this.userId = userId;
            this.amount = amount;
        }
     public Employee(int id, String name, int age, double salary) {
         this.id = id;
         this.name = name;
         this.age = age;
         this.salary = salary;
     }
     public double getSalary() {
         return salary;
     }
        public void setSalary(double salary) {
            this.salary = salary;
        }

     public int getAge() {
        return age;
    }

     public void setAge(int age) {
         this.age = age;
     }

     private double salary;

    public Employee(,int id,String name, double salary) {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return name + " " + age;
    }
    
}
