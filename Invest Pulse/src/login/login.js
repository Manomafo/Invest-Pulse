import axios from '../services/axios'

const eyediv = document.getElementById('eye');
const eyeElement = document.getElementById("visibility");
const eyeOffElement = document.getElementById("visibility-off");
let ispasswordViewEnable = false;

function togleVisibility() {
  if (ispasswordViewEnable) {
    eyeElement.style.display = "none";
    eyeOffElement.style.display = "inline";
    document.getElementById("password").setAttribute("type", "text");
    ispasswordViewEnable = false;
  } else {
    eyeElement.style.display = "inline";
    eyeOffElement.style.display = "none";
    document.getElementById("password").setAttribute("type", "password");
    ispasswordViewEnable = true;
  }
}

async function login() {

  let request = {};
    
  request.email = document.getElementById("email").value;
  request.password = document.getElementById("password").value;
  
  try{
  const response = await axios.post("/api/user/login", request);


  
  window.location.replace("http://localhost:5173/inicial.html")
  } catch( error ) { 

    if (error.response.status === 400) {
      Object.entries(response.data.errors).forEach(([_, value]) => {
        alert(value)
        return;
      })
    }

    if(error.response.status === 404) {
      alert("Email ou Senha incorretos")
      return;
    }

    alert("houve um erro")

  }
}

eyediv.addEventListener("click", togleVisibility);

document.getElementById("login-form").addEventListener("submit", function(event) {
  event.preventDefault();
  login();
})