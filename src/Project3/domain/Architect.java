package Project3.domain;

public class Architect extends Designer{
    private int Stock;



    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int Stock) {
        super(id, name, age, salary, equipment, bonus);
        this.Stock = Stock;

    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getStock() {
        return Stock;
    }

    @Override
    public String toString() {
        return GetDetails() + "\tArchitect\t" + getStatus() +"\t" + getBonus() + "\t" + Stock + "\t" + getEquipment().getDescription();
    }
}
