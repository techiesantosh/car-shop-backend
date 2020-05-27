# car-shop-backend

Windows OS

1. Download and install mongodb for windows on our machine with default settings
2. Download json from https://api.jsonbin.io/b/5ebe673947a2266b1478d892  and save as cars.json
3. Go to C:\Program Files\MongoDB\Server\4.0\bin and execute below command
  ```
  mongoimport --db shop --collection warehouse --file cars.json --jsonArray
 ```
4. If required change frontend.url in application.propeties to the frontend url 
5. Checkout this project and run below command 
   ```
   mvn spring-boot:run
   ```
