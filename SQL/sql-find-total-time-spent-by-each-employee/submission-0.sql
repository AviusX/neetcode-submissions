SELECT event_day as day, emp_id, SUM((out_time - in_time)) AS total_time
FROM employees
GROUP by day, emp_id;