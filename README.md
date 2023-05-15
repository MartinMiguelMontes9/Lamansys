# Framework hecho con Selenium, Maven, TestNG, Page Objet y Rest Assured

## System Requirements:
+ jdk: https://docs.oracle.com/en/java/javase/index.html
+ maven: https://maven.apache.org/download.cgi
+ git client: https://www.atlassian.com/git/tutorials/install-git

# Getting started

- ## Running with Maven

    + ### First Step

        + Download and unzip the source repository for this guide, or clone it using Git:
      ```
      $ git clone https://github.com/MartinMiguelMontes9/Lamansys.git
      ```

        + Go to root directory:
      ```
      $ cd Lamansys
      ```   

    + ### Second Step

      If you want to run tests locally, you need maven as a minimum requirement
        + Make sure you have installed maven correctly

      ```
      $ mvn --version
  
        OUTPUT:
          Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
          Maven home: /opt/apache-maven-3.8.2
          Java version: 13.0.5.1, vendor: Debian, runtime: /usr/lib/jvm/java-13-openjdk-amd64
          Default locale: en_US, platform encoding: UTF-8
          OS name: "linux", version: "5.10.0-6parrot1-amd64", arch: "amd64", family: "unix"
      ```

      If you don't see a similar output:
        + Make sure you have the maven path configured
      #### Linux user
      ```
      $ grep -Ew '(.*)(M2_HOME)' ~/.bashrc
  
        OUTPUT:
          M2_HOME=/opt/apache-maven-3.8.2
          PATH=$PATH:$M2_HOME/bin
      ```   
      #### Windows user
      ```
      $ set
  
        OUTPUT:
          M2_HOME=C:\Program Files\apache-maven-3.8.2
          PATH=%PATH%;%M2_HOME%\bin;
      ```

    + ### Third Step
  
  + To run the tests, you need to modify the pom file by changing the maven-surefire-plugin parameter suiteXmlFile, setting the testng.xml file that corresponds to the test. For example, to run the webservice tests, we modify the parameter in the following way: 
      ```
      <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-surefire-plugin</artifactId>
              <version>3.0.0</version>
              <configuration>
                  <suiteXmlFiles>
                      <suiteXmlFile>testngws.xml</suiteXmlFile>
                  </suiteXmlFiles>
              </configuration>
      </plugin>
       ```
  + ### Four Step
  
  + To run the tests with maven, we must execute the following command:

    ```
     $ mvn test
    ```
# Reports

The report is automatically generated using the Extend Report library and is located at the root of the project with the name extend.html.


## Project structure


```
  .
├── main
│     └── java
│           └── com
│                 └──lamansys
│                     ├── pages
│                     │     ├── EbayPage
│                     │     ├── HomePage
│                     │     └── LoginPage
│                     └── utilities 
│                           ├── ConfigReader
│                           ├── DriverFactory
│                           └── ExtendReportListener
│
└── test
      ├── java
      │     └── com
      │            └──lamansys
      │                 ├── web
      │                 │     └── TestRunner 
      │                 └──ws
      │                     └── ApiTest
      │                 
      └──resources      
           └──config
                └──config.properties
```

## Driver options in DriverFactory file:

The WebDrivers for the following browser version are located in the 'drivers' folder.

| **Driver**    | **Description**      | 
|---------------|----------------------| 
| ChromeDriver  | Chrome 113.0.5672.93  |  
| Geckodriver   | Firefox 111.0.1      |
| EdgeDrive     | Edge 112.0.1722.34   |  
