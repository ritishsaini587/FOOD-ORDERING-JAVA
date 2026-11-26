FOOD ORDERING SYSTEM - PURE JAVA (NO ADMIN, NO DATABASE)

Requirements:
- JDK 17 or later (JDK 8+ should also work with these sources)
- Visual Studio Code with Extension Pack for Java (optional for one-click Run)

Run from the project root in PowerShell:

  javac -d out (Get-ChildItem .\src\com\foodorder\*.java).FullName
  java -cp out com.foodorder.Main

VS Code one-click Run:
1. Open this extracted folder in VS Code.
2. Install Microsoft's Extension Pack for Java.
3. Open src/com/foodorder/Main.java.
4. Click Run above the main method.

Main menu:
1. Register
2. Customer Login
3. Exit

No MySQL, SQL, JDBC, Maven, or Admin class is used.
Data is held in ArrayLists and resets when the program exits.
