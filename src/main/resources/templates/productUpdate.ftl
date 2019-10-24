
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div>
    <fieldset>
        <legend>Edit product</legend>
        <form name="product" action="" method="POST">
            name:<@spring.formInput "productForm.name" "" "text"/>
            <br>Description:<@spring.formInput "productForm.description" "" "text"/>
            <br>Price:<@spring.formInput "productForm.price" "" "text"/>
            <br>Delivery:<@spring.formInput "productForm.delivery" "" "text"/>

            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>
