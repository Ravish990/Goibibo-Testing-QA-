# Goibibo QA Automation Project

This is a Selenium TestNG-based automated testing framework written in Java for testing core functionalities of the Goibibo website. The project focuses on validating the **Home Page Login** and **Flight Booking** features to ensure consistent and bug-free user experiences.

## 📌 Tech Stack

- **Language:** Java
- **Framework:** TestNG
- **Automation Tool:** Selenium WebDriver
- **Build Tool:** Maven
- **IDE:** Eclipse

## 📂 Project Structure

goibibo-qa/
├── src/
│ ├── main/
│ │ └── java/ # Page Objects and Utility classes
│ └── test/
│ └── java/ # TestNG Test Cases
├── testng.xml # TestNG Suite Configuration
├── pom.xml # Maven Configuration
└── README.md

markdown
Copy
Edit

## ✅ Features Covered

- **Home Page Login**
  - UI login flow validation
  - Error handling for invalid credentials

- **Flight Booking**
  - Search flights with various filters
  - Validate booking flow and pricing

## ⚙️ Prerequisites

- Java JDK 8 or higher
- Maven 3.6+
- Eclipse IDE (or any other Java IDE)
- ChromeDriver (or the driver matching your browser version)

## 🚀 How to Run the Tests

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Ravish990/Goibibo-Testing-QA-.git
   cd Goibibo-Testing-QA-
Update WebDriver Path (if needed)

Make sure the path to chromedriver is correctly set in your test base or system properties.

Run Tests via Maven

bash
Copy
Edit
mvn clean test
Run Specific Suite via TestNG

Right-click on testng.xml → Run As → TestNG Suite (in Eclipse)

📄 Reporting
Test results and logs will be generated in the test-output folder by TestNG. For advanced reporting (like ExtentReports), integration can be added as needed.

🧪 Best Practices Followed
Page Object Model (POM) design pattern

Clear separation of test logic and UI actions

Reusable utility methods for common actions

Maven lifecycle management

🔧 Future Enhancements
Add cross-browser testing

Integrate ExtentReports for detailed reports

CI/CD pipeline with Jenkins or GitHub Actions

Expand coverage to Hotel Booking and Payment Gateway