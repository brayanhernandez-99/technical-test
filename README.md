
# Technical Test - Trading Platform

## Question Description

A team is building a trading platform that allows users to be registered as traders. One requirement is to implement a REST API service using the Spring Boot Framework to provide options to create an account, update account information, add money, etc. It must deal with the typical information for a trader: name, email, account balance, account creation time, and account update time.

Each trader record is a JSON object with the following keys:

- `id`: The unique ID assigned at the time of registration.
- `name`: The name of the trader.
- `email`: The email of the trader.
- `balance`: The account balance of the trader.
- `createdAt`: The timestamp when the registration was completed, described by the string `yyyy-MM-dd HH:mm:ss`.
- `updatedAt`: The timestamp when the trader account got updated (i.e., either the name was updated or money was added), described by the string `yyyy-MM-dd HH:mm:ss`.

### Example of a Trader JSON Object

```json
{
  "id": 1,
  "name": "Elizabeth Small",
  "email": "susanchandler.wchurch@buck.com",
  "balance": 62.0,
  "createdAt": "2018-04-16 04:56:28",
  "updatedAt": ""
}
```

---

The REST service must expose the `/trading/traders` endpoint, which allows managing the data records in the following way:

### POST request to `/trading/traders/register`
- Registers a new trader record.
- Expects a JSON trader object with missing `id`, `createdAt`, and `updatedAt`. Assume that the given object is always valid.
- If a trader with the same email already exists, the response code is **400**. Otherwise, the response code is **201**.

### GET request to `/trading/traders/all`
- Returns all the records with status code **200**.
- Records should be sorted by ID in ascending order.

### GET request to `/trading/traders?email={email}`
- Returns a record with the given email and status code **200**.
- If there is no record with the given email, the response code is **404**.

### PUT request to `/trading/traders`
- Updates the trader's name by email.
- The trader JSON object sent in the request body will have the keys `email`, `name`.
- If the trader with the requested email does not exist, the response code is **404**. Otherwise, **200**.

### PUT request to `/trading/traders/add`
- Adds money to the trader's account by email.
- The trader JSON object sent in the request body will have the keys `email`, `amount`.
- If the trader with the requested email does not exist, the response code is **404**. Otherwise, **200**.

---

### Note:
- The default timezone of the application is set to **UTC**, which should not be modified.
- We allow an absolute error of **10⁻³** in the expected and returned `balance` field of the trader data.
- We allow a maximum difference of **one second** between the returned `createdAt` value in any GET request and the expected `createdAt`, i.e., the timestamp when the registration request was sent from the JUnit test.
- We allow a maximum difference of **one second** between the returned `updatedAt` value in any GET request and the expected `updatedAt`, i.e., the timestamp when the update request was sent from the JUnit test.

Most of the implementation is provided, but the expected behavior is not achieved as there are some bugs in the given project. Find and fix the bugs in order to get the expected behavior, which is validated by executing a set of JUnit tests.

By default, the project supports the use of the **H2 database**.

---

## Example Outputs

### Consider the following POST requests:

```json
{
  "name": "Elizabeth Small",
  "email": "susanchandler.wchurch@buck.com",
  "balance": 62.0
}
```

```json
{
  "name": "Susan Adams",
  "email": "jeremyortega.smithpatricia@coleman.biz",
  "balance": 67.0
}
```

### GET to `/trading/traders?email={email}`

The response of the GET request is the following JSON with the HTTP response code **200**:

```json
{
  "id": 1,
  "name": "Elizabeth Small",
  "email": "susanchandler.wchurch@buck.com",
  "balance": 62.0,
  "createdAt": "2018-04-16 05:46:18",
  "updatedAt": ""
}
```

---

### PUT to `/trading/traders`

The name is successfully updated for the trader with the HTTP response code **200**.  
The following JSON is sent to update the name:

```json
{
  "name": "Susan Wood",
  "email": "jeremyortega.smithpatricia@coleman.biz"
}
```

---

### PUT to `/trading/traders/add`

The following JSON is sent to add money:

```json
{
  "email": "mbooker.jacobsmith@hotmail.com",
  "amount": 73.0
}
```

---

### GET to `/trading/traders/all`

The response of the GET request is the following JSON array with the HTTP response code **200**:

```json
[
  {
    "id": 2,
    "name": "Susan Wood",
    "email": "jeremyortega.smithpatricia@coleman.biz",
    "balance": 67.0,
    "createdAt": "2018-04-16 05:46:27",
    "updatedAt": "2018-04-16 05:49:18"
  },
  {
    "id": 3,
    "name": "Rebecca Carter",
    "email": "adkinsjason.paul57@collins.com",
    "balance": 151.0,
    "createdAt": "2018-04-16 05:46:34",
    "updatedAt": "2018-04-16 05:53:40"
  }
]
```
