-- EXERCISE 1: CONTROL STRUCTURES
-- ==========================================

-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.
DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (SELECT * FROM Customers) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customer to VIP status based on their balance over $10,000.
-- Note: Assuming an IsVIP column exists or is added: ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';
BEGIN
    FOR rec IN (SELECT * FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
BEGIN
    FOR rec IN (SELECT l.LoanID, c.Name, l.EndDate 
                FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID 
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ', your loan ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/


