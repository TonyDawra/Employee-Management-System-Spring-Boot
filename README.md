# Employee Management System Spring Boot

A comprehensive application for managing employees, salaries, and projects with an intuitive user interface.

## Overview

The Employee Management System is a full-stack application designed to help companies manage their workforce efficiently. The system provides a secure interface for management personnel to track employee information, manage salaries, and monitor project assignments.

## Features

- **Secure Authentication**: Only authorized management personnel can access the system
- **Dashboard**: Visual representation of company statistics including:
  - Total employee count
  - Active employee count
  - Inactive employee count
  - Statistical graphs
- **Employee Management**:
  - View all employees in a list with detailed information
  - Add new employees
  - Update existing employee information
  - Delete employees
  - Import employee profile pictures
- **Salary Management**:
  - Track and view all employee salaries
  - Update salary information
- **Project Management**:
  - Monitor ongoing projects
  - Track project assignments to employees
  - Record project start and finish dates
  - Mark projects as completed

## Getting Started

### Prerequisites

- Backend API server
- Frontend application

### Installation & Setup

1. Start the backend API server
   ```
   # Command to start the backend service
   ```

2. Launch the frontend application
   ```
   # Command to start the frontend application
   ```

3. The application will open with the login page

## Usage Guide

### Login

1. Launch the application
2. Enter management credentials in the login form
3. Click the login button
4. System will display an alert confirming successful login or error

### Dashboard

After successful login, you'll be directed to the home page dashboard which displays:
- Company statistics
- Employee distribution graphs
- Navigation panel on the left
- Control buttons (minimize, exit) on the top right
- Logout button at the bottom of the navigation panel

### Employee Management

1. Click "Add Employee" in the navigation panel
2. View the complete employee list with detailed information
3. To add a new employee:
   - Fill in the required fields
   - Import a profile picture if available
   - Click the "Add" button
4. To update an employee:
   - Select the employee from the list (fields will auto-populate)
   - Modify the required information
   - Click the "Update" button
5. To delete an employee:
   - Select the employee from the list
   - Click the "Delete" button
6. Use the "Clear" button to reset form fields

### Salary Management

1. Click "Employee Salary" in the navigation panel
2. View the complete list of employees with their salary information
3. To update a salary:
   - Select an employee from the list
   - Modify the salary information
   - Click the "Update" button
4. Use the "Clear" button to reset form fields

### Project Management

1. Click "Project Management" in the navigation panel
2. View all company projects with their details, including:
   - Project name
   - Assigned employee
   - Start date
   - Status (ongoing/completed)
3. To mark a project as finished:
   - Select the project
   - Click the "Finish" button to record completion time

### Navigation & Controls

- **Navigation Panel**: Located on the left side for accessing different modules
- **Exit Button**: Located at the top right to close the application
- **Minimize Button**: Located at the top right to minimize the application
- **Logout Button**: Located at the bottom of the navigation panel

## System Feedback

The system provides alert notifications for various actions:
- Successful/failed login attempts
- Employee addition, updates, and deletion
- Salary updates
- Project status changes

## Security Features

- Authentication required for system access
- Only management personnel have login credentials
- Session management with logout functionality

## Technical Notes

This application consists of two main components:
1. Backend API server for data management and authentication
2. Frontend interface for user interaction

## Future Enhancements

Potential improvements for future versions:
- Advanced reporting features
- Role-based access control
- Employee self-service portal
- Time tracking integration
- Performance evaluation tools
