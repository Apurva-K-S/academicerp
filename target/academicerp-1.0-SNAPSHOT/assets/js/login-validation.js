let login_form = document.getElementById('login-validation');
window.onload = fetch_department;

/*login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        let response = await fetch('api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                department: document.getElementById("departments").value,
            })
        });
        let result = await response;
        if(result["status"]===200){
            location.href = "dashboard.html";
        }else{
            document.getElementById("login-alert").style.display = "block";
        }
    }
});*/

login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                first_name: document.getElementById('first_name').value,
                email: document.getElementById('email').value,
                department: document.getElementById("departments").value,
            })
        });
        let result = await response;
        console.log(response);
        if(result['status'] === 200){
            let data = response.json();
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

           // sessionStorage.setItem('id', data["student_id"]);
            location.href = "dashboard.html";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});

async function fetch_department(){
    let response = await fetch("api/employee/get");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);
    let dep_option = document.getElementById('departments');
    dep_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<departments.length ; i++){
        dep_option.innerHTML += '<option value="'+departments[i]+'">'+departments[i]+'</option>';
    }

    //let response2 = await fetch("api/employee/add", {method: 'POST'}); -> remove this if u want to create tables and load data into files.
}