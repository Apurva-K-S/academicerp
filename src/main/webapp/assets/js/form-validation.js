let employee_form = document.getElementById('employee-validation');
window.onload = fetch_department;

employee_form.addEventListener('submit', async (e) => {
  e.preventDefault();
  e.stopPropagation();
  if (employee_form.checkValidity() === true) {
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
  employee_form.classList.add('was-validated');
});

async function fetch_department(){
    let response = await fetch("api/departments/get");
    let departments = await response.json(); // read response body and parse as JSON
    console.log(departments);
    let dep_option = document.getElementById('departments');
    dep_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<departments.length ; i++){
        dep_option.innerHTML += '<option value="'+departments[i]+'">'+departments[i]+'</option>';
    }
}