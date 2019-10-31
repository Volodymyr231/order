
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1> hello </h1>
<div class="container">
    <fieldset>
        <legend>Add new order</legend>
        <form name="order" action="" method="POST">
            delivery:<@spring.formSingleSelect "orderForm.delivery", mavsDelivery ,"class='form-control'"/>
           <br> Product:<@spring.formSingleSelect "orderForm.Product", mavs, "class='form-control'"/>
           <br> Customer:<@spring.formSingleSelect "orderForm.Customer", mavs1, "class='form-control'"/>
            <br>Price:<@spring.formInput "orderForm.price" "class='form-control'" "text"/>
            <br>Number:<@spring.formInput "orderForm.number" "class='form-control'" "text"/>
            <br>Date:<@spring.formInput "orderForm.date" "class='form-control'" "text"/>
            <script>
                $('#date').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>


            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
