1)Spring boot application:patients-pratice-service.

2)Database:internal h2,Table created when application is started and 
data in both Patient and Practice table interseted from data.sql file in resource.

3) Url: To get all patients list >http://localhost:8080/patient/getAllPatient
		To get all practice list >http://localhost:8080/practices/getAllPractice
		To get one patients by given id>http://localhost:8080/patient/getPatientById/{id}
		To get  patients List by given practice list>http://localhost:8080/patient/getPatientByPracticeId/{id}
		To delete patient by given id>http://localhost:8080/patient/deletePatient/{id}  (http delete)
		To add new update already present patient in list>http://localhost:8080/patient/updatePatients  (http put)
		To add new Patient already present patient in list>http://localhost:8080/patient/addPatients (http post)

4) Exceptions handling is used in this application - if patients or practice object is not found with given id then exception is thrown with given id ,details of exception and datatimestamp.

5) Followed TDD approach to write methods.Junit test cases are prepared in PatientDetailsApplicationTests class.

6) Used Sonar Analyze to found issues and code quality and fixed all major issues.

7) This project is developed in Intellj.You can open it in Intellj as maven project and run it.

8) JUnit test coverage screenshot attachted,Junit test cases for Controller and Service methods are created.



