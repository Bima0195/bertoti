    # 🎨 Design Patterns e Anti-Patterns

Este repositório apresenta exemplos de **Design Patterns** e seus respectivos **Anti-Patterns**, destacando boas práticas e más práticas de implementação em sistemas orientados a objetos.

---

# 📌 Strategy – Sistema de Empréstimos

O padrão **Strategy** permite encapsular diferentes algoritmos ou comportamentos em classes separadas, tornando-os intercambiáveis sem alterar o código do cliente.

Neste exemplo, cada tipo de cliente possui uma estratégia diferente para realizar empréstimos.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/strategy

---

## ✅ Pattern

### Diagrama UML

<img width="1588" height="568" alt="Strategy" src="https://github.com/user-attachments/assets/162ac3ee-6fee-4dba-a39d-e8288c15783d" />


### Descrição

A classe `Cliente` utiliza a interface `Emprestimo` para delegar o comportamento de empréstimo. Assim, novos tipos de empréstimo podem ser adicionados sem alterar a classe principal.

### Código

```java
public interface Emprestimo {
    String emprestimo();
}
```

```java
public class Cliente {

    private String nome;
    private Emprestimo emprestimo;

    public Cliente(String nome, Emprestimo emprestimo) {
        this.nome = nome;
        this.emprestimo = emprestimo;
    }

    public void emprestar() {
        System.out.println(emprestimo.emprestimo());
    }
}
```

```java
public class ClienteComum implements Emprestimo {

    @Override
    public String emprestimo() {
        return "Empréstimo com juros padrão";
    }
}
```

```java
public class Estudante implements Emprestimo {

    @Override
    public String emprestimo() {
        return "Empréstimo estudantil";
    }
}
```

```java
public class Empresa implements Emprestimo {

    @Override
    public String emprestimo() {
        return "Empréstimo empresarial";
    }
}
```

```java
public class Aposentado implements Emprestimo {

    @Override
    public String emprestimo() {
        return "Empréstimo consignado";
    }
}
```

### Vantagens

- Baixo acoplamento.
- Fácil manutenção.
- Segue Open/Closed Principle.
- Novas estratégias podem ser adicionadas sem alterar código existente.

---

## ❌ Anti-Pattern

### Diagrama UML

<img width="823" height="432" alt="Observer" src="https://github.com/user-attachments/assets/f00957b6-522f-4d3f-a191-dcafcb8910d9" />


### Descrição

Toda a lógica de empréstimo fica centralizada na classe Cliente através de condicionais.

### Código

```java
public class Cliente {

    private String nome;
    private String tipo;

    public Cliente(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void emprestimo() {

        if(tipo.equals("COMUM")) {
            System.out.println("Empréstimo comum");
        }

        else if(tipo.equals("ESTUDANTE")) {
            System.out.println("Empréstimo estudantil");
        }

        else if(tipo.equals("EMPRESA")) {
            System.out.println("Empréstimo empresarial");
        }

        else if(tipo.equals("APOSENTADO")) {
            System.out.println("Empréstimo consignado");
        }
    }
}
```

### Problemas

- Muitos if/else.
- Alto acoplamento.
- Difícil manutenção.
- Violação do princípio Open/Closed.

---

# 📌 Observer – Monitoramento de Preço de Produto

O padrão **Observer** permite que diversos objetos sejam notificados automaticamente quando ocorrer uma alteração em outro objeto.

Neste exemplo, clientes recebem notificações quando o preço de um produto é alterado.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/observer

---

## ✅ Pattern

### Diagrama UML

<img width="823" height="432" alt="Observer" src="https://github.com/user-attachments/assets/764e885e-e355-44ba-ae16-694f135c103f" />




### Descrição

O produto mantém uma lista de observadores e notifica todos quando o preço é alterado.

### Código

```java
public interface Observador {
    void update(double preco);
}
```

