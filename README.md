# Riassunto di tante cose belle:

## Architettura N-Tier: 

1) La richiesta viene inviata dal client a un Controller (Servlet)
2) Il controller accetta la richiesta
  * Se deve consultare un database richiama una classe apposita che chiama DAO (Data Axcess Object) che interagisce con il DB
  * Altrimenti invia tramite POJO (Oggetto contenente classi) i dati alla view (JSP Java Server Pages)
3) JSP contiene il contenuto statico + dinamico (elaborato dall'app) che l'utente visualizzerà!

## NOTE IMPORTANTI:
- Mai scrivere Business Login in JSP. Questa va scritta in Servlet e, in caso di accesso al Database, l'accesso a quest'ultimo dovrà essere gestito da una classe service la quale accede a una DAO.
- Mai scrivere nella servlet il codice per il database, seguire quello scritto sopra!
