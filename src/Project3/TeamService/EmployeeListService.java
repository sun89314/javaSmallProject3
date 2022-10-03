package Project3.TeamService;

import Project3.domain.*;

/*
 @Description import data into Employee[] and other operation to modify employee
 */
public class EmployeeListService {
    private Employee[] employees;

    public EmployeeListService() {
        // import data to the employees
        int n = Data.EMPLOYEES.length;
        employees = new Employee[n];
        for(int i = 0; i < n; i ++){
            //get info
            String[] s = Data.EMPLOYEES[i];
            //four basic data;
            int id = Integer.parseInt(s[1]);
            String name = s[2];
            int age = Integer.parseInt(s[3]);
            double salary = Double.parseDouble(s[4]);
            //Employee  :  10, id, name, age, salary
            //Programmer:  11, id, name, age, salary
            //Designer  :  12, id, name, age, salary, bonus
            //Architect :  13, id, name, age, salary, bonus, stock

            if(s[0] == "10") {
                employees[i] = new Employee(id,name,age,salary);
            }else if(s[0] == "11"){
                Equipment equipment = createEquipment(Data.EQUIPMENTS[i]);
                employees[i] = new Programmer(id,name,age,salary,equipment);
            }else if(s[0] == "12"){
                Equipment equipment = createEquipment(Data.EQUIPMENTS[i]);
                employees[i] = new Designer(id,name,age,salary,equipment,Double.parseDouble(s[5]));
            }
            else if(s[0] == "13"){
                Equipment equipment = createEquipment(Data.EQUIPMENTS[i]);
                employees[i] = new Architect(id,name,age,salary,equipment,Double.parseDouble(s[5]),Integer.parseInt(s[6]));
            }

        }
    }

    public Employee[] getALlEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException{
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getId() == id) return employees[i];
        }
        throw new TeamException("Can't find the employee!");

    }
    private Equipment createEquipment(String[] equipmentinfo) {
        //PC      :21, model, display
        //NoteBook:22, model, price
        //Printer :23, name, type
        int type = Integer.parseInt(equipmentinfo[0]);
        String model = equipmentinfo[1];
        String info2 = equipmentinfo[2];
        Equipment equip;
        switch (type){
            case Data.PC:
                return new PC(model,info2);

            case Data.NOTEBOOK:
                return new Notebook(model,Double.parseDouble(info2));

            case Data.PRINTER:
                return new Printer(model,info2);


        }
        return null;
    }

}
