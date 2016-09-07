<#-- @ftlvariable name="" type="com.kainos.discoverydiary.views.BookListView" --> 
<#import "../layout.ftl" as layoutTemplate>  
<@layoutTemplate.layout>  
<h1>Book list</h1>
 <p class="lead">Registered books.</p>  
<table class="table"> 
<thead> 
<th>Title</th> 
<th>Author</th> 
</thead>  
<tbody> 
<#list books as book> 
<tr> 
<td> 
${book.title} 
</td> 
<td> 
${book.author} 
</td> 
</tr> 
</#list>  
</tbody> 
</table>  
<a class="btn btn-default" href="/add">Add Book</a>  
</@layoutTemplate.layout>
