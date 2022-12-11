const element = (v) => document.getElementById(v)
const value = (v) => element(v).value

function cadastrar() {
    const user = value("user")
    const pwd = value("pwd")
    const confPwd = value("confPwd")

    if (!user) alertWifi("Preencha o campo usuário!")
    else if (!pwd) alertWifi("Preencha o campo senha!")
    else if (!confPwd) alertWifi("Preencha o campo confirmação de senha!")
    else if (pwd !== confPwd) alertWifi("As senhas não conferem!")
    else recordNewUser(user)
}

function recordNewUser(user) {
    fetch("json/users.json")
        .then((response) => response.json())
        .then((data) => checkUserCadastro(data, user))
        .catch((err) => console.log(err))
}

function checkUserCadastro(content, user) {
    if (content.find((usuario) => usuario.user === user)) alert("Usuário já cadastrado!")
    else document.getElementsByTagName("form")[0].submit()
}
