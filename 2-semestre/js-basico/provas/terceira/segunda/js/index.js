function enviar() {
    const nome = document.getElementById("nome")
    const sobrenome = document.getElementById("sobrenome")
    const sexo = document.getElementById("sexo").value

    const nomeRegex = /^[A-Z][\wáéíóúãâêîôû]+$/
    const sobrenomeRegex = /^[A-Z][\wáéíóúãâêîôû]{2,19}( [A-Z][\wáéíóúãâêîôû]{2,19})?$/

    if (!nomeRegex.test(nome.value)) {
        alert("Nome Incorreto!!!")
        nome.focus()
    } else if (!sobrenomeRegex.test(sobrenome.value)) {
        alert("Sobrenome Incorreto!!!")
        sobrenome.focus()
    } else {
        localStorage.setItem("nome", nome.value)
        localStorage.setItem("sobrenome", sobrenome.value)
        window.open(sexo + ".html", "_self")
    }
}
