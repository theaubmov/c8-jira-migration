# JIRA to Camunda Migration Proof of Concept

## Introduction
This repository contains a Proof of Concept for migrating sprint workflows from JIRA to Camunda. It showcases a BPMN process for Sprint Creation and Planning, integrating with JIRA via REST API to fetch issues and manage sprints.

## Workflow Overview
![Workflow Overview](https://assets.zyrosite.com/m7VEG49oOecMOJLw/c8-sprint-planning-execution-Aq26X7yz0jfjZj9w.png)

*Above is the BPMN diagram depicting the entire sprint management workflow from creation, planning to execution.*

## Features
- **Sprint Creation Form**: A form to define the sprint goal and timeline.

  ![Sprint Creation Form](https://assets.zyrosite.com/m7VEG49oOecMOJLw/create-new-sprint-dWxwVkne3PuB9xDD.png)

- **Sprint Planning Form**: A form to select issues fetched from JIRA and assign them to the sprint, including estimation.

  ![Sprint Planning Form](https://assets.zyrosite.com/m7VEG49oOecMOJLw/backlog-grooming-dJoB0kleaBtpoyBk.png)
- **JIRA Integration**: REST API integration to manage sprints and issues directly from Camunda.

## Getting Started
To get started with this PoC, clone the repository and follow the setup instructions below.

### Prerequisites
- Camunda 8 Account
- Access to JIRA with necessary permissions to fetch and create issues

## 🚀 About Me
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ayoubaitlachgar.com/)
