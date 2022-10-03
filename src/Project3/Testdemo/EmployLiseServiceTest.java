package Project3.Testdemo;

//import org.testng.annotations.Test;
import Project3.TeamService.EmployeeListService;
import Project3.TeamService.TeamException;
import Project3.domain.Employee;
import Project3.domain.Programmer;
import Project3.domain.Status;
import org.junit.Test;

/*
test EmployLiseService's
 */
public class EmployLiseServiceTest{
//    public static void main(String[] args) {
//        System.out.println("runnable");
//    }
    @Test
    public void TestGetAllEmployees(){
        EmployeeListService service = new EmployeeListService();
        Employee[] employees = service.getALlEmployees();
        for(int i = 0; i < employees.length;i++){
//            if(employees[i] instanceof Programmer){
//               if(((Programmer) employees[i]).getStatus() == Status.Free){
//                   System.out.println("status meet!!");
//               }
//
//            }
            System.out.println(employees[i].toString());
        }

    }
    @Test
    public void TestgetEmployy(){
        EmployeeListService service = new EmployeeListService();
        try{
            Employee employee = service.getEmployee(101);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }



    }

}
