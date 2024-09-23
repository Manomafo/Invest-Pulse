import axios from "../services/axios";

async function register() {
    let request = {};
    
    request.email = document.getElementById("email").value;
    request.phoneNumber = document.getElementById("phone-number").value;
    request.cpf = document.getElementById("cpf").value;
    request.fullName = document.getElementById("full-name").value;
    request.password = document.getElementById("password").value;

    
    if (request.email !== document.getElementById("email-confirm").value) {
        alert("confirmação do email esta errada");

    }

    if (request.password !== document.getElementById("password-confirm").value) {
        alert("confirmação da senha esta errada");

    }
    try {

        const response = await axios.post("/api/user", request);
        
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

    if(error.response.status === 409) {
      alert("Usuario ja existe com este E-mail ou numero de telefone")
      return;
    }

    alert("houve um erro")

  }
}

document.getElementById("register-form").addEventListener("submit", function(event) {
    event.preventDefault();
    register();
    
});