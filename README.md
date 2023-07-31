# DiabetesDB
An Android app for logging insulin bolus amounts and their impact on blood glucose levels, and suggesting bolus amounts based on past data.

## The concept
The idea behind this app is to take a results-based approach to insulin estimation.
Rather than using a purely theoretical approach based on insulin:carb ratios and estimated insulin sensitivity, DiabetesDB will use the user's own data to form a model.

Conveniently, this also means DiabetesDB acts as a meal diary too.

## Current build
This project has only just started, so far if you build the app it will allow you to add a meal to the local database.  There is currently no way to view the database entries within the app but you can view it in Android Studio's debugging tools.

## Future vision
When the user first loads up the app, they will have an empty database which they can add meals to.  For example: if you have pesto pasta for dinner on a day when you haven't exercised, you might enter:
 - Carb type: Wholewheat pasta
 - Carbs: 60g
 - Glucose level: 7.8mmol/l
 - High fat: true
 - Exercise day: false

By adding this to your database, the app will schedule a notification to prompt you to check your blood sugar 90 minutes after your insulin injection.  This is the ideal/expected time by which your postprandial blood glucose level should have returned to between 5 and 9 mmol/l.
Now, your database contains detailed information about the meal you ate, what your levels were before the meal, and what they were afterwards.
After you have a certain number of meals in your database (undecided as of writing) you will be able to use the app to suggest a bolus amount based on a mathematical model using your own data.  When using the bolus advisor you will be given the option of saving the suggestion to your database, in order to continue growing your data points and improving the model.

## Roadmap
- ~~Set up local database for storing user data~~
- ~~Expand UI so users can log meals, with optional extra information~~
- ~~Create a notification system for postprandial blood glucose~~
- Create an activity for viewing meal history
- Implement system for bolus estimation based on past data
- Create UI for estimating a bolus
