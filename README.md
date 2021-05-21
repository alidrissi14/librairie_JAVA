________________________________________________

Librairie by Ali Drissi
________________________________________________

readme.txt

________________________________________________

IMPORTANT
________________________________________________

JRE version used : JavaSE-1.8
________________________________________________

CONTENTS
________________________________________________

1) Launch
2) Main Frame
3) Add Livre Frame
4) Add BD Frame
5) Sell Frame
6) Client Frame
________________________________________________

1) Launch
________________________________________________

Either run from Eclipse or open "libraire.jar" with "JAVA(TM) Platform SE binary ".
________________________________________________

2) Main Frame
________________________________________________
A table in the main frame shows the available stock and the type (Livre/BD) is specified in each row.
There are several buttons :
-Ajouter un livre : go to 3) Add Livre Frame
-Ajouter une BD : go to 4) Add BD Frame
-Vendre un ouvrage : go to 5) Sell Frame
-Consulter Clients : go to 6) Client Frame
-Journal d'achats : didn't implement it
-Quitter : quit the application
_______________________________________________

3) Add Livre Frame
_______________________________________________

When clicked, a new frame appears with many textboxs. To add a new livre to stock, enter its information in the designated textbox and click on "Valider".
If a textbox or more are empty, a message appears saying "Veuilez remplir tous les champs". If they're not, the info entered appears in the table in the main frame.
_______________________________________________

4)Add BD Frame
_______________________________________________

See 3) Add Livre Frame but instead of Livre, BD applies here.
_______________________________________________

5) Sell Frame
_______________________________________________

In this frame, you should first of all choose an option in this comboBox Type. By default, "Livre" is selected. Then select an option from the comboBox Titre and Client, and enter a quantity.
The button "Ajouter" is disabled until a quantity is entered. When clicked, the info entered appears in the table "Panier" on the right and the total price of the table is calcuted and showed under the table ("Montant Total: ... €).
When the button "Valider" is clicked, the stock is updated. The new quantities are calculated and showed in the table in the main frame. And if all quantities are bought, the item is removed from the table.
And the total of points gained by the client from his purchase are calculated and added to the points he earns.
_______________________________________________

6) Client Frame
_______________________________________________

In this frame, the clients are showed in the table "Liste des Clients". To add a new client, simply click on the button "Ajouter un client" and enter the info in the textfields.
Again, if one or many textfields are empty, a message appears saying "Veuillez remplir tous les champs". When the "Valider" button is clicked, a new client is created/added and his info appear in the table "Liste des Clients"
_______________________________________________

To quit the application, simply close the main frame.