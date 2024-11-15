# Nurse Management System

## Description

This project is a Nurse Management application designed to efficiently manage nurse data in hospitals, including creating, updating, searching, and logging in. 
It uses Spring Boot as the backend framework and provides several endpoints to interact with the nurse database.

### Key features:
- Create new nurses.
- Search for nurses by name or ID.
- Update nurse information.
- Delete nurses by ID.
- Authentication through login with username and password.

## Endpoints
1. **View All Nurses**
- **Endpoint**: `GET /nurse/allnurses`
- **Description**: Returns a list of all nurses.
- **Response**: `200 OK`: List of nurses. 
2. **Login**
- **Endpoint**: `POST /nurse/login`
- **Description**: Validates nurse credentials.
- **Parameters**: 
 `username` (String) 
 `password` (String)
- **Response**:
  `200 OK`: Login successful.
 `401 Unauthorized`: Invalid credentials. 
3. **Search Nurses by Name**
- **Endpoint**: `GET /nurse/findnursebyname`
- **Description**: Searches for nurses whose names contain the given substring.
- **Parameters**:
   `name` (String)
- **Response**:
   `200 OK`: List of nurses.
   `400 Bad Request`: Invalid name parameter.
   `404 Not Found`: No nurses match the search. 
4. **Find Nurse by ID**
- **Endpoint**: `GET /nurse/{id}`
- **Description**: Fetches a nurse by their ID.
- **Path Variable**:
  `id` (Integer)
- **Response**:
  `200 OK`: Nurse details.
  `404 Not Found`: Nurse not found. 
5. **Create New Nurse**
- **Endpoint**: `POST /nurse`
- **Description**: Creates a new nurse record.
- **Parameters**:
 `name`(String)
 `username` (String)
 `password` (String)
- **Response**:
 `201 Created`: Nurse successfully created.
 `400 Bad Request`: Invalid data. 
6. **Update Nurse**
- **Endpoint**: `PUT /nurse/{id}`
- **Description**: Updates an existing nurse's details.
- **Path Variable**:
 `id` (Integer)
- **Parameters**:
 `name` (String)
 `username`(String)
 `password` (String)
- **Response**:
 `200 OK`: Nurse successfully updated.
 `400 Bad Request`: Invalid data.
 `404 Not Found`: Nurse not found.
7. **Delete Nurse by ID**
- **Endpoint**: `DELETE /nurse/{id}`
- **Description**: Deletes a nurse by their ID.
- **Path Variable**:
 `id` (Integer)
- **Response**:
 `200 OK`: Nurse successfully deleted.
 `404 Not Found`: Nurse not found.
