# Microservices E-commerce System Services

This system consists of multiple microservices, each responsible for a specific domain or functionality. Below is an overview of each service:

#### **Architecture Diagram**

The architecture diagram for the system is shown below:

![System Architecture](https://github.com/Mohamed-Hamdy/microservices-ecommerce-system/blob/main/diagrams/Arch%20Diagram%20of%20app.png)

#### **Project Requirements**

The Project Requirements for the system is shown below:

![Project Requirements](https://github.com/Mohamed-Hamdy/microservices-ecommerce-system/blob/main/diagrams/project%20requirment.png?raw=true)

### 1. **Product Service**

* **Purpose:** Manages product information, including product descriptions, prices, and inventory.
* **Endpoints:**
  + `GET /products`: Retrieves a list of all products.
  + `GET /products/{id}`: Retrieves a specific product by ID.
  + `POST /products`: Creates a new product.
  + `PUT /products/{id}`: Updates an existing product.
  + `DELETE /products/{id}`: Deletes a product.
* **Dependencies:** None

### 2. **Order Service**

* **Purpose:** Manages customer orders, including order creation, updates, and cancellations.
* **Endpoints:**
  + `POST /orders`: Creates a new order.
  + `GET /orders/{id}`: Retrieves a specific order by ID.
  + `PUT /orders/{id}`: Updates an existing order.
  + `DELETE /orders/{id}`: Cancels an order.
* **Dependencies:** Product Service (for product information)

### 3. **Customer Service**

* **Purpose:** Manages customer information, including customer profiles and addresses.
* **Endpoints:**
  + `GET /customers`: Retrieves a list of all customers.
  + `GET /customers/{id}`: Retrieves a specific customer by ID.
  + `POST /customers`: Creates a new customer.
  + `PUT /customers/{id}`: Updates an existing customer.
  + `DELETE /customers/{id}`: Deletes a customer.
* **Dependencies:** None

### 4. **Payment Service**

* **Purpose:** Handles payment processing for orders.
* **Endpoints:**
  + `POST /payments`: Processes a payment for an order.
  + `GET /payments/{id}`: Retrieves a specific payment by ID.
* **Dependencies:** Order Service (for order information)

### 5. **Inventory Service**

* **Purpose:** Manages inventory levels for products.
* **Endpoints:**
  + `GET /inventory`: Retrieves the current inventory levels for all products.
  + `GET /inventory/{id}`: Retrieves the inventory level for a specific product.
  + `PUT /inventory/{id}`: Updates the inventory level for a product.
* **Dependencies:** Product Service (for product information)

### 6. **Shipping Service**

* **Purpose:** Handles shipping logistics for orders.
* **Endpoints:**
  + `POST /shipments`: Creates a new shipment for an order.
  + `GET /shipments/{id}`: Retrieves a specific shipment by ID.
* **Dependencies:** Order Service (for order information)

### 7. **Gateway Service**

* **Purpose:** Acts as an entry point for the system, routing requests to the appropriate service.
* **Endpoints:**
  + `GET /`: Retrieves a list of available services.
  + `POST /`: Routes a request to the appropriate service.
* **Dependencies:** All services (for routing requests)

## How to Run the Project

To run the project, follow these steps:

1. Clone the repository to your local machine.
2. Install the required dependencies using Maven or Gradle.
3. Configure the application properties as needed.
4. Start each service individually by running the `main` method in the corresponding service class.
5. Use a tool like Postman or cURL to test the endpoints for each service.

**Note:** Make sure to start the services in the correct order, as some services depend on others. The recommended order is:

1. Product Service
2. Order Service
3. Customer Service
4. Payment Service
5. Inventory Service
6. Shipping Service
7. Gateway Service

By following these steps, you should be able to run the project and test the endpoints for each service.

## Tools

The following tools were used to develop and test this project:

- **Java 11**: The programming language used to develop the services.
- **Spring Boot**: The framework used to build the services.
- **Maven**: The build tool used to manage dependencies and compile the code.
- **Postman**: The tool used to test the endpoints for each service.
- **Docker**: The containerization platform used to deploy the services.
- **Kubernetes**: The orchestration platform used to manage the deployment of the services.
- **Git**: The version control system used to manage the codebase.

## How to Run the Project

To run the project, follow these steps:

1. Clone the repository to your local machine.
2. Install the required dependencies using Maven or Gradle.
3. Configure the application properties as needed.
4. Start each service individually by running the main method in the corresponding service class.
5. Use a tool like Postman or cURL to test the endpoints for each service.

**Note:** Make sure to start the services in the correct order, as some services depend on others. The recommended order is:

1. Product Service
2. Order Service
3. Customer Service
4. Payment Service
5. Inventory Service
6. Shipping Service
7. Gateway Service

By following these steps, you should be able to run the project and test the endpoints for each service.



