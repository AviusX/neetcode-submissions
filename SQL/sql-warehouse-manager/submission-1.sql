-- Write your query below
SELECT name AS warehouse_name, SUM(units * width * length * height) AS volume
FROM warehouse w
JOIN products p ON w.product_id = p.product_id
GROUP BY name;

-- WareHouse0 123123 5
-- WareHouse0 454543 8

-- 123123 Shampoo 5 6 1
-- 454543 Conditioner 5 1 3