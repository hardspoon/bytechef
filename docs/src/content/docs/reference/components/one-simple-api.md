---
title: "One Simple API"
description: "A toolbox with all the things you need to get your project to success:  Image resize and CDN, PDF and Screenshots generation, Currency Exchange and Discounts, Email Validation, QR codes, and much more!"
---
## Reference
<hr />

A toolbox with all the things you need to get your project to success:  Image resize and CDN, PDF and Screenshots generation, Currency Exchange and Discounts, Email Validation, QR codes, and much more!


Categories: [developer-tools]


Version: 1

<hr />



## Connections

Version: 1


### null

#### Properties

|      Name      |     Type     |     Control Type     |     Description     |
|:--------------:|:------------:|:--------------------:|:-------------------:|
| API Token | STRING | TEXT  |  |





<hr />





## Actions


### Currency Converter
Convert currency from one to another.

#### Properties

|      Name      |     Type     |     Control Type     |     Description     |
|:--------------:|:------------:|:--------------------:|:-------------------:|
| From Currency | STRING | SELECT  |  Currency from which you want to convert.  |
| To Currency | STRING | SELECT  |  Currency to which you want to convert.  |
| Value | NUMBER | NUMBER  |  Value to convert.  |


### Output



Type: OBJECT


#### Properties

|     Type     |     Control Type     |
|:------------:|:--------------------:|
| STRING | TEXT  |
| STRING | TEXT  |
| STRING | TEXT  |
| NUMBER | NUMBER  |
| STRING | TEXT  |






### URL Shortener
Shorten your desired URL

#### Properties

|      Name      |     Type     |     Control Type     |     Description     |
|:--------------:|:------------:|:--------------------:|:-------------------:|
| URL | STRING | TEXT  |  Place the URL you want to shorten  |


### Output



Type: OBJECT


#### Properties

|     Type     |     Control Type     |
|:------------:|:--------------------:|
| STRING | TEXT  |
| STRING | TEXT  |
| STRING | TEXT  |
| STRING | TEXT  |
| STRING | TEXT  |






### Web Page Information
Get information about a certain webpage

#### Properties

|      Name      |     Type     |     Control Type     |     Description     |
|:--------------:|:------------:|:--------------------:|:-------------------:|
| URL | STRING | TEXT  |  Place the web page url you want to get info from  |


### Output



Type: OBJECT


#### Properties

|     Type     |     Control Type     |
|:------------:|:--------------------:|
| {STRING\(title), STRING\(description), STRING\(canonical)} | OBJECT_BUILDER  |
| {STRING\(site), STRING\(title), STRING\(description)} | OBJECT_BUILDER  |
| {STRING\(title), STRING\(url), STRING\(image), STRING\(description), STRING\(type)} | OBJECT_BUILDER  |






