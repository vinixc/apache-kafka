# Apache kafka Demo

[![Java Badge](https://img.shields.io/badge/-Java_14-green?style=for-the-badge&logo=Java&logoColor=black)](https://www.oracle.com/br/java/technologies/javase/jdk14-archive-downloads.html)
[![Apache-Kafka Badge](https://img.shields.io/badge/-Apache_Kafka_2.3.1-black?style=for-the-badge&logo=Apache-Kafka&logoColor=white)](https://kafka.apache.org/)

Projeto para estudo de mensageria utilizando apache kafka.


## Variaveis de Ambiente.
Variaveis de ambiente necessarias:

|  Variavel  	|           Conteudo          	|
|:----------:	|:---------------------------:	|
| JAVA_HOME  	| Diretorio da sua JDK        	|
| MAVEN_HOME 	| Diretorio do Apache Maven    	|
| Path       	| Adicionar JAVA_HOME\bin     	|
| Path       	| Adicionar MAVEN_HOME        	|


## Iniciando o Desenvolvimento
Para iniciar o desenvolvimento, e necessario clonar o projeto do GitHub num diretorio de sua preferencia:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/vinixc/apache-kafka.git
```

### Build do Projeto

No Build utilizamos o Maven como gerenciador e empacotador do projeto para distribuicao.

```shell
cd "diretorio do seu projeto"
mvn package
```

Seu jar sera gerado dentro da pasta target do projeto.
