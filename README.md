# rent-a-bike

Assumptions
-----------
- Each rental is for only one bike.
- The time duration of a rental is an int value.

Design
------
- I just tried to follow the simplest way that I am familiar with. 
- I create a REST service with two different methods to take care of the different types of rentals. 
- I created a Rental DTO to have the required info of a rental.
- I didn't create any data layer or repository.
- I didn't pursuit a more complex classes hierarchy to avoid unnecessary complexity.

Development practices
--------------------- 
- I just build a simple Springboot application to get something working quickly. It just helps me to organize my work. 
- I used Mockito for unit testing together and Jacoco for test coverage.
 
How run the tests
-----------------
Note: you should have Maven installed.
1. Download the code from Github.
2. 'cd' into the project directory 'rentabike' and run 'mvn test'
3. Then, go to the 'coverage-report/ut' folder and open the index.html file in your browser.