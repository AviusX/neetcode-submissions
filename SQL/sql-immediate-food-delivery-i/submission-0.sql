SELECT ROUND(
    (100.0 * SUM(CASE WHEN customer_pref_delivery_date = order_date THEN 1 ELSE 0 END)) / COUNT(*),
    2
) as immediate_percentage
FROM delivery;