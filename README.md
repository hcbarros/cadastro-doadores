# cadastro-doadores

Sistema implementado com Spring boot e Angular. Foi utilizado um arquivo .json com 300 objetos e aproximadamente 6000 linhas, representando doadores de sangue, 
doadores de sangue com algumas propriedades. O projeto Angular se encontra na branch "angular".

### baseURL: http://localhost:8080/doadores

GET/ candidatosPorEstado \
GET/ imcMedioPorFaixaEtaria \
GET/ percentualObesosPorSexo \
GET/ mediaIdadePorTipo \
GET/ doadoresPorTipoReceptor \
POST/ auth/signin \
POST/ auth/signup 

O servico do Spring boot tambem se encontra no seguinte endereco:

### https://spring-doadores.herokuapp.com/doadores

As seguinte consultas podem ser realizadas:

- Quantos candidatos temos nessa lista em cada estado do Brasil
- IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2)
- O percentual de obesos entre os homens e entre as mulheres (É obeso quem tem IMC > 30)
- A média de idade para cada tipo sanguíneo
- A quantidade de possíveis doadores para cada tipo sanguíneo receptor.

