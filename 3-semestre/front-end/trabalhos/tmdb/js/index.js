const catalogo = document.getElementById("catalogo")
const paginaNumero = document.getElementById("numero")
const URL_BASE = "https://www.themoviedb.org"
let paginaAtual = 1

const generos = {
    28: "Ação",
    12: "Aventura",
    16: "Animação",
    35: "Comédia",
    80: "Crime",
    99: "Documentário",
    18: "Drama",
    10751: "Família",
    14: "Fantasia",
    36: "História",
    27: "Terror",
    10402: "Música",
    9648: "Mistério",
    10749: "Romance",
    878: "Ficção científica",
    10770: "Cinema TV",
    53: "Thriller",
    10752: "Guerra",
    37: "Faroeste",
}

const buscarDados = (pagina) => {
    fetch("https://api.themoviedb.org/3/movie/popular?api_key=a6fd16b664e3540ab93625c391d38f7f&region=BR&language=pt-BR&page=" + pagina)
        .then((dado) => dado.json())
        .then((filmes) => {
            catalogo.innerHTML = ""
            filmes.results.forEach((filme) => carregarFilme(filme))
        })
}

const carregarFilme = (filme) => {
    catalogo.innerHTML += `
    <div class="filme">
        <a href="${URL_BASE}/movie/${filme.id}" target="_blank" >
            <img class="poster" src="${URL_BASE}/t/p/w300${filme.poster_path}" />
        </a>
        <div class="descricao">
            <span class="nota">
                <svg width="12" height="12" viewBox="0 0 24 24" fill="#f5c518">
                    <path d="M12 20.1l5.82 3.682c1.066.675 2.37-.322 2.09-1.584l-1.543-6.926 5.146-4.667c.94-.85.435-2.465-.799-2.567l-6.773-.602L13.29.89a1.38 1.38 0 0 0-2.581 0l-2.65 6.53-6.774.602C.052 8.126-.453 9.74.486 10.59l5.147 4.666-1.542 6.926c-.28 1.262 1.023 2.26 2.09 1.585L12 20.099z"></path>
                </svg>${filme.vote_average}
            </span>
            <a class="titulo" href="${URL_BASE}/movie/${filme.id}" target="_blank">${filme.title}</a>
            <span class="data">${filme.release_date}</span>
            <div class="categorias">
                ${filme.genre_ids.map((id) => `<a href="${URL_BASE}/genre/${id}" target="_blank">${generos[id]}</a>`).join("")}
            </div>
        </div>
    </div>`
}

const avancar = () => {
    paginaAtual++
    carregarPagina()
}

const voltar = () => {
    if (paginaAtual === 1) return
    paginaAtual--
    carregarPagina()
}

const inicio = () => {
    if (paginaAtual === 1) return
    paginaAtual = 1
    carregarPagina()
}

const carregarPagina = () => {
    paginaNumero.innerText = paginaAtual.toString()
    buscarDados(paginaAtual)
}

carregarPagina()
