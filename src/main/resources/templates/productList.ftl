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
    <h3>product list</h3>
    <table class="table table-striped table-sm">
        <thead class="thead-dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>price</th>
            <th>delivery</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.delivery?c}</td>
                <td>  <a href="/product/delete/${product.id}" type="button" class="btn btn-danger">Delete</a></td>
                <td>  <a href="/product/update/${product.id}" type="button" class="btn btn-primary">Update</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a href="/product/create" type="button" class="btn btn-success">Add new product</a>
    <a href="/" type="button" class="btn btn-success">Go to Main</a>
</div>


</body>
</html>>