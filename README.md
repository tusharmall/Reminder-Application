# Overview


This is a simple Reminder Application built using Spring Boot with a UI based on JSP. The application allows users to schedule daily activities and be reminded through a sound/chime when the scheduled time is reached. It supports selecting the day of the week, time, and a list of predefined activities through dropdown menus.

# Features
Schedule daily activities from a predefined list.
Choose the day of the week and time for each activity.
A sound/chime notification plays when the scheduled time is reached.
Simple and intuitive UI using dropdown menus for ease of use.

![Screenshot 2024-09-25 205401](https://github.com/user-attachments/assets/154de76a-c989-4a26-a6cc-70b16864d88a)
![Screenshot 2024-09-25 205552](https://github.com/user-attachments/assets/e599b2f9-c59b-4b21-bb60-aead6747c1fd)
![Screenshot 2024-09-25 205505](https://github.com/user-attachments/assets/6ae8f662-b6a9-4e8e-976a-4f024081fb8a)
![Screenshot 2024-09-25 205445](https://github.com/user-attachments/assets/e82d8fcf-c69b-4849-9e29-bb8f81a45d43)
![Screenshot 2024-09-25 205428](https://github.com/user-attachments/assets/cd9b9f6c-de95-4817-8d69-d2addbc35824)


# Predefined Activities:

- Wake up<br>
- Go to gym<br>
- Breakfast<br>
- Meetings<br>
- Lunch<br>
- Quick nap<br>
- Go to library<br>
- Dinner<br>
- Go to sleep<br>

# Tech Stack
**Backend:** Spring Boot <br>
**Frontend:** JSP, HTML, CSS<br>
**Database:** H2 (In-Memory)<br>
**Validation:** Jakarta Bean Validation<br>
**JPA:** Jakarta Persistence API<br>

# How It Works
Users can select a day of the week, a time, and an activity from dropdown menus.             
The selected reminder will be saved in the database.
At the scheduled time, the app will play a sound/chime to notify the user of the activity.
Users can view, add, or modify their reminders at any time through the UI.

# Project Structure

Controller: Handles the user requests and responses.
Service: Contains the business logic, fetching reminders from the database and saving new ones.
Repository: Manages data persistence using Spring Data JPA.
Model: Represents the Reminder entity, containing fields such as day of the week, time, and activity.
