# Project: E-comerce Management
### Create Project by spring.start.io
#### - Add dependacies and MySQL database (using MySQL)
#### - Add content in application.properties file of resources:
```spring.datasource.url = jdbc:mysql://localhost:3306/emp
spring.datasource.username = root
spring.datasource.password = 123456789

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.hibernate.ddl-auto = update

logging.level.org.hibernate.stat=debug

spring.jpa.show-sql=true
```

#### - Specific: 
- ```spring.datasource.url = jdbc:mysql://localhost:3306/emp``` is the url to database (emp is the name of database)
- ``` spring.datasource.username = root``` is username
- ``` spring.datasource.password = 123456789``` is password

#### Create table and insert data

### Tables
#### 1. Customer

| Column            | Type                     | Nullable |
| :---------------- | ------------------------ | -------- |
| **`customer_id`** | `int `                   | not null |
| `customer_name`   | `varchar(45)`            | not null |
| `address`         | `varchar(100)`           | not null |
| `phone_no`        | `varchar(20)`            | not null |
| `cart_id`         | `int`                    |          |

#### 2. Cart

| Column        | Type      | Nullable |
| :------------ | :-------- | :------- |
| **`cart_id`** | `int`     | not null |

#### 3. Cart_item

| Column            | Type              | Nullable |
| :---------------- | :----------       | :------- |
| **`cart_id`**     | `int`             | not null |
| **`product_id`**  | `int`             | not null |
| `quantity_wished` | `int`             | not null |
| `date_added`      | `date`            |          |
| `total_amount`    | `demical(10,0)`   |          |

#### 4. Product

| Column           | Type                     | Nullable |
| :--------------- | :----------------------- | :------- |
| **`product_id`** | `int`                    | not null |
| `name_product`   | `varchar(45)`            | not null |
| `type`           | `varchar(3)`             |          |
| `size`           | `varchar(3)`             |          |
| `quantity`       | `int`                    | not null |
| `price`          | `demical910,0`           |          |

### Data

#### Customer

|customer_id|customer_name|address |phone_no   |cart_id|
|:----------|:------------|:------ |:-------   |:------|
|1          |Hoang        |DakLak  |0399457000 |3      |
|2          |Thanh        |DakLak  |0919719693 |4      |
|3          |HuyThanh     |HCM     |0967500021 |1      |
|4          |MyAnh        |Hue     |0372679000 |2      |
|5          |Lan          |HaNam   |0914585450 |1      |
|6          |DatThanh     |QuangNam|0329413000 |3      |

#### Product
 |product_id |name_product |type     |size       |price   |quantity|
 |:----------|:------------|:------  |:-------   |:------ |:-----  |
 |1	         |T-shirt      |Cl1	     |M          |250000  |15      |
 |2          |Skirt        |Cl2	     |M          |270000  |7       |
 |3          |Glas         |Cl3      |S      	   |300000	|8       |
 |4          |Blouse     	 |Cl1	     |M	         |275000	|9       |
 |5	         |Flip	       |Cl4	     |M	         |175000	|10      |
 |6	         |Short	       |Cl2	     |L	         |220000	|12      |
 |7	         |Tie	         |Cl5	     |S	         |425000	|11      |
 |8	         |Shoes        |Cl4	     |M	         |375000	|13      |
 |9	         |Coat	       |Cl6	     |L	         |400000	|16      |
 |10	       |Suit	       |Cl1	     |L	         |525000	|5       |
 
 ### Get all products (Product) use Mybatis with:
 #### - Params: price, condition
 #### - Price of product
 #### - Condition is one of these values: less_than, greater_than và equal
 
 1. Greater_than
 - Request: `GET` - http://localhost:8080/product/400000/greater_than
 ```json
 {
 [
    {
        "product_id": 7,
        "name_product": "Tie",
        "type": "Cl5",
        "size": "S",
        "price": 425000.0
    },
    {
        "product_id": 10,
        "name_product": "Suit",
        "type": "Cl1",
        "size": "L",
        "price": 525000.0
    }
]
 }
 ```
 
 2. Less_than
 - Request: `GET` - http://localhost:8080/product/200000/less_than
 ```json
 {
 [
    {
        "product_id": 5,
        "name_product": "Flip",
        "type": "Cl4",
        "size": "M",
        "price": 175000.0
    },
    {
        "product_id": 11,
        "name_product": "Cap",
        "type": "Cl7",
        "size": "M",
        "price": 95000.0
    }
]
 }
 ```
 
 3. Equal
 - Request: `GET` - http://localhost:8080/product/275000/equal
 ```json
 {
 [
    {
        "product_id": 4,
        "name_product": "Blouse",
        "type": "Cl1",
        "size": "M",
        "price": 275000.0
    }
]
 }
 ```
 
 ### Add item into cart with param customer_id of customer (using Mybatis)
 #### - Params: customẻ_id, product_id, quantity
 #### - Create cart for customer (if not exist) and update cart_id
 #### - Calculate total_amout based on quantity_wished, price of product and insert int cart
 #### * If existing item in cart, calculate again and update. In contrast, insert into cart
 Do this function and display "Successfully!" if do it successfully and check by geting all items in cart  
 - Request: `POST` - http://localhost:8080/cart_item/add/2/4/1
 Successfully!
 - Request: `GET` - http://localhost:8080/cart_item/findAllItem
 ```json
 {
 [
    {
        "cart_id": 4,
        "product_id": 4,
        "quantity_wished": 1,
        "date_added": null,
        "total_amount": 275000.0
    }
]
 }
 ```
 - Add a new item that is not in cart
 - Request: `POST` - http://localhost:8080/cart_item/add/3/4/5
 - Request: `GET`- http://localhost:8080/cart_item/findAllItem
 ```json
 {
 [
    {
        "cart_id": 4,
        "product_id": 4,
        "quantity_wished": 1,
        "date_added": null,
        "total_amount": 275000.0
    },
    {
        "cart_id": 1,
        "product_id": 4,
        "quantity_wished": 5,
        "date_added": null,
        "total_amount": 1375000.0
    }
]
 }
 ```
 
 - Add a new item that existed in cart 
 - Request: `POST` - http://localhost:8080/cart_item/add/3/4/6
 - Request: `GET`- http://localhost:8080/cart_item/findAllItem
 ```json
 {
 [
    {
        "cart_id": 4,
        "product_id": 4,
        "quantity_wished": 1,
        "date_added": null,
        "total_amount": 275000.0
    },
    {
        "cart_id": 1,
        "product_id": 4,
        "quantity_wished": 11,
        "date_added": null,
        "total_amount": 3025000.0
    }
]
 }
 ```
 #### The quantity_wished and total_amount are updated
 
 ### Get the list of items by customer_id of customer with condition:
 #### - Params: customer_id, offset và limit
 - Request: `GET` - http://localhost:8080/cart_item/findAll1/3/Blouse/0/1
 ```json
 {
 [
    {
        "cart_id": 1,
        "product_id": 4,
        "quantity_wished": 11,
        "date_added": null,
        "total_amount": 3025000.0
    }
]
 }
 ```
