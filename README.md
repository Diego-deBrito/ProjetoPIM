## Índice
  <li><a href="#sobre">Sobre o projeto</a></li>
  <li><a href="package">Divisão de package</a></li>
  <li><a href="funcionalidades">Funcionalidades</a></li>
  <li><a href="tec">Tecnologias</li>
  <li><a hrfe="SQL"> ScriptSQL</a></li>  
  <li><a href="futura">Implementações Futuras</a></li>





<h2 id="sobre">Sobre</h2>

  Um sistema de serviços para auxiliar o cadastro de moradores e serviços de 
  reserva.
  

<h1 id="package"> Registro da divisão de packages do projeto.</h1>


![image](https://github.com/Diego-deBrito/ProjetoPIM/assets/104443845/107af7fe-54f3-4347-b8fd-9b501b353769)



<h2 id="SQL"> Registro das instruções SQL do projeto.</h2>
<a>Tabela Morador:</a>

    CREATE TABLE TB_MORADOR( id_morador bigint GENERATED BY DEFAULT AS IDENTITY  PRIMARY KEY,
                         cpf char(11) not null ,
                         NOME VARCHAR(255) not null ,
                         TELEFONE VARCHAR(255) not null ,
                         EMAIL VARCHAR (255)) not null;

<a>Tabela Apartamento: <a/>

    CREATE TABLE TB_APARTAMENTO(id_apartamento bigint primary key,
                            id_morador bigint,
                            FOREIGN KEY (id_morador) REFERENCES tb_morador (id_morador)
);


<a>Tabela Tipo de Reserva: <a/>
    
    
    CREATE TABLE tb_tipo_reserva( ID_TIPO_RESERVA  bigint GENERATED BY DEFAULT AS IDENTITY primary key,
                                NOME VARCHAR(255) NOT NULL
);

<a>Tabela Reserva: <a/>

    
    CREATE TABLE TB_RESERVA(id_reserva bigint GENERATED BY DEFAULT AS IDENTITY primary key,
                        id_apartamento bigint,
                        id_tipo_reserva bigint,
                        data_inicio timestamp,
                        data_fim timestamp,
                        status boolean,
                        FOREIGN KEY (id_apartamento) REFERENCES TB_APARTAMENTO (id_apartamento) ,
                        FOREIGN KEY (id_tipo_reserva) REFERENCES tb_tipo_reserva(id_tipo_reserva)
);



<a>Tabela Usuário: <a/>



    CREATE TABLE TB_USERS(
        id TEXT PRIMARY KEY UNIQUE NOT NULL ,
        login TEXT NOT NULL UNIQUE ,
        password TEXT NOT NULL ,
        role TEXT NOT NULL
);

<h2 id="metodos">Métodos de controlador </h2>

<a>Método de cadastro de morador em apartamento</a>

    @PostMapping("/addMoradorAoApartamento/{moradorId}/{apartamentoId}")
    public ResponseEntity <String> adicionarMoradorAoAp(@PathVariable Long moradorId, @PathVariable Long apartamentoId){
        return apartamentoService.adicionarMoradorAoAp(moradorId, apartamentoId);
    }

<a>Método para cadastrar reservas em tipo de reservas.</a>

    @PostMapping("/cadastrar")
    public ResponseEntity<TipoReservaEntity> cadastrar(@RequestBody TipoReservaEntity entity) {
        return ResponseEntity.ok(tipoReservaService.cadastrar(entity));
    }

<a>Método para cadastrar morador(ap) na reserva</a>


    @PostMapping("/cadastrar-reservaDTO")
    public ResponseEntity<ReservaEntity> cadastrarReservaDTO(@RequestBody ReservaDTO reserva) throws NaoEncontradoException, URISyntaxException {
        ReservaEntity novaReserva = reservaService.cadastrarReservaDTO(reserva);
        return ResponseEntity.created(new URI("/reserva/" + novaReserva.getId())).body(novaReserva);
    }









   
 
