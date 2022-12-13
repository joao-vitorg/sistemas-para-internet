let player = 0,
    players = ["mario", "luigi"],
    scores = [0, 0]

function clicks() {
    document.getElementById(players[player]).innerText = String(++scores[player])
}

function change(op) {
    player = op
    document.getElementById("player").src = `img/${players[player]}.gif`
}
