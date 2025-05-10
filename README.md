# Console-Based Banking System

A feature-rich, console-based banking system implemented in Java with a beautiful user interface, persistent data storage, and comprehensive banking operations.

## 🌟 Features

### 1. User Management
- User registration with validation
- Secure login system
- Password requirements (minimum 6 characters)
- Persistent user data storage

### 2. Banking Operations
- 💰 View Account Balance
- 💳 Fund Transfer between users
- 📝 Bill Payment system
  - Electricity bills
  - Water bills
  - Internet bills
- 📞 Customer Support information

### 3. User Interface
- 🎨 Color-coded console interface
- 📊 Box-drawn borders for better readability
- 😊 Emoji indicators for different operations
- 📱 Mobile-friendly support contact information

### 4. Data Management
- Persistent data storage using file system
- Automatic data backup
- Default user accounts for testing

## 🛠️ Technical Details

### Data Structures Used
1. **HashMap<String, User>**
   - Stores user information
   - O(1) time complexity for operations
   - Key: username, Value: User object

2. **File System Storage**
   - Binary file storage (bank_data.dat)
   - Java serialization for data persistence
   - Automatic data loading/saving

### Classes
1. **Main.java**
   - Program entry point
   - Main program loop

2. **User.java**
   - User data model
   - Serializable for persistence
   - Stores username, password, and balance

3. **BankingSystem.java**
   - Core banking operations
   - User interface management
   - Transaction handling

4. **DataStorage.java**
   - Data persistence management
   - File I/O operations
   - Default user creation

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Basic understanding of Java programming
- Terminal or command prompt

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd BankingSystemProject
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the program**
   ```bash
   java Main
   ```

### Default Users
The system comes with two default users for testing:
- Username: `john`, Password: `pass123`, Balance: $5000.0
- Username: `alice`, Password: `pass456`, Balance: $3000.0

## 💻 Usage Guide

### 1. Login/Registration
- Choose between login or registration
- For new users, complete the registration form
- For existing users, enter credentials

### 2. Banking Menu
After successful login, you can:
1. View your current balance
2. Transfer funds to other users
3. Pay bills
4. Access customer support
5. Logout

### 3. Fund Transfer
- Enter receiver's username
- Specify transfer amount
- Confirm transaction

### 4. Bill Payment
- Select bill type
- Confirm payment
- View updated balance

## 🔒 Security Features

- Password length validation
- Balance validation for transactions
- Input validation for all operations
- No negative balance allowed

## 📝 Data Storage

- All user data is stored in `bank_data.dat`
- Data persists between program runs
- Automatic data saving after each transaction
- Default users created if no data file exists

## 🐛 Error Handling

The system handles various error cases:
- Invalid login credentials
- Insufficient balance
- Invalid numeric input
- File I/O errors
- Invalid menu choices

## 🔄 Program Flow

1. Program starts
2. Loads existing user data
3. Shows login/registration menu
4. After successful login:
   - Displays banking menu
   - Handles user operations
   - Returns to login after logout

## 🤝 Contributing

Feel free to contribute to this project:
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgments

- Java Documentation
- Console UI Design Patterns
- Banking System Best Practices

## 📞 Support

For support, please contact:
- Phone: 1-800-BANK-HELP
- Email: support@bank.com

---

Made with ❤️ for banking enthusiasts 