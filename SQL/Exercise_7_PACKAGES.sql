-- EXERCISE 7: PACKAGES
-- ==========================================

-- Scenario 1: CustomerManagement Package
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers SET Name = p_name, Balance = p_balance, LastModified = SYSDATE WHERE CustomerID = p_id;
        COMMIT;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2: EmployeeManagement Package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
    PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_department, SYSDATE);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_position VARCHAR2, p_salary NUMBER) IS
    BEGIN
        UPDATE Employees SET Position = p_position, Salary = p_salary WHERE EmployeeID = p_id;
        COMMIT;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3: AccountOperations Package
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_acc_id NUMBER);
    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_acc_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_acc_id;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
        RETURN NVL(v_total, 0);
    END GetTotalBalance;
END AccountOperations;
/

/*
==========================================
SIMULATED OUTPUTS (Based on Sample Data)
==========================================

-- Exercise 1, Scenario 3 (Loan Reminders)
-- No output expected with sample data (loan ends in 60 months, not 30 days)
-- If loan ended within 30 days:
Reminder: Customer John Doe, your loan 1 is due on 2026-07-15
PL/SQL procedure successfully completed.

-- Exercise 2, Scenario 1 (SafeTransferFunds)
EXEC SafeTransferFunds(1, 2, 5000);
Error: Insufficient funds in account 1
PL/SQL procedure successfully completed.

-- Exercise 2, Scenario 2 (UpdateSalary)
EXEC UpdateSalary(99, 10);
Error: Employee ID 99 does not exist.
PL/SQL procedure successfully completed.

-- Exercise 4, Scenario 1 (CalculateAge)
SELECT CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD')) FROM DUAL;
-- Output: 41 (Assuming current year is 2026)

-- Exercise 6, Scenario 1 (GenerateMonthlyStatements)
Customer: John Doe | Transaction: 1 | Type: Deposit | Amount: 200
Customer: Jane Smith | Transaction: 2 | Type: Withdrawal | Amount: 300
PL/SQL procedure successfully completed.

-- Example output from Trigger (CheckTransactionRules)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (3, 1, SYSDATE, 5000, 'Withdrawal');
-- Output: ORA-20001: Withdrawal exceeds balance.
*/