```java
public class Cliente implements Observador {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(double preco) {
        System.out.println(nome +
                " recebeu atualização de preço: R$ " + preco);
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private double preco;

    private List<Observador> observadores =
            new ArrayList<>();

    public void adicionarObservador(
            Observador observador) {

        observadores.add(observador);
    }

    public void setPreco(double preco) {

        this.preco = preco;

        notificarObservadores();
    }

    private void notificarObservadores() {

        for(Observador observador : observadores) {

            observador.update(preco);
        }
    }
}
```

### Vantagens

- Desacoplamento.
- Fácil expansão.
- Comunicação automática.
- Escalável.

---

## ❌ Anti-Pattern

### Diagrama UML

<img width="723" height="491" alt="AntiObserver" src="https://github.com/user-attachments/assets/25bb9430-4b0b-44de-97db-5d4d6e0e6df1" />


### Descrição

O produto possui referências diretas para cada cliente.

### Código

```java
public class Produto {

    private double preco;

    private Cliente1 cliente1;
    private Cliente2 cliente2;
    private Cliente3 cliente3;

    public void setPreco(double preco) {

        this.preco = preco;

        avisarClientes();
    }

    private void avisarClientes() {

        cliente1.update();
        cliente2.update();
        cliente3.update();
    }
}
```

### Problemas

- Dependência direta dos clientes.
- Pouca flexibilidade.
- Difícil adicionar novos observadores.
- Forte acoplamento.

---

# 📌 Composite – Restaurante

O padrão **Composite** permite tratar objetos individuais e grupos de objetos de maneira uniforme.

Neste exemplo, pratos, bebidas e menus podem ser manipulados através da mesma interface.

🔗 Referência: https://refactoring.guru/pt-br/design-patterns/composite

---

## ✅ Pattern

### Diagrama UML

<img width="891" height="606" alt="Composite" src="https://github.com/user-attachments/assets/e6d3f837-50ff-4203-a2d2-c7fbf5e9d064" />


### Descrição

Pratos e bebidas são objetos simples (Leaf). Menus e combos são objetos compostos (Composite).

### Código

```java
public interface Componente {

    String mostrarDescricao();

    double calcularPreco();
}
```

```java
public class Prato implements Componente {

    private String nome;
    private double preco;

    @Override
    public String mostrarDescricao() {
        return nome;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}
```

```java
public class Bebida implements Componente {

    private String nome;
    private double preco;

    @Override
    public String mostrarDescricao() {
        return nome;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Menu implements Componente {

    private List<Componente> itens =
            new ArrayList<>();

    public void adicionarItem(
            Componente componente) {

        itens.add(componente);
    }

    public void removerItem(
            Componente componente) {

        itens.remove(componente);
    }

    @Override
    public String mostrarDescricao() {

        String descricao = "";

        for(Componente item : itens) {

            descricao += item.mostrarDescricao()
                    + "\n";
        }

        return descricao;
    }

    @Override
    public double calcularPreco() {

        double total = 0;

        for(Componente item : itens) {

            total += item.calcularPreco();
        }

        return total;
    }
}
```

### Vantagens

- Tratamento uniforme.
- Fácil expansão.
- Baixo acoplamento.
- Estruturas hierárquicas organizadas.

---

## ❌ Anti-Pattern

### Diagrama UML

<img width="1117" height="606" alt="AntComposite" src="https://github.com/user-attachments/assets/bb82feae-a88c-485c-957b-5f50e0a42fa1" />


### Descrição

Uma única classe tenta representar pratos, bebidas e menus ao mesmo tempo.

### Código

```java
public class ItemPedido {

    private String nome;
    private double preco;
    private String tipo;

    public void adicionarItem(
            ItemPedido item) {

        System.out.println(
                "Adicionando item...");
    }

    public void removerItem(
            ItemPedido item) {

        System.out.println(
                "Removendo item...");
    }

    public void mostrarDescricao() {

        System.out.println(
                tipo + " - " + nome);
    }

    public double calcularPreco() {

        return preco;
    }
}
```

### Problemas

- Classe genérica faz tudo.
- Métodos sem sentido para alguns objetos.
- Alta complexidade.
- Violação do princípio da responsabilidade única.
- Difícil manutenção.
