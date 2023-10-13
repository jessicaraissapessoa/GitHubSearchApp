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

![iconeAppPersonalizado](https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/c65746ef-15a5-4e9f-81a1-85b83c522d71)

<br>

### Tela do aplicativo em primeiro acesso

![telaAplicativoPrimeiroAcesso](https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/d860ee7d-6709-4a26-8500-8ee2b1f8baf1)

<br>

### Tela do aplicativo ao pesquisar um usuário

![telaAplicativoAoPesquisar](https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/953553d8-6e0e-4668-8646-b60f99a19c32)

<br>

### Demonstração de parte do método para compartilhar link de um repositório

![TelaAplicativoCompartilharRepositorio](https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/b052246b-4fa1-4970-b333-08f7214aa42f)

<br>

## Vídeos demonstrando aplicativo

<br>

https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/3ebefdd9-1193-46f9-ac1b-6fb2cb8a0afc

<br>

https://github.com/jessicaraissapessoa/GitHubSearchApp/assets/103599234/6b6c3619-76a7-4c5a-bd2b-bf3ec660b6e6

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





