# 🍊 OrangeHRM Test Automation Framework
*"The project that turned 'I know Selenium' into 'I built a framework.'"*

Welcome to my complete test automation framework built for **OrangeHRM**, a widely used open-source HR management system. This project was developed from scratch to move beyond manual testing and establish a reliable, scalable automation architecture that mirrors industry-standard QA practices.

---

## 🛠️ Tech Stack & Tools

* **Language:** Core Java
* **Automation Tool:** Selenium WebDriver
* **Test Runner:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** Allure Reports

---

## 🚀 Key Technical Features

* ☕ **Comprehensive Coverage:** Automated core workflows across multiple modules including Login, Dashboard, Admin, PIM, MyInfo, Leave, Recruitment, and Buzz.
* 🏗️ **Page Object Model (POM):** Designed with a highly maintainable and scalable architecture that strictly separates test execution logic from UI locators.
* 🧪 **TestNG Framework Integration:** Implemented structured test execution, grouping, and prioritization for organized and repeatable test runs.
* ⚡ **Parallel Execution:** Configured TestNG for concurrent test runs, significantly cutting down overall execution time.
* 📸 **Automatic Failure Screenshots:** Implemented a TestNG listener to automatically capture a screenshot on test failure, attached directly to the Allure report for faster debugging.
* 📊 **Allure Reports:** Integrated visual, detailed reporting to generate clear test execution metrics readable by both technical and non-technical stakeholders.

---

## ⚙️ Engineering Highlights & Real-World Challenges

This project wasn't a follow-along tutorial; it was built to solve practical automation challenges:

* Handling dynamic WebElements and implementing robust synchronization strategies.
* Writing reliable, scalable locator strategies.
* Capturing screenshots on failure to speed up debugging and bug reporting.
* Optimizing the suite for speed through parallel execution configurations.

**Current Test Execution Metrics:**
* ✅ **Passed:** 25 Test Cases
* ❌ **Failed:** 5 Test Cases *(Root cause analysis and debugging currently actively underway — failure screenshots attached in Allure report)*

---

## 💻 How to Run This Project Locally

### 1. Prerequisites

* **Java Development Kit (JDK):** Ensure JDK 11 or higher is installed.
* **Maven:** Ensure Maven is installed for dependency management.
* **Allure Commandline:** Required to serve and view the generated reports.

### 2. Clone the Repository

```bash
git clone https://github.com/MuhammadHarisTariq/orangehrm-selenium-automation.git
cd orangehrm-selenium-automation
```
