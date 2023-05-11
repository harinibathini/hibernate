<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>CRM</title>
</head>
<body>


<div class="container">
    <div class="card bg-light">
        <div class="card-body mx-auto"></div>

        <div align="center">
            <h1>Add Product</h1>
        </div>
        <form action="AddProductServlet" method="get">
            <div class="form-row">


                <div class="col">
                    <label for="inputEmail4">Name</label>
                    <input type="text" class="form-control" placeholder="Product Name" name="name">
                </div>


                <div class="form-group col-md-6">
                    <label for="inputEmail4">Price</label>
                    <input type="int" class="form-control" id="inputEmail4" placeholder="Price" name="price">
                </div>

                 <div class="col">
                       <label for="inputEmail4">Quantity</label>
                        <input type="text" class="form-control" placeholder="Quantity" name="quantity">
                  </div>

           </div>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </div>
        </div>
    </form>
</div>
</div>

<br>
<a href="customerLogin.html"><button>Back</button></a>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>