# 1.	Login
* 1.1.	Login to your system will be done via email and password
* 1.2.	Make sure there are simple validations for the inputs
  * 1.2.1.	Email — validate that user insert valid email
  * 1.2.2.	Password — validate that user insert password answer the following criteria:
    * 1.2.2.1.	must contain at least 1 lowercase alphabetical character
    * 1.2.2.2.	must contain at least 1 uppercase alphabetical character
    * 1.2.2.3.	must contain at least 1 numeric character
    * 1.2.2.4.	must contain at least one special character
    * 1.2.2.5.	must be eight characters or longer
  * 1.2.3.	User and passwords can be mock with in-memory repository in your server
* 1.3.	Make sure that the server generate temporary authentication token and return it in the response headers.
# 2.	Orders
* 2.1.	GET Method : getOrders — return list of orders - see optional mock
  * 2.1.1.	User can paginate the orders - /api/getOrders
  * 2.1.2.	User can filter.orders by order id /api/getOrders? filter=orderld
  * 2.1.3.	User can sort orders by any column - /api/getOrders?sortBy=date& order=desc
* 2.2.	Make sure you can combine filtering with sorting and pagination
* 2.3.	Make sure that user send the generated token in the headers “Authorization” and the server is verify it.
# 3.	General Requirements
* 3.1.	Keep you code clean and readable.
* 3.2.	Break your web application into models, request handlers and services
* 3.3.	Use postman with ready to use requests for you demo
* 3.4.	Make sure you handle right errors that thrown back to the client side with right response codes and appropriate descriptions
# 4.	Technologies:
* 4.1.	Java springboot
* 4.2.	JWT - Authentication
