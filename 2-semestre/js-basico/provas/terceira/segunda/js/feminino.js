const nomeCompleto = localStorage.getItem("nome") + " " + localStorage.getItem("sobrenome")

document.getElementById("nome").value = nomeCompleto
document.getElementById("nomeP").innerText = nomeCompleto
