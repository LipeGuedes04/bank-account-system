# 🏢 Sistema de Operações Bancárias - Conta Bancária Simples

## 🎯 O que o projeto faz?

O sistema simula o funcionamento básico de um caixa eletrônico para gerenciamento de uma conta bancária individual. O usuário insere o **nome do titular** e estipula um **saldo inicial**. Em seguida, a aplicação permite realizar uma operação de **depósito em conta** e uma operação de **saque com validação de saldo**. Caso o cliente tente sacar um valor maior do que possui em conta, o motor de regras bloqueia a transação e emite um alerta de saldo insuficiente, garantindo a integridade financeira da conta.

### 🔄 Fluxo da Aplicação
```text
[ Nome do Titular ] ➔ [ Saldo Inicial ] ➔ [ Operação de Depósito ] ➔ [ Validação de Saque ] ➔ [ Saldo Atualizado ]
```

---

## 🎨 Design do Código (Como as classes conversam)

Este projeto foi construído utilizando os pilares da **Programação Orientada a Objetos (POO)**, separando de forma clara a lógica de execução da interface de terminal das regras de domínio da entidade de negócios. Veja a estrutura limpa do design:

```text
       ┌────────────────────────┐
       │      main.java         │ (Classe Principal / Application Layer)
       └───────────┬────────────┘
                   │
                   ▼ (Instancia e manipula)
       ┌────────────────────────┐
       │   ContaBancaria.java   │ (Classe de Entidade / Domain Layer)
       └───────────┬────────────┘
                   │
         ┌─────────┴─────────┐
         ▼                   ▼
   [.depositar()]       [.sacar()]
   (Soma ao saldo)     (Valida se há saldo e subtrai)
```

### 📋 Mapeamento de Responsabilidades e Arquivos

| Classe / Arquivo | O que ela faz no código? |
| :--- | :--- |
| 🚀 `main.java` | É o cérebro da execução. Instancia a conta, gerencia a captura de dados via `Scanner` e imprime as respostas no console. |
| 👤 `ContaBancaria.java` | Entidade de domínio. Guarda o estado da conta (`titular`, `saldo`) e encapsula as regras de transação financeira. |
| 💸 `depositar(valor)` | Método que atualiza o saldo de forma cumulativa com o montante injetado. |
| 🔓 `sacar(valor)` | Método booleano que valida o saldo em tempo real, realizando o débito ou retornando falso se travar na barreira de crédito. |
| 📄 `toString()` | Sobrescrita nativa (`@Override`) que formata os dados da conta em uma linha estruturada e limpa. |

---

## 🧠 Conceitos de Programação Praticados

* **Programação Orientada a Objetos (POO):** Criação de classes e instanciação de objetos para representar elementos e comportamentos do mundo real em memória.
* **Encapsulamento de Métodos com Retorno Booleano:** O método de saque toma a decisão interna de validar a regra de negócio e retorna `true` ou `false` para sinalizar o status do fluxo à interface principal.
* **Sobrescrita de Métodos de Sistema (`@Override`):** Customização do método padrão `toString()` para renderizar as propriedades do objeto de forma amigável no console sem precisar de funções extras de impressão.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação de uma abertura de conta seguida de depósito e um saque com saldo insuficiente rodando direto no terminal:

```text
Insira o nome do Titular: 
Alex Green
Saldo inicial da Conta: 
1000.00
Quanto deseja depositar? 
500.00
Titular: Alex Green| Saldo Atual: R\$ 1500.00
Quanto deseja sacar?
2000.00
❌ Erro: Saldo insuficiente para realizar o saque!
Titular: Alex Green| Saldo Atual: R\$ 1500.00
```
