USE insurance_db;

-- QA Validation 1: Verify customers and their associated policies

SELECT
    customers.customer_id,
    customers.first_name,
    customers.last_name,
    policies.policy_id,
    policies.policy_type,
    policies.premium_amount,
    policies.policy_status
FROM customers
         INNER JOIN policies
                    ON customers.customer_id = policies.customer_id;

-- QA Validation 2: Find customers without any policies

SELECT
    customers.customer_id,
    customers.first_name,
    customers.last_name
FROM customers
         LEFT JOIN policies
                   ON customers.customer_id = policies.customer_id
WHERE policies.policy_id IS NULL;

-- QA Validation 3: Verify the number of policies associated with each customer

SELECT
    customers.customer_id,
    customers.first_name,
    COUNT(policies.policy_id) AS total_policies
FROM customers
         LEFT JOIN policies
                   ON customers.customer_id = policies.customer_id
GROUP BY customers.customer_id, customers.first_name;

-- QA Validation 4: Identify duplicate customer email addresses

SELECT
    email,
COUNT(email) AS duplicate_email
FROM customers
GROUP BY email
HAVING COUNT(email) > 1;

-- QA Validation 5: Identify customers with missing mandatory information

SELECT
    customer_id,
    first_name,
    last_name,
    email,
    city
FROM customers
WHERE email IS NULL
OR city is NULL;

-- QA Validation 6: Identify policies incorrectly marked as Expired

SELECT
    policy_id,
    policy_type,
    end_date,
    policy_status
FROM policies
WHERE policy_status = 'Expired'
  AND end_date >= CURDATE();

-- QA Validation 7: Verify customers and their associated insurance claims

SELECT
    customers.first_name,
    customers.last_name,
    policies.policy_type,
    claims.claim_id,
    claims.claim_amount,
    claims.claim_status
FROM customers
INNER JOIN policies
ON customers.customer_id = policies.customer_id
INNER JOIN claims
ON policies.policy_id = claims.policy_id;


