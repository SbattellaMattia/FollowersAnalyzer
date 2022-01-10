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
    * [Rotte primarie/di base](#primarie)
    * [Filtri](#filters)
    * [Statistiche sui followers](#stats)
  * [Specifiche](#info)
  * [Test](#test)
* [Documentazione](#documentation)
* [Struttura del progetto](#strucure)
* [FrameWork e Software](#software)
* [Autori](#authors)

***

<a name="intro"></a>
## :white_small_square: Introduzione

Il programma FollowersAnalyzer offre varie possibilità 

***

<a name="project"></a>
## <h2 align="center"> Il progetto </h2>

<a name="install"></a>
## :white_small_square: Installazione

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

Per eseguire le richieste potrebbe essere utile utilizzare [Postman](https://www.postman.com/), un tool che permette di costruire, testare e documentare le API (Application Programming Interface): un set di definizioni che consentono al programma di comunicare con altri prodotti o servizi, per agevolare la programmazione ed evitare la ripetizione e ridondanza di codice. 

Postman permette di eseguire qualsiasi tipo di richiesta verso un server e ottenere in risposta le informazioni di cui si necessita.
  
***

<a name="rotte"></a>
## :white_small_square: Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo
```
localhost:8080
```

**_Le rotte definite sono le seguenti:_**

**(Ove possibile, cliccare sulla seguente immagine per maggiori informazioni generali)** :information_source: 

**(E sul numero della rotta per informazioni specifiche)**

***

<a name="primarie"></a>
## :white_small_square: Rotte primarie/di base
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | -- 
**1.**|GET|```/UserById/```|id utente|*Passato come parametro un id utente, la rotta restituisce i suoi dati.*
**2.**|GET|```/UserByUsername/```|username utente|*Dato l'username di un utente, la rotta restituisce i suoi dati.*
**[3.](#3)**|GET|```/Followers/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi followers. [:information_source:](#info)*
**[4.](#4)**|GET|```/Following/```|id utente|*Passato come parametro un id utente, la rotta ne restituisce l'elenco dei seguiti. [:information_source:](#info)*
**5.**|GET|```/TweetById/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce i suoi dati.*
**6.**|GET|```/User/Tweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi tweet.*
**7.**|GET|```/User/LikedTweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco di tweet ai quali ha messo like.*
**[8.](#8)**|GET|```/Tweet/Retweeted_by/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce la lista degli utenti che lo hanno ritwittato. [:information_source:](#info)*
**[9.](#9)**|GET|```/Tweet/LikingUsers/```|id utente|*Passato come parametro un id tweet, la rotta restituisce gli utenti che hanno messo like al tweet. [:information_source:](#info)*

<a name="filters"></a>
## :white_small_square: Filtri
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | --
**[10.](#10)**|GET|```/Filter/FollowersByCreation/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati per data di creazione dell'account. [:information_source:](#info)**
**[11.](#11)**|GET|```/Filter/FollowingByCreation/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco degli (utenti) seguiti filtrati per data di creazione dell'account. [:information_source:](#info)*
**[12.](#12)**|GET|```/Filter/VerifiedFollowers/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati secondo il verificato del loro profilo. [:information_source:](#info)*
**13.**|GET|```/Filter/Refollowers/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco degli utenti che ricambiano il follow.*

***

<a name="stats"></a>
## :white_small_square: Statistiche sui Followers
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | --
**14.**|GET|```/FollowersStats/Media/```|id utente|*Passato come parametro un id utente, la rotta restituisce la media del numero di followers dei suoi followers.*
**15.**|GET|```/FollowersStats/Varianza/```|id utente|*Passato come parametro un id utente, la rotta restituisce la varianza del numero di followers dei suoi followers.*
**[16.](#16)**|GET|```/FollowersStats/Range/```|id utente|*Passato come parametro un id utente, la rotta restituisce la sudivisione in range per numero di followers, dei followers dell'utente. [:information_source:](#info)*
**[17.](#17)**|GET|```/FollowersStats/Activity/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'ordine degli utenti più attivi sul suo profilo sulla base del numero di like. (la lista degli utenti e la loro attività sul profilo) [:information_source:](#info)*

***

<a name="info"></a>
## :white_small_square: Specifiche
E' necessario specificare che alcune rotte possono includere un parametro aggiuntivo per modificare i risultati di filtri e statistiche aggiungendo alla richiesta:
```
/? <PARAMETRO> = <OPZIONE>
```
Se non verrà inserito nulla, la rotta sarà eseguita con un defaul value (in descrizione in tabella) preimpostato e restituirà il risultato descritto [qui](#rotte).

Tutte le varie possibilità sono in descrizione nella seguente tabella:
ROTTA | "/?" | PARAMETRO | "=" | OPZIONE | VALORE DI DEFAULT | DESCRIZIONE
-- | -- | -- | -- | -- | -- | --
<a name="3">3.</a>|```/?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Se viene inserito l'username, la rotta restituisce i paramentri dell'utente ricercato fra tutti i followers.
<a name="4">4.</a>|```/?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Se viene inserito l'username, la rotta restituisce l'utente seguito con il nome inseito.
<a name="8">8.</a>|```/?```|"username"| ```=``` | Username della persona da ricercare | ```all``` | Se viene inserito l'username e l'utente viene trovato tra coloro che hanno riteittato, ne restituisce i suoi dati.
<a name="9">9.</a>|```/?```|"method"| ```=``` | ```followers``` |  ```all``` | Se inserita l'opzione ```followers```, la rotta restituirà esclusivamente i followers dell'utente che hanno messo like al tweet.
<a name="10">10.</a>|```/?```|"username"| ```=``` | ```all``` | | |
<a name="11">11.</a>|```/?```|"username"| ```=``` | ```all``` | | |
<a name="12">12.</a>|```/?```|"username"| ```=``` | ```all``` | | |
<a name="16">16.</a>|```/?```|"username"| ```=``` | ```all``` | | |
<a name="17">17.</a>|```/?```|"username"| ```=``` | ```all``` | | |

***

<a name="test"></a>
## :white_small_square: Test

E' possibile eseguire i seguenti test:

***

<a name="documentation"></a>
## :white_small_square: Documentazione
Il progetto è interamente documentato in Javadoc, un applicativo utilizzato per la generazione automatica della documentazione del codice.

***

<a name="software"></a>
## :white_small_square: FrameWork e Software

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
### :white_small_square: Autori

| Sviluppatore | Email  | Profilo GitHub |
|--|--|--|
| Sbattella Mattia |s1081890@studenti.univpm.it | 
| Sumcutean Sara | s1099404@studenti.univpm.it  | https://github.com/SaraSumcutean
