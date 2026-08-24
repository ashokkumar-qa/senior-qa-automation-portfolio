USE insurance_db;

INSERT INTO customers
(customer_id, first_name, last_name, email, city, status)
VALUES
    (1, 'Vinoth', 'Kumar', 'vinoth@example.com', 'Johor Bahru', 'Active'),
    (2, 'Priya', 'Sharma', 'priya@example.com', 'Kuala Lumpur', 'Active'),
    (3, 'John', 'David', 'john@example.com', 'Penang', 'Inactive');

INSERT INTO policies
(policy_id, customer_id, policy_type, premium_amount, start_date, end_date, policy_status)
VALUES
    (101, 1, 'Automobile', 2500.00, '2026-01-01', '2026-12-31', 'Active'),
    (102, 2, 'Health', 1800.50, '2026-02-01', '2027-01-31', 'Active'),
    (103, 1, 'Travel', 750.00, '2026-03-01', '2026-08-31', 'Expired');

INSERT INTO claims
(claim_id, policy_id, claim_amount, claim_date, claim_status)
VALUES
    (1001, 101, 5000.00, '2026-04-15', 'Approved'),
    (1002, 101, 2500.00, '2026-06-20', 'Pending'),
    (1003, 102, 1200.00, '2026-07-10', 'Rejected');

