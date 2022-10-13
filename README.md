# softeng 0-hotel_management
emphasis on developing the database in an efficient way

## Τεχνολογίες
______________________________________________________________
•	DBMS: Postgresql  
•	Front end: Java Swing  
•	Back end: Java 16  
•	Java editor: Intellij με ακαδημαϊκή άδεια  
•	Driver connector με DBMS: ”org.postgresql.Driver”  
 
 
## Βήματα εγκατάστασης εφαρμογών
______________________________________________________________
•	Κατέβασμα της postgres, που περιέχει το pgAdmin(GUI για τον χειρισμό της), βρίσκεται από την σελίδα:  
(https://www.postgresql.org/download/). Κατα την εγκατάσταση αφήνουμε το username(default)->postgres
•	Κατέβασμα Intellij (by jetbrains)   
μαθητικής άδεια από το site: (https://www.jetbrains.com/idea/download/#section=mac)
•	Δημιουργούμε μέσα στην Postgres μέσω του pgAdmin μια βάση δεδομένων με όνομα hoteldb.
•	Στην συνέχεια βάζουμε το Path του φάκελου bin που βρίσκεται μέσα στον φάκελο που δημιουργήθηκε κατα την εγκατάσταση της Postgres, μέσα στο Path στα System Variables του υπολογιστή(Για windows). Έτσι θα μπορούμε να έχουμε πρόσβαση μέσω του cmd σε εντολές της postgres.
•	Κάνουμε navigate με το cmd στον φάκελο όπου βρίσκεται το hoteldb.sql και πληκτρολογούμε την εντολή: “psql -U postgres hoteldb < hoteldb.sql” κι έτσι αντιγράφεται και η βάση στην postgres.
•	Τέλος στα αρχεία του project ανοίγουμε το αρχείο src/Interfaces/Provider και αλλάζουμε τα credentials με αυτά που εισήχθησαν κατα την εγκατάσταση της βάσης

## Constraints
______________________________________________________________
Inherent Constraints  
1) Key constraints  
2) Referential integrity – based on foreign keys  
Primary keys  
Customers:   
Primary key ~> nfc_id of type varchar
 
ipiresies:  
Primary key ~> id_ipiresias  
 
xoroi:  
Primary key ~> id_xorou of type varchar  
 
 
Foreign keys  
eggrafontai_se_ipiresies:   
Foreign keys ~> nfc_id of type varchar from Customers  
          ~> id_ipiresias of type int from ipiresies  
 
episkeptontai:  
Foreign keys ~> id_xorou of type varchar from xoroi  
                      ~> nfc_id of type varchar from  Customers  
 
exoun_prosvasi:  
Foreign keys ~> id_xorou of type varchar from xoroi  
                      ~> nfc_id of type varchar from Customers  
 
xreosi_ipiresias:  
Foreign keys ~> id_ipiresias of type int from ipiresies  
                      ~> nfc_id of type varchar from Customers  
 
Integrity Constraints  
Οι τιμές των primary keys και συνεπώς και των foreign keys, έχουν οριστεί έτσι ώστε να μην δέχονται NULL τιμές.  
 
Domain Constraints  
Παρατίθενται οι τύποι των μεταβλητών, καθώς δεν ορίσαμε επιμέρους περιορισμούς στο domain και για αυτό εξάλλου δεν έχουμε attribute constraints:  
 
Customers:  
•	nfc_id: varchar, not NULL (PK)  
•	onoma: varchar, not NULL  
•	eponimo: varchar, not NULL  
•	hm_gennisis date, not NULL  
•	arithmos_eggrafou: varchar, not NULL  
•	eidos_eggrafou: varchar, not NULL  
•	arxi_ekdosis: varchar, not NULL  
•	email: varchar, not NULL  
•	phone: varchar, not NULL  


eggrafontai_se_ipiresies:  
•	hm_ora_eggrafis: date, not NULL  
•	nfc_id: varchar, not NULL  
•	id_ipiresias: int, not NULL  
 
episkeptontai:  
•	hm_ora_eisodou: timestamp without time zone, not NULL  
•	hm_ora_eksodou: timestamp without time zone, not NULL  
•	nfc_id: varchar, not NULL   
•	id_xorou: varchar, not NULL   
 
exoun_prosvasi:  
•	hm_ora_enarksis: timestamp without time zone, not NULL  
•	hm_ora_liksis: timestamp without time zone, not NULL  
•	nfc_id: varchar, not NULL  
•	id_xorou: varchar, not NULL  
 
ipiresies:  
•	id_ipiresias: int, not NULL (PK)  
•	perigrafi_ipiresias: varchar, not NULL  
•	eggrafi: char, not NULL  
 
xoroi:  
•	id_xorou: varchar, not NULL (PK)  
•	plithos_klinon: int, not NULL  
•	onomasias_xorou: varchar, not NULL  
•	perigraf_thesi_xorou: varchar, not NULL  
•	id_ipiresias: int, not NULL  
 
xreosi_ipiresias:  
•	perigrafi: varchar, not NULL  
•	poso: int, not NULL  
•	nfc_id: varchar, not NULL  
•	id_ipiresias: int, not NULL  
•	hm_ora_xreosis: timestamp without time zone, can be NULL  
 
Δεν έχουμε άλλα ή άλλων ειδών constraints.  
 

## Indexes  
______________________________________________________________
Παρακάτω παρατίθενται τα ευρετήρια, τα οποία προσπάθησα να είναι ασυσχέτιστα με τα primary keys, αφού στα primary keys γίνεται, συνήθως, αυτόματα indexing:  
 
•	Εβαλα index την ημερομηνία γέννησης για να βελτιστοποιηθεί η απόδοση των queries, όπου αναζητούμε στατιστικά για ομάδες πελατών του ξενοδοχείου με βάση την ηλικία τους.  


•	Για την ιχνηλάτηση κρουσμάτων χρησιμοποιώ την ημερομηνία εισόδου σε ένα χώρο από ένα πελάτη οπότε θεωρώ καλό το συγκεκριμένο attribute να αποκτήσει ένα index.


•	Τέλος πρόσθεσα ένα index στην ημερομηνία και ώρα εγγραφής σε μια υπηρεσία αφού την χρησιμοποιώ για διαγραφή μιας εγγραφής σε υπηρεσία. 
