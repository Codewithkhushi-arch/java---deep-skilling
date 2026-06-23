@echo off
cls
echo ====================================================================
echo   Spring Data JPA with Hibernate - Recruiter Launch Runner
echo ====================================================================
echo.
echo This runner will build and execute the two projects:
echo  1. orm-learn (Hands-On tasks for Country, Stock, Payroll, and Quiz)
echo  2. EmployeeManagementSystem (Exercises 1-10 covering advanced features)
echo.
echo Java Version:
java -version
echo.
echo ====================================================================
echo  Phase 1: Building and Running [orm-learn]
echo ====================================================================
echo.
cd orm-learn
echo Running: mvn clean package -DskipTests
call "..\maven\apache-maven-3.9.8\bin\mvn.cmd" clean package -DskipTests
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Maven build failed for orm-learn!
    goto end
)
echo.
echo Build Succeeded! Running orm-learn Application...
java -jar target/orm-learn-0.0.1-SNAPSHOT.jar
cd ..
echo.
echo.
echo ====================================================================
echo  Phase 2: Building and Running [Exercise1 to Exercise10]
echo ====================================================================
echo.

for /L %%i in (1,1,10) do (
    echo.
    echo Building and running [Exercise%%i]...
    cd Exercise%%i
    call "..\maven\apache-maven-3.9.8\bin\mvn.cmd" clean package -DskipTests
    if errorlevel 1 (
        echo [ERROR] Maven build failed for Exercise%%i!
        cd ..
        goto end
    )
    java -jar target/Exercise%%i-0.0.1-SNAPSHOT.jar
    cd ..
)

:end
echo.
echo Finished runner script execution.
pause
