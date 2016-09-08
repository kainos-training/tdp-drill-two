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
    <p class="help-block">Please enter the books ISBN</p> 
</div>  
<div class="form-group"> 
    <label for="title">Book Title</label> 
    <input name="title" type="text" size = "50" maxlength="200" placeholder="Book Title" class="form-control" required /> 
    <p class="help-block">Please enter the book title, max 200 characters</p> 
</div>  
    <div class="form-group"> 
    <label for="author">Author</label> 
    <input name="author" type="text" size = "50" maxlength="200" placeholder="Book Author" class="form-control" required /> 
<p class="help-block">Please enter the author of the book, max 200 characters</p> 
</div>  

<!--
<div class="form-group"> 
<form>
<label for="location">Location</label> <br>
<input name="Location" type="radio" value="Breakout"> MC Breakout Room<br>
<input name="Location" type="radio" value="UC"> UC 1.5<br>
<input name="Location" type="radio" value="Cupboard"> MC 10 Cupboard<br>
</form>
<p class="help-block">Please enter the location of the book</p> 
</div>  
-->



</div>
<input type="submit" value="Submit" class="btn btn-success" /> 
<a class="btn btn-default" href="/">Cancel</a>  </form>   </@layoutTemplate.layout>
</form>

