#Primer Informe
SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia 
FROM Lider ORDER BY Ciudad_Residencia;

#Segundo Informe
SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad 
FROM Proyecto 
WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla');

#Tercer Informe
SELECT Compra.ID_Compra, Proyecto.Constructora, Proyecto.Banco_Vinculado FROM Compra INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento';