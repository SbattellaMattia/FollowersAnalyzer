<p align="center">
<img src="https://github.com/SbattellaMattia/SaraSumcutean-ProgettoEsame/blob/master/graphics/FollowersAnalyzerLogo.jpg">
</p>

<h1 align="center"> FollowersAnalyzer </h1>
 
<p align="center">
L'applicazione FollowersAnalyzer permette di eseguire una serie di richieste riguardanti i followers Twitter.
</p>

## :white_small_square: **Indice dei contenuti**

* [Introduzione](#intro)
* [Progetto/Applicazione](#install)
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

<a name="intro"></a>
## :white_small_square: Introduzione

Il programma FollowersAnalyzer offre varie possibilità: fare statistiche

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

A questo punto l'applicazione è pronta e in ascolto all'indirizzo http://localhost:8080 dove si potranno fare le [richieste](#rotte) GET. 

(POSTMAN)
  

<a name="rotte"></a>
## :white_small_square: Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo
```
localhost:8080
```

**_Le rotte definite sono le seguenti:_**

**(Ove possibile, cliccare sulla seguente immagine per maggiori informazioni)** :information_source: 

<a name="primarie"></a>
## :white_small_square: Rotte primarie/di base
N° | TIPO | ROTTA | PARAMETRO | DESCRIZIONE
-- | -- | -- | -- | -- 
**1.**|GET|```/UserById/```|id utente|*Passato come parametro un id utente, la rotta restituisce i suoi dati.*
**2.**|GET|```/UserByUsername/```|username utente|*Dato l'username di un utente, la rotta restituisce i suoi dati.*
**[3.](#3)**|GET|```/Followers/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi followers. [:information_source:](#info)*
**4.**|GET|```/Following/```|id utente|*Passato come parametro un id utente, la rotta ne restituisce l'elenco dei seguiti.*
**5.**|GET|```/TweetById/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce i suoi dati.*
**6.**|GET|```/User/Tweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce la lista dei suoi tweet.*
**7.**|GET|```/User/LikedTweets/```|id utente|*Passato come parametro un id utente, la rotta restituisce l'elenco di tweet ai quali ha messo like.*
**8.**|GET|```/Tweet/Retweeted_by/```|id tweet|*Passato come parametro un id tweet, la rotta restituisce la lista degli utenti che lo hanno ritwittato.*

<a name="filters"></a>
## :white_small_square: Filtri
N° | TIPO | ROTTA | DESCRIZIONE
-- | -- | -- | --
**[9.](#9)**|GET|```/Filter/FollowersByCreation/{id}```|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati per data di creazione dell'account. [:information_source:](#info)**
**[10.](#10)**|GET|```/Filter/FollowingByCreation/{id}```|*Passato come parametro un id utente, la rotta restituisce l'elenco degli (utenti) seguiti filtrati per data di creazione dell'account. [:information_source:](#info)*
**11.**|GET|```/Filter/VerifiedFollowers/{id}```|*Passato come parametro un id utente, la rotta restituisce l'elenco dei followers filtrati secondo il verificato del loro profilo.*
**12.**|GET|```/Filter/Refollowers/{id}```|*Passato come parametro un id utente, la rotta restituisce l'elenco degli utenti che ricambiano il follow.*
**13.**|GET|```/Tweet/LikingUser/{id}```|*Passato come parametro un id tweet, la rotta restituisce gli utenti che hanno messo like al tweet.*

<a name="stats"></a>
## :white_small_square: Statistiche sui Followers
N° | TIPO | ROTTA | DESCRIZIONE
-- | -- | -- | --
**14.**|GET|```/FollowersStats/Media/{id}```|*Passato come parametro un id utente, la rotta restituisce la media del numero di followers dei suoi followers.*
**15.**|GET|```/FollowersStats/Range/{id}```|*Passato come parametro un id utente, la rotta restituisce la sudivisione in range per numero di followers, dei followers dell'utente.*
**16.**|GET|```/FollowersStats/Activity/{id}```|*Passato come parametro un id utente, la rotta restituisce l'ordine degli utenti più attivi sul suo profilo sulla base del numero di like. (la lista degli utenti e la loro attività sul profilo)*


<a name="info"></a>
## :white_small_square: Specifiche
E' necessario specificare che alcune rotte possono includere parametri aggiuntivi per modificare i risultati di filtri e statistiche aggiungendo alla richiesta:
```
/? <PAROLA CHIAVE> = <OPZIONE>
```
In particolare:
ROTTA | /? | PAROLA CHIAVE | OPZIONI | DESCRIZIONE
-- | -- | -- | -- | --
<a name="3">3.</a>|/?|username|username della persona da ricercare| restituisce l'utente se trovato


<a name="test"></a>
## :white_small_square: Test

E' possibile eseguire i seguenti test:



<a name="software"></a>
## :white_small_square: FrameWork e Software
Per lo sviluppo del programma è risultato necessario l'utilizzo di



<a name="authors"></a>
### Autori
Progetto realizzato da:
- Sbattella Mattia
- Sumcutean Sara
