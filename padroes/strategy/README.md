# Design Patterns e Anti-Patterns

Este repositório apresenta exemplos de **Design Patterns** e seus respectivos **Anti-Patterns**, destacando boas práticas e más práticas de implementação em sistemas orientados a objetos.

---

## 📌 Strategy

O **Strategy** é um padrão comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Ele separa o comportamento do contexto, facilitando a extensão e manutenção do código.

🔗 Referência: [Strategy - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/strategy?utm_source=chatgpt.com)

### Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Strategy Pattern)*  
- **Código**
  *(Espaço para imagem do código Strategy Pattern)*  

### Anti-Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Strategy Anti-Pattern)*  
- **Código**
  *(Espaço para imagem do código Strategy Anti-Pattern)*  

---

## 📌 Observer

O **Observer** é um padrão comportamental que define uma dependência um-para-muitos entre objetos, de forma que quando um objeto muda de estado, todos os seus dependentes são notificados automaticamente.

🔗 Referência: [Observer - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/observer)

### Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Observer Pattern)*  
- **Código**
  *(Espaço para imagem do código Observer Pattern)*  

### Anti-Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Observer Anti-Pattern)*  
- **Código**
  *(Espaço para imagem do código Observer Anti-Pattern)*  

---

## 📌 Composite

O **Composite** é um padrão estrutural que permite tratar objetos individuais e composições de objetos de maneira uniforme. Ele é útil para representar hierarquias de árvores, como menus ou estruturas de arquivos.

🔗 Referência: [Composite - Refactoring Guru](https://refactoring.guru/pt-br/design-patterns/composite)

### Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Composite Pattern)*  
- **Código**
  # 🍽️ Restaurante Composite (Pattern)

Exemplo de implementação do padrão **Composite** aplicado a um restaurante.

```java
import java.util.ArrayList;
import java.util.List;

// Interface comum para todos os componentes do menu
interface ItemMenu {
    void mostrarDescricao();
    double calcularPreco();
}

// Classe Leaf — representa pratos individuais
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

// Classe Leaf — representa bebidas
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

// Classe Composite — representa menus ou combos
class Menu implements ItemMenu {
    private String nome;
    private List<ItemMenu> itens = new ArrayList<>();

    public Menu(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public void removerItem(ItemMenu item) {
        itens.remove(item);
    }

    @Override
    public void mostrarDescricao() {
        System.out.println("Menu: " + nome);
        for (ItemMenu item : itens) {
            item.mostrarDescricao();
        }
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        for (ItemMenu item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }
}

// Classe principal para testar o padrão Composite
public class RestauranteComposite {
    public static void main(String[] args) {
        Prato pizza = new Prato("Pizza Margherita", 35.0);
        Bebida suco = new Bebida("Suco de Laranja", 8.0);

        Menu comboAlmoco = new Menu("Combo Almoço");
        comboAlmoco.adicionarItem(pizza);
        comboAlmoco.adicionarItem(suco);

        comboAlmoco.mostrarDescricao();
        System.out.println("Preço total: R$" + comboAlmoco.calcularPreco());
    }
}


### Anti-Pattern
- **Diagrama UML**
  *(Espaço para imagem UML do Composite Anti-Pattern)*  
- **Código**
 # ⚠️ Restaurante Anti‑Pattern (Composite mal implementado)

Este exemplo mostra uma implementação incorreta do padrão **Composite**, com lógica duplicada e acoplamento excessivo.

```java
// RestauranteAntiPattern.java
// Exemplo de Anti-Pattern: uma única classe genérica faz tudo

class ItemPedido {
    String nome;
    double preco;
    String tipo; // "Prato", "Bebida", "Menu"

    void mostrarDescricao() {
        System.out.println(tipo + ": " + nome + " - R$" + preco);
    }

    double calcularPreco() {
        return preco;
    }

    // Métodos que não fazem sentido para todos os tipos
    void adicionarItem(ItemPedido p) {
        System.out.println("Adicionando item (mesmo se não for menu)");
    }

    void removerItem(ItemPedido p) {
        System.out.println("Removendo item (mesmo se não for menu)");
    }
}

// Subclasses repetem atributos e lógica
class Prato extends ItemPedido {
    void fazerPedidoEspecial() {
        System.out.println("Pedido especial para prato.");
    }
}

class Bebida extends ItemPedido {
    void prepararBebida() {
        System.out.println("Preparando bebida.");
    }
}

class Menu extends ItemPedido {
    void montarCombo() {
        System.out.println("Montando combo.");
    }
}
 

---

## 🎯 Objetivo

- Demonstrar como aplicar corretamente os padrões de projeto.  
- Evidenciar más práticas (Anti-Patterns) que dificultam manutenção e extensibilidade.  
- Fornecer exemplos visuais (UML e código) para comparação entre **Pattern** e **Anti-Pattern**.
