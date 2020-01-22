TODO: 
	- [x] spring's java mail
	- [x] update customer class with username
		- [x] model: updated getters/setters, constructors, toString()
		- [x] repo: added signature get by username
		- [x] service: added method to get by username
		- [x] controller: added mapping to get by username
	- [ ] implement log4j2 logger
	   	-[x] request parameters logged at INFO/DEBUG level
	   	-[ ] any errors at the ERROR level
	   		- get requests with invalid id
	-[x] load in pre-existing records before app startup (schema.sql ??)
	
	-[ ] implement security checks
		-[x] Branch Controller

	Customer registration controller
		- [x] model
		- [x] repo, currently have findByAgent
		- [ ] service
		- [ ]

	Agent Controller:
		- [ ] authorization
		- [x] model
		- [x] repo
		- [x] service
		- [x] controller
	
	BM Controller:
		- [ ] authorization
		- [x] everything else
		
	Policy Controller:
		-[ ] controller integration test
		-[ ] sql scripts
		-[x] create
		-[x] read
		-[x] update
		-[x] delete
	
	User:
	UserController 
	UserService
		- [X] add new users with different roles 
			-[ ] admin adding bm
			-[ ] admin adding agents
			-[ ] admin adding customers
			-[ ] bm adding agents
			-[ ] bm adding customers
		-[ ] securities associated with adding new users
			-[ ] admin adding bm
			-[ ] admin adding agents
			-[ ] admin adding customers
			-[ ] bm adding agents
			-[ ] bm adding customers
	
	Customer
		- [ ] authorization
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
	