TODO: 
	-[ ] implement log4j2 logger
	   	-[x] request parameters logged at INFO/DEBUG level
	   	-[ ] any errors at the ERROR level
	   		- get requests with invalid id
	-[ ] load in pre-existing records before app startup (schema.sql ??)
	
	Customer
	   	-[ ] adding new customer:
	   		-[ ] automatically use today's date
	   		-[ ] redundancy check
		-[x] persist customer with his information (using request body)
	  		firstName, lastName, age, sex, date, qualification, occupation, address, 
	   		email, password, branchId
	   	-[x] fix date parameter
	   	-[x] retrieve all of the customers
	   	-[x] retrieve the list of customers with branch id
	   	-[x] retrieve the list of customers with last name
	   	-[x] get customer by id 
	   	-[x] update customer with all fields
	   	-[x] delete customer by id
	Branch
 		-[x] fix date parameter
 		-[x] add branch using request body
 		-[x] retrieve all of the branches
 		-[x] retrieve the list of branches with state
 	  		- using request param
 		-[x] retrieve the list of branches with id
 		-[x] update
 		-[x] delete by id
	