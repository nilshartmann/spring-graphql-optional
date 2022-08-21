# Spring for GraphQL: Input-Types containing java.util.Optional with objects fail

## Steps to reproduce

* Start Server, open GraphiQL at `http://localhost:31080`
* Run Query that works:
  ```graphql
    mutation {
      createAccount(input:{
        id: "1",
        fullname:"Klaus"
      }
    )}```
* Note this query works, even `fullname` on the Java type `AccountInput` is a `java.util.Optional`
* Try to add also a contact:
  ```graphql
    mutation {
      createAccount(input:{
        id: "1",
        fullname:"Klaus",
        contact:{
          phone:"123"
        }
      })
    }```
* This mutation fails (`Unable to make private java.util.Optional(java.lang.Object) accessible: module java.base does not "opens java.util" to unnamed module`)
* `contact` on the java record `AccountInput` is also a `java.util.Optional` (as `fullname` is), but contains another Record and not a Java primitive 
* Same problem occurs if instead of a Record a regular java class is used (see `personalData`)
* 