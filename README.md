Quiz Portal - https://quizzing-site.netlify.app/ 

Plz visit this website for attending the quiz.

Quiz Portal is a fully functional website where users can test their knowledge by participating in quizzes. The project includes a backend service, already deployed, and a frontend interface (currently under development using Angular). The system supports two roles: Admin and Normal User, with distinct functionalities for each.


Functionalities

Normal User:-

1. Register on the Platform

   New users can register themselves to access the platform's features.

   • Registration URL:
   https://quiz-portal-backend-production.up.railway.app/user/

   • Example Body:
         {
          "username": "xyzabc123",
          "password": "pingpong",
          "firstName": "Ram",
          "lastName": "Kumar",
          "email": "ram@gmail.com",
          "phone": "9887766551"
         }

   
2. Login and Token Generation

   After registering, users can log in to generate a token for authentication. This token will allow them to access all other functionalities.

   • Token Generation URL:
   https://quiz-portal-backend-production.up.railway.app/generate-token

   • Example Body:
         {
          "username": "xyzabc123",
          "password": "pingpong"
         }
   • The system will identify the user as a valid registered user and grant access to protected functionalities.
   
3. Browse and Attempt Quizzes

   Normal users can:

      • Select a category from the available list.
      • Choose a quiz within the selected category.
      • Attempt the quiz and view results.

Admin User:-

Admins have advanced capabilities to manage the platform. They can:

1. Manage Categories
      • Add, update, or delete quiz categories.
   
2. Manage Quizzes
      • Add, update, or delete quizzes under specific categories.
   
3. Manage Questions
      • Configure quiz questions, including:
      • Adding or updating options.
      • Defining correct answers.

4. Admin Interface
      • Admins will have a dedicated frontend interface (currently under development) with all the tools needed to manage categories, quizzes, and questions.


Deployment :-

The backend service is already deployed and running at:
https://quiz-portal-backend-production.up.railway.app/

The frontend interface is under development using Angular. Once completed, it will provide a seamless user experience for both admins and normal users.

How It Works :-
1. Register: New users register themselves on the platform.
2. Login: Generate a token to authenticate and access other features.
3. Normal Users: Browse and attempt quizzes.
4. Admins: Use a separate interface to manage the platform content.

   
![image](https://github.com/user-attachments/assets/930a3b73-1f34-4ccb-a5d8-4945e0ccfd06)
