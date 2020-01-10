TODO: 
	-[ ] implement log4j2 logger
	   	-[x] request parameters logged at INFO/DEBUG level
	   	-[ ] any errors at the ERROR level
	   		- get requests with invalid id
	-[x] load in pre-existing records before app startup (schema.sql ??)
	
	-[ ] implement security checks
		-[x] Branch Controller
	
	Policy Controller:
		-[ ] controller integration test
		-[x] create
		-[x] read
		-[x] update
		-[x] delete
	
	User:
	UserController 
	UserService
		-[X] add new users with different roles 
			-[ ] admin adding bm
			-[ ] admin adding agents
			-[ ] admin adding customers
			-[ ] bm adding agents
			-[ ] bm adding customers
		-[X] securities associated with adding new users
			-[ ] admin adding bm
			-[ ] admin adding agents
			-[ ] admin adding customers
			-[ ] bm adding agents
			-[ ] bm adding customers
	
	Customer
		-[ ] test new REST controller
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
	