use a_enterprise_project;

-- Branches
INSERT INTO BRANCH (branch_id, address, branch_name, city, date, phone, state) VALUES 
(1, "a_branch_address", "a_branch_name", "a_city", "2020-01-01", "123456789", "a_state"),
(2, "b_branch_address", "b_branch_name", "b_city", "2020-01-01", "123456789", "b_state")
;

-- Customers
insert into customer (customer_id, address, age, date, email, first_name, last_name, occupation, qualification, sex, branch_id) values 
(1, 'default address', 18, '2000-01-01', 'a@email.com', 'a_firstName', 'a_lastName', 'a_occupation', 'a_qualification', 'male', 1),
(2, 'default address', 19, '2000-01-01', 'b@email.com', 'b_firstName', 'b_lastName', 'b_occupation', 'b_qualification', 'male', 1),
(3, 'default address', 20, '2000-01-01', 'c@email.com', 'c_firstName', 'c_lastName', 'c_occupation', 'c_qualification', 'female', 1)
,
(4, 'default address', 21, '2000-01-01', 'd@email.com', 'd_firstName', 'd_lastName', 'd_occupation', 'd_qualification', 'male', 2),
(5, 'default address', 22, '2000-01-01', 'e@email.com', 'e_firstName', 'e_lastName', 'e_occupation', 'e_qualification', 'male', 2);


-- Users
INSERT INTO user (USER_ID, USERNAME, PASSWORD) VALUES 
(1, "admin", "$2y$12$eH44smI96Q/CVFZk63FtS.W39bjTluAcDsfY9WfBbPYpiE79FNyJe"),
(2, "bm", "$2y$12$8otS6ZuojoN2Yq56iaOkfuf4sLIUO2YBpwm3avs2bO5MeBwkCwlHC"),
(3, "agent", "$2y$12$fwjmNzvBpRrmJdsla6FXSeo4z1MYY2p2o.Qw7gB63G.81Pibu0XL2"),
(4, "customer", "$2y$12$3tB1/6VkdTmulNSePVWCSun5yNOFkrxHDvis2NguxI35LhafR3oTm");

INSERT INTO role (role_id, role_name, description) VALUES 
(1, 'ROLE_ADMIN', 'Administrator'),
(2, 'ROLE_BM', 'Branch Manager'),
(3, 'ROLE_CSR', 'Customer Service Representative'),
(4, 'ROLE_C', 'Customer');

INSERT INTO user_role(user_id, role_id) VALUES
(1,1), (1,2), (1,3), (1,4),
(2,2), (2,3),
(3,3),
(4,4);
