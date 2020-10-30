<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html>
  <head>
   <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
   </head> 
    <body>  
<style>
 
    body {
        height: 877px;
        width: 620px;
        /* to centre page on screen*/
        margin-left: auto;
        margin-right: auto;
        background-color: ;    
    }
       
        
       
    </style>
      
      <div id="header" style="border: solid; border-radius: 15px">
          
          <div style = "" >
              
              <div style="float: left">
              <img src="rent-a-car.png" align="center" height='50px' width="50px">  
              <h3 style="display: inline-block ; padding: 0px">AGENCE TOMOBILTI</h3>
              </div>
              
              <div style="display: inline-block; float: right">
              <p style="margin:2px; margin-top: 7px" >Telephone :0500000000 </p>
              <p style="margin: 2px" >Adresse :ENSAH, HOCEIMA </p>
                </div>
            </div>
          
      <h1 align="center" style="font-family: arial; clear: both">Contat de location de véhicule</h1>
          
      </div>
      
      
      <div align="center"> 
        <p style="font-size: 20px; font-style: italic;display: inline-block"> Date : 01/01/2020 </p>
          <p style="margin-left: 20px;margin-right: 20px;display: inline-block"></p>
        <p style="font-size: 20px; font-style: italic;display: inline-block"> Contrat Numéro : 00001</p>
      </div>
      
      <div >
      <div style="display: inline-block; border: solid; padding-left: 18px;padding-right: 10px; border-top-left-radius: 20px; width: 274px">
      <h3 style="font-family: cursive">Le locataire :</h2>
      
       <c:forEach items="${clients}" var="client">
        <p>Nom:${client.getNom()}</p>
        <p>Prenom : ${client.getPrenom()}</p>
        <p>CIN : ${client.getCin()}</p>
        <p>Permis Numéro : ${client.getAdresse()}</p>
     
        <p>Nationalité : Marocaine</p>
        <p>Telephone : ${client.getTelephone()}</p>
         </c:forEach>
      </div>
      
      <div style="display: inline-block; border: solid; padding-left: 18px;padding-right: 10px; border-top-right-radius: 20px; width: 274px;">
      <h3 style="font-family: cursive">Le Véhicule loué :</h2>
      
     
		 <c:forEach items="${voitures}" var="voiture">					             
        <p>Marque :  ${voiture.getMarque()}</p>
        <p>Modele : ${voiture.getModele()}</p>
        <p>Immatriculation : ${voiture.getMatricule()} </p>
   
        <p>Date Fin Assur. :${voiture.getAssurance()}</p>
        <p>Kilométrage du depart :  ${voiture.getKilometrage()}</p>
        <p>Carburant : ${voiture.getCarburant()} </p>
        </c:forEach>
      </div>
    
          <div style="display: inline-block; border: solid; padding-left: 18px;padding-right: 10px; border-bottom-left-radius: 20px; width: 274px">
      <h3 style="font-family: cursive">Deuxieme Chauffeur :</h2>
        <p>Nom : Wld Nas</p>
        <p>Prenom : Flan</p>
        <p>CIN : R000000 </p>
        <p>Permis Numéro : 02/055566</p>
        <p>Date De Naissance : 01/01/1999 </p>
        <p>Nationalité : Marocaine</p>
        <p>Telephone : 0600000000</p>
      </div>
          
          <div style="display: inline-block; border: solid; padding-left: 18px;padding-right: 10px; margin-top: 5px; border-bottom-right-radius: 20px; width: 274px;">
      <h3 style="font-family: cursive">Details de location :</h2>
      <c:forEach items="${reservations }" var="reservation">
        <p>Date de départ : ${reservation.getDate_sortie()}</p>
        <p>Date de fin : ${reservation.getDate_sortie()}</p>
        <p>Prix Total : 2550 Dhs </p>
        <p>Etat exterieur : Parfait </p>
        <p>Etat exterieur : Parfait </p>
        <p>Garantie : Oui</p>
        <p>Roue de secoure : Oui </p>
        </c:forEach>
      </div>
      </div>    
          
      </div>
      <div align="center">
      <h3 style="display: inline-block;">Signature du locataire</h2>
          <h3 style="margin-left: 50px;margin-right: 50px; display: inline-block"></h3>
      <h3 style="display: inline-block">Signature et cachet de société</h2>
    
      <a  href="javascript:window.print()"class="btn btn-secondary" data-dismiss="modal">Imprimer</a>
      </div>

    
   
 
  </body>
</html>