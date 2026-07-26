SELECT name AS warehouse_name, SUM(units * width * length * height) AS volume
FROM warehouse w
JOIN products p ON w.product_id = p.product_id
GROUP BY name;