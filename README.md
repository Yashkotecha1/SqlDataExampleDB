# Android SQLite CRUD App (Kotlin)

A simple **Android application built with Kotlin** that demonstrates how to use **SQLite Database** to perform basic **CRUD operations (Create, Read, Update, Delete)**.

This project is designed for beginners who want to learn how to store and manage local data in Android applications using SQLite.

---

## 📱 Features

* ➕ Insert data into SQLite database
* 📄 View all stored records
* ✏️ Update existing records
* ❌ Delete records
* 🎯 Simple and beginner-friendly UI
* ⚡ Built using Kotlin and Android Studio

---

## 🛠 Tech Stack

* **Language:** Kotlin
* **IDE:** Android Studio
* **Database:** SQLite
* **UI:** XML Layouts
* **Platform:** Android

---

## 📂 Project Structure

```
app
 ┣ java/com/example/sqlitecrud
 ┃ ┣ MainActivity.kt
 ┃ ┗ DatabaseHelper.kt
 ┣ res
 ┃ ┗ layout
 ┃   ┗ activity_main.xml
 ┗ AndroidManifest.xml
```

---

## 🗄 Database Schema

**Table Name:** `student`

| Column | Type    | Description                  |
| ------ | ------- | ---------------------------- |
| id     | INTEGER | Primary Key (Auto Increment) |
| name   | TEXT    | Student Name                 |
| email  | TEXT    | Student Email                |

---

## 🔄 CRUD Operations

### Create (Insert)

Adds a new student record to the database.

### Read (View)

Fetches and displays all stored student records.

### Update

Updates an existing record using the student ID.

### Delete

Removes a student record from the database using the ID.

---



## 🔎 Viewing SQLite Database in Android Studio

You can inspect the database using **Database Inspector**.

Steps:

```
View → Tool Windows → App Inspection → Database Inspector
```

