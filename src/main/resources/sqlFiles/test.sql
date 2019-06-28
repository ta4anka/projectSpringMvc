-- Test for authoritiesByUsernameQuery() TODO: DELETE

SELECT u.username, r.name
FROM users u INNER JOIN user_role ur
ON u.id = ur.user_id INNER JOIN roles r
ON ur.role_id = r.id
WHERE u.username = 'Maya';