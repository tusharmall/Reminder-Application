# Overview


This is a simple Reminder Application built using Spring Boot with a UI based on JSP. The application allows users to schedule daily activities and be reminded through a sound/chime when the scheduled time is reached. It supports selecting the day of the week, time, and a list of predefined activities through dropdown menus.

# Features
Schedule daily activities from a predefined list.
Choose the day of the week and time for each activity.
A sound/chime notification plays when the scheduled time is reached.
Simple and intuitive UI using dropdown menus for ease of use.

![Screenshot 2024-10-28 133003](https://github.com/user-attachments/assets/11de01ea-dc4b-41e2-bf9b-cd10e3a2ea15)
![Screenshot 2024-10-28 132851](https://github.com/user-attachments/assets/d5ea94ba-3309-4890-b2e8-f2269ce8344f)
![Screenshot 2024-10-28 132915](https://github.com/user-attachments/assets/f6314273-d059-4b8d-80c2-c4605d05fc70)
![Screenshot 2024-10-28 132939](https://github.com/user-attachments/assets/9ee3103a-dd7f-4cd0-8bda-081c21adf336)
![Screenshot 2024-10-28 133358](https://github.com/user-attachments/assets/23d0cf0a-8ee1-495e-acd9-c52a754458c8)


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
