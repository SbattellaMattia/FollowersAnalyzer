<a name="start"></a>
<p align="center">
<img src="https://github.com/SbattellaMattia/SaraSumcutean-ProgettoEsame/blob/master/graphics/FollowersAnalyzerLogo.jpg">
</p>

<h1 align="center"> FollowersAnalyzer </h1>
 
<p align="center">
L'applicazione FollowersAnalyzer permette di eseguire una serie di richieste riguardanti i followers Twitter.
</p>

***

## :white_small_square: **Indice dei contenuti**

* [Introduzione](#intro)
* [Il Progetto](#project)
  * [Installazione](#install)
  * [Rotte](#rotte)
    * [Rotte di base](#primarie)
    * [Filtri](#filters)
    * [Statistiche sui followers](#stats)
  * [Specifiche](#info)
  * [Test](#test)
  * [Eccezioni](#ecc)
* [Documentazione e altre note](#documentation)
* [Struttura del progetto](#strucure)
* [FrameWork e Software](#software)
* [Autori](#authors)

***


<a name="intro"></a>
## :white_small_square: Introduzione <div align="right"> [:arrow_up_small:](#start) </div> 


<div align="center">
Il programma FollowersAnalyzer offre varie possibilità per chiunque fosse interessato a fare ricerca su Twitter e i suoi utenti.
Possono essere eseguite ricerche base di utenti e tweet specifici, filtrare i followers secondo vari parametri o fare statistiche sull'attività dei nostri followers sul nostro profilo.
</div>


***


<a name="project"></a>
## <h2 align="center"> Il progetto </h2> 


<a name="install"></a>
## :white_small_square: Installazione <div align="right"> [:arrow_up_small:](#start) </div>

E' possibile installare il programma nel seguente modo:

•	Dal Prompt dei Comandi, aperto nella cartella che diventerà il repository locale, è possibile clonare il repository remoto da GitHub digitando:
  ```
  $ git clone https:///github.com/SbattellaMattia/SaraSumcutean-ProgettoEsame
  ```
•	E' poi necessario importare il progetto nell'ambiente di sviluppo (Eclipse nel nostro caso):
  ```
  File -> Import -> Existing Maven Projects
  ```
• Il codice deve essere eseguito come Spring Boot App

A questo punto l'applicazione è pronta e in ascolto all'indirizzo http://localhost:8080 dove si potranno fare le [richieste](#rotte). 

Per eseguire le richieste potrebbe essere utile utilizzare [Postman](https://www.postman.com/), un tool che permette di costruire, testare e documentare le API (Application Programming Interface). Le API sono un set di definizioni che consentono al programma di comunicare con altri prodotti o servizi, per agevolare la programmazione ed evitare la ripetizione e ridondanza di codice. In questo progetto è stata utilizzata l'ultima versione delle Twitter API: la v2.

Postman permette di eseguire qualsiasi tipo di richiesta verso un server e ottenere in risposta le informazioni di cui si necessita.
  
***


<a name="rotte"></a>
## :white_small_square: Rotte <div align="right"> [:arrow_up_small:](#start) </div>

Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo
```
localhost:8080
```
e dovranno essere del tipo:
```
localhost:8080 <ROTTA> <PARAMETRO>
```

 
**_Le rotte definite sono le seguenti:_**

**(Ove possibile, cliccare sulla seguente immagine per maggiori informazioni generali)** :information_source: 

**(E sul numero della rotta per informazioni specifiche)**

***

<a name="primarie"></a>
## :white_small_square: Rotte di base <div align="right"> [:arrow_up_small:](#start) </div>
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | -- 
**1.**|GET|```/UserById/```|id utente|*Passato come parametro un id utente, la rotta restituisce i suoi dati.*
**2.**|GET|```/UserByUsername/```|username utente|*Dato l'username di un utente, la rotta restituisce i suoi dati.*
<a name="3.0">**[3.](#3)**|GET|```/Followers/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi followers. [:information_source:](#info)*
<a name="4.0">**[4.](#4)**|GET|```/Following/```|id utente|*Passato come parametro un id utente, la rotta ne restituisce l'elenco dei seguiti. [:information_source:](#info)*
**5.**|GET|```/TweetById/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce i suoi dati.*
**6.**|GET|```/User/Tweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi tweet.*
**7.**|GET|```/User/LikedTweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco di tweet ai quali ha messo like.*
<a name="8.0">**[8.](#8)**|GET|```/Tweet/Retweeted_by/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce la lista degli utenti che lo hanno ritwittato. [:information_source:](#info)*
<a name="9.0">**[9.](#9)**|GET|```/Tweet/LikingUsers/```|id utente|*Passato come parametro un id tweet, la rotta restituisce gli utenti che hanno messo like al tweet. [:information_source:](#info)*

<a name="filters"></a>
## :white_small_square: Filtri <div align="right"> [:arrow_up_small:](#start) </div>
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | --
<a name="10.0">**[10.](#10)**|GET|```/Filter/FollowersByCreation/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati per data di creazione dell'account. [:information_source:](#info)*
<a name="11.0">**[11.](#11)**|GET|```/Filter/FollowingByCreation/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco degli (utenti) seguiti filtrati per data di creazione dell'account. [:information_source:](#info)*
<a name="12.0">**[12.](#12)**|GET|```/Filter/VerifiedFollowers/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati secondo il verificato del loro profilo. [:information_source:](#info)*
**13.**|GET|```/Filter/Refollowers/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco degli utenti che ricambiano il follow.*

***

<a name="stats"></a> 
## :white_small_square: Statistiche sui Followers <div align="right"> [:arrow_up_small:](#start) </div>
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | --
**14.**|GET|```/FollowersStats/Media/```|id utente|*Passato come parametro un id utente, la rotta restituisce la media del numero di followers dei suoi followers.*
**15.**|GET|```/FollowersStats/Varianza/```|id utente|*Passato come parametro un id utente, la rotta restituisce la varianza del numero di followers dei suoi followers.*
<a name="16.0">**[16.](#16)**|GET|```/FollowersStats/Range/```|id utente|*Passato come parametro un id utente, la rotta restituisce la sudivisione in range per numero di followers, dei followers dell'utente. [:information_source:](#info)*
<a name="17.0">**[17.](#17)**|GET|```/FollowersStats/Activity/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'ordine degli utenti più attivi sul suo profilo sulla base del numero di like. (la lista degli utenti e la loro attività sul profilo) [:information_source:](#info)*

***


<a name="info"></a>
## :white_small_square: Specifiche <div align="right"> [:arrow_up_small:](#start) </div>
E' necessario specificare che alcune rotte possono includere un parametro aggiuntivo per modificare i risultati di filtri e statistiche aggiungendo alla richiesta:
```
? <PARAMETRO 1> = <OPZIONE> & <(eventuale) PARAMETRO 2> = <OPZIONE>
```
Se non verrà inserito nulla, la rotta sarà eseguita con un defaul value (in descrizione in tabella) preimpostato e restituirà il risultato descritto [qui](#rotte).

Tutte le varie possibilità sono in descrizione nella seguente tabella:
ROTTA | "?" | PARAMETRI | "=" | OPZIONI | VALORE DI DEFAULT | DESCRIZIONE
-- | -- | -- | -- | -- | -- | --
<a name="3">[3.](#3.0)</a>|```?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Nel caso venga inserito l'username, la rotta restituirà i paramentri dell'utente ricercato fra tutti i followers; se non trovato verrà mostrato un messaggio di errore.
<a name="4">[4.](#4.0)</a>|```?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Nel caso venga inserito l'username, la rotta restituirà l'utente seguito con il nome inseito; se non trovato, verrà mostrato un messaggio di errore.
<a name="8">[8.](#8.0)</a>|```?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Nel caso venga inserito l'username e l'utente viene trovato tra coloro che hanno ritwittato, la rotta ne restituirà i suoi dati.
<a name="9">[9.](#9.0)</a>|```?```|"method"| ```=``` | ```followers``` |  ```all``` | Se inserita l'opzione ```followers```, la rotta restituirà esclusivamente i followers dell'utente che hanno messo like al tweet.
<a name="10">[10.](#10.0)</a>|```?```|"StartDate",  "EndDate"| ```=``` | Data di inizio e di fine della ricerca | ```all```, ```all``` | Possono essere inseriti a discrezione dell'utente uno o entrambi i valori, a seconda dei quali verranno restituiti i followers filtrati nell'arco temporale scelto. La data di inzio se non inserita è settata al giorno di fondazione di Twitter. E' necessario specificare che il formato della data deve essere del tipo "**dd/MM/yyyy**".|
<a name="11">[11.](#11.0)</a>|```?```|"StartDate", "EndDate"| ```=``` | Data di inizio e di fine della ricerca | ```all```, ```all``` | Possono essere inseriti a discrezione dell'utente uno o entrambi i valori, a seconda dei quali verranno restituiti gli utenti seguiti filtrati nell'arco temporale scelto. La data di inzio se non inserita è settata al giorno di fondazione di Twitter. E' necessario specificare che il formato della data deve essere del tipo "**dd/MM/yyyy**".|
<a name="12">[12.](#12.0)</a>|```?```|"method"| ```=``` | ```verified```,  ```not_verified``` | ```all```| Nel caso venga inserita l'opzione ```verified```, la rotta restituirà i followers che hanno il profilo verificato; nel caso di inserimento dell'opzione ```not_ verified```, la rottà restituirà i followers che hanno il profilo non verificato. L'opzione di base ```all```, restituisce entrambe le liste.|
<a name="16">[16.](#16.0)</a>|```?```|"method"| ```=``` | ```%``` |```number```| Nel caso venga inserita l'opzione ```number```, la rotta restituirà i followers dell'utente in considerazione, divisi per range in base al numero di loro followers; nel caso di inserimento dell'opzione ```%```, la rottà ne restituirà la suddivisione per range di percentuale. |
<a name="17">[17.](#17.0)</a>|```?```|"method"| ```=``` | ```followers``` | ```all``` | Nel caso venga inseria l'opzione ```followers```, la rotta restituirà l'elenco dei followers più attivi sul profilo dell'utente in considerazione. |

***


<a name="test"></a>
## :white_small_square: Test <div align="right"> [:arrow_up_small:](#start) </div>

Nel programma è presente una sezione di testing per verificare il corretto funzionamento di alcuni metodi ed eccezioni. 

I test che è possibile possibile eseguire sono i seguenti:

N° | TIPO | NOME 
-- | -- | -- 
**1.**|Filters Test|```FilterByCreationTest```
**2.**|Filters Test|```FilterByFollowersTest```
**3.**|Filters Test|```FilterByUsernameTest```
**4.**|Json Test|```TestJsonArray```
**5.**|Json Test|```TestJsonObj```
**6.**|Json Test|```TestJsonToUser```
**7.**|Json Test|```TestJsonToUserArray```
**8.**|Model Test|```UserTest```
**9.**|Stats Test|```TestFollowersRange```
**10.**|Stats Test|```TestVariation_Average```
**11.**|Utils Test|```TestCounter```

***


<a name="ecc"></a>
## :white_small_square: Eccezioni <div align="right"> [:arrow_up_small:](#start) </div>

Nel caso il programma incorra in problemi quali l'inserimento inesatto di qualche parametro, il formato errato di una data o la restituizione di un risultato inesistente, esso restituirà dei messaggi di errore dedicati.

Le eccezioni sono implementate in modo che restituiscano un messaggio di base ed eventualmente uno aggiuntivo a discrezione del programmatore.

Di seguito, le eccezioni nelle quali si può incorrere:

```ConnectionException``` un'eccezione che viene lanciata quando si incorre in un problema di connessione con il server.

```DateException``` un'eccezione che viene lanciata quando il formato della data inserita non è conforme o si inserisce una data inesistente.

```NullDataException``` un'eccezione che viene lanciata quando non viene trovato nessun risultato alla richiesta.

```WrongParameterException``` un'eccezione che viene lanciata quando un parametro inserito è errato o inesistente.

!!! Importante: E' necessario che il valore immesso come id, sia un Long, l'eccezione per l'inserimento di un valore diverso, non è gestita.

***


<a name="documentation"></a>
## :white_small_square: Documentazione e altre note <div align="right"> [:arrow_up_small:](#start) </div>
Il progetto è interamente documentato in Javadoc, un applicativo utilizzato per la generazione automatica della documentazione del codice.

Ai fini del progetto, è stato utile creare due profili Twitter utilizzabili per fare richieste. Vengono lasciati i dati in descrizione. 
* [Sbattella Mattia](https://twitter.com/DarioSecond) con rispettivo id utente: 1467146412009967620.
* [Sumcutean Sara](https://twitter.com/Sara35793654) con rispettivo id utente: 1473955877635997696.

Tramite questi profili didattici sono stati creati dei tweet di prova, messi dei like e sono stati fatti dei retweet. Vengono lasciati gli id relativi ai tweet postati.
* 1478658975444963330
* 1480151930668208135


E' stata resa visibile l'avvenuta comprenzione del concetto di ereditarietà attraverso l'estensione delle classi  ```User``` e ```Tweet``` da una classe ```Super``` contentente solo un id: componente basilare. Molto visibile questo concetto anche nella classe ```Service```, dalla quale molte classi ereditano, che instaura il collegamento con il server e setta il bearer Token (necessario affinchè

E' stato scelto di inserire un id di tipo Long perchè è il tipo più utilizzato per rappresentarlo.

***


<a name="structure"></a>
## :white_small_square: Struttura del progetto <div align="right"> [:arrow_up_small:](#start) </div>



```
    FollowersAnalyzer
    ├── README.md
    ├── src
    │   ├── main
    │   |   ├── java
    |   |   |   └── it
    |   |   |       └── Twitter
    |   |   |           └── FollowersAnalyzer
    │   |   |               ├── Controller
    │   |   |               |   └── Controller.java
    │   |   |               ├── Exceptions
    |   │   |               |   ├── ConnectionException.java
    |   │   |               |   ├── DateException.java
    |   │   |               |   ├── NullDataException.java
    |   │   |               |   └── WrongParameter.java
    │   |   |               ├── Filter
    │   |   |               |   ├── Filter.java
    │   |   |               |   ├── FilterByCreation.java
    │   |   |               |   ├── FilterByFollowers.java
    │   |   |               |   ├── FilterByRefollowers.java
    │   |   |               |   ├── FilterByUsername.java
    │   |   |               |   └── FilterByVerified.java
    │   |   |               ├── JsonComponent
    │   |   |               |   ├── JsonToTweet.java
    │   |   |               |   ├── JsonToUser.java
    │   |   |               |   └── StringToJson.java
    │   |   |               ├── Model
    │   |   |               |   ├── Super.java
    │   |   |               |   ├── Tweet.java
    │   |   |               |   └── User.java
    │   |   |               ├── Service
    │   |   |               |   ├── Service.java
    │   |   |               |   ├── ServiceFollowers.java
    │   |   |               |   ├── ServiceFollowing.java
    │   |   |               |   ├── ServiceLikedTweets.java
    │   |   |               |   ├── ServiceLikingUsers.java
    │   |   |               |   ├── ServiceRetweeted_by.java
    │   |   |               |   ├── ServiceTweetById.java
    │   |   |               |   ├── ServiceTweets.java
    │   |   |               |   ├── ServiceUserById.java
    │   |   |               |   └── ServiceUserByUsername.java
    │   |   |               ├── Stats
    │   |   |               |   ├── StatAverage.java
    │   |   |               |   ├── StatFollowersRange.java
    │   |   |               |   └── StatVariation.java
    │   |   |               ├── Utils
    │   |   |               |   ├── Counter.java
    │   |   |               |   └── StringToDate.java
    │   |   |               └── FollowersAnalyzerApplication.java 
    │   |   └── resources
    |   |       └── application.properties
    │   └── test/java/it/Twitter/FollowersAnalyzer
    |       └── java
    |           └── it
    |               └── Twitter
    |                   └── FollowersAnalyzer
    │                       ├── FiltersTest
    |                       |   ├── FilterByCreationTest.java
    |                       |   ├── FilterByFollowersTest.java
    |                       |   └── FilterByUsernameTest.java
    │                       ├── JsonTest
    |                       |   ├── TestJsonArray.java
    |                       |   ├── TestJsonObj.java
    |                       |   ├── TestJsonToUser.java
    |                       |   └── TestJsonToUserArray.java
    │                       ├── ModelTest
    |                       |   └── UserTest.java
    │                       ├── StatsTest
    |                       |   ├── TestFollowersRange.java
    |                       |   └── TestVariation_Average.java
    │                       ├── UtilsTest
    |                       |   └── TestCounter.java
    │                       └── FollowersAnalyzerApplicationTests.java
    ├── graphics
    |   └──FollowersAnalyzerLogo.jpg
    ├── .mvn/wrapper
    ├── .gitignore
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml

```


***


<a name="software"></a>
## :white_small_square: FrameWork e Software <div align="right"> [:arrow_up_small:](#start) </div>

Per lo sviluppo del programma è risultato necessario l'utilizzo di:
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo;
* [Maven](https://maven.apache.org/) - Strumento di buid automation, cioè compilazione e gestione progetti software di gestione di progetti e librerie;
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework per sviluppo di applicazioni web in Java basate sul framework Java Spring che semplifica la configurazione iniziale del progetto. Le dipenzenze vengono settate tramite [Spring Initializr](https://start.spring.io/) e sono:
  * Spring Boot Dev Tools;
  * Spring Web che include il web server open source Tomcat nella nostra applicazione;
* [JUnit](https://www.postman.com/) - Framework utilizzato per fare test unitari sul codice;
* [Postman](https://www.postman.com/) - ambiente di sviluppo API per effettuare richieste;

***


<a name="authors"></a>
### :white_small_square: Autori <div align="right"> [:arrow_up_small:](#start) </div>

| Sviluppatore | E-mail  | Profilo GitHub |
|--|--|--|
| Sbattella Mattia | [mail](tiasba01@gmail.com) | [GitHub](https://github.com/SbattellaMattia)
| Sumcutean Sara | [mail](s1099404@studenti.univpm.it)  | [GitHub](https://github.com/SaraSumcutean)

