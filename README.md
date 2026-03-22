# wedding-site

A fullstack website created using spring boot for showcasing wedding images and also to accept booking requests which would be sent to the specified email.

Im new to spring boot and this is my **first project**. I'm open for suggestions and advices.

*Its named sofistudio because I made it for my dad's studio*

## Features

- Admin panel to monitor and modify bookings, 

- Clean, Color palleted UI

- Email Service which sends confirmation, cancellation, received bookings 

## Tech Stack

- Java 25

- Spring Boot 

- Postgres 

- Cloudinary for Image uploads

- HTML, CSS, JS Frontend

- JavaMailSender (Gmail SMTP)

## Setup

- **Inside `application.yaml`:**
    - Gmail app password into password field under `mail:` 
    - Add your personal mail id to `admin-email` under `app: `
    - Add admin panel credentials there too 
    - Add the gmail id which the service should use to `username` under `mail`
    - Add your cloudinary details like api key, username and api secret

- Modify the message which should be sent through mail inside service/MailNotifServiceImpl

- Feel free to edit the front-end however you want; change name, logo, hero image 

- Also change the project details in the artifact tag in pom.xml to your liking

