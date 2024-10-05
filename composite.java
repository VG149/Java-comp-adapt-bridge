// Componente base
interface Employee {
    void showDetails();
}

// Folha
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " is a " + position);
    }
}

// Folha
class Manager implements Employee {
    private String name;
    private String position;

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " is a " + position);
    }
}

// Composite
class Department implements Employee {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}

// Testando o Composite
public class CompositeExample {
    public static void main(String[] args) {
        Developer dev1 = new Developer("John", "Software Developer");
        Developer dev2 = new Developer("Jane", "Frontend Developer");
        Manager man1 = new Manager("Robert", "Project Manager");

        Department department = new Department();
        department.addEmployee(dev1);
        department.addEmployee(dev2);
        department.addEmployee(man1);

        department.showDetails(); // Exibe detalhes de todos os empregados
    }
}
