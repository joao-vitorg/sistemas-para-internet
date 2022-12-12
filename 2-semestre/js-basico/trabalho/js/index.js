let users = JSON.parse(window.sessionStorage.getItem("users"))
if (!users || users.length !== 2) window.location.href = "login.html"

const iframe = document.getElementById("jogo")
const url = new URLSearchParams()

url.append("user", users[0])
url.append("user", users[1])

iframe.src = "https://joao-vitorg.github.io/tic-tac-toe?" + url.toString()
