<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<!DOCTYPE html>
		<html>
			<head>
				<title> Tushar Reminder App</title>
				<style>
        body {
            font-family: Arial, sans-serif;
            background-color: black;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            margin-top: 20px;
            width: 100%;
            max-width: 600px; /* Limit the width for better appearance */
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .btn-success {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            display: block; /* Center button */
            margin: 0 auto; /* Center button */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #e9ecef;
        }

        .mb-3 {
            margin-bottom: 1rem;
        }

        select, input[type="time"] {
            width: 100%; /* Full width for form fields */
            padding: 8px;
            margin-top: 5px; /* Add some space above */
            border: 1px solid #ced4da;
            border-radius: 4px;
        }
    </style>
			</head>
			<body>
				<div class="container">
					<h2>Tushar Mall Reminder</h2>
					<form action="/saveReminder" method="post">
						<div class="mb-3">
							<label for="dayOfWeek" class="form-label">Day of the Week:</label>
							<select name="dayOfWeek" class="form-select" required>
								<option value="">Select a day</option>
								<option>Monday</option>
								<option>Tuesday</option>
								<option>Wednesday</option>
								<option>Thursday</option>
								<option>Friday</option>
								<option>Saturday</option>
								<option>Sunday</option>
							</select>
						</div>

						<div class="mb-3">
							<label for="time" class="form-label">Time:</label>
							<input type="time" name="time" class="form-control" required/>
						</div>

						<div class="mb-3">
							<label for="activity" class="form-label">Activity:</label>
							<select name="activity" class="form-select" required>
								<option value="">Select an activity</option>
								<option>Wake up</option>
								<option>Go to gym</option>
								<option>Breakfast</option>
								<option>Meetings</option>
								<option>Lunch</option>
								<option>Quick nap</option>
								<option>Go to library</option>
								<option>Dinner</option>
								<option>Go to sleep</option>
							</select>
						</div>
						<button type="submit" class="btn btn-success">Save Reminder</button>
					</form>

					<h2>Reminders</h2>
					<table>
						<thead>
							<tr>
								<th>Day</th>
								<th>Time</th>
								<th>Activity</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reminder" items="${reminders}">
								<tr>
									<td>${reminder.dayOfWeek}</td>
									<td>${reminder.time}</td>
									<td>${reminder.activity}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</body>
		</html>


