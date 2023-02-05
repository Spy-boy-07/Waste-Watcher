# Waste-Watcher
//Had to edit my commits because there were some errors

we are Designing a system for tracking and reducing food waste and garbage in local areas.
We are devloping this in Native Android Platform using java.

Features of our app:
  Login/Registration for each and every user.
  We take input of their location in terms of city and area.
  We give our user option of both, food tracking and garbage tracking.
  
  In Food Section, user gets 4 options: Inventory - Donation - Track Waste - Tips n Tricks
  Inventory: is to store items that you own or can say have in fridge.
  Donation: if you have too much of left over food , you can contact your neaarest ngo.
  Track Waste: Track how much of food is getting dumped.
  Tips n Tricks to reduce wastage of food items.
  
  Unlike Foodsection, Garbage section has two sections: 
    Track waste: In which user gets two option, for wet watse and for dry waste.
      Two separate virtual dustbins are created in Firebase RealtimeDatabase, for dry and wet wastes.
      Also if user doesnt have two separate dustbins for these wastes then we give them a platform to buy one.
      Tracking is done as user provides description and weight of the waste added to bin.
    Tips n Tricks to save environment and local areas.
   
  
   Also in database, the waste is stored by category of area so we can get total wastage in a city or a perticular area.
   //stored in database but not retrieved yet.
   
