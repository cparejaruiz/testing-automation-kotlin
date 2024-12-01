I decided to use TestFX instead of Playwright for this exercise for several reasons:

### TestFX
- **Pros:**
  - Specifically designed for testing JavaFX applications.
  - Easy to integrate with Java desktop applications.
  - Good support for simulating user events and verifying UI states.
- **Cons:**
  - Less known and with less documentation than Playwright.
  - Limited to JavaFX applications.

### Playwright
- **Pros:**
  - Excellent for testing web applications.
  - Support for multiple browsers and platforms.
  - Extensive documentation and active community.
- **Cons:**
  - Not designed for testing JavaFX desktop applications.
  - Requires more configuration to integrate with desktop applications.

### Issues Encountered
While running the desktop applications, I encountered some issues:
- Initial configuration of TestFX was complex due to the lack of specific documentation for certain use cases.
- Compatibility issues with certain versions of JavaFX.
- Difficulties in simulating certain user events that are not well supported by TestFX.

Despite these issues, TestFX proved to be a suitable tool for testing JavaFX applications due to its specific focus and capabilities for simulating user events.

### Next Iteration
In the next iteration of tests, the Page Object Pattern will be included to improve the maintainability and readability of the test code. This pattern allows separating the UI logic from the tests, making it easier to manage and update the tests as the application evolves.