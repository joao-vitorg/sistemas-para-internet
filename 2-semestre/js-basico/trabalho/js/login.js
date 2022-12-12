const element = (v) => document.getElementById(v)
const value = (v) => element(v).value

function login() {
    const user = value("user")
    const pwd = value("pwd")

    if (!user) alertWifi("Usuário em branco")
    else if (!pwd) alertWifi("Senha em branco")
    else readJSON(user, pwd)
}

function readJSON(user, pwd) {
    fetch("https://sistemas-internet.000webhostapp.com/users.json")
        .then((response) => response.json())
        .then((content) => checkUser(content, user, pwd))
        .catch((err) => console.log(err))
}

function checkUser(content, user, pwd) {
    if (!content.find((v) => v.user === user && v.pwd === pwd)) {
        alertWifi("Usuario invalido!")
    } else {
        sessionStorage.setItem("user", user)
        window.location.href = "players.html"
    }
}
