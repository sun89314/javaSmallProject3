package Project3.domain;
//define employee status
public class Status {
    private final String Name;
    private Status(String Name){
        this.Name = Name;
    }
    public static final Status Free = new Status("Free");
    public static final Status Busy = new Status("Busy");
    public static final Status Vacation = new Status("Vacation");

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
