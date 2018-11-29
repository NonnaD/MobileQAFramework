# MobileQAFramework (Still in development)
Mobile QA Automation framework (Java,Selenium,Appium, TestNG)
Mobile QA Automation Framework - .docx - read full instruction 


![alt text](https://raw.githubusercontent.com/NonnaD/MobileQAFramework/master/Framework.png)
 
      

Why do we need framework?
Framework allows company to save time and money. It makes our code reusable, create it once and execute it multiple times. Framework is very useful for compatibility and regression testing, it enables parallel execution. Framework requires less manual intervention and helps to increase the test coverage.
 
Prerequisite to build framework:
Installed IntelliJ IDEA 
Installed JDK(Java Development Kit)
Installed TestNG
Installed Appium Desktop 
Installed Maven
 
 
Part 1. Framework architecture
Step 1.Create Maven project
In a terminal (*uix or Mac) or cmd(Windows), navigate to the folder you want to create the Java project. Type this command:
mvn archetype:generate 
"-DgroupId=companyName"
"-DartifactId=projectName"
"-DarchetypeArtifactId=maven-archetype-quickstart"
"-DinteractiveMode=false"
You will see the following: 

Step 2. Import completed project to IntelliJ IDEA 
To import the project, open IntelliJ IDEA and proceed to the steps shown below.
















Step 3. Apply Page Object Model
In this framework we will use POM and Page Factory pattern to separate element locators and tests. Each page has a separate class, and that class holds the functionality and members of that page. 
We will store all elements and locators in src/main/java/pageObjects and Test Cases in src/test/java/testCases. For convenience, we will store Positive TC and Negative TC in separate folders. 
For that, we need to create new packages (File-New-Package), as shown below. 

Step 4. Create resources folder 
Also, we need resources folder, where we will keep all configuration, data provider and XML based files. For example, the logging library log4j stores log4j.xml in this folder by default. Create new directory — “resources” in the main folder (File-New-Directory). Then, go to Project Structure and mark this directory as shown below.






Step 5.Configure dependencies in POM.xml
Go to Maven repository site — https://mvnrepository.com/artifact/io.appium/java-client
Add dependencies:
— Add Selenium (Selenium Java) dependency
— Add TestNG dependency
— Add Appium (Java client for Appium Mobile Webdriver) dependency
— Add Apache POI dependency
— Add Log4j API and Core dependencies
After all additions your POM.xml file should look as shown below.





Step 6. Create properties file.
The next step is to create a properties file, which will store information that remains static, such as browser specific information, web page URL, OS type, and test type. For that we should create new file “data.properties” in resources folder. Proceed to the next steps.






This is as far as we will go with the Framework architecture. In the next part we will see, how to create Create Base.java class and will add application file that will be tested.
 
 
Author: Nonna Dzhabieva
Contacts: dz.nonna@gmail.com

