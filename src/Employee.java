public class Employee {

    private final int id;
    private final String name;
    private final int age;
    private final double salary;
    
     public int getid() {
        return id;
    }
     public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    public Employee(int id,String name, int age, double salary) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters and setters (or lombok annotations) here

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
