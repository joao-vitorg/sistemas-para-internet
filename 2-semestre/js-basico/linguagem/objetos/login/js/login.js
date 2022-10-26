const element = (v) => document.getElementById(v)
const value = (v) => element(v).value

function login() {
    const user = value("usuario");
    const pwd = value("senha");

    if (!user) {
        alertWifi("Usuário em branco")
    } else if (!pwd) {
        alertWifi("Senha em branco")
    } else {
        readJSON(user, pwd)
    }
}

function readJSON(user, pwd) {
    fetch("users.json")
        .then((response) => response.json())
        .then((content) => checkUser(content, user, pwd))
        .catch((err) => console.log(err))
}

function checkUser(content, user, pwd) {
    const achou = content.users.find(v => v.user === user && v.pwd === pwd)

    if (achou) alertWifi("Usuario valido", false, 0, "img/toupeira.gif")
    else alertWifi("Usuario invalido!!!!!!",)
}
