# GameAndroid
## Screenshots

![App Screenshot](https://giadinh.mediacdn.vn/296230595582509056/2022/2/28/ly-tham-1-16460167959361875529123.jpg)

## Tech Stack

**Server:** 
  - Spring boot.
  - Spring security.
  - Spring data jpa.
  - MongoDB

**Frontend:** flutter.


## API Reference

#### register

```http
  POST localhost:8080/api/v1/auth/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` |  `register`|

#### authenticate

```http
  POST localhost:8080/api/v1/auth/authenticate
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`, `password` | `string` ,`string` | `authenticate` |

#### add(num1, num2)

Takes two numbers and returns the sum.


## Authors

- [@QuangDuong-BN](https://github.com/QuangDuong-BN)
  
