# Appium Automation Framework - Al-Muzaini

## Project Overview
This is a professional, enterprise-grade Appium automation framework designed for the Al-Muzaini mobile application. It follows the **Page Object Model (POM)** pattern and is built for scalability, maintainability, and parallel execution.

## Tech Stack
- **Languages:** Java 11+
- **Automation:** Appium 9.x, Selenium 4.x
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **Reporting:** Extent Reports
- **Logging:** Log4j2
- **CI/CD:** Jenkins

## Folder Structure
```text
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/           # Core framework (DriverFactory, BaseTest, BasePage)
│   │   │   ├── config/         # Environment & properties management
│   │   │   ├── constants/      # Static path & wait constants
│   │   │   ├── listeners/      # TestNG Listeners for Reporting & Failures
│   │   │   ├── utils/          # Mobile actions (Waits, Gestures)
│   │   │   └── pages/          # Page Object classes
│   │   └── resources/
│   │       ├── config/         # Environment-specific property files
│   │       └── log4j2.xml      # Logger configuration
│   └── test/
│       ├── java/
│       │   └── tests/          # Test execution scripts
│       └── resources/
│           └── testng.xml      # Suite configuration
```

## Prerequisites
- **Java Development Kit (JDK):** Version 11 or higher.
- **Node.js & Appium Server:** Installed and accessible via CLI.
- **Android Studio / Xcode:** For emulator/simulator management.
- **Maven:** For build and dependency management.

## Setup Instructions
1. Clone the repository.
2. Install dependencies: `mvn clean install -DskipTests`.
3. Configure `src/main/resources/config/qa.properties` with your local device details.
4. Start Appium Server: `appium`.

## Quick Start (Run tests now)
Execute the following commands to run tests immediately on a pre-configured Android emulator:

```bash
# 1. Start Appium Server
appium

# 2. Run all tests via Maven (on Android)
mvn test -Denv=qa -Dplatform=android
```

---

## Running Tests

### 1. Command Line (CLI)
The most flexible method for running tests. You can pass environment and platform variables dynamically:

```bash
mvn test -Denv=qa -Dplatform=android
```
- **`-Denv`**: Environment to run against (e.g., `qa`, `dev`, `prod`).
- **`-Dplatform`**: Target platform (`android` or `ios`).

### 2. VS Code
- **Prerequisites:** Install [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
- **Steps:**
    1. Open the **Testing** tab (beaker symbol).
    2. Click **Run** next to a specific test case or class.
    3. View real-time results in the **Test Report** window.

### 3. Antigravity (AI Workspace)
Antigravity can manage test execution autonomously:
- **Steps:**
    1. Command: `Run all tests` or `Run TransferMoneyTest`.
    2. Antigravity will check your environment, start Appium if needed, and execute the tests.

### 4. IntelliJ IDEA
- **Steps:**
    1. Open the project as Maven.
    2. Locate `src/test/resources/testng.xml`.
    3. Right-click and select **Run 'testng.xml'**.
    4. To run individual tests, right-click any `@Test` method and select **Run**.

### 5. Android Studio
Since this is a Maven project:
- **Steps:**
    1. Open the **Terminal** at the bottom.
    2. Use the Maven CLI command: `mvn test -Denv=qa -Dplatform=android`.
    3. Alternatively, use the **Maven Tool Window** (View > Tool Windows > Maven) to trigger the `test` lifecycle phase.

## Reporting & Logs
- **Extent Reports:** Generated after every run in the `/reports` directory.
- **Logs:** Detailed execution logs are stored in `/logs/automation.log`.
- **Screenshots:** Failure screenshots are automatically attached to the Extent Report (configured via Listener).

## Contribution Guidelines
- Always use `BasePage` and `BaseTest`.
- No hardcoded values; use `ConfigReader` or `FrameworkConstants`.
- Each Page Object must focus on a specific screen UI.
- Maintain thread safety by using `DriverFactory.getDriver()`.
