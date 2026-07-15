-- Write your query below
SELECT employee_id,
CASE WHEN 
    name LIKE 'M%' THEN 0
    ELSE (employee_id % 2) * salary
END AS bonus
FROM employees
ORDER BY employee_id;