# DemoTodo

0. Instruction for Running the App:
   - get the whole project, the script (deploy.sh is responsible for starting up the compose the docker and run it)
   If you have git bash installed on your machine
   -- run the following command where the directory of the project is same as the script file
   -- bash deploy.sh

   If you dont have it installed: cd the directory/project
   run the below commands: 
   --docker-compose build
   --docker-compose up -d
     
1. I have uploaded the POSTMAN project for testing purposes:
   Note: I did not do the Sign in with oauth2 (github,google,facebook), unable to integrate it with this token generation.

   
   First - 
   You have to can register a user (after you register, the response contain the token) or you can get the token from users created 
   ![image](https://github.com/yo-y0/DemoTodo/assets/83231306/551a2972-4df5-44c5-a0d0-8b97f1571ba2)

   Second -
   In the TodoTest,
   You can use the token in TodoTest Bearer token:
   ![image](https://github.com/yo-y0/DemoTodo/assets/83231306/d702dc91-3ede-4149-9f70-ca34294cbe82)

   Third -
   Just run each test to see the results in the response. :)

2. The build is included in the run.
   
3. Authentication Methods:
   The tokenGeneration is from a video I followed which is https://www.youtube.com/watch?v=KxqlJblhzfI
   

   


   
