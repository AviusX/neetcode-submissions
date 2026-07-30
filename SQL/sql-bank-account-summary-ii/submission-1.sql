SELECT name, SUM(amount) AS balance
FROM transactions t
JOIN users u ON u.account = t.account
GROUP BY name
HAVING SUM(amount) > 10000;