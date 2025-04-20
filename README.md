# Engenharia de Software 💻 - Prof. Betoti 👨‍🏫

Bem-vindo ao meu repositório do curso de Tecnologia em Banco de Dados na FATEC SJC! 📚💻

Aqui, exploro conceitos de Engenharia de Software, compartilhando minhas impressões, estudos e exemplos práticos. Se você curte desenvolvimento e boas práticas, sinta-se à vontade para explorar e trocar ideias.

Bora mergulhar nesse universo? 🚀


# Atividade 01 - Resumo dos trechos do livro: Software Engineering at Google, Oreilly

What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And
why would Google have a unique perspective to add to the corpus of previous software engineering literature written over the past 50 years?
The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term
has a different emphasis and different implications. University students tend to study computer science and get jobs writing code as “programmers.”

“Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real
and precise. Mechanical engineers, civil engineers, aeronautical engineers, and those in other engineering disciplines all practice 
engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. 
Software engineers also create “something real,” though it is less tangible than the things other engineers create.

Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous.
Aeronautical engineers must follow rigid guidelines and practices, because errors in their calculations can cause real damage; programming,
on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt 
and rely on more rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices.

## Comentario.

Esse trecho do livro destaca a diferença entre "engenharia de software", "programação" e "ciência da computação", mostrando como o 
desenvolvimento de software exige um olhar mais rigoroso.  A ideia central é que, assim como em outras áreas da engenharia, é fundamental]]
adotar práticas mais estruturadas para criar sistemas mais confiáveis e sustentáveis. Com sua experiência acumulada ao longo dos anos, a Google pode trazer insights valiosos sobre como seguir esse caminho.


# Atividade 02 - Resumo dos trechos do livro: Software Engineering at Google, Oreilly

"Programming Over Time
We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers.
 
One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
 
The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:
 
Time and Change
How code will need to adapt over the length of its life
 
Scale and Growth
How an organization will need to adapt as it evolves
 
Trade-offs and Costs
How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth"

## Comentario

Esse trecho do livro traz uma visão ampla sobre engenharia de software, mostrando que vai muito além de simplesmente escrever código.
A ideia principal é refletir sobre como o tempo e as mudanças impactam o desenvolvimento de software, destacando a importância de adotar práticas que garantam um código sustentável e valioso a longo prazo. 
Com base em duas décadas de experiência da Google, o texto busca oferecer insights sobre como lidar com desafios como sustentabilidade e rigor na engenharia de software. 
Em resumo, ele reforça a necessidade de considerar não só o código em si, mas também a evolução da organização e os desafios envolvidos nas decisões do desenvolvimento de software.


# Atividade 03 - Tradeoff

-> Desempenho vs. Manutenibilidade
Um código altamente otimizado pode ser mais rápido, mas também mais difícil de entender e manter. Por outro lado, um código bem estruturado 
e legível pode ser mais fácil de manter, mas pode não ter o melhor desempenho. Tempo de Desenvolvimento vs. Qualidade

-> Tempo de Desenvolvimento vs. Qualidade
Lançar um software rapidamente pode ser essencial para ganhar vantagem no mercado, mas
pode resultar em mais bugs e necessidade de correções futuras. Por outro lado, investir mais
tempo no desenvolvimento pode melhorar a qualidade, mas atrasar o lançamento.

-> Segurança vs. Usabilidade
Medidas de segurança mais rígidas, como autenticação em múltiplos fatores, tornam um sistema
mais seguro, mas também podem dificultar a experiência do usuário. Se as barreiras forem
muito altas, os usuários podem optar por soluções menos seguras, mas mais convenientes.


# Atividade 04 - UML Unified Modeling Language (linguagem de modelagem visual)

A UML possui diversos diagramas que servem para representar artefatos de sistemas orientados a objetos.

o sinal de (+) representa um atributo, que por sua vez armazena um estado de objeto e define as informções que o objeto mantém.

o sinal de (-) representa um método, que são funções ou procedimento que definem seu comportamento.

![Diagrma UML](https://github.com/user-attachments/assets/f33ac5f9-81e2-4dfb-8c38-2d329973df7f)


# Atidade 05 Projeto Java com JUnit testes

// importação das bibliotecas utilizadas
import java.util.List;
import java.util.LinkedList;

// definição da classe da loja de carros
public class LojaCarros {
    // atributo da classe
    private List<Carro> carros = new LinkedList<Carro>();

    // métodos para acessar o atributo da classe por fora da classe
    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public List<Carro> getCarros() {
        return this.carros;
    }
}

// definição da classe do carro
public class Carro {
    // atributos da classe
    private String modelo;
    private String placa;

    // construtor da classe
    public Carro(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    // métodos para acessar os atributos da classe por fora da classe
    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }
}

// import das classes utilitárias
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

// definição da classe teste
class LojaCarrosTeste {
    @Test
    void testAdicionarDoisCarros() {
        LojaCarros lojaCarros = new LojaCarros();

        // instancia carros
        Carro carro1 = new Carro("Sedan", "ABC1234");
        Carro carro2 = new Carro("SUV", "XYZ5678");

        // adiciona os carros na loja
        lojaCarros.adicionarCarro(carro1);
        lojaCarros.adicionarCarro(carro2);

        // verifica se a loja tem os dois carros cadastrados
        assertEquals(lojaCarros.getCarros().size(), 2);
    }

    @Test
    void testTrazPrimeiroCarroDaLista() {
        LojaCarros lojaCarros = new LojaCarros();
        Carro carro1 = new Carro("Hatch", "AAA1111");
        Carro carro2 = new Carro("Pickup", "BBB2222");
        lojaCarros.adicionarCarro(carro1);
        lojaCarros.adicionarCarro(carro2);

        List<Carro> todosCarros = lojaCarros.getCarros();

        // verifica se o primeiro carro é o primeiro carro cadastrado
        assertEquals(todosCarros.get(0).getPlaca(), carro1.getPlaca());
    }

    @Test
    void testCarrosSaoDiferentes() {
        LojaCarros lojaCarros = new LojaCarros();
        Carro carro1 = new Carro("Conversível", "CCC3333");
        Carro carro2 = new Carro("Van", "DDD4444");
        lojaCarros.adicionarCarro(carro1);
        lojaCarros.adicionarCarro(carro2);
        List<Carro> todosCarros = lojaCarros.getCarros();

        // verifica se os dois carros são diferentes
        assertNotEquals(todosCarros.get(0).getModelo(), todosCarros.get(1).getModelo());
    }
}
