let player = window.sessionStorage.getItem("user")
if (!player) window.location.href = "login.html"

const element = (v) => document.getElementById(v)
const value = (v) => element(v).value

element("player").innerHTML = player

function play() {
    const player1 = value("player1")
    const player2 = value("player2")

    if (!player1) alertWifi("Jogador 1 em branco")
    else if (!player2) alertWifi("Jogador 2 em branco")
    else {
        sessionStorage.setItem("users", JSON.stringify([player1, player2]))
        window.location.href = "index.html"
    }
}
