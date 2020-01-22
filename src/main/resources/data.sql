use a_enterprise_project;

-- Branches
INSERT INTO BRANCH (branch_id, address, branch_name, city, date, phone, state) VALUES 
(1, "1035 Boyce Rd", "ABC Insurance HQ", "Pittsburgh", "2020-01-01", "4128352700", "PA"),
(2, "b_branch_address", "b_branch_name", "b_city", "2020-01-01", "123456789", "b_state");

-- Managers
INSERT INTO MANAGER (manager_id, branch_id, username, password, address, age, date, first_name, last_name, qualification, sex) values
(1, 1, 'bm', 'bm', 'manager address', 33, '2020-01-01', 'George', 'Burdell', 'Master Degree in management', 'male'),
(2, 2, 'bm2', 'bm2', 'manager2 address', 22, '2020-01-01', 'Dave', 'Davidson', 'Master Degree in management', 'male');


-- Agents
INSERT INTO agent (agent_id, date, first_name, last_name, username, password, branch_id) VALUES
(1, '2020-01-01', 'James', 'Spectre', 'agent', 'agent', 1),
(2, '2020-01-01', 'agent2', 'agent2', 'agent2', 'agent2', 2);

-- Customers
insert into customer (customer_id, address, age, date, email, first_name, last_name, occupation, qualification, sex, branch_id, USERNAME, PASSWORD) values 
(1, 'default address', 18, '2020-01-01', 'a@email.com', 'Aaron', 'Smith', 'doctor', 'MD', 'male', 1, 'customer1', 'customer1'),
(2, 'default address', 19, '2020-01-01', 'b@email.com', 'b_firstName', 'b_lastName', 'b_occupation', 'b_qualification', 'male', 1, 'customer2', 'customer2'),
(3, 'default address', 20, '2020-01-01', 'c@email.com', 'c_firstName', 'c_lastName', 'c_occupation', 'c_qualification', 'female', 1, 'customer3', 'customer3'),
(4, 'default address', 21, '2020-01-01', 'd@email.com', 'd_firstName', 'd_lastName', 'd_occupation', 'd_qualification', 'male', 2, 'customer4', 'customer4'),
(5, 'default address', 22, '2020-01-01', 'e@email.com', 'e_firstName', 'e_lastName', 'e_occupation', 'e_qualification', 'male', 2, 'customer5', 'customer5');

-- Users
INSERT INTO user (USER_ID, USERNAME, PASSWORD) VALUES 
(1, "admin", "$2y$12$eH44smI96Q/CVFZk63FtS.W39bjTluAcDsfY9WfBbPYpiE79FNyJe"),
(2, "bm", "$2y$12$8otS6ZuojoN2Yq56iaOkfuf4sLIUO2YBpwm3avs2bO5MeBwkCwlHC"),
(3, "bm2", "$2y$12$xOuj7IR2s.RR8KdgirztCOa7EIhu4.FlM.X0u3V8TTC3B2jais4GC"),
(4, "agent", "$2y$12$fwjmNzvBpRrmJdsla6FXSeo4z1MYY2p2o.Qw7gB63G.81Pibu0XL2"),
(5, "agent2", "$2y$12$NSmuEHyjk0Agv90zQQPbjOLSlkborpExhiXw2oNSofrbGqKCLHY3q"),
(6, "customer1", "$2y$12$RT9bUG3ML7mxjPDTzP4OV.2dF8ejjv4bKN2sDgmjeSJI5iGSSigzC"),
(7, "customer2", "$2y$12$/qH0BL/BDtxjq8DX8A8mNezb/6awfgzzBj9/CgsSrogu/HIDPufCy"),
(8, "customer3", "$2y$12$5/ymGOMb6ZYIw3aoM8/pSOoNsNWNF7kroWKFA.eatG3ZCO467OHf2"),
(9, "customer4", "$2y$12$qHKuQxTqZS7aYbJDcwvUqOxd8/AhSQV8A0c5VlII1t7MBneJTGN7C"),
(10, "customer5", "$2y$12$/XFzFAJ1EmnskH9GrFpS5OhqbTiO2b4ljlEjqdtzOiiZRofHEBxBS");


INSERT INTO role (role_id, role_name, description) VALUES 
(1, 'ROLE_ADMIN', 'Administrator'),
(2, 'ROLE_BM', 'Branch Manager'),
(3, 'ROLE_CSR', 'Customer Service Representative'),
(4, 'ROLE_C', 'Customer');

INSERT INTO user_role(user_id, role_id) VALUES
(1,1), (1,2), (1,3), (1,4),
(2,2), (2,3), (2,4),
(3,2), (3,3), (3,4),
(4,3), (4,4), 
(5,3), (5,4), 
(6,4), (7,4), (8,4), (9,4), (10,4);

INSERT INTO POLICY(policy_id, date, maturity_amount, policy_amount, policy_interest, policy_name, policy_term, policy_type) values
(1, '2020-01-01', 5999, 599, 0.05, 'Motorcycle', 5, 'AUTO'),
(2, '2020-01-01', 1999, 199, 0.01, 'SUV', 15, 'AUTO');

INSERT INTO CUSTOMER_POLICY_REGISTRATION(customer_policy_registration_id, agent_commission,date,nominee_name,
nominee_relationship,premium_type,terms_and_conditions, agent_id, customer_id, policy_id) VALUES
(1, 1000, '2020-01-01', 'Stephanie Griffon', 'mom','annual',1, 1, 1, 1);
