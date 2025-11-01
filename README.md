# 📚 BookStore - Java OOP Project

A simple **Java Object-Oriented Programming** project that simulates a bookstore system.  
This project demonstrates clean OOP principles like **inheritance**, **encapsulation**, and **abstraction** through a bookstore application that manages paper books and e-books.

---

## 🚀 Features

- Add, remove, and display books
- Purchase system with total cost calculation
- Manage inventory and book stock
- Support for both **PaperBooks** and **EBooks**
- Organized folder structure (Models, Service, Test, Main)
- Demonstrates OOP concepts:
  - **Inheritance** (`EBook`, `PaperBook` extend `Book`)
  - **Encapsulation** (private fields with getters/setters)
  - **Abstraction** (common `Book` class)
  - **Polymorphism** (different book types with unique behaviors)

---
## 🗂️ Folder Structure
```
├──Quantum-Bookstore/
│ ├── src/
│ │ ├── Models/
│ │ │ ├── Book.java
│ │ │ ├── EBook.java
│ │ │ └── PaperBook.java
│ │ ├── service/
│ │ │ ├── delivery/
│ │ │ │ ├── Deliverable.java
│ │ │ │ ├── MailService.java
│ │ │ │ └── ShippingService.java
│ │ │ └── BookStore.java
│ │ ├── Test/
│ │ │ └── BookStoreTest.java
│ │ └── Main.java
├── README.md
└── .gitignore
```

---

💡 **Contributing**

Feel free to open an issue or submit a pull request with new features, improvements, or bug fixes — contributions are always welcome!
