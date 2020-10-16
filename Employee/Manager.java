package main.ru.mephi.java.Employee;

public class Manager extends Employee {
    private int bonus;
    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus=bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString()+"Manager{" +
                "bonus=" + bonus +
                '}';
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
