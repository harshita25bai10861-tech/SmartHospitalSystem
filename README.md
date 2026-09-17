# SmartHospitalSystem
# Smart Hospital Patient Triage & Bed Allocation System

## Overview
A Java application designed to handle emergency room triage queues, perform concurrent bed allocations safely, and manage patient persistence.

## Key Features
* **Triage Prioritization:** Sorts patients dynamically (`CRITICAL`, `HIGH`, `MEDIUM`, `LOW`).
* **Multithreaded Allocation:** Prevents race conditions during bed booking using `synchronized` execution.
* **Resilient Logging:** Logs activities to `hospital_audit.log` when external databases are offline.

## Tech Stack & Tools
* **Language:** Java (JDK 17+)
* **Database:** JDBC / MySQL
* **Tools:** Visual Studio Code, Git, GitHub

## Installation & Running
1. Clone this repository:
   ```bash
   git clone <YOUR_GITHUB_REPOSITORY_URL>
   cd SmartHospitalSystem
