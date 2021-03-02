# yurets2000.github.io
KPI university frontend labs project. Project represents web-application of IT-shop. 

Short Description:
1. **Lab1:** <br>
   Basic project structure created, several pages created;
2. **Lab2:** <br>
   Project cleared from not used files, some new pages added. <br>
   Added possibility to run application on Docker through using Express.js. <br>
   To run application use these commands: <br>
    - docker pull yurets2000/e-shop <br>
    - docker run --name e-shop -p 8080:8080 -d yurets2000/e-shop <br>
   After this open localhost:8080 to see results.
2. **Lab3:** <br>
   Backend created on the base of Spring Boot Framework. <br>
   Frontend part was rewrote on Angular. <br>
   Application run on public GCP VM (http://35.228.94.134:4200). <br>
   To run application locally you need: <br>
   - Download Lab3/docker-compose.yml file and put it to some directory; <br>
   - Run docker-compose up <br>