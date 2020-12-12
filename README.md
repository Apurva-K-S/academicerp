# academicerp

8.8. Placement History

Allow the employee of the outreach department to login and view the history of all placed/unplaced students. Give an interface to filter the details according to organisation, year, domain etc. On selection of a certain organisation show all placement history along with Alumni presently working there.

Here we need 5 tables:
1. Students:
      
      Has all the details of the students
      <br/>student_id
      <br/>roll_no: MT2020011
      <br/>first_name
      <br/>last_name
      <br/>email
      <br/>domain: MTCSE2020 etc.
      <br/>specialisation: AIML/NC/TSCD
      <br/>placement_id: null if not placed. Maps to placement_id in placement table. unique for each student.
      
2. Employees:
      
      Has employees details like first_name, last_name, email, department.
      <br/>employee_id: id of the employee.
      <br/>first_name
      <br/>last_name
      <br/>email
      <br/>title
      <br/>department
      
3. placement:

      Details of which company came for placement and      
      <br/>id: placement_id (unique id for each placed student). This is mapped to placement_id in students table.
      <br/>organisation: name of the organisation.
      <br/>profile: SDE/Data analyst etc.
      <br/>description: job description
      <br/>intake: number of student intake
      <br/>minimum_grade: grade requirement.
      
4. organisation:

      Details of the organisation.
      <br/>id: Organisation id. This is mapped to org_id in alumni_organisation table.
      <br/>name: Name of the organisation.
      <br/>address: Address of the organisation.
      
5. Alumni_Organisation:

      Details of Alumni, where they are working.
      <br/>id: alumni_organisation_id
      <br/>(Organisation) org_id: id of the organisation where alumni is working. mapped to id in organisation table.
      <br/>name: name of the alumni
      <br/>email: email of the alumni
      <br/>position: position of the alumni
      <br/>joining_date: date of joining
      <br/>leaving_date: date of leaving.


Features to implement:
1. Allow the employee of the outreach department to login
  
  Here in "employees" table we have first_name(not null), last_name, email(not null + unique), title, department fields. 
  <br/>So we will use first_name and email fields to login into the system.
  <br/>while logging in we will check if the department of the person is "outreach" or not. If not outreach we will display an error. Else proceed to next page.
  
  So here we need to access "employees" table.
  
2. After logging in we have to provide various filters and display results as per the filter.
    
    Various filters include:
    1. placed/not
    2. domain
    3. specialization
    4. Organisation
    5. Alumni
    
    1. placed/not:
       
       To display data as per this filter we have to use student table and placement table. We can combine them by "placement_id" field. 
       
       If filter is "on" means we want list of all placed students then we can do this from students table by using following query:
       
            select s.first_name, s.last_name, p.organisation 
            from student s, placement p 
            where s.placement_id is not null and p.placement_id == s.placement_id;
       
       This displays us student's name and organisation where student is placed and if we want we can add other fields also.
       
       If filter is "off" means we want list of all not placed students then we can do this from students table using following query:
       
            select * 
            from student 
            where placement_id is null;
             
   2. domain:
       
       we want to display students who are placed and belonging to particular domain. For this we use students table and placement table using following query:
       
            select s.first_name, s.last_name, p.organisation 
            from student s, placement p 
            where s.placement_id is not null and domain = 'MTCSE2020' and s.placement_id = p.placement_id;
       
       by this we will get first_name, last_name and organisation details of the students who are placed and belong to MTCSE2020 domain. We can add other details also if we want.
       
   3. Specialisation:
       
       we want to display students who are placed and belonging to particular domain. For this we use students table and placement table using following query:
       
            select s.first_name, s.last_name, p.organisation 
            from student s, placement p 
            where s.placement_id is not null and domain = 'AIML' and s.placement_id = p.placement_id;
       
       by this we will get first_name, last_name and organisation details of the students who are placed and belong to AIML domain. We can add other details also if we want.
       
   4. Organisation:
        
        to filter based on organisation:

        steps:
        1. take "id" from organization
        2. map to "organization" of placement
        3. for those rows take "id" -> map to "placement_id" of placement_student
        4. check if acceptance == "ACCEPT" then print it..

        organisation + placement + placement_student + student 

      
   5. Alumni:
   
        steps:
        1. take "id" from organization
        2. map to "organisation" of Alumni_organisation
        3. print details..
        
        Organisation + Alumni_Organisation.

       
       
