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
    <h3>customer list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>phoneNumber</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.phoneNumber}</td>
            <td>  <a href="/customer/delete/${customer.id}" type="button" class="btn btn-danger">Delete</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
    <a href="/customer/create" type="button" class="btn btn-success">Add new customer</a>
</div>



</body>
</html>>