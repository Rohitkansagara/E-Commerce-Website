---

# A99 E-Commerce Website

A99 is a fully functional e-commerce website where all products are priced at ₹99. The platform supports multiple categories and allows users to browse products, add them to the cart, and complete the checkout process. It also includes an admin panel for managing products and categories.

## Features

- **User Features:**
  - Browse products by categories.
  - Search for products.
  - View detailed product information.
  - Add products to the shopping cart.
  - Checkout and place an order.

- **Admin Features:**
  - Admin can add, update, and delete products.
  - Admin can manage product categories.

- **Authentication:**
  - User registration and login with JWT-based authentication.

## Tech Stack

### Frontend:
- **React.js** - JavaScript library for building user interfaces.
- **Axios** - Promise-based HTTP client for making API requests.
- **Material UI** or **Tailwind CSS** - For modern, responsive UI design.
- **React Router** - For client-side routing.
- **React Context API** - For state management.

### Backend:
- **Spring Boot** - Java framework to build the backend RESTful API.
- **MySQL** - Database to store products, users, orders, and categories.
- **Spring Security** - For handling user authentication and authorization.

### Database:
- **MySQL** - To store products, users, orders, and categories.

## Project Structure

### Frontend (React):
- **src/components/**: Reusable components such as ProductList, ProductDetails, Cart, etc.
- **src/pages/**: Different pages of the website like Home, Product Listing, Cart, Checkout, etc.
- **src/services/**: API calls for handling user and product data.
- **src/context/**: Context providers for Auth and Cart state management.
- **src/styles/**: CSS files for styling the components.

### Backend (Spring Boot):
- **controller/**: Handles the HTTP requests and routes them to appropriate service methods.
- **model/**: Contains the entity classes for products, categories, users, and orders.
- **repository/**: Interface for interacting with the database.
- **service/**: Contains the business logic for products, categories, users, and orders.
- **security/**: Configures Spring Security for handling user authentication and authorization.

## Installation and Setup

### Prerequisites:

- **Node.js**: To run the frontend React application.
- **MySQL**: To run the backend with Spring Boot.
- **Java**: To run the backend Spring Boot application.

### Frontend Setup:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/a99-ui.git
   cd a99-ui
   ```

2. Install the required dependencies:

   ```bash
   npm install
   ```

3. Run the React development server:

   ```bash
   npm start
   ```

   The app should now be running at `http://localhost:3000/`.

### Backend Setup:

1. Clone the backend repository:

   ```bash
   git clone https://github.com/your-username/a99-backend.git
   cd a99-backend
   ```

2. Set up your MySQL database and update the `application.properties` or `application.yml` file with your database credentials.

3. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

   The backend will run on `http://localhost:8080/`.

## API Endpoints

### Authentication:
- **POST** `/api/auth/register`: Register a new user.
- **POST** `/api/auth/login`: Login and retrieve a token.

### Products:
- **GET** `/api/products`: Retrieve a list of all products.
- **GET** `/api/products/{id}`: Retrieve details of a specific product.
- **POST** `/api/products`: Create a new product (Admin only).
- **PUT** `/api/products/{id}`: Update a product (Admin only).
- **DELETE** `/api/products/{id}`: Delete a product (Admin only).

### Categories:
- **GET** `/api/categories`: Retrieve a list of all categories.
- **POST** `/api/categories`: Create a new category (Admin only).

### Orders:
- **POST** `/api/orders`: Create a new order for a logged-in user.
- **GET** `/api/orders/{id}`: Retrieve order details by ID.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to your branch (`git push origin feature-name`).
5. Create a new pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

