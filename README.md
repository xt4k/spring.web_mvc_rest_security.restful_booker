# RESTFUL-BOOKER
## Web-Application project
### Done in frame self-qualification task to show and use knowledge taken from UDEMY training: 'Spring for beginners'.
<img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/6322f2d9-bd8f-4919-8585-e0448088e100" width="400" height="300">

## TABLE OF CONTENT

* [SPOTIFY](#spotify)
* [General info](#general-info)
* [Technology stack](#technology-stack)
* [Test Levels](#test-levels)
* [Typical API messages](#typical-api-messages)
* [Web UI autotest video](#web-ui-autotest-video)
* [Spotify mobile application autotests video](#spotify-mobile-application-autotests-video)
* [Last screenshot for live and emulated phones accordingly](#last-screenshot-for-live-and-emulated-phones-accordingly)
* [Spotify job screenshot](#spotify-job-screenshot)
* [Allure report in Jenkins](#allure-report-in-jenkins)
* [AllureTestOps screenshots](#alluretestops-screenshots)
* [Jira issue screenshot](#jira-issue-screenshot)
* [Mail screenshot](#mail-screenshot)
* [Chat message](#chat-message)

## General info

#### :arrow_forward: Web application run on Tomcat server version 10.1.9

## Such Spring features are used in project: 
### MVC - Model View Controller  application architecture
### Rest - to operate with API (free api - https://restful-booker.herokuapp.com )
### Security - to get different web-application behaviour according to user role. Used 3 different role GUEST, USER, ADMIN which binded to users: 'guest','user','admin' accordingly. User's password equal to their username for simplicity.
### GUEST - has only acces to read information about booking.
### USER - has additionally access to search by criteria and update bookings.
### ADMIN - has full access - may addionally create and delete bookings.
### AOP - created @Aspect method that reflect controlled method's start-end and duration.

## Technology stack

| GitHub | IDEA | Java | Spring | Gradle | Jakarta | SLF4J | Lombok | JSP |
|:-----:|:-----:|:----:|:------:|:------:|:--------:|:--------:|:------------:|:-------:|
|<img src="https://user-images.githubusercontent.com/38681283/120561870-048f0480-c40e-11eb-9ff8-c155f9d617c4.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/248457688-2df513b9-56c6-42df-96a5-27b3ccf0e00d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/248458847-7136dbda-f182-471f-9ee8-c8963e9cbd17.png" width="40" height="40"> | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/dd07cd20-5a95-4672-96a4-684a39440b24.png" width="80" height="40">  | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/e064428e-560c-4357-b2aa-2501a7d7da1b.png" width="40" height="40">  | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/7fcc4497-4f1c-449d-85fa-4ee1fd1531c3.png" width="40" height="40"> |

### Web-application screenshots:
### Initial Login screen (common for any role)
![image](https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/9a6ca2c8-438a-4cd5-9f3e-7490401bb8e3)

### Main page
| Role 'GUEST'| 'Role 'USER'| Role 'ADMIN'|
|:-------------:|:--------:|:------:|
| <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/0d0f2e2c-230c-4ffe-8258-141dc795db6a.png" width="300" height="300">  | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/2ac6fc5c-2121-409e-9f9b-c3b0f90797aa.png" width="300" height="300">  | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/c6eb74dd-1877-4685-807b-2847779e32f3.png" width="330" height="300"> |

### 'Booking Information' page
| Role 'GUEST'| 'Role 'USER'| Role 'ADMIN'|
|:-------------:|:--------:|:------:|
| <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/d8bc5bc7-7cf8-4e8d-a48c-a42bb9858f96.png" width="300" height="130"> | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/9836562b-b6e9-47df-9973-8492c2960864.png" width="300" height="130"> | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/2b03d39a-747c-4973-9552-89ac7c56a796.png" width="350" height="180"> |

### 'Booking Operation' page
| Role 'GUEST'| 'Role 'USER'| Role 'ADMIN'|
|:-------------:|:--------:|:------:|
| has no access to this page | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/92aa36ac-cbc0-4fa6-9a4f-4f9f0e80e987.png" width="400" height="300"> | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/918b0b34-eb67-4aff-a1e9-d37a4797719f.png" width="400" height="300"> |

### 'Booking Search' page
| Role 'GUEST'| 'Role 'USER' and 'ADMIN'|
|:-------------:|:--------:|
| user has no access to this page | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/04607bf1-e531-4260-892a-3d5bfa77b287.png" width="400" height="300"> |

### 'Booking Operation' page: Add new Booking
| Role 'GUEST' and 'Role 'USER'| 'ADMIN'|
|:-------------:|:--------:|
| has no access to this page | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/def38fef-2dcd-4ea5-ad12-b3f8ae6d7b80.png" width="400" height="380"> |


## Search result (from screenshot for 'Booking Search' page) for created booking (as shown on last screenshot):
| 'Role 'USER' and 'ADMIN'|
|:-------------:|
 | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/ba7f5f8c-32e6-46e6-ae13-9267a8a8c3d2.png" width="600" height="250"> |


## Booking Information for found one:
| 'Role 'USER' and 'ADMIN'|
|:-------------:|
 | <img src="https://github.com/xt4k/spring.web_mvc_rest_security.restful_booker/assets/38681283/28ac6f61-3903-4c5f-a255-15108fbc3b6c.png" width="600" height="250"> |











