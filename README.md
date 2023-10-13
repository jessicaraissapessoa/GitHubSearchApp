# GitHubSearchApp

<br>

Repositório destinado ao meu desenvolvimento para o desafio de projeto proposto: "Criando um App Android para Compartilhar seu Portfólio de Projetos", do bootcamp Santander 2023, na trilha "Mobile Android com Kotlin"

<br>

## Tecnologias utilizadas

<br>

* **Linguagem:** Kotlin
- **IDE:** Android Studio
* **"API"**: https://api.github.com/

<br>

## O aplicativo

* Trata-se de uma aplicação por meio da qual você pode informar um usuário do Github e o aplicativo retorna uma lista de todos os repositórios desse
- Clicando no card de um repositório do usuário pesquisado, abre o mesmo no navegador
* Clicando no ícone de compartilhar, aparecem opções de compartilhamento do Android, enviando o link do repositório selecionado no meio selecionado

<br>

## Personalizações

<br>

Principais personalizações que fiz além do que foi proposto do desafio:

* Personalização do ícone do app
- Implementação e personalização de actionbar
* Personalização do tema do aplicativo
- Adoção e implementação de paleta de cores baseada no Github
* Efeito de clique no ícone de compartilhamento
- Implementação de um ProgressBar para o período de carregamento dos repositórios do usuário pesquisado
* Métodos shareRepositoryLink() e openBrowser() direto no Adapter
- Método para verificação de conexão com a internet
* Implementação de uma resposta (imagem e texto) para feedback de falta de conexão com a internet ao pesquisar
- Popup que avisa falha na pesquisa (usuário não encontrado)

<br>

## Screenshots demonstrando aplicativo

<br>

### Ícone personalizado do aplicativo

<img src="https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/6e2519b9-5422-44a3-bc34-3568cc89f4d9" width="300">

<br>
<br>

### Tela do aplicativo em primeiro acesso

<img src="https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/d0c2b90c-47f4-4937-b964-87a8ec0693a3" width="300">

<br>
<br>

### Tela do aplicativo ao pesquisar um usuário

<img src="https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/8e087faa-2ef2-4391-b50d-8921e32e8ce2" width="300">

<br>
<br>

### Demonstração de parte do método para compartilhar link de um repositório

<img src="https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/5e764f49-80a4-43fb-9b5c-fb53005e85d2" width="300">

<br>
<br>

## Vídeos demonstrando aplicativo

<br>

https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/70b47d36-af1a-4fd9-9b85-846a92a2665c

<br>

https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/df80a2bf-5812-4a73-b406-de644905de81

<br>

## Como usar um repositório

<br>

* Clique no botão Fork. Você criaá uma cópia desse repositório em seus repositórios do GitHub:
![fork](https://github.com/jessicaraissapessoa/desafio-projeto-meu-primeiro-app--dio-bootcamp-santander-dio-2023/assets/103599234/55d24bc1-3739-4711-b706-5c84d1d26fa6)

<br>

* No seu repositório remoto resultante do fork, clique em Code e copie o link da aba HTTPS:
![link_repositorio](https://github.com/jessicaraissapessoa/desafio-projeto-meu-primeiro-app--dio-bootcamp-santander-dio-2023/assets/103599234/099d753e-bb2f-4d46-b6a2-112255c3a302)

<br>

* Abra o Android Studio e clique em Get from VCS. Você puxará o repositório remoto para um repositório local:
![getfromvcs](https://github.com/jessicaraissapessoa/desafio-projeto-meu-primeiro-app--dio-bootcamp-santander-dio-2023/assets/103599234/7dbc0d9b-2774-4e4c-b12b-dcffce22624b)

<br>

* Você pode colar o link copiado no espaço URL ou se tiver seu GitHub conectado na IDE, ir na aba GitHub e selecionar o repositório remoto criado anteriormente. Depois disso, clique em Clone:
![criando_repositorio_local](https://github.com/jessicaraissapessoa/desafio-projeto-meu-primeiro-app--dio-bootcamp-santander-dio-2023/assets/103599234/cd110245-b7e1-4bb7-be4d-bb07e5639947)

<br>

* Agora divirta-se!
