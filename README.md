# Spring AI - Padrões agentes

## Padrões Implementados

### 1. Fluxo de Trabalho da Cadeia

O padrão Chain Workflow exemplifica o princípio de dividir tarefas complexas em etapas mais simples e gerenciáveis.

**Quando usar:**
- Tarefas com etapas sequenciais claras
- Quando você deseja trocar latência por maior precisão
- Quando cada etapa se baseia na saída da etapa anterior

**Princípios-chave:**
- Cada etapa tem uma responsabilidade focada
- A saída de uma etapa se torna a entrada para a próxima
- A cadeia é facilmente extensível e de fácil manutenção

### 2. Fluxo de Trabalho de Paralelização

Os LLMs podem trabalhar simultaneamente em tarefas e ter suas saídas agregadas programaticamente.

**Variações:**
- **Seccionamento**: Dividir tarefas em subtarefas independentes para processamento paralelo
- **Votação**: Executar várias instâncias da mesma tarefa para consenso

**Quando usar:**
- Processamento de grandes volumes de itens semelhantes, mas independentes
- Tarefas que exigem múltiplas perspectivas independentes
- Quando o tempo de processamento é crítico e as tarefas são paralelizáveis

### 3. Fluxo de Trabalho de Roteamento

O padrão de roteamento implementa distribuição inteligente de tarefas, permitindo tratamento especializado para diferentes tipos de entrada.

**Quando usar:**
- Tarefas complexas com categorias distintas de entrada
- Quando diferentes entradas requerem processamento especializado
- Quando a classificação pode ser tratada com precisão

### 4. Orquestradores-Trabalhadores

Este padrão demonstra como implementar um comportamento mais complexo, semelhante ao de um agente, mantendo o controle.

**Componentes:**
- Um LLM central orquestra a decomposição de tarefas
- Trabalhadores especializados lidam com subtarefas específicas
- Limites claros mantêm a confiabilidade do sistema

**Quando usar:**
- Tarefas complexas onde as subtarefas não podem ser previstas antecipadamente
- Tarefas que exigem diferentes abordagens ou perspectivas
- Situações que exigem resolução adaptativa de problemas

### 5. Avaliador-Otimizador

O padrão Evaluator-Optimizer implementa um processo dual-LLM onde um modelo gera respostas enquanto outro fornece avaliação e feedback em um loop iterativo.

**Componentes:**
- **Gerador LLM**: Produz respostas iniciais e as refina com base no feedback
- **Avaliador LLM**: Analisa respostas e fornece feedback detalhado para melhorias

**Quando usar:**
- Existem critérios de avaliação claros
- O refinamento iterativo fornece valor mensurável
- As tarefas se beneficiam de múltiplas rodadas de crítica

## Como Começar
- mais detalhes:
```bash
git clone https://github.com/seu-usuario/spring-ai-agentic-patterns.git
