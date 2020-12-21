let filter_form = document.getElementById('form-validation');
window.onload = fetch_options;

filter_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  /*if (filer_form.checkValidity() === true) {
    let response = await fetch('api/departments/register', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify({
          first_name: document.getElementById('first_name').value,
          last_name: document.getElementById('last_name').value,
          email: document.getElementById('email').value,
      })
    });
    let result = await response;
    console.log(result);
  }
  employee_form.classList.add('was-validated');*/

    let op1 = document.getElementById('options').value;
    let ch_option = document.getElementById('end_result');
    let table = document.getElementById('results_table');
    let table2 = document.getElementById('alumni_table');
    let p_alumni = document.getElementById("alumni_p");

    if(op1 === 'Placed')
    {
        let response = await fetch("api/student/get_placed");

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = 'No placed students here!!';

            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(placed);

            ch_option.innerHTML = 'Placed Students List <br> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '<br>';
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            cell4.innerHTML = "Organisation";

            for(let i=0;i<placed.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed[i][j];
                }
            }

            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
    }
    else if(op1 === 'Not Placed')
    {
        let response = await fetch("api/student/get_not_placed");

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = 'No placed students here!!';
            let table = document.getElementById('results_table');
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let not_placed = await response.json(); // read response body and parse as JSON
            console.log(not_placed);

            //ch_option.innerHTML = 'Not Placed Students List <br> <br>';
            //for (let i = 0; i < not_placed.length; i++) {
            //    ch_option.innerHTML += not_placed[i][0] + '&emsp;' + not_placed[i][1] + '&emsp;' + not_placed[i][2] + '<br>'
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            for(let i=0;i<not_placed.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<3;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = not_placed[i][j];
                }
            }

            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
    }
    else if(op1 === 'Organisation')
    {

        let op2 = document.getElementById('org').value;
        // here organisations part will come.
        let response2 = await fetch("api/student/by_org", {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                name: op2,
            })
        });
        if(response2['status'] === 500)
        {
            console.log("current students empty!!");
            ch_option.innerHTML = 'Current Students are not yet placed in this organisation';
            let table = document.getElementById('results_table');
            table.innerHTML = '';
        }
        else{
            let placed2 = await response2.json(); // read response body and parse as JSON
            console.log(placed2);

            ch_option.innerHTML = 'Current Placed Students List <br> <br>';
            //for (let i = 0; i < placed2.length; i++) {
            //    ch_option.innerHTML += placed2[i][0] + '&emsp;' + placed2[i][1] + '&emsp;' + placed2[i][2] + '&emsp;' + placed2[i][3] + '<br>';
            //}

            let table = document.getElementById('results_table');
            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            cell4.innerHTML = "Organisation Name";
            for(let i=0;i<placed2.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed2[i][j];
                }
            }
        }

        // this is alumni part.
        let p_alumni = document.getElementById('alumni_p');
        let response = await fetch("api/almorg/get_alumni",{
        method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                name: op2,
            })
        });

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            p_alumni.innerHTML = 'No Alumni here!!';
            table2.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(placed);

            p_alumni.innerHTML = 'Alumni List <br> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '&emsp;' + placed[i][3] + '<br>';
            //}

            let table2 = document.getElementById('alumni_table');
            table2.innerHTML = '';
            let row = table2.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "Alumni Name";
            cell2.innerHTML = "Alumni Email";
            cell3.innerHTML = "Joining Date";
            cell4.innerHTML = "Organisation Name";
            for(let i=0;i<placed.length; i++)
            {
                let row = table2.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed[i][j];
                }
            }
        }
    }
    else if(op1 === 'Year')
    {
        op2 = document.getElementById('year').value;

        let response = await fetch("api/student/by_year",{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: op2
        });

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = 'No placed students from this year!!';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = 'Placed Students List <br> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '&emsp;'+ placed[i][3] + '<br>';
            //}

            let table = document.getElementById('results_table');
            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            cell4.innerHTML = "Organisation";

            for(let i=0;i<placed.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed[i][j];
                }
            }
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
    }
    else if(op1 === 'Domain')
    {
        op2 = document.getElementById('domain').value;

        let response = await fetch("api/student/by_domain",{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: op2
        });

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = 'No placed students from this domain!!';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = 'Placed Students List <br> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '&emsp;'+ placed[i][3] + '<br>';
            //}
            let table = document.getElementById('results_table');
            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            cell4.innerHTML = "Organisation";

            for(let i=0;i<placed.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed[i][j];
                }
            }

            let table2 = document.getElementById('alumni_table');
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
    }
    else //specialisation
    {
        op2 = document.getElementById('Specialisation').value;

        let response = await fetch("api/student/get_specialisation",{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                specialisation: op2,
            })
        });

        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = 'No placed students here!!';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = 'Placed Students List <br> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '<br>';
            //}

            let table = document.getElementById('results_table');
            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "First Name";
            cell2.innerHTML = "Roll number";
            cell3.innerHTML = "Email";
            cell4.innerHTML = "Organisation";

            for(let i=0;i<placed.length; i++)
            {
                let row = table.insertRow(i+1);
                for(let j=0;j<4;j++)
                {
                    let cell = row.insertCell(j);
                    cell.innerHTML = placed[i][j];
                }
            }

            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
    }
});

