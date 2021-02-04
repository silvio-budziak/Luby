# 2 SQL

2.1 Crie uma query para remover todas as pessoas 'tabela_pessoa' que não possuem eventos 

'tabela_evento' relacionados.</li>

```
SELECT p.id,p.nome,subq.eventos FROM tabela_pessoa p
LEFT JOIN
    (SELECT e.pessoa_id,ARRAY_AGG(e.evento || ', ') AS eventos FROM tabela_evento e
    GROUP BY e.pessoa_id) AS subq
ON subq.pessoa_id = p.id;
```

2.2 Crie uma query para selecionar todas as pessoas 'tabela_pessoa' com sobrenome 'Doe'.</li>

  
```
SELECT ALL nome FROM tabela_pessoa WHERE nome LIKE '%Doe'
```

2.3 Crie uma query para adicionar um novo evento 'tabela_evento' e relacionar à pessoa 'Lisa 

Romero'.</li>

  
```
INSERT INTO tabela_evento (id,evento,pessoa_id)
SELECT '5', 'EVENTO E', id FROM tabela_pessoa WHERE nome = 'Lisa Romero' 
```


2.4 Crie uma query para atualizar 'Evento D' na 'tabela_evento' e relacionar à pessoa 'John 

Doe'.</li>

  
```
UPDATE tabela_evento SET pessoa_id = (
						 SELECT id 
  						 FROM tabela_pessoa
  						 WHERE nome LIKE 'John Doe'
) WHERE evento LIKE 'Evento D'
```
  

2.5 Crie uma query para remover o 'Evento B' na 'tabela_evento'.</li>

  
```
DELETE FROM tabela_evento where evento LIKE 'Evento B'
```  


2.6 Crie uma query para remover todas as pessoas 'tabela_pessoa' que não possuem eventos 

'tabela_evento' relacionados.</li>

  
```
DELETE FROM tabela_pessoa
WHERE id NOT IN
(SELECT pessoa_id 
FROM tabela_evento)
```  


2.7 Crie uma query para alterar a tabela 'tabela_pessoa' e adicionar a coluna 'idade' (int).</li>


```
ALTER TABLE tabela_pessoa 
ADD idade int
```  


2.8 Crie uma query para criar uma tabela chamada 'tabela_telefone' que pertence a uma 

pessoa...</li>


```
CREATE TABLE tabela_telefone (
              id INTEGER PRIMARY KEY,
              telefone VARCHAR(200),
              pessoa_id integer,
   FOREIGN KEY(pessoa_id) REFERENCES tabela_pessoa(id)
);
```


2.9 Crie uma query para criar uma índice do tipo único na coluna telefone da 

'tabela_telefone'.</li>


```
CREATE UNIQUE INDEX IF NOT EXISTS indice ON tabela_telefone (telefone)
```  


2.10  Crie uma query para remover a 'tabela_telefone'.</li>

```
DROP TABLE tabela_telefone
```  
