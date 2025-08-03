
# 💰 Digital Bank in Java

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

This project is a simulation of a **Digital Bank**, developed in Java using key **Object-Oriented Programming (OOP)** concepts such as **interfaces**, **inheritance**, **encapsulation**, and **Stream API**.

## 📌 Features

- Create accounts (Checking or Savings)
- Login using CPF and password
- List all accounts
- Search accounts by CPF or account number
- Bank operations:
  - Deposit
  - Withdraw
  - Transfer between accounts
  - View account statement
  - Simulate interest earnings (savings account only)

## 🛠 Technologies & Concepts

- Java 17
- Object-Oriented Programming (OOP)
- Stream API
- `Scanner` for terminal input
- Modular package structure (`cliente`, `conta`, `banco`)

## ▶️ How to Run

1. **Clone the repository:**

```bash
git clone https://github.com/your-username/digital-bank-java.git
```

2. **Compile and run the project:**

If you're using terminal:

```bash
javac -d ./bin ./src/main/java/main/java/*.java ./src/main/java/main/java/dio/**/*.java
java -cp ./bin main.java.Main
```

> Or open the project in an IDE like IntelliJ IDEA and run the `Main` class.

## 📁 Project Structure

```
src/
└── main/
    └── java/
        └── main/java/
            ├── Main.java
            └── dio/
                ├── banco/
                │   └── Banco.java
                ├── cliente/
                │   └── Cliente.java
                └── conta/
                    ├── Conta.java
                    ├── ContaCorrente.java
                    └── ContaPoupanca.java
```

## 💡 Usage Example

- **Creating an account:**
  - Enter name, age, CPF, and password
  - Choose between Checking or Savings account

- **Accessing an account:**
  - Enter CPF and password
  - Choose operations such as deposit, withdrawal, transfer, or view statement

## 🧪 Testing

The project is tested manually via terminal interaction. You can create multiple users and accounts and perform the available banking operations.

## 📖 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

**Developed by Junior G 💻**
