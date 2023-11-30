## Air-traval - Programção de banco de dados III

### Desenvolver uma aplicação que através de um único ponto de acesso seja possível enviar uma requisição da criação de uma ordem de compra de passagens aéreas sendo que para cada destino da compra deve ser realizada uma requisição a um outro serviço onde verificará se no mesmo ainda tem a disponibilidade de assentos, bem como o preço atualizado do trecho. É possível que em uma mesma ordem tenham vários trechos, que serão consultados caso algum deles não tenha disponibilidade não deve ser possível realizar a compra.
### Deve ter um outro ponto de acesso que irá realizar a consulta dos preços das passagens, este processo é realizado buscando os trechos de varias companhias que podem estar cadastrada em um serviço de cadastro de companhias e trechos operados.

#### Devem ter os seguintes serviços:
- Ordem de Compra
- Preços de Passagens
- Companhias aéreas
- Preços por trechos
- Clientes