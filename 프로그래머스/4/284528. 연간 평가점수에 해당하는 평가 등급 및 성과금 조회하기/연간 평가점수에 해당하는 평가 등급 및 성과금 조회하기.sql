-- 코드를 작성해주세요
SELECT emp.EMP_NO, EMP_NAME, 
    CASE
        WHEN AVG(gra.SCORE) >= 96 THEN 'S'
        WHEN AVG(gra.SCORE) >= 90 THEN 'A'
        WHEN AVG(gra.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN AVG(gra.SCORE) >= 96 THEN SAL * 0.2
        WHEN AVG(gra.SCORE) >= 90 THEN SAL * 0.15
        WHEN AVG(gra.SCORE) >= 80 THEN SAL * 0.1
        ELSE SAL * 0
    END AS BONUS
FROM HR_EMPLOYEES emp
JOIN HR_GRADE gra ON emp.EMP_NO = gra.EMP_NO
GROUP BY emp.EMP_NO
ORDER BY emp.EMP_NO;