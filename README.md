Quiz Portal - https://quizzing-site.netlify.app/

Quiz Portal is a fully functional website where users can test their knowledge by participating in quizzes. The system supports two roles: Admin and Normal User, with distinct functionalities for each.


Functionalities

Normal User:-

1. Register on the Platform

   New users can register themselves to access the platform's features.

   
2. Login and Token Generation

   After registering, users can log in to generate a token for authentication. This token will allow them to access all other functionalities.
   
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

The backend service is deployed and running at:
https://quiz-portal-backend-production.up.railway.app/

The frontend service is deployed on netlify - https://quizzing-site.netlify.app/

How It Works :-
1. Register: New users register themselves on the platform.
2. Login: Generate a token to authenticate and access other features.
3. Normal Users: Browse and attempt quizzes.
4. Admins: Use a separate interface to manage the platform content.

   
