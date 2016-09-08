<#import "../layout.ftl" as layoutTemplate>
  <@layoutTemplate.layout>  
<h1>Add a book</h1> 
<p class="lead">Please provide details of the book.</p>  
<form enctype="multipart/form-data" action="/add" method="post" autocomplete="off">  


<#if errors? has_content> 
<div class="bg-danger text-danger">
<ul> 
<#list errors as error>
 <li> 
    ${error} 

</li> 
</#list>
</ul> 
</div> 
</#if>   


<div class = "halfwidth">
<div class="form-group"> 
    <label for="isbn">ISBN</label> 
    <input name="isbn" type="text"  placeholder="Book ISBN" class="form-control" required /> 

    <div class="panel-group" id="accordion">
        <div class="panel panel-primary" id="panel0">
            <div class="panel-heading">
                 <h4 class="panel-title">
            <a data-toggle="collapse" data-target="#collapseZero"
               href="#collapseZero">
              Help
            </a>
          </h4>

            </div>
            <div id="collapseZero" class="panel-collapse collapse">
                <div class="panel-body">Please enter an ISBN in one of the following formats: <br>
                123456789-1<br>
                101-1-10-123456-7</div>
            </div>
        </div>
</div>  


<div class="form-group"> 
    <label for="title">Book Title</label> 
    <input name="title" type="text" size = "50" maxlength="200" placeholder="Book Title" class="form-control" required /> 

<div class="panel-group" id="accordion">
    <div class="panel panel-primary" id="panel1">
        <div class="panel-heading">
             <h4 class="panel-title">
        <a data-toggle="collapse" data-target="#collapseOne"
           href="#collapseOne">
          Help
        </a>
      </h4>

        </div>
        <div id="collapseOne" class="panel-collapse collapse">
            <div class="panel-body">Please enter the book title<br>
            Max 200 characters</div>
        </div>
    </div>
</div>  


<div class="form-group"> 
    <label for="author">Author</label> 
    <input name="author" type="text" size = "50" maxlength="200" placeholder="Book Author - Surname, First Name" class="form-control" required /> 

<div class="panel-group" id="accordion">
    <div class="panel panel-primary" id="panel2">
        <div class="panel-heading">
             <h4 class="panel-title">
        <a data-toggle="collapse" data-target="#collapseTwo"
           href="#collapseTwo">
          Help
        </a>
      </h4>

        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <div class="panel-body">Please enter the author of the book<br>
            Enter Surname, First Name: "Doe, John" <br>
            Max 200 characters</div>
        </div>
    </div>
</div>

<div class="form-group">
    <label for="current">Current Status</label> 
    <input name="current" type="text" size = "50" maxlength="200" placeholder="Current Status - Please look below for guidelines" class="form-control" required /> 

<div class="panel-group" id="accordion">
    <div class="panel panel-primary" id="panel3">
        <div class="panel-heading">
             <h4 class="panel-title">
        <a data-toggle="collapse" data-target="#collapseThree"
           href="#collapseThree">
          Help
        </a>
      </h4>

        </div>
        <div id="collapseThree" class="panel-collapse collapse">
            <div class="panel-body">If the book is available please enter: Available - Current Location <br>
                                          "Available - MC 10 Cupboard" <br><br>
                                            If the book is currently on loan, please enter: Taken - Name of Borrower, Date Taken, Location of Borrower in Kainos<br>
                                            "Taken - John Doe, 10/10/16, MC 8.0.1"</div>
        </div>
    </div>
</div>


</div>
<input type="submit" value="Submit" class="btn btn-success" /> 
<a class="btn btn-default" href="/">Cancel</a>  </form>   </@layoutTemplate.layout>
</form>

