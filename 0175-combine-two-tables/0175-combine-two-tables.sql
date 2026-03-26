/* Write your PL/SQL query statement below */
SELECT a.firstName, a.lastName, b.city, b.state
FROM Person a
LEFT JOIN Address b On a.personId = b.personId;