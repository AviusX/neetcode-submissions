-- Write your query below
SELECT customers.customer_id
FROM customers
WHERE customers.revenue > 0
AND customers.year = 2020;