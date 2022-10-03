package Project3.domain;

public class PC implements Equipment{
    private String PCmodel;//name of computer
    private String monitor;//name of the monitor

    //constructor
    public PC() {
    }

    public PC(String PCmodel, String monitor) {
        this.PCmodel = PCmodel;
        this.monitor = monitor;
    }

    public void setPCmodel(String PCmodel) {
        this.PCmodel = PCmodel;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getPCmodel() {
        return PCmodel;
    }

    public String getMonitor() {
        return monitor;
    }

    @Override
    public String getDescription() {
        return PCmodel + "(" + monitor + ")";
    }
}
