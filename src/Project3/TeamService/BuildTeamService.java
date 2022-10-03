package Project3.TeamService;

import Project3.domain.*;

public class BuildTeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];

    private int total = 0;

    public BuildTeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] curTeam = new Programmer[total];
        for(int i = 0; i < total ; i++){
            curTeam[i] =  team[i];
        }
        return curTeam;
    }

    public void addMember(Employee e) throws TeamException{
        //full!
        if(total >= MAX_MEMBER){
            throw new TeamException("team is already full!");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("not a valid programmer!");
        }
        if(MemberExist(e)){
            throw new TeamException("already in the team!");
        }
        if(((Programmer) e).getStatus() == Status.Busy){
            throw new TeamException("already in another team!");
        }
        if(((Programmer) e).getStatus() == Status.Vacation){
            throw new TeamException("the employee is in a vacation!");
        }
        int CountProgrammer = 0, CountDesigner = 0,CountAchitect = 0;
        for(int i = 0; i < total ;i ++){
            if(team[i] instanceof Architect){
                CountAchitect ++;
            }
            else if(team[i] instanceof Designer){
                CountDesigner ++;
            }
            else {
                CountProgrammer++;
            }
        }
        Programmer p = (Programmer) e;
        if (p instanceof Architect && CountAchitect >= 1) {
            throw new TeamException("one team can only have one Architect ");
        }
        else if (p instanceof Designer && CountDesigner >= 2) {
            throw new TeamException("one team can only have one Designer ");
        }
        else if (p instanceof Programmer && CountProgrammer >= 3) {
            throw new TeamException("one team can only have one Programmer ");
        }





        team[total ++] = p;
        p.setStatus(Status.Busy);
        p.setMemberId(counter++);

    }
    public boolean MemberExist(Employee e){
        for(int i = 0; i < total; i++){
            //if(team[i].equals(e)) return true;
            if(team[i].getId() == e.getId()) return true;
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException{
        for(int i = 0; i < total; i ++){
            if(team[i].getId() == memberId) {
                team[i].setStatus(Status.Free);
                for (int j = i+1; j < total; j++) {
                    team[j-1] = team[j];
                }
                total --;
                //team[total] = null;
                return;
            }
        }
        throw new TeamException("the employee is not in the team!");
    }

    public void setTeam(Programmer[] team) {
        this.team = team;
    }



    public int getTotal() {
        return total;
    }
}
