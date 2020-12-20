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

    if(op1 === 'Placed')
    {
        let response = await fetch("api/student/get_placed");
        let placed = await response.json(); // read response body and parse as JSON
        console.log(placed);
        //let courses_option = document.getElementById('courses');
        //courses_option.innerHTML = '<option value=""> Choose...</option>';
        //ch_option.innerHTML = '<table style="width:100%"> <tbody>';
        ch_option.innerHTML = 'Placed Students List <br> <br>';
        for (let i = 0; i < placed.length; i++) {
            //ch_option.innerHTML += '<tr> <td>'+placed[i]['id'] +'</td> <td>'+placed[i]['roll_number'] +'</td> <td>'+placed[i]['first_name'] +'</td> <td>'+placed[i]['email'] +'</td></tr>';
            //ch_option.innerHTML += placed[i]['first_name'] + '&emsp;' + placed[i]['id'];
                //+ '&emsp;' +placed[i]['first_name'] + '&emsp;' + placed[i]['email'] + '<br>';

            //for(let j=0; j<placed[i].length; j++){
            ch_option.innerHTML += placed[i][0] + '&emsp;' + placed[i][1] + '&emsp;'+placed[i][2] + '<br>' ;
            //}

        }
       // ch_option.innerHTML += '</tbody> </table>';

    }
    else if(op1 === 'Not Placed')
    {

    }
    else if(op1 === 'Organisation')
    {
        op2 = document.getElementById('org').value;
    }
    else if(op1 === 'Year')
    {
        op2 = document.getElementById('year').value;
    }
    else if(op1 === 'Domain')
    {
        op2 = document.getElementById('domain').value;
    }
    else
    {
        op2 = document.getElementById('Specialisation').value;
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

    /*let response2 = await fetch('api/student/displayall');

    let result = await response2;
    console.log(response2);
    let placeholder = document.getElementById("all");

    placeholder.innerHTML += '<br>';

    if(result['status'] === 200)
    {
        let data = response2.json();
        console.log(data);
        placeholder.innerHTML += data['id'] + '<br>' + data['first_name'] + '<br>';
    }
    else
    {
        placeholder.innerHTML += 'No students to display';
    }*/

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