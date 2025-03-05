# REST Assured API Testing Project

This project is a **Java-based API test automation framework** using **REST Assured**, **TestNG**, and **Maven**, with **Allure Reports** for test reporting. It also includes **GitHub Actions** for continuous integration and automated test execution.

## Project Structure
```
├── src/test/java      # Test cases and utilities
├── src/main/java      # Main framework code (if applicable)
├── pom.xml            # Maven dependencies and configuration
├── testng.xml         # TestNG suite configuration
├── .github/workflows  # GitHub Actions workflow files
├── allure-results     # Directory where Allure stores results
└── README.md          # Project documentation
```

## Prerequisites
Ensure you have the following installed before running the tests:
- **Java 11+**
- **Maven**
- **Allure Command-Line Tool** (for report generation)

To install Allure CLI:
```sh
brew install allure  # macOS (Homebrew)
scoop install allure # Windows (Scoop)
```

## Installation & Setup
### From Command Line
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```

### From IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Click on **File → Open** and select the cloned project folder.
3. When prompted, **import the project as a Maven project**.
4. Ensure that IntelliJ detects the correct JDK (Settings → Project Structure → SDKs).
5. Wait for Maven to download dependencies.
6. Open **testng.xml**, right-click, and select **Run 'testng.xml'** to execute tests.

## Running Tests
- To execute tests using TestNG from the command line:
  ```sh
  mvn test
  ```
- To generate and view the Allure report:
  ```sh
  mvn allure:serve
  ```

## GitHub Actions Workflow
This project includes a **CI/CD pipeline** using **GitHub Actions**:
- Runs tests on each push and pull request.
- Generates and uploads Allure reports as an artifact.

### Workflow File Example (`.github/workflows/api-tests.yml`):
```yaml
name: Java CI with Maven

on:
  push:
    branches: [ "master" ]
  pull_request:
    branches: [ "master" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 17
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn -B package --file pom.xml
    - name: Load test report history
      uses: actions/checkout@v3
      if: always()
      continue-on-error: true
      with:
        ref: gh-pages
        path: gh-pages

    - name: Build test report
      uses: simple-elf/allure-report-action@v1.7
      if: always()
      with:
        gh_pages: gh-pages
        allure_history: allure-history
        allure_results: target/allure-results

    - name: Publish test report
      uses: peaceiris/actions-gh-pages@v3
      if: always()
      with:
        github_token: ${{ secrets.GITHUB_TOKEN }}
        publish_branch: gh-pages
        publish_dir: allure-history
```

## Reporting & Logs
- **Allure Reports** are stored in `allure-results`.
- To view test results locally, run:
  ```sh
  mvn allure:serve
  ```


