const element = (v) => document.getElementById(v)
const value = (v) => element(v).value

function play() {
    const player1 = value("player1")
    const player2 = value("player2")

    if (!player1) alertWifi("Jogador 1 em branco")
    else if (!player2) alertWifi("Jogador 2 em branco")
    else {
        localStorage.setItem("users", JSON.stringify([player1, player2]))
        window.location.href = "index.html"
    }
}
