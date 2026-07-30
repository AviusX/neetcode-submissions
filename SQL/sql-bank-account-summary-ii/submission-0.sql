WITH account_balances AS (
    SELECT name, SUM(amount) AS balance
    FROM transactions t
    JOIN users u ON u.account = t.account
    GROUP BY name
)
SELECT name, balance
FROM account_balances
WHERE balance > 10000;