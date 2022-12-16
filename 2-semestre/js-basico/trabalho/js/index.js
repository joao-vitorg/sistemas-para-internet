let user = sessionStorage.getItem("user")
if (!user) window.location.href = "login.html"

const iframe = document.getElementById("jogo")
const url = new URLSearchParams("user=" + user)

iframe.src = "https://joao-vitorg.github.io/tic-tac-toe?" + url.toString()
