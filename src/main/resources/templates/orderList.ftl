<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>order list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>delivery</th>
            <th>product</th>
            <th>customer</th>
            <th>price</th>
            <th>number</th>
            <th>date</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.delivery}</td>
                <td>${order.product.description}</td>
                <td>${order.customer.phoneNumber}</td>
                <td>${order.price}</td>
                <td>${order.number}</td>
                <td>${order.date}</td>
                <td>  <a href="/order/delete/${order.id}" type="button" class="btn btn-danger">Delete</a></td>
                <td>  <a href="/order/update/${order.id}" type="button" class="btn btn-primary">Update</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/order/create" type="button" class="btn btn-success">Add new order</a>
    <a href="/" type="button" class="btn btn-success">Go to Main</a>
</div>


</body>
</html>>