# Esame di Programmazione ad Oggetti!

Progetto per il corso di Programmazione ad oggetti dell'università Politecnico delle Marche, svolto dallo studente Andrea Albasini del secondo anno dell'indirizzo: "ingegneria informatica e dell'automazione" .


 

## Introduzione

L’applicazione, basata sul linguaggio di programmazione Java, sfrutta il framework Spring e i vantaggi di un linguaggio OOP (incapsulamento, ereditarietà e polimorfismo). Inoltre, restituisce tramite API REST GET dati e statistiche in formato JSON a partire da un dataset assegnatoci in formato csv. Il progetto può essere compilato attraverso i framework Maven e Gradle che gestiscono l'importazione delle librerie Spring.

## Come utilizzare il software

All’avvio, l’applicazione apre una connessione con il web-server in locale sula porta 8080. Viene scaricato in automatico il dataset ed effettua il parsing del file CSV contenuto nell’[URL](http://data.europa.eu/euodp/data/api/3/action/package_show?id=b8c13971-e315-470e-a125-40d67fe7067b) assegnatoci.

Per testare il software è possibile utilizzare Postman, ambiente attraverso il quale è possibile richiedere dati, metadati, statistiche sui dati e si possono applicare filtri a dati e statistiche..
### Dati
Per richiedere i dati contenuti nel file CSV bisogna impostare il metodo “GET” e definire la rotta

```
localhost:8080/data

```


### Metadati

Per richiedere i metadati bisogna impostare il metodo **GET** e definire la rotta

```
localhost:8080/metadata

```
### Statistiche

Per ottenere le statistiche di ogni attributo del dataset bisogna impostare il metodo **GET** e definire la rotta

```
localhost:8080/stats

```

oppure ad esempio per il campo Category, bisogna specificare nella rotta il campo _field_ (fare attenzione alla lettera maiuscola) nel seguente modo:

```
localhost:8080/stats?field=Category

```

che restituisce:

```
[
	{
		"field": "Category",
		"elementi unici": {
		"Vegetable products": 1000
		},
		"count": 1000
	}
]
```
_**Di seguito viene elencata la lista degli attributi:**_
Category;
SectorCode;
ProductCode ;
ProductDesc ;
ProductBriefDescription ;
Unit;
Country;
Period;
MPMarketPrice.

## UML diagrams

![enter image description here](https://raw.githubusercontent.com/andreaalbasini/EsameP.O./master/Univpm/Univpm/Diagrammadelleclassi.jpg)


![enter image description here](https://raw.githubusercontent.com/andreaalbasini/EsameP.O./master/Univpm/Univpm/diagrammi/Interaction%20Sequence%20diagram.jpg)



![enter image description here](https://raw.githubusercontent.com/andreaalbasini/EsameP.O./master/Univpm/Univpm/diagrammi/Use%20Case%20diagram.jpg)
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE0MzY1OTY1OTksLTEwNDIwNjk0ODIsND
c1MTMyMzA1LDExODc0MDMxODQsLTM4MjcxOTI5OSw5NDA2NTM4
MTcsLTE1MzQ2MzAwMjYsLTEyNjYyNTk5MDAsLTk1Njk1OTIwMi
wxNjg3Njg4OTk5XX0=
-->