async function button_options(){

    let chosen = document.getElementById('options').value;

    if(chosen === 'Placed')
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "none";

    }
    else if(chosen === 'Not Placed')
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "none";
    }
    else if(chosen === "Organisation")
    {
        document.getElementById("div-Organisation").style.display = "block";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "none";

        let response = await fetch("api/org/get");
        let options = await response.json(); // read response body and parse as JSON
        console.log(options);
        let ch_option = document.getElementById('org');
        ch_option.innerHTML = '<option value=""> Choose...</option>';

        for(let i = 0 ; i<options.length ; i++){
            ch_option.innerHTML += '<option value="'+options[i]+'">'+options[i]+'</option>';
        }

    }
    else if(chosen === "Year")
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "block";
        document.getElementById("div-Specialisation").style.display = "none";

        let response = await fetch("api/student/year");
        let options = await response.json(); // read response body and parse as JSON
        console.log(options);
        let ch_option = document.getElementById('year');
        ch_option.innerHTML = '<option value=""> Choose...</option>';

        for(let i = 0 ; i<options.length ; i++){
            ch_option.innerHTML += '<option value="'+options[i]+'">'+options[i]+'</option>';
        }

    }
    else if(chosen === "Domain")
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "block";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "none";

        let response = await fetch("api/student/domain");
        let options = await response.json(); // read response body and parse as JSON
        console.log(options);
        let ch_option = document.getElementById('domain');
        ch_option.innerHTML = '<option value=""> Choose...</option>';

        for(let i = 0 ; i<options.length ; i++){
            ch_option.innerHTML += '<option value="'+options[i]+'">'+options[i]+'</option>';
        }

    }
    else
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "block";

        let response = await fetch("api/student/specialisation");
        let options = await response.json(); // read response body and parse as JSON
        console.log(options);
        let ch_option = document.getElementById('Specialisation');
        ch_option.innerHTML = '<option value=""> Choose...</option>';

        for(let i = 0 ; i<options.length ; i++){
            ch_option.innerHTML += '<option value="'+options[i]+'">'+options[i]+'</option>';
        }
    }
    document.getElementById("for_button").style.display = "block";
}

async function fetch_options(){
    let response = await fetch("api/employee/options");
    let options = await response.json(); // read response body and parse as JSON
    console.log(options);
    let ch_option = document.getElementById('options');
    ch_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<options.length ; i++){
        ch_option.innerHTML += '<option value="'+options[i]+'">'+options[i]+'</option>';
    }

    //----------------------------------------------------------------------------
    let ch_option2 = document.getElementById('end_result');
    let response2 = await fetch("api/student/display_all");

    if(response2['status'] === 500)
    {
        console.log("No Data!!");
        ch_option2.innerHTML = 'No Students Data.';
    }
    else {
        let students = await response2.json(); // read response body and parse as JSON
        console.log(students);

        ch_option2.innerHTML = 'Students List <br> <br>';
        //for (let i = 0; i < students.length; i++) {
        //    ch_option2.innerHTML += students[i][0] + '&emsp;' + students[i][1] + '&emsp;' + students[i][2] + '&emsp;' + students[i][3] + '&emsp;' + students[i][4] + '<br>';
        //}

        let table = document.getElementById('results_table');
        let row = table.insertRow(0);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);
        let cell5 = row.insertCell(4);
        cell1.innerHTML = "Roll Number"
        cell2.innerHTML = "First Name";
        cell3.innerHTML = "Last Name";
        cell4.innerHTML = "Email";
        cell5.innerHTML = "Placement Id";

        for(let i=0;i<students.length; i++)
        {
            let row = table.insertRow(i+1);
            for(let j=0;j<5;j++)
            {
                let cell = row.insertCell(j);
                cell.innerHTML = students[i][j];
            }
        }
    }
}

async function go_to_display_page(){

    let chosen = document.getElementById('options').value;

    if(chosen === "Organisation")
    {


    }
    else if(chosen === "Year")
    {


    }
    else if(chosen === "Domain")
    {


    }
    else
    {

    }
    document.getElementById("for_button").style.display = "block";
}