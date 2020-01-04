TODO: 
	Customer
		-[x] persist customer with his information (using request body)
	  	firstName, lastName, age, sex, date, qualification, occupation, address, 
	   	email, password, branchId
	   	-[x] fix date parameter
	   	- adding new customer:
	   	-[ ] automatically use today's date
	   	-[ ] redundancy check
	   
	   	-[ ] load in pre-existing records before app startup (schema.sql ??)
	   
	   	-[x] retrieve all of the customers
	   	-[x] retrieve the list of customers with branch id
	   	-[x] retrieve the list of customers with last name
	   	-[x] get customer by id 
	   	-[x] update customer with all fields
	   	-[x] delete customer by id
	   
	   	-[ ] implement log4j logger
	   		-[x] request parameters logged at INFO/DEBUG level
	   		-[ ] any errors at the ERROR level
	   			- get requests with ivalid ids
	Branch
	