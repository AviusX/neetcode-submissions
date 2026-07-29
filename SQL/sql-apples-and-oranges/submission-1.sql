-- Write your query below
SELECT a.sale_date, a.sold_num - b.sold_num AS diff
FROM sales a
JOIN sales b ON a.sale_date = b.sale_date
WHERE a.fruit = 'apples' AND b.fruit = 'oranges'
ORDER BY a.sale_date;