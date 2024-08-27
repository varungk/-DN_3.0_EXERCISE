CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id IN NUMBER,
  p_name IN VARCHAR2,
  p_dob IN DATE,
  p_balance IN NUMBER
) AS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
  
  COMMIT;
  
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    -- Log the error message
    DBMS_OUTPUT.PUT_LINE('Error: Customer with this ID already exists.');
  WHEN OTHERS THEN
    -- Log other errors
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
