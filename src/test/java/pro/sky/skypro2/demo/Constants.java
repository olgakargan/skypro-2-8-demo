package pro.sky.skypro2.demo;



import java.util.List;

public class Constants {
    public static final String GOOD_FAM1 = "GOODFIRSTNAMEONe";
    public static final String GOOD_FAM2 = "goodFirstnametwo";
    public static final String GOOD_FME = "FName3";
    public static final String BAD_FAM1 = "BADFIRSTNAME1";
    public static final String BAD_FAM2 = "bad_firstname";
    public static final String BAD_FAM3 = "";
    public static final String BAD_FAM4 = null;


    public static final String GOOD_NAME1 = "GOODLASTNAMEOne";
    public static final String GOOD_NAME2 = "goodLastnametwo";
    public static final String GOOD_NAME3 = "LName3";
    public static final String BAD_NAME1 = "BAD LASTNAME";
    public static final String BAD_NAME2 = "'badlastname";
    public static final String BAD_NAME3 = "  ";
    public static final String BAD_NAME4 = null;

    public static final Integer GOOD_DEPARTMENT1 = 3;
    public static final Integer GOOD_DEPARTMENT2 = 1;
    public static final Integer GOOD_DEPARTMENT3 = 3;
    public static final Integer BAD_DEPARTMENT1 = 6;
    public static final Integer BAD_DEPARTMENT2 = 0;
    public static final Integer BAD_DEPARTMENT3 = - 1;


    public static final Integer GOOD_SALARY1 = 15500;
    public static final Integer GOOD_SALARY2 = 22000;
    public static final Integer GOOD_SALARY3 = 25000;
    public static final Integer TOO_BIG_SALARY = Integer.MAX_VALUE;
    public static final Integer NEGATIVE_SALARY = - Integer.MAX_VALUE;

    public static final Employee GOOD_EMPLOYEE1 =
            new Employee(GOOD_FAM1, GOOD_NAME1,
                    GOOD_DEPARTMENT1, GOOD_SALARY1);

    public static final Employee GOOD_EMPLOYEE2 =
            new Employee(GOOD_FAM2,  GOOD_NAME2,
                    GOOD_DEPARTMENT2, GOOD_SALARY2);

    public static final Employee GOOD_EMPLOYEE3 =
            new Employee(GOOD_FAM2,  GOOD_NAME3,
                    GOOD_DEPARTMENT3, GOOD_SALARY3);

    public static final List<Employee> EMPLOYEE_LIST =
            List.of(GOOD_EMPLOYEE1, GOOD_EMPLOYEE2, GOOD_EMPLOYEE3);

    public static final List<Employee> EMPLOYEE_LIST_ORDERED =
            List.of(GOOD_EMPLOYEE2, GOOD_EMPLOYEE1, GOOD_EMPLOYEE3);

    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT1 =
            List.of(GOOD_EMPLOYEE2);

    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT3 =
            List.of(GOOD_EMPLOYEE1, GOOD_EMPLOYEE3);
}