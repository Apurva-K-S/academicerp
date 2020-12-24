let filter_form = document.getElementById('form-validation');
window.onload = fetch_options;

filter_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();

    let op1 = document.getElementById('options').value;
    let ch_option = document.getElementById('end_result');
    let table = document.getElementById('results_table');
    let table2 = document.getElementById('alumni_table');
    let p_alumni = document.getElementById("alumni_p");


    if(op1 === 'Organisation')
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
            ch_option.innerHTML = '<b> No Students placed in ' + op2 + ' yet </b>';
            let table = document.getElementById('results_table');
            table.innerHTML = '';
        }
        else{
            let placed2 = await response2.json(); // read response body and parse as JSON
            console.log(placed2);

            ch_option.innerHTML = '<b> Students placed in ' + op2 + ' are: </b> <br>';
            //for (let i = 0; i < placed2.length; i++) {
            //    ch_option.innerHTML += placed2[i][0] + '&emsp;' + placed2[i][1] + '&emsp;' + placed2[i][2] + '&emsp;' + placed2[i][3] + '<br>';
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
            cell4.innerHTML = "<b> Organisation Name </b>";
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
            p_alumni.innerHTML = '<b> No Alumni from ' + op2 + '</b>';
            table2.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(placed);

            p_alumni.innerHTML = '<b> Alumni from ' + op2 + ' are </b> <br> <br>';
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
            cell1.innerHTML = "<b> Alumni Name </b>";
            cell2.innerHTML = "<b> Alumni Email </b>";
            cell3.innerHTML = "<b> Joining Date </b>";
            cell4.innerHTML = "<b> Organisation Name </b>";

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
            ch_option.innerHTML = '<b> Students of ' + op2 + ' year are yet to be placed </b> <br> ';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = '<b> List of placed students from ' + op2 + ' year are: </b> <br> ';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '&emsp;'+ placed[i][3] + '<br>';
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
            cell4.innerHTML = "<b> Organisation </b>";

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
            ch_option.innerHTML = '<b> Students of ' + op2 + ' domain are yet to be placed </b> <br> ';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = '<b> List of placed students from ' + op2 + ' domain are: </b> <br> ';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '&emsp;'+ placed[i][3] + '<br>';
            //}
            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
            cell4.innerHTML = "<b> Organisation </b>";

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
            ch_option.innerHTML = '<b> Students of ' + op2 + ' specialisation are yet to be placed </b> <br> ';
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(response);

            ch_option.innerHTML = '<b> List of placed students from ' + op2 + ' specialisation are: </b> <br> ';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '<br>';
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
            cell4.innerHTML = "<b> Organisation </b>";

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

        let ch_option = document.getElementById('end_result');
        let table = document.getElementById('results_table');
        let table2 = document.getElementById('alumni_table');
        let p_alumni = document.getElementById("alumni_p");

        let response = await fetch("api/student/get_placed");
        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = '<b> Students are yet to be placed!! </b>';

            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let placed = await response.json(); // read response body and parse as JSON
            console.log(placed);

            ch_option.innerHTML = '<b> Placed Students List </b> <br>';
            //for (let i = 0; i < placed.length; i++) {
            //    ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;' + placed[i][2] + '<br>';
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            let cell4 = row.insertCell(3);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
            cell4.innerHTML = "<b> Organisation </b>";

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
        document.getElementById("for_button").style.display = "none";
    }
    else if(chosen === 'Not Placed')
    {
        document.getElementById("div-Organisation").style.display = "none";
        document.getElementById("div-Domain").style.display = "none";
        document.getElementById("div-Year").style.display = "none";
        document.getElementById("div-Specialisation").style.display = "none";


        let ch_option = document.getElementById('end_result');
        let table = document.getElementById('results_table');
        let table2 = document.getElementById('alumni_table');
        let p_alumni = document.getElementById("alumni_p");

        let response = await fetch("api/student/get_not_placed");
        if(response['status'] === 500)
        {
            console.log("No Data!!");
            ch_option.innerHTML = ' <b> All are placed :D </b>';
            let table = document.getElementById('results_table');
            table.innerHTML = '';
            table2.innerHTML = '';
            p_alumni.innerHTML = '';
        }
        else {
            let not_placed = await response.json(); // read response body and parse as JSON
            console.log(not_placed);

            ch_option.innerHTML = '<b> List of students who are yet to be placed are </b> <br>';
            //for (let i = 0; i < not_placed.length; i++) {
            //    ch_option.innerHTML += not_placed[i][0] + '&emsp;' + not_placed[i][1] + '&emsp;' + not_placed[i][2] + '<br>'
            //}

            table.innerHTML = '';
            let row = table.insertRow(0);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            let cell3 = row.insertCell(2);
            cell1.innerHTML = "<b> First Name </b>";
            cell2.innerHTML = "<b> Roll number </b>";
            cell3.innerHTML = "<b> Email </b>";
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
        document.getElementById("for_button").style.display = "none";
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

        document.getElementById("for_button").style.display = "block";
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

        document.getElementById("for_button").style.display = "block";
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

        document.getElementById("for_button").style.display = "block";
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

        document.getElementById("for_button").style.display = "block";
    }

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

    let opn2 = document.getElementById("end_result1");
    let response2 = await fetch("api/student/display_all");
    if(response2['status'] === 500)
    {
        console.log("No Data!!");
        opn2.innerHTML = 'No Students Data.';
    }
    else {
        let students = await response2.json(); // read response body and parse as JSON
        console.log(students);

        opn2.innerHTML = '<b> Students List</b> <br> <br>';

        let table1 = document.getElementById('results_table1');
        let row = table1.insertRow(0);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);
        let cell5 = row.insertCell(4);
        let cell6 = row.insertCell(5);
        cell1.innerHTML = "<b> Roll Number </b>"
        cell2.innerHTML = "<b> First Name </b>";
        cell3.innerHTML = "<b> Last Name </b> ";
        cell4.innerHTML = "<b> Email </b>";
        cell5.innerHTML = "<b> Specialisation </b>";
        cell6.innerHTML = "<b> Placement Id </b>";

        for (let i = 0; i < students.length; i++) {
            let row = table1.insertRow(i + 1);
            for (let j = 0; j <6; j++) {
                let cell = row.insertCell(j);
                cell.innerHTML = students[i][j];
            }
        }
    }
}
