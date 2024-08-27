CREATE OR REPLACE PROCEDURE UpdateSalary(
  p_employee_id IN NUMBER,
  p_percentage IN NUMBER
) AS
BEGIN
  -- Increase the salary
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percentage / 100)
  WHERE EmployeeID = p_employee_id;
  
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee ID does not exist.');
  END IF;
  
  COMMIT;
  
EXCEPTION
  WHEN OTHERS THEN
    -- Log the error message
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
