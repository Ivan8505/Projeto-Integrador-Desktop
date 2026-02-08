<div align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=28&duration=4000&pause=1000&color=4CAF50&center=true&vCenter=true&width=600&lines=Projeto+Integrador+Desktop;%7C+Java+Swing+%7C+Gerencial+Acad%C3%AAmico+%7C" alt="Typing SVG" />
</div>

<br />

# Projeto Integrador Desktop

Sistema desktop gerencial desenvolvido como projeto integrador acadêmico (2022-2023/2024).  
Um aplicativo simples para gerenciamento de [entidades — ex: produtos/estoque/clientes/vendas — ajuste conforme o real], com interface gráfica em Java Swing, persistência em banco de dados e operações CRUD básicas.

**Status atual**: Projeto funcional, mas com código legado e erros típicos de iniciante (ex: organização, segurança básica, acoplamento). Conceitos e melhorias estão sendo refatorados e aplicados no projeto [MedFlow-desktop-java](https://github.com/Ivan8505/MedFlow-desktop-java) (arquitetura em camadas, clean code, etc.).

### Tecnologias Utilizadas
- **Java** (JDK 8 ou superior — compatível com versões mais novas)
- **Swing** — para interface gráfica (JFrames, JTables, botões, forms)
- **Maven** — gerenciador de dependências e build (pom.xml)
- **JDBC** + MySQL (ou similar) — persistência via DAO
- **Arquitetura**: Tentativa inicial de MVC-ish (separação de telas, lógica e acesso a dados), mas ainda acoplada

### Funcionalidades Principais (no estado atual)
- Login básico de usuário
- Cadastro, listagem, edição e exclusão de itens/entidades (ex: produtos, clientes)
- Tabelas para visualização de dados
- Conexão com banco de dados local
- Telas modulares (JFrames separados por funcionalidade)

**Observações**:  
- Segurança: Versão original tinha credenciais hard-coded e SQL vulnerável — em refatoração futura.  
- UI: Swing clássico (não moderno como JavaFX).  
- Banco: Inclui script ou conexão antiga (adicionado em commit recente).

### Como Rodar o Projeto
1. **Pré-requisitos**:
   - Java JDK instalado (recomendado 11+)
   - Maven instalado (ou use wrapper se tiver mvnw)
   - MySQL rodando localmente (configure credenciais no código ou properties)

2. **Clone o repositório**:
   ```bash
   git clone https://github.com/Ivan8505/Projeto-Integrador-Desktop.git
   cd Projeto-Integrador-Desktop
   ```

3. **Build com Maven**:
   ```bash
   mvn clean install
   ```

4. **Execute**:
   - Via script (Linux/Mac):
     ```bash
     ./start.sh
     ```
   - Ou diretamente:
     ```bash
     mvn exec:java -Dexec.mainClass="seu.pacote.Main"  # ajuste o main class real
     ```

5. **Configuração do banco**:
   - Crie um database MySQL.
   - Ajuste URL, user e password nas classes de conexão (procure por JDBC strings no código).

### Estrutura do Projeto
```
Projeto-Integrador-Desktop/
├── src/
│   └── main/
│       └── java/
│           └── [pacotes]          # ex: model/, view/, controller/, dao/
├── pom.xml                        # Configuração Maven
├── start.sh                       # Script para rodar no Linux
├── target/                        # Artefatos de build (gerado)
└── README.md
```

<!-- ### Capturas de Tela (em breve)
Adicione prints aqui depois de rodar:
- Tela de login
- Dashboard principal
- Formulário de cadastro
- Tabela de listagem

![Login Screen](caminho/para/print-login.png)  
![Main Dashboard](caminho/para/print-dashboard.png)

*(Coloque imagens reais no repo via commit ou use links externos como Imgur para evitar peso.)*-->

### Por Que Refatorar?
Esse projeto foi meu primeiro grande app desktop em Java. Aprendi muito com os erros (legado, injeção SQL, acoplamento alto) e agora aplico lições aprendidas no MedFlow:  
- Camadas claras (DAO → Service → View)  
- OOP melhor (encapsulamento, interfaces)  
- Evitar hard-code  
- Testes básicos (futuro)

### Contato & Contribuição
Quer discutir Java Swing, refatoração de código legado, migração para JavaFX ou homelab?  
- LinkedIn: [ivan8505](https://www.linkedin.com/in/ivan8505)  
- Portfólio: [ivanrodrigues.dev](https://ivanrodrigues.dev)  
- Wiki técnica: [xwiki.ivanrodrigues.dev](https://xwiki.ivanrodrigues.dev)

Issues e PRs são bem-vindos — especialmente sugestões de melhorias!

Obrigado por visitar! 🚀  
Aprendizado real vem de quebrar e consertar.

---
Última atualização: Fevereiro 2026
