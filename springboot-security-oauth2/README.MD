# test request

http://localhost:8080/oauth/token
- method : POST
- parameter
  - username      
    user
  - password   
    123
  - grant_type   
    password
  - client_id  
    authClient
  - scope 
    all
  - client_secret  
    123
    
  http://localhost:8080/user/hello
  - method : get
  - parameter
   - access_token  
     