-- EXERCISE 6: CURSORS
-- ==========================================

-- Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR c_transactions IS
        SELECT t.TransactionID, t.AccountID, t.Amount, t.TransactionType, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
    FOR rec IN c_transactions LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | Transaction: ' || rec.TransactionID || ' | Type: ' || rec.TransactionType || ' | Amount: ' || rec.Amount);
    END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR c_accounts IS SELECT AccountID, Balance FROM Accounts FOR UPDATE;
    v_fee NUMBER := 50; -- Example annual fee
BEGIN
    FOR rec IN c_accounts LOOP
        UPDATE Accounts SET Balance = Balance - v_fee WHERE AccountID = rec.AccountID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR c_loans IS SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
BEGIN
    FOR rec IN c_loans LOOP
        UPDATE Loans SET InterestRate = InterestRate + 0.5 WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/


