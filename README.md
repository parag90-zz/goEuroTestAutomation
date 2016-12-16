#Created this project: goEuroTestAutomation for Automating tests on www.goeuro.com

###It contain test: TC001_PriceFilterTest which will
 1. goto www.euro.com
 2. Search from Berlin to Pragues
 3. check on search landing page that the prices are sorted in descending order

###Project structure
 - src/java
    * pages: contains page file which conatins all actions
    * testscripts: this has testcase files, Basically the actions and verifications
    * Utilities: All other supported java files liek browserDriver, Sort utility

 - Configuring the deparure and arrival city can be changes at test data file: TestData/TC001_PriceFilterTest.properties
 - All xpaths are kept at: ElementRepository/MainPage.properties
 - ChromeDriver is placed at Setup folder
 - All dependancies are specified in pom.xml
 - testng configuration at testng.xml

###Technologies used
* Scripting: Java(1.8)
* Build management: Maven
* Other: Selenium, surefire plugin, testNg

###Pre-requisites:
1. Java installed
2. Linux/OSX
3. Maven
4. Git

###Steps to run
1. Take repository clone on you local "git clone git@github.com:parag90/goEuroTestAutomation.git"
2. Go inside the main folder
3. run this command "mvn clean install" on terminal

###Reports will be generated at "target/surefire-reports/html/index.html"

###Debugging:
1. If in case of chrome driver permission issues, Please give executable permssion to Setup/chromedriver2