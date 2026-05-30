# 🎨 Design Patterns e Anti-Patterns

Este repositório apresenta exemplos de **Design Patterns** e seus respectivos **Anti-Patterns**, destacando boas práticas e más práticas de implementação em sistemas orientados a objetos.

---

# 📌 Strategy

O **Strategy** é um padrão comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Ele separa o comportamento do contexto, facilitando a extensão e manutenção do código.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/strategy

## ✅ Pattern

### Diagrama UML
*(Espaço para imagem UML do Strategy Pattern)*

### Código

```java
// Interface Strategy
interface PagamentoStrategy {
    void pagar(double valor);
}

// Estratégias concretas
class CartaoCredito implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " no cartão.");
    }
}

class Pix implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " via PIX.");
    }
}

// Context
class Carrinho {
    private PagamentoStrategy estrategia;

    public void setEstrategia(PagamentoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void finalizarCompra(double valor) {
        estrategia.pagar(valor);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        carrinho.setEstrategia(new Pix());
        carrinho.finalizarCompra(100);

        carrinho.setEstrategia(new CartaoCredito());
        carrinho.finalizarCompra(200);
    }
}
```

## ❌ Anti-Pattern

### Diagrama UML
*(Espaço para imagem UML do Strategy Anti-Pattern)*

### Código

```java
class Carrinho {

    public void finalizarCompra(String tipoPagamento, double valor) {

        if(tipoPagamento.equals("PIX")) {
            System.out.println("Pagamento de R$" + valor + " via PIX");
        }

        else if(tipoPagamento.equals("CARTAO")) {
            System.out.println("Pagamento de R$" + valor + " no cartão");
        }

        else if(tipoPagamento.equals("BOLETO")) {
            System.out.println("Pagamento de R$" + valor + " via boleto");
        }
    }
}
```

### Problemas

- Uso excessivo de `if/else`.
- Violação do princípio Open/Closed.
- Necessário alterar a classe sempre que surgir uma nova forma de pagamento.
- Alto acoplamento.

---

# 📌 Observer

O **Observer** é um padrão comportamental que define uma dependência um-para-muitos entre objetos, de forma que quando um objeto muda de estado, todos os seus dependentes são notificados automaticamente.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/observer

## ✅ Pattern

### Diagrama UML
*(Espaço para imagem UML do Observer Pattern)*

### Código

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void atualizar(String noticia);
}

class Assinante implements Observer {

    private String nome;

    public Assinante(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String noticia) {
        System.out.println(nome + " recebeu: " + noticia);
    }
}

class Jornal {

    private List<Observer> assinantes = new ArrayList<>();

    public void adicionar(Observer observer) {
        assinantes.add(observer);
    }

    public void publicarNoticia(String noticia) {
        for(Observer observer : assinantes) {
            observer.atualizar(noticia);
        }
    }
}

public class ObserverPattern {

    public static void main(String[] args) {

        Jornal jornal = new Jornal();

        jornal.adicionar(new Assinante("João"));
        jornal.adicionar(new Assinante("Maria"));

        jornal.publicarNoticia("Nova edição disponível!");
    }
}
```

## ❌ Anti-Pattern

### Diagrama UML
*(Espaço para imagem UML do Observer Anti-Pattern)*

### Código

```java
class Jornal {

    private ClienteEmail cliente1;
    private ClienteEmail cliente2;

    public Jornal(ClienteEmail cliente1, ClienteEmail cliente2) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
    }

    public void publicarNoticia(String noticia) {

        cliente1.receberEmail(noticia);
        cliente2.receberEmail(noticia);
    }
}

class ClienteEmail {

    public void receberEmail(String noticia) {
        System.out.println("Recebeu: " + noticia);
    }
}
```

### Problemas

- Dependência direta dos destinatários.
- Difícil adicionar novos observadores.
- Alto acoplamento.
- Baixa escalabilidade.

---

# 📌 Composite

O **Composite** é um padrão estrutural que permite tratar objetos individuais e composições de objetos de maneira uniforme. Ele é útil para representar hierarquias de árvores, como menus ou estruturas de arquivos.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/composite

## ✅ Pattern

### Diagrama UML
*(Espaço para imagem UML do Composite Pattern)*

### Código

```java
import java.util.ArrayList;
import java.util.List;

interface ItemMenu {
    void mostrarDescricao();
    double calcularPreco();
}

class Prato implements ItemMenu {

    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Prato: " + nome + " - R$" + preco);
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}

class Bebida implements ItemMenu {

    private String nome;
    private double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Bebida: " + nome + " - R$" + preco);
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}

class Menu implements ItemMenu {

    private String nome;
    private List<ItemMenu> itens = new ArrayList<>();

    public Menu(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Menu: " + nome);

        for(ItemMenu item : itens) {
            item.mostrarDescricao();
        }
    }

    @Override
    public double calcularPreco() {
        double total = 0;

        for(ItemMenu item : itens) {
            total += item.calcularPreco();
        }

        return total;
    }
}
```

## ❌ Anti-Pattern

### Diagrama UML
*(Espaço para imagem UML do Composite Anti-Pattern)*

### Código

```java
class ItemPedido {

    String nome;
    double preco;
    String tipo;

    void mostrarDescricao() {
        System.out.println(tipo + ": " + nome);
    }

    void adicionarItem(ItemPedido item) {
        System.out.println("Adicionando item...");
    }

    void removerItem(ItemPedido item) {
        System.out.println("Removendo item...");
    }
}

class Prato extends ItemPedido {
}

class Bebida extends ItemPedido {
}

class Menu extends ItemPedido {
}
```

### Problemas

- Classe genérica faz tudo.
- Métodos sem sentido para alguns objetos.
- Lógica duplicada.
- Violação do princípio da responsabilidade única.
- Difícil manutenção e evolução do sistema.

---
