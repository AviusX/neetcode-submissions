SELECT DISTINCT title
FROM content c
JOIN tv_program t ON t.content_id = c.content_id
WHERE t.program_date BETWEEN '2020-06-01' 
    AND '2020-07-01'
    AND c.kids_content = 'Y' 
    AND c.content_type = 'Movies';