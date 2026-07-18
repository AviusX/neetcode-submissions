-- Write your query below

SELECT seller_name
FROM seller
WHERE seller_id NOT IN (
    SELECT DISTINCT seller.seller_id
    FROM seller
    JOIN orders ON orders.seller_id = seller.seller_id
    WHERE sale_date BETWEEN '2020-01-01' AND '2020-12-31'
)
ORDER BY seller_name;