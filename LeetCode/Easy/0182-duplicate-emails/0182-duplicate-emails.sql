/* Write your PL/SQL query statement below */
SELECT DISTINCT a.email AS Email
FROM Person a
INNER JOIN Person b ON a.id < b.id
WHERE a.email = b.email;
