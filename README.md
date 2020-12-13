# academicerp

8.8. Placement History

Allow the employee of the outreach department to login and view the history of all placed/unplaced students. Give an interface to filter the details according to organisation, year, domain etc. On selection of a certain organisation show all placement history along with Alumni presently working there.

Here we need 6 tables:
1. Students
2. Employees
3. placement
4. organisation
5. Alumni_Organisation
6. placement_student

Features to implement:
1. Allow the employee of the outreach department to login
  
2. After logging in we have to provide various filters and display results as per the filter.
    
    Various filters include:
    1. placed/not
    2. domain
    3. specialization
    4. Organisation
    5. Alumni
       
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

       
       
