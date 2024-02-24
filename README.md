## Descriere generala
Acest proiect a fost realizat în cadrul cursului de Programare Orientată Obiect, din cadrul Facultatii de Automatică, Calculatoare, Inginerie Electrică și Electronică din cadrul Universității Dunarea de Jos, anul 2022-2023, semestrul 1.

Scopul acestui proiect este de a realiza o aplicație care să permită gestionarea unei baze de date cu automobile. Acestea fiind de 2 feluri: cu motor si fara motor, care la randul lor pot sa fie cu motorina, benzina si electrice , respectiv sportive sau de agrement. Consider ca procesul de vanzare a unui vehicul este unul destul de complex, de aceea am creat aceasta aplicatie pentru a putea gestiona mai usor datele despre acestea atat in cazul unui depozit cat si in cazul unui magazin, aplicatia putand fi folosita atat de catre un client cat si de catre un vanzator.

Cum poate ajuta/imbunatatii aceasta aplicatie procesul de vanzare a unui vehicul va intrebati? Raspunsul este simplu: clientul vine cu niste specificatii deja cunoscute despre vehiculul pe care il doreste, iar vanzatorul poate sa isi faca o idee despre ce vehicul poate sa ii ofere clientului. De asemenea, clientul poate sa isi faca o idee despre pretul pe care il poate obtine pentru vehiculul pe care il doreste sa il cumpere. Filtrarea din tabel ajuta in acest scop, pentru a vedea raportul dintre pret si viteza pentru vehiculele de tipul dorit, cat si restul datelor despre acestea. 

Am decis sa implementez vehicule fara motor de agrement, mai exact biciclete, care pot fi de tipul: mountain bike, city bike, road bike, electric bike, etc. Scopul aplicatiei mele este acela de a putea vizualiza mai usor datele specifice despre acestea, precum si de a putea adauga noi biciclete in baza de date sau daca se doreste chiar stergerea lor.
De asemenea este implementata functia de a importa date dintr-un fisier .txt.

Am creat un seeder ce este apelat in interfata pentru a ne oferii date aleatorii pentru a putea testa aplicatia. Aceste date nu sunt create cu scopul de a fi utilizate in cadrul unei aplicatii reale. De aceea a fost implementata si functia de a putea sterge toate datele si a le importa din nou cu date exacte, precise si corecte.

Un scop secundar al proiectului este acela putea vedea unde se regaseste raportul cel mai bun dintre pret si viteza pentru biciclete. Din acest motiv in pagina principala a interfetei grafice am implementat 2 filtre, fiecare avand 2 inputuri: minim si maxim. Aici putem filtra atat dupa un minim, dupa un maxim sau dupa valoarea dintre cele 2 in cazul in care se doreste acest lucru. Odata ce am introdus valorile dorite, apasam butonul de refresh al tabelului si se va afisa tabelul cu datele filtrate.

## Interfata grafica
Interfata a fost creata cu ajutorul JavaFX si este compusa din 2 taburi: 
 - pagina principala: in care putem vizualiza tabelul, putem filtra atat dupa viteza cat si dupa pret, putem sterge toate datele din tabel, putem da refresh la tabel si putem inversa numele din coloana "proprietari".
 - pagina de adaugare: in care putem adauga noi biciclete in tabel si putem importa date dintr-un fisier .txt
Fiecare fisier .fxml are asociat un controller ce se ocupa de logica din spatele elementelor din interfata. In aceste controller am implementat functiile necesare pentru a putea face functionalitatea dorita. 
Pentru interfata grafica am folosit si un style.css pentru a stiliza fiecare element din paginile .fxml. Am ales sa folosesc un style.css pentru a putea modifica mai usor stilul aplicatiei. Am ales ca tema: dark mode pentru a putea fi mai usor de utilizat in timpul noptii si pentru a nu obosii ochii la utilizarea mai indelungata a aplicatiei.

## Fișiere
- `src/main/java/`: conține fișierele sursă Java cu codul aplicației cat si seederul pentru a genera date aleatorii
- `src/main/resources/`: conține fișierele ce tin de partea de interfata grafica a aplicatiei (fisiere .fxml, .css)


## Instalare
Pentru a rula aplicația, este necesară instalarea Maven și a Java JDK 19.

## Rulare
Pentru a rula aplicația, se rulează comanda Play din VS Code.

## Pentru mai multe detalii
Pentru mai multe detalii despre proiect: gorobtovvladandrei@gmail.com
# VICEE Move - Proiect CTI UGAL Anul 2 POO

## Descriere

Aplicație de indexare, afișare și filtrare a vehiculelor dintr-o bază de date.

Proiectul a fost realizat în cadrul cursului de Programare Orientată Obiect, anul 2, semestrul 1, 2022-2023.

Această aplicație caută să ajute utilizatorii să găsească vehiculele potrivite pentru ei, în funcție de preferințele lor. Și de asemenea le permite și managerilor de showroom-uri să țină evidența vehiculelor de pe stoc.

---

Clasa implemntată de mine VehiculFMSport se adresează vehiculelor fără motor de tip sport, cum ar fi bicicletele, role, skate-uri, ski-uri, etc.

Acesta este bună pentru magazine de inchiriat de biciclete, role, etc. mai ales cele de pe lângă parcurile sportive sau pârtiile de schi.

Funcțiile de import și export date permit actualizarea rapidă a stocului și lucrul offline.

---

Datele utilizate sunt fictive, iar aplicația nu are scop comercial.

## Utilizare

Datele pot fi adaugate in panou `AddData` prin generare aleatoare sau prin importarea unui fisier text.

În panoul principal se pot vedea datele după apăsarea butonului `Refresh data tabel`, actiune necesara și în urmă unei filtrari de pret sau vitează.

Butonul `Export` exporta datele din tabel într-un fișier text compatibil cu importul.

## Instalare

Pentru a rula aplicația, este necesară instalarea Maven și a Java JDK 19.

## Rulare

Pentru a rula aplicația, se rulează comanda `Play` din VS Code.

## Autori

- Iordăchescu Cristian Ștefan
- Gorobțov Vlad Andrei
- Zaharia Florina
- Hodină Emilia
- Paraschiv Cătălin
