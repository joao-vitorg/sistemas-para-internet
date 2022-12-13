const setText = (id, txt) => (document.getElementById(id).innerText = txt)

function info() {
    const txt = document.getElementById("txt").value
    if (!txt) {
        alert("Caixa vazia!!")
        return
    }

    const txtSplit = txt.split(" ")
    document.getElementById("info").style.display = "block"

    setText("quantidadeCaracteres", txt.length)
    setText("primeiro", txtSplit[0])
    setText("ultimo", txtSplit[txtSplit.length - 1])
    setText("quantidadePalavras", txtSplit.length)
}
