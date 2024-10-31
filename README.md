# JavaAirportManagementProject

# Airport Management System

## Project Overview
The **Airport Management System** is a Java-based application designed to manage airport operations effectively.
This project provides features to manage flights, passengers, and airport services efficiently, using a PostgreSQL database for data storage.

## Features
- **Flight Management**: Add, update, search, and delete flight records.
- **Passenger Management**: Manage passenger information details.
- **Database Integration**: PostgreSQL database for secure data storage and retrieval.

## Project Structure
Airport_Management_System/ ├── .gitignore ├── README.md ├── connection.properties # Database connection settings
├── src/ │
         ├── Airport/ │ │ ├── Aircontroller.java # Controller for flight and passenger management │
                        │ ├── Airpojo.java # Plain Old Java Object for data encapsulation
                        │ │ └── Airservice.java # Service layer handling business logic 
                        │ └── connection.properties # Database configuration file └── untitled.iml # IntelliJ project configuration


## Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
Set up a PostgreSQL database and update connection.properties with your database credentials.

Compile and run the project from the command line or using an IDE like IntelliJ.

Usage
Flight Operations: Use Aircontroller.java to manage flight details.
Passenger Records: Access passenger records through Airservice.java.
Database Configuration: Update connection details in connection.properties as needed.
Requirements
Java 11 or later
PostgreSQL database
IntelliJ IDEA or another Java-compatible IDE
Contributing
# Contributions are welcome! Please fork the repository and make a pull request for any feature additions or improvements
