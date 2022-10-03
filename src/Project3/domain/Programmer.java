package Project3.domain;

public class Programmer  extends Employee{
    private int memberId; // ID in the team,not employee ID
    private Status status = Status.Free;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);


        this.equipment = equipment;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public Status getStatus() {
        return status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public String toString() {
        return GetDetails() + "\tProgrammer\t" + status +"\t\t\t\t\t" + equipment.getDescription();
    }

}
