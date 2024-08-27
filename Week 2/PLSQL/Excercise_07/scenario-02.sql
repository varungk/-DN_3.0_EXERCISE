CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireNewEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_department IN VARCHAR2, p_hire_date IN DATE);
  PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_salary IN NUMBER, p_department IN VARCHAR2);
  FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireNewEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_department IN VARCHAR2, p_hire_date IN DATE) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);
    COMMIT;
  END HireNewEmployee;

  PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_salary IN NUMBER, p_department IN VARCHAR2) IS
  BEGIN
    UPDATE Employees
    SET Salary = p_salary, Department = p_department
    WHERE EmployeeID = p_employee_id;
    COMMIT;
  END UpdateEmployeeDetails;

  FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_employee_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END CalculateAnnualSalary;

END EmployeeManagement;
/
