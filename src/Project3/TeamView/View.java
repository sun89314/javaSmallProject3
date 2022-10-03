package Project3.TeamView;

import Project3.TeamService.BuildTeamService;
import Project3.TeamService.EmployeeListService;
import Project3.TeamService.TeamException;
import Project3.domain.Employee;

import java.util.EnumMap;

public class View {
    private EmployeeListService listSvc = new EmployeeListService();
    private BuildTeamService teamSvc = new BuildTeamService();

    public void enterMainMenu(){
        System.out.println("-----------this is a employee team modify system --------\n");
        boolean flag = true;
        while(flag){
            listAllEmployees();
            System.out.println("Please press: 1--to get the team list  2--to add team member 3--delete team member 4--exit:");
            char menu = TSUtility.readMenuSelection();
            switch(menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    DeleteMember();
                    break;
                case '4':
                    System.out.println("do you really want to quit:(Y/N)");
                    char exit = TSUtility.readConfirmSelection();
                    if(exit == 'Y'){
                        flag = false;
                        System.out.println("exit system!!");
                    }
                    else continue;

                    break;
            }
        }
    }
    private void listAllEmployees(){
        Employee[] employees = listSvc.getALlEmployees();
        if(employees == null ||employees.length == 0){
            System.out.println("no employee in the company!");
            return ;
        }
        System.out.println("Id\tname\tage\tsalary\ttype\tstatus\tbonus\tstock\tequipments");
        for(int i = 0; i < employees.length;i++){

            System.out.println(employees[i].toString());
        }

    }
    private void getTeam(){
        System.out.println("check the team situation");
        Employee[] employees = teamSvc.getTeam();
        if(employees == null ||employees.length == 0){
            System.out.println("no employee in the team!");
            return ;
        }
        System.out.println("Id\tname\tage\tsalary\ttype\tstatus\tbonus\tstock\tequipments");
        for(int i = 0; i < employees.length;i++){

            System.out.println(employees[i].toString());
        }
        TSUtility.readReturn();
    }
    private void addMember(){
        System.out.println("adding member into the team");
        int id  = TSUtility.readInt();
        Employee employee;
        try{
            employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("add successfully");
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }


        getTeam();
       // TSUtility.readReturn();



    }
    private void DeleteMember(){
        System.out.println("delete member from the team");
        int id  = TSUtility.readInt();
        Employee employee;
        try{

            teamSvc.removeMember(id);
            System.out.println("remove successfully");
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }


        getTeam();
        //TSUtility.readReturn();
    }

    public static void main(String[] args) {
        View view = new View();
        view.enterMainMenu();
    }
}
