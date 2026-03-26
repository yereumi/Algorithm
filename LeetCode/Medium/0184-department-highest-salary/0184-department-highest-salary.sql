/* Write your PL/SQL query statement below */
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Department d
LEFT JOIN Employee e ON d.id = e.departmentId
WHERE e.Salary = (
    SELECT MAX(e2.salary)
    FROM Employee e2
    WHERE e2.departmentId = e.departmentId;
);